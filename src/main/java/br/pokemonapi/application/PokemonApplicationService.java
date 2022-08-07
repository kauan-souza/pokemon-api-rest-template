package br.pokemonapi.application;

import br.pokemonapi.model.Pokemon;

public interface PokemonApplicationService {

    Pokemon findById(Long id);

}
