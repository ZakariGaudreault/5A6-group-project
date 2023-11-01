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

    object About : Routes("AboutScreenRoute")

    object SingleDeathBed : Routes("SingleDeathBedRoute/{id}") {
        fun go(id: String) = "SingleDeathBedRoute/$id"
    }

    object AddSingleDeathBed : Routes("AddSingleDeathBedRoute")
}