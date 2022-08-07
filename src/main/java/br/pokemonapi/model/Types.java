package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
@AllArgsConstructor(access = PRIVATE)
public enum Types {

    NORMAL("normal"),
    FLYING("flying"),
    POISON("poison"),
    GROUND("ground"),
    ROCK("rock"),
    BUG("bug"),
    GHOST("ghost"),
    STEEL("steel"),
    FIRE("fire"),
    WATER("water"),
    GRASS("grass"),
    ELETRIC("eletric"),
    PSYCHIC("psychic"),
    ICE("ice"),
    DRAGON("dragon"),
    DARK("dark"),
    FAIRY("fairy"),
    UNKNOW("unknow"),
    FIGHTING("fighting");

    final String descricao;
}
