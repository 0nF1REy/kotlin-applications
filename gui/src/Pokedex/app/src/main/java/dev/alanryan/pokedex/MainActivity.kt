package dev.alanryan.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.alanryan.pokedex.ui.components.PokedexTopBar
import dev.alanryan.pokedex.ui.screens.LoadingScreen
import dev.alanryan.pokedex.ui.screens.PokedexScreen
import dev.alanryan.pokedex.ui.theme.PokedexTheme
import dev.alanryan.pokedex.viewmodels.MainViewModel
import dev.alanryan.pokedex.viewmodels.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PokedexTheme {
                val mainViewModel: MainViewModel = viewModel(
                    factory = MainViewModelFactory(application)
                )

                val pokemonList by mainViewModel.pokemonList.collectAsState()

                if (pokemonList.isEmpty()) {
                    LoadingScreen()
                } else {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { PokedexTopBar() }
                    ) { innerPadding ->
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
