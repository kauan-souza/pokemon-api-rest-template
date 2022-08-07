package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Types;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class PokemonTypesConverter implements Function<TypeResponse, Types> {

    private static PokemonTypesConverter instance;

    public static PokemonTypesConverter getInstance() {

        if (Objects.isNull(instance)) {
            instance = new PokemonTypesConverter();
        }

        return instance;
    }

    @Override
    public Types apply(TypeResponse response) {

        return Optional.ofNullable(response)
            .map(PokemonTypesConverter::convert)
            .orElseThrow(() ->
                new RuntimeException("Não foi possível converter o reponse para a entidade")
            );

    }

    private static Types convert(TypeResponse response) {

        return Types
            .valueOf(
                response
                    .getName()
                    .toLowerCase()
            );
    }
}
