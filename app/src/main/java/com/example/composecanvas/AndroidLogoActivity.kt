package com.example.composecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.composecanvas.BottomNavigationScreens.*

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        CanvasLine()
      /*      val navController = rememberNavController()

          Scaffold(
              bottomBar = {
                  BottomNavigationBar2(navController =navController , list = listOf(Home,Cart,Settings,Menu) )
              }
          ) { padding->
              Column(modifier = Modifier.padding(padding)) {
                  AsyncImage(model = "https://cdn.shopify.com/s/files/1/0514/6332/3817/products/1296484_1_c15f498a-4f1c-46f3-a788-3617a8f731ee_800x.png?v=1679993706", contentDescription ="" )
                  Navigation(navController = navController)
              }
          }*/
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
}