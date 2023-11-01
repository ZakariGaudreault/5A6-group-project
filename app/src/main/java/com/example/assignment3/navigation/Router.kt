package com.example.kotlinwithcompose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment3.components.DeathBed
import com.example.assignment3.layout.MainLayout
import com.example.assignment3.navigation.Routes
import com.example.assignment3.rememberMutableStateListOf
import com.example.assignment3.screen.AboutScreen
import com.example.assignment3.screen.AddSingleDeathBedScreen
import com.example.assignment3.screen.LoginScreen
import com.example.assignment3.screen.MainScreen
import com.example.assignment3.screen.StartUpScreen
import com.example.assignment3.screen.ViewSingleDeathBedScreen

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }
val LocalDeathBeds = compositionLocalOf<MutableList<DeathBed>> { error("No deathbed list found") }

/**
 * The router used to navigate the different routes. Defaults to the MainScreen
 */
@Composable
fun Router() {
    val navController = rememberNavController()
    val deathBeds = rememberMutableStateListOf<DeathBed>()

    // Two providers, so I can also access the list of deathbeds
    CompositionLocalProvider(
        LocalNavController provides navController,
        LocalDeathBeds provides deathBeds,
    ) {
        MainLayout {
            NavHost(navController = navController, startDestination = "StartUpRoute") {
                composable(Routes.Main.route) { MainScreen() }
                composable(Routes.About.route) { AboutScreen() }
                composable(Routes.Login.route) { LoginScreen() }
                composable(Routes.StartUp.route) { StartUpScreen() }
                composable(Routes.AddSingleDeathBed.route) { AddSingleDeathBedScreen() }
                composable(Routes.SingleDeathBed.route) {
                    ViewSingleDeathBedScreen(it.arguments?.getString("id") ?: "")
                }
            }
        }
    }
}