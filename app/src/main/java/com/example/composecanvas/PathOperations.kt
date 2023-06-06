package com.example.composecanvas

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BasicPathOperations() {
    Box {
        Canvas(modifier = Modifier ){
            val rectangle = Path().apply {
                addRect(Rect(Offset(200f, 200f), Size(200f, 200f)))
            }
            val circle = Path().apply {
                addOval(Rect(Offset(200f, 200f), 100f))
            }
            val pathDifferance  = Path().apply {
                op(circle,rectangle, PathOperation.Difference)
            }
            val pathUnion  = Path().apply {
                op(circle,rectangle, PathOperation.Union)
            }
            val pathXor  = Path().apply {
                op(circle,rectangle, PathOperation.Xor)
            }
            val pathIntersect  = Path().apply {
                op(circle,rectangle, PathOperation.Intersect)
            }
            val pathReverseDifference  = Path().apply {
                op(circle,rectangle, PathOperation.ReverseDifference)
            }
            drawPath(
                path = rectangle,
                color = Color.Blue,
                style = Stroke(width = 4.dp.toPx())
            )
            drawPath(
                path = circle,
                color = Color.Red,
                style = Stroke(width = 4.dp.toPx())
            )
            drawPath(
                path = pathDifferance,
                color = Color.Green
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewSimplePathsOps() {
    BasicPathOperations()
}