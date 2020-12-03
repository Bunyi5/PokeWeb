package com.example.pokeweb.service;

import com.example.pokeweb.model.Pokemon;
import com.example.pokeweb.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public void saveNewPokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        pokemonRepository.deleteById(id);
    }

    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public boolean isPokemonExist(Long id) {
        return pokemonRepository.existsById(id);
    }
}
