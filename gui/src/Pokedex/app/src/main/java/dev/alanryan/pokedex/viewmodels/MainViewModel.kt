package dev.alanryan.pokedex.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alanryan.pokedex.models.Pokemon
import dev.alanryan.pokedex.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    init {
        getPokemons()
    }

    private fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.retrofit.getPokemons()

            _pokemonList.value = response.body()?.pokemonList ?: emptyList()
        }
    }
}
