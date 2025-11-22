package dev.alanryan.pokedex.models

data class Pokemon(
    val pokemonImage: String,
    val pokedexNumber: Int,
    val name: String,
    val evolutions: List<String> = emptyList(),
    val type: List<String>,
    val strongAgainst: List<String> = emptyList(),
    val weakAgainst: List<String> = emptyList()
)
