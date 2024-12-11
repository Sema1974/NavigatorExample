package com.example.navigatorexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigatorexample.model.Routes.*
import com.example.navigatorexample.ui.theme.NavigatorExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigatorExampleTheme {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController,
                    startDestination = MainScreen.route) {
                    composable(MainScreen.route) { Screen1(navigationController) }
                    composable(Pantalla2.route) { Screen2(navigationController) }
                    composable(Pantalla3.route) { Screen3(navigationController) }
                    composable(
                        PantallaConArgOblligatorios.route,
                        arguments = listOf(navArgument("name") { type = NavType.StringType })
                    ) {
                        Screen4(
                            navigationController,
                            it.arguments?.getString("name").orEmpty()
                        )
                    }
                    composable(
                        PantallaFinal.route,
                        arguments = listOf(navArgument("age") { defaultValue = 25 })
                    ) {
                        Screen5(
                            navigationController,
                            it.arguments?.getInt("age")?:0
                        )
                    }
                }


            }
        }
    }
}

