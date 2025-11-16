package dev.alanryan.pokedex.views

import androidx.compose.runtime.Composable

@Composable
fun translateTypeToPortuguese(type: String): String {
    return when (type.lowercase()) {
        "normal" -> "Normal"
        "fire" -> "Fogo"
        "water" -> "Água"
        "electric" -> "Elétrico"
        "grass" -> "Planta"
        "ice" -> "Gelo"
        "fighting" -> "Lutador"
        "poison" -> "Veneno"
        "ground" -> "Terra"
        "flying" -> "Voador"
        "psychic" -> "Psíquico"
        "bug" -> "Inseto"
        "rock" -> "Pedra"
        "ghost" -> "Fantasma"
        "dragon" -> "Dragão"
        "dark" -> "Sombrio"
        "steel" -> "Aço"
        "fairy" -> "Fada"
        else -> type
    }
}