package tdd.api.service

import tdd.api.repository.Pokemon

interface PokemonService {
  fun getAllPokemons(): List<Pokemon>
  
  fun createPokemon(pokemon: Pokemon): Pokemon
}
