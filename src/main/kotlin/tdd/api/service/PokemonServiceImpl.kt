package tdd.api.service

import org.springframework.stereotype.Service
import tdd.api.repository.Pokemon
import tdd.api.repository.PokemonRepository

@Service
class PokemonServiceImpl(
  private val pokemonRepository: PokemonRepository
): PokemonService {
  override fun getAllPokemons(): List<Pokemon> {
    return pokemonRepository.findAll()
  }
  
  override fun createPokemon(pokemon: Pokemon): Pokemon {
    return pokemonRepository.save(pokemon)
  }
}
