package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CanvasLine() {
    val x1 = 1000f
    val y1 = 1200f
    val path = Path().apply {
        moveTo(200f,800f)
        quadraticBezierTo(x1,y1,1000f,800f)
        //lineTo(1000f,800f)
    }
    Canvas(modifier = Modifier.fillMaxSize())
    {
        drawPath(path = path, Color.Red, style = Stroke(width = 10f))
        drawCircle(Color.Black, center = Offset(x1,y1), radius = 20f)
    }
}


@Preview(showSystemUi = true)
@Composable
fun CanvasLinePrev() {
    CanvasLine()
}