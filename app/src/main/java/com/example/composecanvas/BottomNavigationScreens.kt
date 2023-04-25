package com.example.composecanvas

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavigationScreens(val route: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("home", Icons.Filled.Home)
    object Cart : BottomNavigationScreens("cart",  Icons.Filled.ShoppingCart)
    object Menu : BottomNavigationScreens("menu",  Icons.Filled.Menu)
    object Settings : BottomNavigationScreens("settings", Icons.Filled.Settings)
}