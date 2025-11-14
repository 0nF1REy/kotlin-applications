package dev.alanryan.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alanryan.pokedex.ui.theme.PokedexTheme
import dev.alanryan.pokedex.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexTheme {
                val mainViewModel: MainViewModel = viewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PokedexScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = mainViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val font = FontFamily(Font(R.font.pokemon_hollow))

    val pokemonList by viewModel.pokemonList.collectAsState()

    val currentIndex by remember { mutableIntStateOf(0) }

    val currentPokemon = pokemonList.getOrNull(currentIndex)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.red))
    ) {
        if (currentPokemon != null) {
            Text(
                text = "Pokémon: ${currentPokemon.name}",
                fontFamily = font,
                color = Color.White
            )
        } else {
            Text(
                text = "Carregando Pokémons...",
                fontFamily = font,
                color = Color.White
            )
        }
    }
}