package br.com.fiap.parkingbikers.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill

class CanvasComponent(
    private val colors: List<Color>
) {
    @Composable
    fun drawCanvas() {

        Canvas(
            modifier = Modifier.fillMaxSize()) {
            val startY = 0f

            drawRect(
                brush = Brush.verticalGradient(
                    colors = colors,
                    startY = startY,
                    endY = size.height
                ),
                topLeft = Offset(0f, startY),
                size = Size(size.width, size.height),
                style = Fill
            )
        }
    }
}