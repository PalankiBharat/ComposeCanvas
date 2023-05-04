package com.example.composecanvas

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomNavigationScreens(val route: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("Home", Icons.Filled.Home)
    object Cart : BottomNavigationScreens("Cart",  Icons.Filled.ShoppingCart)
    object Menu : BottomNavigationScreens("Menu",  Icons.Filled.Menu)
    object Settings : BottomNavigationScreens("Settings", Icons.Filled.Settings)
}