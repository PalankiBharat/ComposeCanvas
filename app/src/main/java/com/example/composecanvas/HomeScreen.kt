package com.example.composecanvas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Home")
    }
}

@Composable
fun CartScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Cart")
    }
}