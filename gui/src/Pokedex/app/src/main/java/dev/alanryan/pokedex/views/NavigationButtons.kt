package dev.alanryan.pokedex.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
// Import the AutoMirrored versions of the icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.alanryan.pokedex.ui.theme.PokedexPurple

@Composable
fun NavigationButtons(
    currentIndex: Int,
    totalPokemons: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            modifier = Modifier
                .padding(end = 8.dp),
            onClick = {
                if (currentIndex > 0) {
                    onPreviousClick()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PokedexPurple
            )
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Anterior"
            )

            Text(text = "Anterior")
        }

        Button(
            modifier = Modifier
                .padding(end = 8.dp),
            onClick = {
                if (currentIndex < (totalPokemons - 1)) {
                    onNextClick()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = PokedexPurple
            )
        ) {
            Text(text = "Próximo")

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Próximo"
            )
        }
    }
}