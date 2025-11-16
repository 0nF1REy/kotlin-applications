package dev.alanryan.pokedex.utils

import androidx.annotation.StringRes
import dev.alanryan.pokedex.R

@StringRes
fun getTypeStringResource(type: String): Int {
    return when (type.trim().lowercase()) {
        "normal" -> R.string.type_normal
        "fire" -> R.string.type_fire
        "water" -> R.string.type_water
        "electric" -> R.string.type_electric
        "grass" -> R.string.type_grass
        "ice" -> R.string.type_ice
        "fighting" -> R.string.type_fighting
        "poison" -> R.string.type_poison
        "ground" -> R.string.type_ground
        "flying" -> R.string.type_flying
        "psychic" -> R.string.type_psychic
        "bug" -> R.string.type_bug
        "rock" -> R.string.type_rock
        "ghost" -> R.string.type_ghost
        "dragon" -> R.string.type_dragon
        "dark" -> R.string.type_dark
        "steel" -> R.string.type_steel
        "fairy" -> R.string.type_fairy
        else -> R.string.type_normal
    }
}
