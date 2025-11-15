package dev.alanryan.pokedex.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import dev.alanryan.pokedex.models.Pokemon
import dev.alanryan.pokedex.network.response.PokemonResponse
import dev.alanryan.pokedex.utils.loadJsonFromAssets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private var _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    init {
        loadPokemonsFromAssets()
    }

    private fun loadPokemonsFromAssets() {
        viewModelScope.launch(Dispatchers.IO) {

            val context = getApplication<Application>().applicationContext

            val data: PokemonResponse =
                loadJsonFromAssets(context, "pokemon_data_gen1.json")

            _pokemonList.value = data.pokemonList
        }
    }
}
