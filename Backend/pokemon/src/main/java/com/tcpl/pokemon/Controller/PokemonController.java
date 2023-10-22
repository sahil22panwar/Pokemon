package com.tcpl.pokemon.Controller;

import com.tcpl.pokemon.Model.Pokemon;
import com.tcpl.pokemon.Repository.PokemonRepository;
import com.tcpl.pokemon.service.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/vi")
public class PokemonController {

    @Autowired
    private PokemonServiceImpl pokemonService;

    public PokemonController( PokemonServiceImpl pokemonService) {

        this.pokemonService = pokemonService;
    }
    @PostMapping("/addPokemon")
    public ResponseEntity<?> addPokemon(@RequestBody List<Pokemon> pokemonList ){
        List<Pokemon> savedPokemon = pokemonService.addPokemon(pokemonList);
        return new ResponseEntity(savedPokemon,HttpStatus.OK);
    }
    @GetMapping("/allPokemon")
    public ResponseEntity<?> getAllPokemon(){
        return new ResponseEntity<>(pokemonService.getAllPokemon(), HttpStatus.OK);
    }
}
