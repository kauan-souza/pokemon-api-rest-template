package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
class PokemonProvider {

    static Pokemon build() {

        return Pokemon
            .builder()
            .build();
    }

}
