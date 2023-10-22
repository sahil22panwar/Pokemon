package com.tcpl.pokemon.service;

import com.tcpl.pokemon.Model.Pokemon;
import com.tcpl.pokemon.Repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{
    @Autowired
    private PokemonRepository pokemonRepository;

    PokemonServiceImpl(PokemonRepository pokemonRepository){
        this.pokemonRepository=pokemonRepository;
    }


    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public List<Pokemon> addPokemon(List<Pokemon> pokemonList) {
        // Save the list of Pokemon objects to MongoDB


        List<Pokemon> savedPokemon = pokemonRepository.saveAll(pokemonList);
        return savedPokemon;
    }

    @Override
    public Pokemon getPokemon(int id) {
        return pokemonRepository.findById(id).get();
    }

    @Override
    public List<Pokemon> deletePokemon(int id) {
        List<Pokemon> pokemonList = pokemonRepository.findAll();
        Pokemon pokemonToDelete = null;
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == id) {
                pokemonToDelete = pokemon;
                break;
            }
        }

        if (pokemonToDelete != null) {
            pokemonList.remove(pokemonToDelete);
            pokemonRepository.delete(pokemonToDelete);
        }
        return pokemonList;
    }

}
