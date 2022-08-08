package br.pokemonapi.client.primary.http;

import br.pokemonapi.model.Move;
import br.pokemonapi.model.Pokemon;
import java.util.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonControllerMapper {

    PokemonResponseDto mapToResponse(Pokemon pokemon);

    default Collection<String> mapToMoves(Collection<Move> moves) {

        return moves
            .stream()
            .map(Move::getName)
            .toList();
    }

}
