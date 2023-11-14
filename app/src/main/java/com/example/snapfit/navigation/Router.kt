package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snapfit.layout.AuthLayout
import com.example.snapfit.layout.MainLayout
import com.example.snapfit.views.AuthScreen
import com.example.snapfit.views.ExercisesScreen
import com.example.snapfit.views.LoginScreen
import com.example.snapfit.views.MainScreen
import com.example.snapfit.views.ProfileScreen
import com.example.snapfit.views.SignUpScreen
import com.example.snapfit.views.WorkoutsScreen

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
        NavHost(navController = navController, startDestination = Routes.Auth.route) {
            composable(Routes.Main.route) {
                MainLayout {
                    MainScreen()
                }
            }
            composable(Routes.Login.route) {
                AuthLayout {
                    LoginScreen()
                }
            }
            composable(Routes.SignUp.route) {
                AuthLayout {
                    SignUpScreen()
                }
            }
            composable(Routes.Auth.route) {
               AuthLayout {
                   AuthScreen()
               }
            }
            composable(Routes.Profile.route) {
                MainLayout {
                    ProfileScreen()
                }
            }
            composable(Routes.Exercises.route) {
                MainLayout {
                    ExercisesScreen()
                }
            }
            composable(Routes.Workouts.route) {
                MainLayout {
                    WorkoutsScreen()
                }
            }
        }
    }
}