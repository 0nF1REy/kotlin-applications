package dev.alanryan.pokedex.utils

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import dev.alanryan.pokedex.R

private fun getTypeResources(type: String): Pair<Int, Int> {
    return when (type.trim().lowercase()) {
        "normal" -> R.color.normal to R.string.type_normal
        "fire" -> R.color.fire to R.string.type_fire
        "water" -> R.color.water to R.string.type_water
        "electric" -> R.color.electric to R.string.type_electric
        "grass" -> R.color.grass to R.string.type_grass
        "ice" -> R.color.ice to R.string.type_ice
        "fighting" -> R.color.fighting to R.string.type_fighting
        "poison" -> R.color.poison to R.string.type_poison
        "ground" -> R.color.ground to R.string.type_ground
        "flying" -> R.color.flying to R.string.type_flying
        "psychic" -> R.color.psychic to R.string.type_psychic
        "bug" -> R.color.bug to R.string.type_bug
        "rock" -> R.color.rock to R.string.type_rock
        "ghost" -> R.color.ghost to R.string.type_ghost
        "dragon" -> R.color.dragon to R.string.type_dragon
        "dark" -> R.color.dark to R.string.type_dark
        "steel" -> R.color.steel to R.string.type_steel
        "fairy" -> R.color.fairy to R.string.type_fairy
        else -> R.color.white to R.string.type_normal
    }
}

@StringRes
fun getTypeStringResource(type: String): Int {
    return getTypeResources(type).second
}

@Composable
fun getTypeColor(type: String): Color {
    @ColorRes val colorId = getTypeResources(type).first
    return colorResource(id = colorId)
}
