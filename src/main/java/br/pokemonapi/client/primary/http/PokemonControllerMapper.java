package br.pokemonapi.client.primary.http;

import br.pokemonapi.model.Pokemon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PokemonControllerMapper {

    PokemonResponseDto mapToResponse(Pokemon pokemon);

}
