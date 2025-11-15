package dev.alanryan.pokedex.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt

@Composable
fun Circles() {
    Box {
        Canvas(
            modifier = Modifier
                .padding(top = 12.dp)
                .size(70.dp)
        ) {
            drawCircle(
                color = Color("#4CA2DA".toColorInt()),
                radius = size.minDimension / 5f,
                center = center
            )

            drawCircle(
                color = Color.White,
                radius = (size.minDimension / 5.5f) + 5f,
                center = center,
                style = Stroke(width = 5f)
            )

            drawCircle(
                color = Color.Red,
                radius = size.minDimension / 10f,
                center = Offset(center.x + size.minDimension / 1.3f, center.y)
            )

            drawCircle(
                color = Color.Yellow,
                radius = size.minDimension / 10f,
                center = Offset(center.x + size.minDimension / 0.9f, center.y)
            )

            drawCircle(
                color = Color.Green,
                radius = size.minDimension / 10f,
                center = Offset(center.x + size.minDimension / 0.7f, center.y)
            )
        }
    }
}