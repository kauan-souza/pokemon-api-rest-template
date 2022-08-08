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
    public Pokemon save(Pokemon pokemon) {
        return pokemonService.save(pokemon);
    }

    @Override
    public Pokemon findById(Long id) {

        return pokemonService.findById(id);
    }

    @Override
    public Pokemon findByName(String name) {
        return pokemonService.findByName(name);
    }

    @Override
    public void logicDelete(Long id) {

        pokemonService.logicDelete(id);
    }


}
