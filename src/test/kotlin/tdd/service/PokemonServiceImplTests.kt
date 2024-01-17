package tdd.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import tdd.api.repository.Pokemon
import tdd.api.repository.PokemonRepository
import tdd.api.service.PokemonServiceImpl

@ExtendWith(MockitoExtension::class)
class PokemonServiceImplTests {
  @Mock
  private lateinit var pokemonRepository: PokemonRepository
  
  @InjectMocks
  private lateinit var pokemonService: PokemonServiceImpl
  
  @Test
  fun `pokemon service create pokemon`() {
    // given
    val pokemon = Pokemon(
      name = "Pikachu",
      type = "Electric",
      ability = "Static",
      height = 0.4,
      weight = 6.0,
      description = "When several of these POKéMON gather, their electricity could build and cause lightning storms.",
    )
    // when
    `when`(pokemonRepository.save(Mockito.any(Pokemon::class.java))).thenReturn(pokemon)
    val result = pokemonService.createPokemon(pokemon)
    
    // then
    assert(result.id == null)
  }
}
