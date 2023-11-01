package com.example.assignment3.navigation

/**
 * The different possible routes of the navigation
 * @param route The "address" of the route
 */
sealed class Routes(val route: String) {
    object Main : Routes("MainScreenRoute")

    object Profile : Routes("ProfileScreenRoute")

    object SingleDeathBed : Routes("SingleDeathBedRoute/{id}") {
        fun go(id: String) = "SingleDeathBedRoute/$id"
    }

    object AddSingleDeathBed : Routes("AddSingleDeathBedRoute")
}