package com.example.pokeweb.contoller;

import com.example.pokeweb.model.Pokemon;
import com.example.pokeweb.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/pokemons")
    public ResponseEntity<List<Pokemon>> allPokemon() {
        return ResponseEntity.ok(pokemonService.getAllPokemon());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addNewPokemon")
    public ResponseEntity<Void> setNewPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.saveNewPokemon(pokemon);
        return ResponseEntity.ok().build();
    }
}
