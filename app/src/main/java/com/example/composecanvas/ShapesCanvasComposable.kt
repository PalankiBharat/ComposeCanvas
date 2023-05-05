package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShapeCanvasComposableRect() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawRect(
                color = Color.Black,
                topLeft = Offset(100f,100f),
                size = Size(500f,700f)
            )
        }
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight())
        {
            drawRect(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Blue, Color.Cyan),
                    center =  Offset(350f,450f)
                ),
                topLeft = Offset(100f,100f),
                size = Size(500f,700f)
            )
        }
    }
}

@Composable
fun ShapeCanvasComposableCircle() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawCircle(
                color = Color.Black,
                center = center,
                radius = 300f
            )
        }
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight())
        {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Blue, Color.Cyan),
                    center =  center
                ),
                center = center,
                radius = 300f
            )
        }
    }
}

@Composable
fun ShapeCanvasComposableArc() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawArc(
                color = Color.Red,
                startAngle = 270f,
                sweepAngle = 90f,
                useCenter = true,
                topLeft = Offset(100f,100f),
                size = Size(500f,500f)
            )

            drawRect(color = Color.Green,
                    topLeft = Offset(100f,100f),
                style = Stroke(width = 6f),
                size = Size(500f,500f)
            )
        }
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight())
        {

            drawArc(
                color = Color.Green,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = Offset(100f,100f),
                size = Size(500f,500f)
            )
        }
    }
}

@Composable
fun ShapeCanvasComposableOval() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawOval(
                color = Color.Red,
                topLeft = Offset(100f,100f),
                size = Size(300f,500f)
            )

            drawRect(color = Color.Green,
                topLeft = Offset(100f,100f),
                style = Stroke(width = 6f),
                size = Size(300f,500f)
            )
        }
    }
}

@Composable
fun ShapeCanvasComposableRoundRect() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawRoundRect(
                color = Color.Black,
                topLeft = Offset(100f,100f),
                size = Size(500f,700f),
                cornerRadius = CornerRadius(50f,50f)
            )
        }
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight())
        {
            drawRoundRect(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Blue, Color.Cyan),
                    center =  Offset(350f,450f)
                ),
                topLeft = Offset(100f,100f),
                size = Size(500f,700f),
                cornerRadius = CornerRadius(50f,50f)
            )
        }
    }
}

@Composable
fun ShapeCanvasComposableCircularSector() {
    Column(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f))
        {
            drawArc(
                color = Color.Red,
                startAngle = 30f,
                sweepAngle = 300f,
                useCenter = true,
                topLeft = Offset(100f,100f),
                size = Size(500f,500f),
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ShapeCanvasComposablePreview() {
    ShapeCanvasComposableCircularSector()
}