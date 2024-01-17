package tdd.api.repository

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Pokemon(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long? = null,
  val name: String,
  val type: String,
  val ability: String,
  val height: Double,
  val weight: Double,
  val description: String
)
