package br.pokemonapi.client.secondary.http;

public class TypesResponseFixture {

    public static TypesResponse build() {

        return TypesResponse
            .builder()
            .type(TypeResponseFixture.build())
            .build();
    }

    public static TypesResponse buildInvalido() {

        return TypesResponse
            .builder()
            .type(TypeResponseFixture.buildInvalido())
            .build();
    }

}
