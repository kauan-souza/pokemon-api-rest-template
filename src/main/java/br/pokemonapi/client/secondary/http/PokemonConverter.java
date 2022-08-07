package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Moves;
import br.pokemonapi.model.Pokemon;
import br.pokemonapi.model.Types;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class PokemonConverter implements Function<PokemonResponse, Pokemon> {

    private static PokemonConverter instance;

    public static PokemonConverter getInstance() {

        if (Objects.isNull(instance)) {
            instance = new PokemonConverter();
        }

        return instance;
    }

    @Override
    public Pokemon apply(PokemonResponse response) {

        return Optional.ofNullable(response)
            .map(PokemonConverter::convert)
            .orElseThrow(() ->
                new RuntimeException("Não foi possível converter o reponse para a entidade"));

    }

    private static Pokemon convert(PokemonResponse response) {

        return Pokemon
            .builder()
            .id(response.getId())
            .name(response.getName())
            .height(response.getHeight())
            .weight(response.getHeight())
            .active(true)
            .external(true)
            .types(convertTypes(response.getTypes()))
            .moves(convertMoves(response.getMoves()))
            .build();
    }

    private static Collection<Types> convertTypes(Collection<TypesResponse> response) {

        return response
            .stream()
            .map(typesResponse ->
                PokemonTypesConverter
                    .getInstance()
                    .apply(typesResponse.getType()))
            .toList();
    }

    private static Collection<Moves> convertMoves(Collection<MovesResponse> response) {

        return response
            .stream()
            .map(movesResponse -> PokemonMovesConverter
                .getInstance()
                .apply(movesResponse.getMove()))
            .toList();
    }
}