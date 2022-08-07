package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Moves {

    String name;

    public static class MovesBuilder {

        public Moves build() {

            return new Moves(this.name);
        }
    }


}
