package tdd.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepository: JpaRepository<Pokemon, Long>
