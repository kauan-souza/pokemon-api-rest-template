package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Collection;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(schema = "pokemon")
@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Pokemon {

    protected Pokemon() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Integer height;

    private Integer weight;

    private String name;

    private boolean active;

    private boolean external;

    @Convert(converter = TypePersistenceConverter.class)
    Collection<Type> types;

//    Collection<Moves> moves;

    public static class PokemonBuilder {

        public Pokemon build() {

            return new Pokemon(
                this.id,
                this.height,
                this.weight,
                this.name,
                this.active,
                this.external,
                this.types);
        }
    }
}
