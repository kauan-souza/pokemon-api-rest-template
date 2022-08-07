package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Moves;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class PokemonMovesConverter implements Function<MoveResponse, Moves> {

    private static PokemonMovesConverter instance;

    public static PokemonMovesConverter getInstance() {

        if (Objects.isNull(instance)) {
            instance = new PokemonMovesConverter();
        }

        return instance;
    }

    @Override
    public Moves apply(MoveResponse response) {

        return Optional.ofNullable(response)
            .map(PokemonMovesConverter::convert)
            .orElseThrow(() ->
                new RuntimeException("Não foi possível converter o reponse para a entidade"));

    }

    private static Moves convert(MoveResponse response) {

        return Moves
            .builder()
            .name(response.getName())
            .build();
    }
}
