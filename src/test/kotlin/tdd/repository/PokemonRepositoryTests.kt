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
  
}
