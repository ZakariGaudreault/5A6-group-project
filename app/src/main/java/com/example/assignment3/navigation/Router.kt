package com.example.kotlinwithcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.layout.MainLayout
import com.example.assignment3.navigation.Routes
import com.example.assignment3.screen.ExercisesScreen
import com.example.assignment3.screen.MainScreen
import com.example.assignment3.screen.ProfileScreen
import com.example.assignment3.screen.WorkoutsScreen

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
            NavHost(navController = navController, startDestination = "MainScreenRoute") {
                composable(Routes.Main.route) { MainScreen() }
                composable(Routes.Profile.route) { ProfileScreen() }
                composable(Routes.Exercises.route) { ExercisesScreen() }
                composable(Routes.Workouts.route) { WorkoutsScreen() }
            }
        }
    }
}