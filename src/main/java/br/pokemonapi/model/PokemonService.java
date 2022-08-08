package br.pokemonapi.model;

import static java.lang.String.format;

import br.pokemonapi.client.secondary.http.PokemonApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Component
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonApiClient pokemonApiClient;

    public Pokemon findById(Long id) {

        try {
            return findByIdExternal(id);

        } catch (HttpClientErrorException exception) {

            return findByIdInternal(id);
        }
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
                format("Nenhum pokemon encontrado para o id informado: {%s}", id)));
    }

    public void logicDelete(Long id) {

        findByIdExternal(id);

        save(findByIdInternal(id)
            .disableActive());
    }

    public Pokemon save(Pokemon pokemon) {

        return pokemonRepository.saveAndFlush(pokemon);
    }
}
