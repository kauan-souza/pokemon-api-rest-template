package br.pokemonapi.client.primary.http;

import java.util.Collection;
import lombok.Value;

@Value
public class PokemonRequestDto {

    Long id = 907L;

    String name;

    Integer height;

    Integer weight;

    Collection<String> types;

    Collection<String> moves;

    boolean active = true;

    boolean external = false;

}

