package br.pokemonapi.client.primary.http;

import static lombok.AccessLevel.PRIVATE;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
class PokemonResponseDto {

    Long id;

    String name;

    Integer height;

    Integer weight;

    Collection<String> types;

    Collection<String> moves;

}
