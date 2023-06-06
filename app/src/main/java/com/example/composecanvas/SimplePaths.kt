package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimplePaths(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Canvas(modifier = Modifier ){
            val path = Path().apply {
                moveTo(100f,100f)
                lineTo(500f,100f)
                lineTo(300f,500f)
                close()
            }
            drawPath(
                path = path,
                color = Color.Red,
                style = Fill
            )
            drawPath(
                path = path,
                color = Color.Black,
                style = Stroke( width = 5.dp.toPx() )

            )
        } } }

@Composable
fun PathStrokeStyles()
{
    Box {
        Canvas(modifier = Modifier ){
            val path1 = Path().apply {
                moveTo(100f,100f)
                lineTo(500f,100f)
            }
            val path2 = Path().apply {
                moveTo(100f,200f)
                lineTo(500f,200f)
                lineTo(500f,400f)
                close()
            }
            val path3 = Path().apply {
                moveTo(100f,500f)
                lineTo(500f,500f)
            }
            val path4 = Path().apply {
                moveTo(100f,600f)
                lineTo(500f,600f)
                lineTo(500f,800f)
                close()
            }
            drawPath(
                path = path1,
                color = Color.Black,
                style = Stroke(
                    width = 15.dp.toPx()
                )
            )
            drawPath(
                path = path2,
                color = Color.Red,
                style = Stroke(
                    width = 15.dp.toPx(),
                    join = StrokeJoin.Round,
                    //join = StrokeJoin.Miter,
                    //join = StrokeJoin.Bevel,
                )
            )
            drawPath(
                path = path3,
                color = Color.Black,
                style = Stroke(
                    width = 15.dp.toPx(),
                    //cap = StrokeCap.Square
                    cap = StrokeCap.Round
                    //cap = StrokeCap.Butt
                )
            )
            drawPath(
                path = path4,
                color = Color.Red,
                style = Stroke(
                    width = 15.dp.toPx(),
                    miter = 5f
                )
            )
        }
    }
}

@Composable
fun QuadraticBezierLine() {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier ){
            val path = Path().apply {
                moveTo(100f,100f)
                quadraticBezierTo(x1 = 300f, y1 = 300f, x2 = 500f, y2 = 100f)
            }
            drawCircle(
                color = Color.Red,
                radius = 10f,
                center = Offset(300f,300f)
            )
            drawPath(
                path = path,
                color = Color.Black,
                style = Stroke( width = 5.dp.toPx() )
            )
        } }
}

@Composable
fun CubicBezierLine() {
    Box(modifier = Modifier.fillMaxSize()) {
        Canvas(modifier = Modifier ){
            val path = Path().apply {
                moveTo(100f,100f)
                cubicTo(x1 = 200f, y1 = 300f,x2 = 400f, y2 = 300f,  x3 = 500f, y3 =100f)
            }
            drawCircle(
                color = Color.Red,
                radius = 10f,
                center = Offset(200f,300f)
            )
            drawCircle(
                color = Color.Red,
                radius = 10f,
                center = Offset(300f,300f)
            )
            drawPath(
                path = path,
                color = Color.Black,
                style = Stroke( width = 5.dp.toPx() )
            )
        } }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewSimplePaths() {
    QuadraticBezierLine()
}