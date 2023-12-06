package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.snapfit.views.DeepLink.DeepLink
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
import com.example.snapfit.views.progress.ProgressViewModel
import com.example.snapfit.views.progress.ProgressViewModelFactory
import com.example.snapfit.views.snap.SnapScreen
import com.example.snapfit.views.workout.PastWorkoutScreen
import com.example.snapfit.views.workout.WorkoutScreen
import com.example.snapfit.views.workout.WorkoutViewModel
import com.example.snapfit.views.workout.WorkoutViewModelFactory

val LocalNavController = compositionLocalOf<NavController> { error("No NavController found!") }

/**
 * Jetpack Compose navigation router for the application.
 *
 * This router defines the navigation structure of the application using Jetpack Compose and the Navigation
 * component. It sets up various destinations and their corresponding composable functions.
 * @Composable The main entry point for the navigation. It sets up the NavHost and defines various routes.
 */
@Composable
fun Router() {
    // Create a NavController to handle navigation
    val navController = rememberNavController()

    // ViewModels for authentication and profile screens
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())
    val profileViewModel: ProfileViewModel = viewModel(
        factory = ProfileViewModelFactory(),
    )
    val progressViewModel: ProgressViewModel = viewModel(
        factory = ProgressViewModelFactory(),
    )

    val workoutViewModel: WorkoutViewModel = viewModel(
        factory = WorkoutViewModelFactory(),
    )

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        // NavHost defines the navigation structure and sets up various composable functions for each route
        NavHost(navController = navController, startDestination = Routes.Auth.route) {
            composable(Routes.Main.route) {
                RedirectToAuth(authViewModel) {
                    MainScreen(profileViewModel,workoutViewModel)
                }
            }
            composable(Routes.PastWorkout.route) {
                RedirectToAuth(authViewModel) {
                    PastWorkoutScreen(profileViewModel,workoutViewModel)
                }
            }
            composable(Routes.Snap.route) {
                SnapScreen(progressViewModel,authViewModel, profileViewModel )
            }
            composable(Routes.Login.route) {
                RedirectToHome(authViewModel, profileViewModel) {
                    LoginScreen(authViewModel, profileViewModel)
                }
            }

            composable("DeepLink",
                // Note that this navDeepLink pattern has no relation to the route itself
                deepLinks = listOf(navDeepLink { uriPattern = "example://compose.deeplink/?id={id}" })
            ) {
                    backStackEntry ->DeepLink(backStackEntry.arguments?.getString("id"))
            }


            composable(Routes.SignUp.route) {
                RedirectToHome(authViewModel, profileViewModel) {
                    SignUpScreen(authViewModel, profileViewModel)
                }
            }
            composable(Routes.Auth.route) {
                RedirectToHome(authViewModel, profileViewModel) {
                    AuthScreen(profileViewModel, authViewModel)
                }
            }
            composable(Routes.Profile.route) {
                RedirectToAuth(authViewModel) {
                    ProfileScreen(authViewModel, profileViewModel,progressViewModel)
                }
            }
            composable("${Routes.Exercises.route}/{exerciseType}") { backStackEntry ->
                val exerciseType = backStackEntry.arguments?.getString("exerciseType") ?: ""
                RedirectToAuth(authViewModel) {
                    ExercisesScreen(type = exerciseType,workoutViewModel,profileViewModel)
                }
            }

            composable(Routes.Workouts.route) {
                RedirectToAuth(authViewModel) {
                    WorkoutScreen(workoutViewModel)
                }
            }
        }
    }
}