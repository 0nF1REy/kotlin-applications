package dev.alanryan.pokedex.views

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.alanryan.pokedex.R
import dev.alanryan.pokedex.models.Pokemon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun PokemonImageFrame(
    currentPokemon: Pokemon,
    font: FontFamily
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(colorResource(R.color.red))
    ) {
        Canvas(
            modifier = Modifier
                .matchParentSize()
        ) {
            val path = Path().apply {
                moveTo(0f, 0f)
                lineTo(size.width, 0f)
                lineTo(size.width, size.height)
                lineTo(size.width * 0.15f, size.height)
                lineTo(0f, size.height * 0.85f)
                close()
            }

            clipPath(path) {
                drawRect(Color.White)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(16.dp)
                    .background(Color.LightGray)
                    .clip(RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                currentPokemon.let {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxWidth(),
                        model = it.pokemonImage,
                        contentDescription = "",
                        contentScale = ContentScale.Fit
                    )
                }
            }

            currentPokemon.let {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "${it.pokedexNumber}: ${it.name}",
                    fontFamily = font,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    fontSize = 24.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = it.type.joinToString(separator = ", "),
                    fontFamily = font,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold
                    ),
                    fontSize = 16.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}