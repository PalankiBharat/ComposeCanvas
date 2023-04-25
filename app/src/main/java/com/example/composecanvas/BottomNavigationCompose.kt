package com.example.composecanvas

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composecanvas.ui.theme.PhonePeDarkColor
import com.example.composecanvas.ui.theme.PhonePeGrayColor
import com.example.composecanvas.ui.theme.PhonePeLightColor
import com.example.composecanvas.ui.theme.PhonePeTransparentColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun Navigation(navController: NavHostController) {


    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("cart") {
            CartScreen(navController = navController)
        }

        composable("settings") {
            HomeScreen(navController = navController)
        }

        composable("menu") {
            CartScreen(navController = navController)
        }
    }


}


@Composable
fun PhonePeStyleBottomNavigation(navController: NavHostController, list: List<BottomNavigationScreens>) {

    NavigationBar(
        containerColor = PhonePeDarkColor
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        var current by remember {
            mutableStateOf(navController.currentDestination?.route)
        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            current = destination.route
        }
        val animatableCircle1 = remember { Animatable(100f) }
        val animatableCircle2 = remember { Animatable(120f) }
        val animatableCircle3 = remember { Animatable(100f) }

        var isSelected by remember {
            mutableStateOf(true)
        }

        LaunchedEffect(animatableCircle1.value) {
            if (animatableCircle1.isRunning.not() && animatableCircle1.value == 0f) {
                isSelected = false
            }
        }

        LaunchedEffect(isSelected) {
            if (isSelected)
            {
                animatableCircle1.snapTo(100f)
                delay(150)
                animatableCircle1.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 1000)
                )
            }
        }
        LaunchedEffect(isSelected) {
            if (isSelected)
            {
                animatableCircle2.snapTo(120f)
                delay(150)
                animatableCircle2.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        }
        LaunchedEffect(isSelected) {
            if (isSelected)
            {
                animatableCircle3.snapTo(100f)
                animatableCircle3.animateTo(
                    targetValue = 0f,
                    animationSpec = tween(durationMillis = 400)
                )
            }
        }

        list.forEach { screen ->
            NavigationBarItem(
                modifier = Modifier.padding(0.dp),
                icon = {
                    Icon(
                        modifier = Modifier.drawBehind {
                            if (current == screen.route) {

                                val path = Path().apply {
                                    addArc(
                                        Rect(center = center, radius = size.width*0.8f),0f,360f
                                    )
                                }
                                clipPath(path = path)
                                {
                                    drawCircle(color = PhonePeTransparentColor, center = Offset(center.x+animatableCircle3.value,center.y) , radius = size.width*0.8f)
                                    drawCircle(color = PhonePeLightColor, center = Offset(center.x-animatableCircle2.value,center.y) , radius = size.width*0.8f)
                                    drawCircle(color = Color.White, center = Offset(center.x-animatableCircle1.value,center.y) , radius = size.width*0.8f)
                                }
                            }
                        } ,
                        imageVector = screen.icon,
                        contentDescription = screen.route
                    )
                },
                label = { Text(screen.route.uppercase()) },
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
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.White,
                    indicatorColor = PhonePeDarkColor,
                    unselectedIconColor = PhonePeGrayColor,
                    unselectedTextColor = PhonePeGrayColor,
                ),
                // this is to remove the ripple effect
                interactionSource = NoRippleInteractionSource()
            )
        }

    }

}

// For Removing ripple effect from anything
class NoRippleInteractionSource : MutableInteractionSource {

    override val interactions: Flow<Interaction> = emptyFlow()

    override suspend fun emit(interaction: Interaction) {}

    override fun tryEmit(interaction: Interaction) = true
}


