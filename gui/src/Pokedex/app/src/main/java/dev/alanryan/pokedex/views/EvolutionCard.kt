package dev.alanryan.pokedex.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.alanryan.pokedex.models.Pokemon
import androidx.compose.material3.CardDefaults

@Composable
fun EvolutionCard(
    currentPokemon: Pokemon
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            Text(
                text = "Evoluções",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.DarkGray
                )
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                currentPokemon.let { pokemon ->
                    if (pokemon.evolutions.isNotEmpty()) {
                        pokemon.evolutions.forEachIndexed { index, evolutions ->
                            if (index < pokemon.evolutions.size - 1) {
                                Text(
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .align(Alignment.CenterVertically),
                                    text = "${evolutions} -> ",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )
                                )
                            } else {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically),
                                    text = evolutions,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        color = Color.Black
                                    )
                                )
                            }
                        }
                    } else  {
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterVertically),
                            text = "Não há evoluções.",
                            style = TextStyle(
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    }
}