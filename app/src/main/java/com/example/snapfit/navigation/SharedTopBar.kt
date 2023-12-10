package com.example.snapfit.navigation

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.snapfit.ui.theme.md_theme_light_primary

/**
 * The top bar that stays in the MainLayout. Has a back button that disappears if it's on
 * the home screen
 * @param title The title to be shown in big on the header
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SharedTopBar(
    title: String,
    route: String = Routes.Main.route,
) {
    val navController = LocalNavController.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                color = md_theme_light_primary,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier.clickable { navController.navigate(Routes.About.route) },
            )
        },
        // Logic for showing/hiding the back button
        navigationIcon = {
            if (currentDestination?.route !== route) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Go Back",
                    )
                }
            }
        },
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
            ),
    )
}