package br.pokemonapi.client.secondary.http;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PokemonTypeConverterTest {

    @Test
    @DisplayName("Deve converter TypesResponse para Types com sucesso")
    void deveConverterComSucesso() {

        var typeResponse = List.of(TypesResponseProvider.build());

        assertDoesNotThrow(() -> PokemonTypesConverter.getInstance().apply(typeResponse));
    }

    @Test
    @DisplayName("Deve lançar exceção ao converter PokemonResponse para Pokemon com valor inválido")
    void deveLancarExcecaoComValorInvalido() {

        var pokemonResponse = List.of(TypesResponseProvider.buildInvalido());

        Executable executable = () -> PokemonTypesConverter.getInstance().apply(pokemonResponse);

        var excecao = assertThrows(RuntimeException.class, executable);

        assertEquals("Tipo informado não encontrado", excecao.getMessage());
    }

}
