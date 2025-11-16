package dev.alanryan.pokedex

import androidx.compose.material3.*
import dev.alanryan.pokedex.ui.components.PokedexTopBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alanryan.pokedex.ui.theme.PokedexTheme
import dev.alanryan.pokedex.viewmodels.MainViewModel
import dev.alanryan.pokedex.viewmodels.MainViewModelFactory
import dev.alanryan.pokedex.views.Circles
import dev.alanryan.pokedex.views.EvolutionCard
import dev.alanryan.pokedex.views.Lines
import dev.alanryan.pokedex.views.PokemonImageFrame
import dev.alanryan.pokedex.views.TypeStrengthWeaknessCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PokedexTheme {

                val mainViewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
                    factory = MainViewModelFactory(application)
                )

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { PokedexTopBar() }
                ) { innerPadding ->
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
            .background(MaterialTheme.colorScheme.primary)
    ) {

        Circles()

        Lines()

        Spacer(modifier = Modifier.height((8.dp)))

        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Pokédex",
            fontFamily = font,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontWeight = FontWeight.Bold
            ),
            fontSize = 36.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (currentPokemon != null) {
            PokemonImageFrame(
                currentPokemon = currentPokemon,
                font = font
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (currentPokemon != null) {
            EvolutionCard(
                currentPokemon = currentPokemon
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (currentPokemon != null) {
            TypeStrengthWeaknessCard(
                currentPokemon = currentPokemon
            )
        }
    }
}
