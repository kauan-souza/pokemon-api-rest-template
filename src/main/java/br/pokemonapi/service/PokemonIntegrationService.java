package br.pokemonapi.service;

import br.pokemonapi.model.Pokemon;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonIntegrationService {

    private final RestTemplate restTemplate;

    @Value("${pokemon-external-api}")
    private String uri;

    public PokemonIntegrationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Pokemon findById(int id) {
        String url = gerarURLIntegrationById(id);
        return this.restTemplate.getForObject(url, Pokemon.class);
    }

    private String gerarURLIntegrationById(int id) {
        return this.uri + "/" + id;
    }

    private String gerarURLIntegrationByNome(String nome) {
        return this.uri + "/" + nome;
    }

    public Pokemon findByNome(String nome) {
        String url = gerarURLIntegrationByNome(nome);
        return this.restTemplate.getForObject(url, Pokemon.class);
    }
}