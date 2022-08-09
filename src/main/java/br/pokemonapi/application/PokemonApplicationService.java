package br.pokemonapi.application;

import br.pokemonapi.model.Pokemon;

public interface PokemonApplicationService {

    Pokemon findById(Long id);

    void logicDelete(Long id);

    Pokemon findByName(String name);

    Pokemon save(Pokemon pokemon);
}
