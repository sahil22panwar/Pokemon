package com.tcpl.pokemon.service;

import com.tcpl.pokemon.Model.Pokemon;

import java.util.List;

public interface PokemonService {

    public List<Pokemon> getAllPokemon();
    public List<Pokemon> addPokemon(List<Pokemon> pokemon);
    public Pokemon getPokemon(int id);
    public List<Pokemon> deletePokemon(int id);

}
