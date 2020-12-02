package com.example.pokeweb;

import com.example.pokeweb.model.Pokemon;
import com.example.pokeweb.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseRunner implements CommandLineRunner {

    private final PokemonRepository pokemonRepository;

    @Override
    public void run(String... args) {
        pokemonRepository.save(new Pokemon(1L, "ditto", 3, 40, "limber"));
        pokemonRepository.save(new Pokemon(2L, "pikachu", 4, 60, "static"));
        pokemonRepository.save(new Pokemon(3L, "bulbasaur", 7, 69, "overgrow"));
        pokemonRepository.save(new Pokemon(4L, "charmander", 3, 40, "blaze"));
        pokemonRepository.save(new Pokemon(5L, "squirtle", 5, 90, "torrent"));
    }
}
