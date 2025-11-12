package dev.alanryan.pokedex.network.response

import dev.alanryan.pokedex.models.Pokemon

data class PokemonResponse(
    val pokemonList: List<Pokemon>
)
