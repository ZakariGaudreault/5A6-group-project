package com.example.SnapFit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.SnapFit.layout.MainLayout
import com.example.SnapFit.screen.ExercisesScreen
import com.example.SnapFit.screen.LoginScreen
import com.example.SnapFit.screen.MainScreen
import com.example.SnapFit.screen.ProfileScreen
import com.example.SnapFit.screen.SignUpScreen
import com.example.SnapFit.screen.StartUpScreen
import com.example.SnapFit.screen.WorkoutsScreen

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
        //TODO add the routes for login and sign up
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