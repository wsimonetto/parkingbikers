package br.com.fiap.parkingbikers

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.parkingbikers.screens.LoginScreen
import br.com.fiap.parkingbikers.screens.MapaScreen
import br.com.fiap.parkingbikers.screens.MenuScreen
import br.com.fiap.parkingbikers.screens.OpeningScreen
import br.com.fiap.parkingbikers.screens.UserRegisterScreen
import br.com.fiap.parkingbikers.ui.theme.ParkingBikersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParkingBikersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.blue)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "opening",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(1000),
                            ) + fadeOut(animationSpec = tween(1000))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Down,
                                animationSpec = tween(1000)
                            )
                        }
                    )
                    {
                        composable(route = "opening") {
                            OpeningScreen(navController)
                        }
                        composable(route = "login") {
                            LoginScreen(navController)
                        }
                        composable(route = "MapaScreen") {
                            MapaScreen(context = this@MainActivity)
                        }
                        composable(route = "UserRegisterScreen"){
                            UserRegisterScreen()
                        }
                        composable(route = "MenuScreen"){
                            MenuScreen(navController)
                        }
                    }
                }
            }
        }
    }
}