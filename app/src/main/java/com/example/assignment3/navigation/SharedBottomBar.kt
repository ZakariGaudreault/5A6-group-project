package com.example.assignment3.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.assignment3.R
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
            val icon: ImageVector? = null,
            val iconResId: Int
        )

        // List of items routes in a NavBarIcon class, to be used in the bottom navbar
        val items = listOf(
            NavBarIcon(route = Routes.Main.route, iconResId = R.drawable.house),
            NavBarIcon(route = Routes.Workouts.route, iconResId = R.drawable.workout),
            NavBarIcon(route = Routes.Profile.route, iconResId = R.drawable.gear),
        )

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Image(
                        painter = painterResource(id = item.iconResId),
                        contentDescription = item.route,
                        modifier = Modifier.size(24.dp) // Adjust size as needed
                    )
                },
                selected = currentDestination?.hierarchy?.any {
                    currentDestination.route?.substringBefore('/') == item.route.substringBefore('/')
                } == true,
                onClick = { navController.navigate(item.route) },
            )
        }
    }
}