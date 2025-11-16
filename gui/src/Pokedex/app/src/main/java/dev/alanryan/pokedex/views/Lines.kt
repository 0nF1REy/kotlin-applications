package dev.alanryan.pokedex.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Lines() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
    ) {
        val startX = 0f
        val startY = size.height / 3f
        val endX = size.width / 3f

        drawLine(
            color = Color.White,
            start = Offset(startX, startY),
            end = Offset(endX, startY),
            strokeWidth = 8f
        )

        val lineLength = 200f
        val angle = Math.toRadians(45.0)

        val deltaX = (lineLength * cos(angle)).toFloat()
        val deltaY = (lineLength * sin(angle)).toFloat()

        val diagonalEndX = endX + deltaX
        val diagonalEndY = startY - deltaY

        drawLine(
            color = Color.White,
            start = Offset(endX, startY),
            end = Offset(diagonalEndX, diagonalEndY),
            strokeWidth = 8f
        )

        drawLine(
            color = Color.White,
            start = Offset(diagonalEndX, diagonalEndY),
            end = Offset(size.width, diagonalEndY),
            strokeWidth = 8f
        )
    }
}