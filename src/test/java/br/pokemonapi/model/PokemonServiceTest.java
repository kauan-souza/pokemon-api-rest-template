package br.pokemonapi.model;

import br.pokemonapi.client.secondary.http.PokemonApiClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PokemonServiceTest {

    @InjectMocks
    private PokemonService pokemonService;

    @Mock
    private PokemonRepository pokemonRepository;

    @Mock
    private PokemonApiClient pokemonApiClient;

    @Test
    @DisplayName("Deve buscar Pokemon por id em api externa com sucesso")
    void deveBuscarPorId() {

        var pokemon = PokemonFixture.build();
    }

}
