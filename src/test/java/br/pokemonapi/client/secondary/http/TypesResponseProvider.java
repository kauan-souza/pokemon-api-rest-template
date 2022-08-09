package br.pokemonapi.client.secondary.http;

public class TypesResponseProvider {

    public static TypesResponse build() {

        return TypesResponse
            .builder()
            .type(TypeResponseProvider.build())
            .build();
    }

    public static TypesResponse buildInvalido() {

        return TypesResponse
            .builder()
            .type(TypeResponseProvider.buildInvalido())
            .build();
    }

}
