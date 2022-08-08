package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Move;
import br.pokemonapi.model.Pokemon;
import br.pokemonapi.model.Type;
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

    private static Collection<Type> convertTypes(Collection<TypesResponse> response) {

        return PokemonTypesConverter
            .getInstance()
            .apply(response);
    }

    private static Collection<Move> convertMoves(Collection<MovesResponse> response) {

        return PokemonMovesConverter
            .getInstance()
            .apply(response);
    }
}
