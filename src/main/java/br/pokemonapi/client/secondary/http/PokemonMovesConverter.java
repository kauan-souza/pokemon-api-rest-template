package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Move;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class PokemonMovesConverter implements Function<Collection<MovesResponse>, Collection<Move>> {

    private static PokemonMovesConverter instance;

    public static PokemonMovesConverter getInstance() {

        if (Objects.isNull(instance)) {
            instance = new PokemonMovesConverter();
        }

        return instance;
    }

    @Override
    public Collection<Move> apply(Collection<MovesResponse> response) {

        return Optional.ofNullable(response)
            .map(PokemonMovesConverter::convertMoves)
            .orElseThrow(() ->
                new RuntimeException("Não foi possível converter o reponse para a entidade"));

    }

    private static Collection<Move> convertMoves(Collection<MovesResponse> response) {

        return response
            .stream()
            .map(PokemonMovesConverter::convertMove)
            .toList();
    }

    private static Move convertMove(MovesResponse response) {

        return Move
            .builder()
            .name(response.getMove().getName())
            .build();
    }
}
