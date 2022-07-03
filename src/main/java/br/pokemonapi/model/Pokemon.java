package br.pokemonapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pokemon {
    private int id;
    private String name;
    private List<Types> types;
    private int height;
    private int weight;
    private List<Moves> moves;
    private Sprites sprites;

}

