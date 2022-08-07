package br.pokemonapi.client.primary.http;

import static org.springframework.http.HttpStatus.OK;

import br.pokemonapi.client.secondary.http.PokemonApiClient;
import br.pokemonapi.model.Pokemon;
import br.pokemonapi.service.PokemonService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pokemons")
@CrossOrigin(origins = "*")
public class PokemonController {

    private final PokemonApiClient pokemonApiClient;
    private final PokemonService pokemonService;

    public PokemonController(PokemonApiClient pokemonApiClient, PokemonService pokemonService) {
        this.pokemonApiClient = pokemonApiClient;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Pokemon findById(@PathVariable("id") Long id) {

        return this
            .pokemonService
            .findById(id);
    }

//    @PostMapping
//    public ResponseEntity<Pokemon> save(@RequestBody Pokemon pokemon) {
//
//        return ResponseEntity.ok(pokemonService.save(pokemon));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Pokemon> logicDelete(@PathVariable("id") long id) {
//
//        return ResponseEntity.ok(pokemonService.EditIsActive(id));
//    }
}