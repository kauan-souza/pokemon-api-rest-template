package br.pokemonapi.application;

import br.pokemonapi.model.Pokemon;
import br.pokemonapi.model.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokemonApplicationServiceImpl implements PokemonApplicationService {

    private final PokemonService pokemonService;

    @Override
    public Pokemon findById(Long id) {

        return pokemonService.findById(id);
    }
}
