package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
public enum Type {

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
    ELECTRIC("electric"),
    PSYCHIC("psychic"),
    ICE("ice"),
    DRAGON("dragon"),
    DARK("dark"),
    FAIRY("fairy"),
    UNKNOWN("unknown"),
    FIGHTING("fighting");

    final String description;

    public static Type fromDescricao(String value) {
        return Arrays.stream(Type.values())
            .filter(types -> existsEnum(types, value))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Tipo informado não encontrado!"));
    }

    private static boolean existsEnum(Type type, String value) {

        return type.getDescription().equals(value);
    }
}
