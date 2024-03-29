package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(schema = "pokemon")
@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
public class Pokemon {

    protected Pokemon() {}

    @Id
    @Min(value = 906)
    private Long id;

    private Integer height;

    private Integer weight;

    private String name;

    private boolean active;

    private boolean external;

    @Convert(converter = TypePersistenceConverter.class)
    Collection<Type> types;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pokemon_move",
        schema = "pokemon",
        joinColumns = {@JoinColumn(name = "pokemon_id")},
        inverseJoinColumns = {@JoinColumn(name = "move_id")})
    Collection<Move> moves;

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

    public Pokemon disableActive() {

        this.active = false;

        return this;
    }
}
