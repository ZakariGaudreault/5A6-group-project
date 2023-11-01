package com.example.assignment3.navigation

/**
 * The different possible routes of the navigation
 * @param route The "address" of the route
 */
sealed class Routes(val route: String) {
    object Main : Routes("MainScreenRoute")
    
    object StartUp : Routes("StartUpRoute")

    object Login : Routes("LoginScreen")

    object SignUp : Routes("SignUpRoute")

    object Profile : Routes("ProfileScreenRoute")

    object Workouts : Routes("WorkoutsScreen")

    object Exercises : Routes("ExercisesScreen")
}