package br.pokemonapi.service;

import br.pokemonapi.model.Pokemon;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    public Pokemon converter(Pokemon pokemon) {
        pokemon.setName(upperCaseFirstLetter(pokemon.getName()));
        return pokemon;
    }

    private static String upperCaseFirstLetter(String pokemonName) {
        return pokemonName.substring(0, 1).toUpperCase() + pokemonName.substring(1);
    }
}
