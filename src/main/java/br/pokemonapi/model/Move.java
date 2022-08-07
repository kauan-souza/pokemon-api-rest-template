package br.pokemonapi.model;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @ManyToMany
    @JoinTable(
        name = "pokemon_move",
        schema = "pokemon",
        joinColumns = {
            @JoinColumn(
                name = "pokemon_id",
                referencedColumnName = "id"),
        },
        inverseJoinColumns = {
            @JoinColumn(
                name = "move_id",
                referencedColumnName = "id")
        })
    Collection<Pokemon> pokemon;

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
