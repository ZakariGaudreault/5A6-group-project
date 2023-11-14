package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snapfit.layout.MainLayout
import com.example.snapfit.screen.ExercisesScreen
import com.example.snapfit.screen.LoginScreen
import com.example.snapfit.screen.MainScreen
import com.example.snapfit.screen.ProfileScreen
import com.example.snapfit.screen.SignUpScreen
import com.example.snapfit.screen.StartUpScreen
import com.example.snapfit.screen.WorkoutsScreen

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }

/**
 * The router used to navigate the different routes. Defaults to the MainScreen
 */
@Composable
fun Router() {
    val navController = rememberNavController()
    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        // TODO add the routes for login and sign up
        MainLayout {
            NavHost(navController = navController, startDestination = "StartUpRoute") {
                composable(Routes.Main.route) { MainScreen() }
                composable(Routes.Login.route) { LoginScreen() }
                composable(Routes.SignUp.route) { SignUpScreen() }
                composable(Routes.StartUp.route) { StartUpScreen() }
                composable(Routes.Profile.route) { ProfileScreen() }
                composable(Routes.Exercises.route) { ExercisesScreen() }
                composable(Routes.Workouts.route) { WorkoutsScreen() }
            }
        }
    }
}