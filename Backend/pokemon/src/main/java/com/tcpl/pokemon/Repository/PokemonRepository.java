package com.tcpl.pokemon.Repository;

import com.tcpl.pokemon.Model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon,Integer> {
}
