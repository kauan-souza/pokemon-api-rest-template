package br.pokemonapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(schema = "pokemon")
@Getter
@Builder
public class Move {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String name;

    public static class MoveBuilder {

        public Move build() {

            return new Move(
                this.name);
        }
    }

    protected Move() {

    }

    private Move(String name) {
        this.name = name;
    }

}
