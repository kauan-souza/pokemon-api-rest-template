package br.pokemonapi.model;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.NoArgsConstructor;

@Converter
@NoArgsConstructor(access = PRIVATE)
class TypePersistenceConverter implements AttributeConverter<Collection<Type>, String> {

    @Override
    public String convertToDatabaseColumn(Collection<Type> list) {

        if (list == null) {
            return null;
        }

        Collection<String> collection = new ArrayList<>();

        list.forEach(element -> collection.add(element.toString()));

        return String.join(",", collection);
    }

    @Override
    public Collection<Type> convertToEntityAttribute(String joined) {

        if (joined == null) {
            return Collections.emptyList();
        }

        Collection<Type> types = new ArrayList<>();
        Arrays.asList(joined.split(","))
            .forEach(type -> types.add(Type.valueOf(type)));

        return types;
    }


}
