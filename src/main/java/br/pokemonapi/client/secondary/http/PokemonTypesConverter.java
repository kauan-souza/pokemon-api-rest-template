package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Type;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class PokemonTypesConverter implements Function<Collection<TypesResponse>, Collection<Type>> {

    private static PokemonTypesConverter instance;

    public static PokemonTypesConverter getInstance() {

        if (Objects.isNull(instance)) {
            instance = new PokemonTypesConverter();
        }

        return instance;
    }

    @Override
    public Collection<Type> apply(Collection<TypesResponse> response) {

        return Optional.ofNullable(response)
            .map(PokemonTypesConverter::convertTypes)
            .orElseThrow(() ->
                new RuntimeException("Não foi possível converter o reponse para a entidade")
            );

    }

    private static Collection<Type> convertTypes(Collection<TypesResponse> response) {

        return response
            .stream()
            .map(PokemonTypesConverter::convertType)
            .toList();
    }

    private static Type convertType(TypesResponse response) {

        return Type.fromDescricao(response.getType().getName());
    }
}
