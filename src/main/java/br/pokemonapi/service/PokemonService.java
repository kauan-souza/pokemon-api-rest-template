package br.pokemonapi.service;

import static java.lang.String.format;

import br.pokemonapi.client.secondary.http.PokemonApiClient;
import br.pokemonapi.model.Pokemon;
import br.pokemonapi.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    private final PokemonApiClient pokemonApiClient;

    public PokemonService(PokemonRepository pokemonRepository,
        PokemonApiClient pokemonApiClient) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonApiClient = pokemonApiClient;
    }

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

//    public Pokemon save(Pokemon pokemon) {
//        try {
//            responseForPokemon(pokemonApiClient.findById(pokemon.getId()));
//        } catch (HttpClientErrorException.NotFound e) {
//        }
//        return pokemonRepository.save(pokemon);
//    }
//
//    public Pokemon EditIsActive(long id) {
//        Pokemon pokemon = pokemonRepository.findById(id)
//            .orElseThrow(EntityNotFoundException::new);
//        pokemon.setIsActive(false);
//        return pokemon;
//    }
}
