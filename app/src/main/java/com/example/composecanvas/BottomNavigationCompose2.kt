@file:OptIn(ExperimentalTextApi::class)

package com.example.composecanvas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecanvas.ui.theme.PhonePeDarkColor
import com.example.composecanvas.ui.theme.PhonePeGrayColor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun BottomNavigationBar2(navController: NavHostController, list: List<BottomNavigationScreens>) {

    NavigationBar() {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        var current by remember {
            mutableStateOf(navController.currentDestination?.route)
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            current = destination.route
        }

        var isSelected by remember {
            mutableStateOf(true)
        }

        list.forEach { screen ->
            NavigationBarItem(
                modifier = Modifier.padding(0.dp),
                icon = {
                    val isSelected = current == screen.route
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.drawBehind {
                            if (isSelected) {
                                drawRoundRect(color = PhonePeGrayColor, cornerRadius = CornerRadius(100f))
                            }

                        }.padding(horizontal = 10.dp, vertical = 5.dp)
                    ) {
                        Icon(
                            modifier = Modifier.padding(end = 5.dp, start = 0.dp) ,
                            imageVector = screen.icon,
                            contentDescription = screen.route,
                            tint = if (isSelected) Color.White else Color.Black
                        )
                        AnimatedVisibility(visible = current == screen.route ) {
                            Text(text = screen.route, fontSize = 12.sp, color = if (isSelected) Color.White else Color.Black)
                        }

                    }

                },
                selected = currentRoute == screen.route,
                onClick = {
                    isSelected = true
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(LocalAbsoluteTonalElevation.current) ,
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Black,
                ),
                interactionSource = NoRippleInteractionSource()
            )
        }

    }

}




