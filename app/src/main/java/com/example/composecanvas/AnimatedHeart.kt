package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedHeart(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(300.dp)){
        val canvasWidth = size.width
        val canvasHeight = size.height
       // val animatable = remember
        val path = Path().apply {
            moveTo(canvasWidth/2,canvasHeight)
            cubicTo(canvasWidth,canvasHeight*0.7f, canvasWidth,0f,canvasWidth/2,canvasHeight/3)
            moveTo(canvasWidth/2,canvasHeight)
            cubicTo(0f,canvasHeight*0.7f, 0f,0f,canvasWidth/2,canvasHeight/3)

            //lineTo(canvasWidth/2,canvasHeight/4)

        }

        drawPath(path = path, color = Color.Red, style = Stroke(width = 2.dp.toPx()))
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedHeartPreview() {
    AnimatedHeart()
}