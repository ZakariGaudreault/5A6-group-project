package com.example.snapfit.navigation

/**
 * The different possible routes of the navigation
 * @param route The "address" of the route
 */
sealed class Routes(val route: String) {
    object Snap : Routes("SnapScreenRoute")

    object Main : Routes("MainScreenRoute")

    object Auth : Routes("AuthRoute")

    object Login : Routes("LoginRoute")

    object SignUp : Routes("SignUpRoute")

    object Profile : Routes("ProfileScreenRoute")

    object Workouts : Routes("WorkoutsRoute")

    object Exercises : Routes("ExercisesRoute")

    object PastWorkout : Routes("PastWorkoutRoute")

    object Upload : Routes("UploadRoute")

    object DeepLink : Routes("DeepLinkScreen")

    object About : Routes("aboutScreen")

}