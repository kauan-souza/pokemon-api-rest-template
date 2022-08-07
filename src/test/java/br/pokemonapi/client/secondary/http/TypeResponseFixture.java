package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Type;

public class TypeResponseFixture {

    public static TypeResponse build() {

        return TypeResponse
            .builder()
            .name(Type.DARK.getDescription())
            .build();
    }

    public static TypeResponse buildInvalido() {

        return TypeResponse
            .builder()
            .name("invalido")
            .build();
    }

}
