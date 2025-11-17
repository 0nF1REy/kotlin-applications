package dev.alanryan.pokedex.utils

import android.content.Context
import com.google.gson.Gson

inline fun <reified T> loadJsonFromAssets(context: Context, fileName: String): T {
    val json = context.assets.open(fileName).bufferedReader().use { it.readText() }
    return Gson().fromJson(json, T::class.java)
}
