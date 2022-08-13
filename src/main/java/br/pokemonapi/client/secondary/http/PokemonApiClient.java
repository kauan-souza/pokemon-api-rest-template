package br.pokemonapi.client.secondary.http;

import br.pokemonapi.model.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonApiClient {

    private final RestTemplate restTemplate;


    @Value("${pokemon-external-api}")
    private String uri;


    public PokemonApiClient(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    public Pokemon findById(Long id) {

        return PokemonConverter
            .getInstance()
            .apply(this
                .restTemplate
                .getForObject(buildUrl(id), PokemonResponse.class)
            );
    }

    public Pokemon findByName(String name) {

        return PokemonConverter
            .getInstance()
            .apply(this
                .restTemplate
                .getForObject(buildUrl(name), PokemonResponse.class)
            );
    }

    private <T> String buildUrl(T value) {

        return this.uri + "/" + value;
    }
}