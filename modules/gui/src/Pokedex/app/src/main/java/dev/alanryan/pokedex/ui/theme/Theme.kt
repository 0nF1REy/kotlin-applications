package dev.alanryan.pokedex.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val PokedexLightScheme = lightColorScheme(
    primary = PokedexRed,
    onPrimary = Color.White,
    surface = PokedexRed,
    onSurface = Color.White,
    secondary = PokedexRed,
    onSecondary = Color.White
)

private val PokedexDarkScheme = darkColorScheme(
    primary = PokedexRed,
    onPrimary = Color.White,
    surface = PokedexRed,
    onSurface = Color.White,
    secondary = PokedexRed,
    onSecondary = Color.White
)

@Composable
fun PokedexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    useDynamicColors: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme =
        if (useDynamicColors && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        } else {
            if (darkTheme) PokedexDarkScheme else PokedexLightScheme
        }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
