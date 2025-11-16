package dev.alanryan.pokedex.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import dev.alanryan.pokedex.R

@Composable
fun getTypeColor(
    type: String
): Color {
    return when(type.trim().lowercase()) {
        "normal" -> colorResource(id = R.color.normal)
        "fire" -> colorResource(id = R.color.fire)
        "water" -> colorResource(id = R.color.water)
        "electric" -> colorResource(id = R.color.electric)
        "grass" -> colorResource(id = R.color.grass)
        "ice" -> colorResource(id = R.color.ice)
        "fighting" -> colorResource(id = R.color.fighting)
        "poison" -> colorResource(id = R.color.poison)
        "ground" -> colorResource(id = R.color.ground)
        "flying" -> colorResource(id = R.color.flying)
        "psychic" -> colorResource(id = R.color.psychic)
        "bug" -> colorResource(id = R.color.bug)
        "rock" -> colorResource(id = R.color.rock)
        "ghost" -> colorResource(id = R.color.ghost)
        "dragon" -> colorResource(id = R.color.dragon)
        "dark" -> colorResource(id = R.color.dark)
        "steel" -> colorResource(id = R.color.steel)
        "fairy" -> colorResource(id = R.color.fairy)
        else -> colorResource(id = R.color.white)
    }
}
