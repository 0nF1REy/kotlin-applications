package dev.alanryan.pokedex.ui.screens.pokedex.components.navigationbuttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
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
    val arrangement = when {
        currentIndex == 0 -> Arrangement.Center
        currentIndex >= totalPokemons - 1 && totalPokemons > 1 -> Arrangement.Center
        else -> Arrangement.SpaceBetween
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 16.dp),
        horizontalArrangement = arrangement
    ) {
        when {
            currentIndex == 0 && totalPokemons > 1 -> {
                NextButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onNextClick
                )
            }

            currentIndex >= totalPokemons - 1 && totalPokemons > 1 -> {
                PreviousButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onPreviousClick
                )
            }

            totalPokemons > 1 -> {
                PreviousButton(
                    modifier = Modifier.weight(1f),
                    onClick = onPreviousClick
                )
                Spacer(modifier = Modifier.width(16.dp))
                NextButton(
                    modifier = Modifier.weight(1f),
                    onClick = onNextClick
                )
            }
        }
    }
}

@Composable
private fun PreviousButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
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
}

@Composable
private fun NextButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
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
