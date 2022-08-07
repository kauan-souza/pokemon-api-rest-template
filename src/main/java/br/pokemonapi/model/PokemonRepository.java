package br.pokemonapi.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PokemonRepository extends JpaRepository<Pokemon, Long> {

}
