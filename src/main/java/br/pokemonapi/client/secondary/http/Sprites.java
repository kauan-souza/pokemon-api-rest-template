package br.pokemonapi.client.secondary.http;

import static lombok.AccessLevel.PRIVATE;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = PRIVATE)
class Sprites {

    @JsonProperty("front_default")
    String frontDefault;

    @JsonProperty("back_default")
    String backDefault;

    @JsonProperty("front_shiny")
    String frontShiny;

    @JsonProperty("back_shiny")
    String backShiny;
}
