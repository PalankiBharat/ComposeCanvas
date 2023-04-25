package com.example.composecanvas

import kotlin.math.PI

fun Float.toRadians():Float{
    return this*(PI/100).toFloat()
}

fun Float.toDegree():Float{
    return this/(PI/100).toFloat()
}