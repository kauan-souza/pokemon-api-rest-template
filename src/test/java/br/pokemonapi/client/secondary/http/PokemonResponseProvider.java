package br.pokemonapi.client.secondary.http;

import java.util.List;

public class PokemonResponseProvider {

    public static PokemonResponse build() {

        return PokemonResponse
            .builder()
            .id(1L)
            .name("Name")
            .height(123)
            .weight(456)
            .types(List.of(TypesResponseProvider.build()))
            .moves(List.of(MovesResponse.builder().move(MoveResponse.builder().name("CUT").build()).build()))
            .build();
    }

}
