package br.pokemonapi.controller;

import br.pokemonapi.model.Pokemon;
import br.pokemonapi.service.PokemonIntegrationService;
import br.pokemonapi.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pokemons")
@CrossOrigin(origins = "*")
public class PokemonController {

    private final PokemonIntegrationService pokemonIntegrationService;
    private final PokemonService pokemonService;

    public PokemonController(PokemonIntegrationService pokemonIntegrationService, PokemonService pokemonService) {
        this.pokemonIntegrationService = pokemonIntegrationService;
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscarPorId(@PathVariable("id") int id) {
        return ResponseEntity.ok(pokemonService.converter(this.pokemonIntegrationService.findById(id)));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Pokemon> buscarPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(pokemonService.converter(this.pokemonIntegrationService.findByNome(nome)));
    }
}