package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.snapfit.layout.AuthLayout
import com.example.snapfit.layout.MainLayout
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.authentication.AuthViewModelFactory
import com.example.snapfit.views.authentication.home.AuthScreen
import com.example.snapfit.views.authentication.login.LoginScreen
import com.example.snapfit.views.authentication.signup.SignUpScreen
import com.example.snapfit.views.exercise.ExercisesScreen
import com.example.snapfit.views.home.MainScreen
import com.example.snapfit.views.profile.ProfileScreen
import com.example.snapfit.views.profile.ProfileViewModel
import com.example.snapfit.views.profile.ProfileViewModelFactory
import com.example.snapfit.views.workout.WorkoutsScreen

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }

/**
 * The router used to navigate the different routes. Defaults to the MainScreen
 */
@Composable
fun Router() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())
    val profileViewModel: ProfileViewModel = viewModel(
        factory = ProfileViewModelFactory(),
    )
    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        NavHost(navController = navController, startDestination = Routes.Auth.route) {
            composable(Routes.Main.route) {
                RedirectToAuth(authViewModel,profileViewModel) {
                    MainLayout {
                        MainScreen(profileViewModel)
                    }
                }
            }
            composable(Routes.Login.route) {
                RedirectToHome(authViewModel,profileViewModel) {
                    AuthLayout {
                        LoginScreen(authViewModel,profileViewModel)
                    }
                }
            }
            composable(Routes.SignUp.route) {
                RedirectToHome(authViewModel,profileViewModel) {
                    AuthLayout {
                        SignUpScreen(authViewModel,profileViewModel)
                    }
                }
            }
            composable(Routes.Auth.route) {
                RedirectToHome(authViewModel,profileViewModel) {
                    AuthLayout {
                        AuthScreen(authViewModel)
                    }
                }
            }
            composable(Routes.Profile.route) {
                RedirectToAuth(authViewModel,profileViewModel) {
                    MainLayout {
                        ProfileScreen(authViewModel,profileViewModel)
                    }
                }
            }
            composable("${Routes.Exercises.route}/{exerciseType}") { backStackEntry ->
                val exerciseType = backStackEntry.arguments?.getString("exerciseType") ?: ""
                RedirectToAuth(authViewModel,profileViewModel) {
                    MainLayout {
                        ExercisesScreen(type = exerciseType)
                    }
                }
            }

            composable(Routes.Workouts.route) {
                RedirectToAuth(authViewModel,profileViewModel) {
                    MainLayout {
                        WorkoutsScreen()
                    }
                }
            }
        }
    }
}


