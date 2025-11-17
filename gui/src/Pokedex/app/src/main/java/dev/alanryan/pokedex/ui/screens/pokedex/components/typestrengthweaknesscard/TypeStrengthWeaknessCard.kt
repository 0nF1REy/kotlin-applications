package dev.alanryan.pokedex.ui.screens.pokedex.components.typestrengthweaknesscard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.alanryan.pokedex.models.Pokemon
import dev.alanryan.pokedex.utils.getTypeColor
import dev.alanryan.pokedex.utils.getTypeStringResource

@Composable
fun TypeStrengthWeaknessCard(
    currentPokemon: Pokemon
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            TypeColumn(
                modifier = Modifier.weight(1f),
                title = "FORTE CONTRA",
                typesList = currentPokemon.strongAgainst
            )

            TypeColumn(
                modifier = Modifier.weight(1f),
                title = "FRACO CONTRA",
                typesList = currentPokemon.weakAgainst
            )
        }
    }
}

@Composable
private fun TypeColumn(
    modifier: Modifier = Modifier,
    title: String,
    typesList: List<String>
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )

        typesList.forEach { type ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                colors = CardDefaults.cardColors(containerColor = getTypeColor(type))
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    text = stringResource(id = getTypeStringResource(type)),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
