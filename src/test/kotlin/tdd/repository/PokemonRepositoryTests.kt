package tdd.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import tdd.api.repository.Pokemon
import tdd.api.repository.PokemonRepository

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class PokemonRepositoryTests {
  @Autowired
  private lateinit var pokemonRepository: PokemonRepository
  
  @Test
  fun `pokemon save all return saved pokemon`() {
    // Arrange
    val pokemon = Pokemon(
      name = "Pikachu",
      type = "Electric",
      ability = "Static",
      height = 0.4,
      weight = 6.0,
      description = "When several of these POKéMON gather, their electricity could build and cause lightning storms.",
    )
    
    // Act
    val savedPokemon = pokemonRepository.save(pokemon)
    
    // Assert
    assert(savedPokemon.id != null)
    assert(savedPokemon.name == pokemon.name)
  }
  
  @Test
  fun `pokemon find all return all saved pokemon`() {
    // Arrange
    val pokemon1 = Pokemon(
      name = "Pikachu",
      type = "Electric",
      ability = "Static",
      height = 0.4,
      weight = 6.0,
      description = "When several of these POKéMON gather, their electricity could build and cause lightning storms.",
    )
    val pokemon2 = Pokemon(
      name = "Charmander",
      type = "Fire",
      ability = "Blaze",
      height = 0.6,
      weight = 8.5,
      description = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.",
    )
    val pokemon3 = Pokemon(
      name = "Squirtle",
      type = "Water",
      ability = "Torrent",
      height = 0.5,
      weight = 9.0,
      description = "After birth, its back swells and hardens into a shell. Powerfully sprays foam from its mouth.",
    )
    val poke1 = pokemonRepository.save(pokemon1)
    val poke2 = pokemonRepository.save(pokemon2)
    val poke3 = pokemonRepository.save(pokemon3)
    
    // Act
    val pokemons = pokemonRepository.findAll()
    
    // Assert
    assert(pokemons.contains(poke1))
    assert(pokemons.contains(poke2))
    assert(pokemons.contains(poke3))
    assert(poke1.id == 1L)
    assert(poke2.id == 2L)
    assert(poke3.id == 3L)
    assert(pokemons.size == 3)
  }
  
  @Test
  fun `pokemon find by id return pokemon`() {
    // Arrange
    val pokemon = Pokemon(
      name = "Pikachu",
      type = "Electric",
      ability = "Static",
      height = 0.4,
      weight = 6.0,
      description = "When several of these POKéMON gather, their electricity could build and cause lightning storms.",
    )
    val savedPokemon = pokemonRepository.save(pokemon)
    
    // Act
    val pokemonFound = pokemonRepository.findById(savedPokemon.id!!)
    
    // Assert
    assert(pokemonFound.isPresent)
    assert(pokemonFound.get().id == savedPokemon.id)
    assert(pokemonFound.get().name == savedPokemon.name)
  }
}
