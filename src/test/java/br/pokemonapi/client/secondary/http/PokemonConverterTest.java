package br.pokemonapi.client.secondary.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PokemonConverterTest {

    @Test
    @DisplayName("Deve converter PokemonResponse para Pokemon com sucesso")
    void deveConverterComSucesso() {

        var pokemonResponse = PokemonResponseProvider.build();

        assertDoesNotThrow(() -> PokemonConverter.getInstance().apply(pokemonResponse));
    }

}
