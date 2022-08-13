package br.pokemonapi.client.primary.http;

import br.pokemonapi.model.Move;
import br.pokemonapi.model.Pokemon;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonControllerMapper {

    PokemonResponseDto mapToResponse(Pokemon pokemon);

    Pokemon mapToEntity(PokemonRequestDto pokemonRequestDto);

    default Collection<String> mapToMoves(Collection<Move> moves) {

        return moves
            .stream()
            .map(Move::getName)
            .toList();
    }

    default Collection<Move> mapToNameMoves(Collection<String> strings) {

        return strings
            .stream()
            .map(string -> Move.builder().build())
            .toList();
    }
}
