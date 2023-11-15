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
import com.example.snapfit.views.authentication.home.AuthScreen
import com.example.snapfit.views.authentication.login.LoginScreen
import com.example.snapfit.views.authentication.signup.SignUpScreen
import com.example.snapfit.views.exercise.ExercisesScreen
import com.example.snapfit.views.home.MainScreen
import com.example.snapfit.views.profile.ProfileScreen
import com.example.snapfit.views.workout.WorkoutsScreen

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