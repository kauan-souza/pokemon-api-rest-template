package br.pokemonapi.client.secondary.http;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = PRIVATE)
class PokemonResponse {

    Long id;

    String name;

    Integer height;

    Integer weight;

    Sprites sprites;

    Collection<MovesResponse> moves;

    Collection<TypesResponse> types;

}

