package br.pokemonapi.model;

import static java.lang.String.format;

import br.pokemonapi.client.secondary.http.PokemonApiClient;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonApiClient pokemonApiClient;

    public Pokemon save(Pokemon pokemon) {

        Optional<Pokemon> pokemon1 = pokemonRepository.findByName(pokemon.getName());

        if (pokemon1.isPresent()) {

           throw new RuntimeException();
        }
        return pokemonRepository.save(pokemon);
      
    }

    public Pokemon findById(Long id) {

        try {
            return findByIdExternal(id);

        } catch (HttpClientErrorException exception) {

            return findByIdInternal(id);
        }
    }

    public Pokemon findByName(String name) {
        try {
            return findByNameExternal(name);

        } catch (HttpClientErrorException exception) {

            return findByNameInternal(name);
        }
    }

    public void logicDelete(Long id) {

        findByIdExternal(id);

        save(findByIdInternal(id)
            .disableActive());
    }

    private Pokemon findByIdExternal(Long id) {

        return this
            .pokemonApiClient
            .findById(id);
    }

    private Pokemon findByIdInternal(Long id) {

        return pokemonRepository
            .findById(id)
            .orElseThrow(() -> new HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                format("Nenhum pokemon encontrado para o id informado: %s!", id)));
    }

    private Pokemon findByNameExternal(String name) {

        return this
            .pokemonApiClient
            .findByName(name);
    }

    private Pokemon findByNameInternal(String name) {

        return pokemonRepository
            .findByName(name)
            .orElseThrow(() -> new HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                format("Nenhum pokemon encontrado para o nome informado: %s!", name)));
    }
}
