package dev.alanryan.pokedex.ui.screens.pokedex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alanryan.pokedex.R
import dev.alanryan.pokedex.models.Pokemon
import dev.alanryan.pokedex.ui.components.pokedextopbar.PokedexTopBar
import dev.alanryan.pokedex.ui.screens.pokedex.components.evolutioncard.EvolutionCard
import dev.alanryan.pokedex.ui.screens.pokedex.components.navigationbuttons.NavigationButtons
import dev.alanryan.pokedex.ui.screens.pokedex.components.pokemonimageframe.PokemonImageFrame
import dev.alanryan.pokedex.ui.screens.pokedex.components.typestrengthweaknesscard.TypeStrengthWeaknessCard

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    pokemonList: List<Pokemon>
) {

    val font = FontFamily(Font(R.font.pokemon_hollow))
    var currentIndex by remember { mutableIntStateOf(0) }
    val currentPokemon = pokemonList.getOrNull(currentIndex)

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        PokedexTopBar()

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Pokédex",
                fontFamily = font,
                textAlign = TextAlign.Center,
                style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 36.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            currentPokemon?.let {
                PokemonImageFrame(
                    currentPokemon = it,
                    font = font
                )
                Spacer(modifier = Modifier.height(8.dp))
                EvolutionCard(currentPokemon = it)
                Spacer(modifier = Modifier.height(8.dp))
                TypeStrengthWeaknessCard(currentPokemon = it)
            }
        }

        NavigationButtons(
            currentIndex = currentIndex,
            totalPokemons = pokemonList.size,
            onPreviousClick = {
                if (currentIndex > 0) {
                    currentIndex--
                }
            },
            onNextClick = {
                if (currentIndex < (pokemonList.size - 1)) {
                    currentIndex++
                }
            }
        )
    }
}
