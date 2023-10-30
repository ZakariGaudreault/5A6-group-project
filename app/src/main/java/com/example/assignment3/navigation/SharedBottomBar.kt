package com.example.assignment3.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kotlinwithcompose.screens.LocalNavController

/**
 * The default bottom nav bar with three elements : Home button(which is the list of the deathbeds), about button, and an add option button
 */
@Composable
fun SharedBottomBar() {
    BottomAppBar {
        val navController = LocalNavController.current
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        data class NavBarIcon(
            val route: String,
            val icon: ImageVector,
        )

        // List of items routes in a NavBarIcon class, to be used in the bottom navbar
        val items =
            listOf(
                NavBarIcon(route = Routes.About.route, icon = Icons.Filled.Build),
                NavBarIcon(route = Routes.Main.route, icon = Icons.Filled.Home),
                NavBarIcon(route = Routes.AddSingleDeathBed.route, icon = Icons.Filled.Phone),
            )

        // The loop that enables the display of all the nav items from the list above
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.route) },
                selected =
                    currentDestination?.hierarchy?.any {
                        currentDestination.route?.substringBefore('/') == item.route.substringBefore('/')
                    } == true,
                onClick = { navController.navigate(item.route) },
            )
        }
    }
}