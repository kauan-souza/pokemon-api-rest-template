package br.pokemonapi.client.primary.http;

import static org.springframework.http.HttpStatus.OK;

import br.pokemonapi.application.PokemonApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/pokemons")
public class PokemonController {

    private final PokemonApplicationService pokemonApplicationService;
    private final PokemonControllerMapper mapper;

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PokemonResponseDto findById(@PathVariable("id") Long id) {

        return mapper
            .mapToResponse(this
                .pokemonApplicationService
                .findById(id)
            );
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
