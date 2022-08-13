package br.pokemonapi.client.primary.http;

import static org.springframework.http.HttpStatus.OK;

import br.pokemonapi.application.PokemonApplicationService;
import br.pokemonapi.model.Pokemon;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8085/swagger-ui/index.html#/
@RestController
@RequiredArgsConstructor
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

    @GetMapping("/name/{name}")
    @ResponseStatus(OK)
    public PokemonResponseDto findByName(@PathVariable("name") String name) {

        return mapper
            .mapToResponse(this
                .pokemonApplicationService
                .findByName(name)
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> logicDelete(@PathVariable("id") long id) {
        try {
            pokemonApplicationService.logicDelete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public PokemonResponseDto create(@RequestBody PokemonRequestDto pokemonRequestDto) {

        var pokemonSalvo = pokemonApplicationService
            .create(mapper.mapToEntity(pokemonRequestDto));

        return mapper.mapToResponse(pokemonSalvo);
    }

}



