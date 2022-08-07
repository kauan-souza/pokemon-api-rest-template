package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Collection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Entity
@Table(schema = "pokemon")
@Value
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    Integer height;

    Integer weight;

    String name;

    boolean active;

    boolean external;

    @Embedded
    Collection<Types> types;

    @Embedded
    Collection<Moves> moves;

    public static class PokemonBuilder {

        public Pokemon build() {

            return new Pokemon(
                this.id,
                this.height,
                this.weight,
                this.name,
                this.active,
                this.external,
                this.types,
                this.moves);
        }
    }
}
