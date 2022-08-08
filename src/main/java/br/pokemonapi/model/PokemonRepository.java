package br.pokemonapi.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PokemonRepository extends JpaRepository<Pokemon, Long> {
   Optional<Pokemon> findByName(String name);
}
