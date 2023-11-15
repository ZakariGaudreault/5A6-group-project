package com.example.snapfit.navigation

/**
 * The different possible routes of the navigation
 * @param route The "address" of the route
 */
sealed class Routes(val route: String) {
    object Main : Routes("MainScreenRoute")

    object Auth : Routes("AuthRoute")

    object Login : Routes("LoginScreen")

    object SignUp : Routes("SignUpRoute")

    object Profile : Routes("ProfileScreenRoute")

    object Workouts : Routes("WorkoutsScreen")

    object Exercises : Routes("ExercisesScreen")

    object Upload : Routes("UploadScreen")
}