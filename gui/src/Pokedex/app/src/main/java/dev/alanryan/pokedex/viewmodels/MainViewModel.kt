package dev.alanryan.pokedex.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.alanryan.pokedex.models.Pokemon
import dev.alanryan.pokedex.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel : ViewModel() {
    private var _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemonList = _pokemonList.asStateFlow()

    init {
        getPokemons()
    }

    private fun getPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = RetrofitClient.retrofit.getPokemons()

                if (response.isSuccessful) {
                    _pokemonList.value = response.body()?.pokemonList ?: emptyList()
                } else {
                    Log.e("MainViewModel", "Erro na resposta da API: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("MainViewModel", "Falha ao buscar Pokémons: ${e.message}")
            }
        }
    }
}