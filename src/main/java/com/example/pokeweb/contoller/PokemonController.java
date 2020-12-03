package com.example.pokeweb.contoller;

import com.example.pokeweb.model.Pokemon;
import com.example.pokeweb.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/pokemons")
    public ResponseEntity<List<Pokemon>> allPokemon() {
        return ResponseEntity.ok(pokemonService.getAllPokemon());
    }

    @PostMapping("/addNewPokemon")
    public ResponseEntity<Void> setNewPokemon(@RequestBody Pokemon pokemon) {
        List<Pokemon> pokemonList = pokemonService.getAllPokemon();

        if(pokemonList.contains(pokemon)) {
            log.info("User tried to add already existing pokemon: " + pokemon.getPokeName());
            return ResponseEntity.status(409).build();
        }

        pokemonService.saveNewPokemon(pokemon);
        log.info("New pokemon: " + pokemon.getPokeName() + " successfully added to database");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletePokemon")
    public ResponseEntity<Void> deletePokemon(@RequestParam Long id) {
        if (pokemonService.isPokemonExist(id)) {
            pokemonService.deletePokemon(id);
            log.info("User deleted pokemon with: " + id + " id");
            return ResponseEntity.ok().build();
        }

        log.info("Error deleting pokemon with: " + id + " id, pokemon not exist");
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/updatePokemon")
    public ResponseEntity<Void> updatePokemon(@RequestBody Pokemon pokemon) {
        if (pokemonService.isPokemonExist(pokemon.getId())) {
            pokemonService.updatePokemon(pokemon);
            log.info("User updated pokemon with: " + pokemon.getId() + " id");
            return ResponseEntity.ok().build();
        }

        log.info("Error updating pokemon with: " + pokemon.getId() + " id, pokemon not exist");
        return ResponseEntity.status(404).build();
    }
}
