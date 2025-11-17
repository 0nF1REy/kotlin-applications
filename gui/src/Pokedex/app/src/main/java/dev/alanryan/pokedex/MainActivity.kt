package dev.alanryan.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.alanryan.pokedex.ui.screens.pokedex.PokedexScreen
import dev.alanryan.pokedex.ui.theme.PokedexTheme
import dev.alanryan.pokedex.viewmodels.MainViewModel
import dev.alanryan.pokedex.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels { MainViewModelFactory(application) }

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.pokemonList.value.isEmpty()
        }

        enableEdgeToEdge()

        setContent {
            PokedexTheme {
                val pokemonList by viewModel.pokemonList.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.primary
                ) { innerPadding ->
                    if (pokemonList.isNotEmpty()) {
                        PokedexScreen(
                            modifier = Modifier.padding(innerPadding),
                            pokemonList = pokemonList
                        )
                    }
                }
            }
        }
    }
}