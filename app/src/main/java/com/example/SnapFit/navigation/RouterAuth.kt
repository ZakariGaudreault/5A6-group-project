package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel


/**
 * Composable function to redirect to the authentication screen if the user is not authenticated or if the
 * active profile doesn't match the authenticated user's profile.
 *
 * @param authViewModel The authentication ViewModel responsible for managing user authentication state.
 * @param profileViewModel The profile ViewModel responsible for managing the active user profile state.
 * @param content The lambda function representing the content to be displayed if the conditions are met.
 */
@Composable
fun RedirectToAuth(
    authViewModel: AuthViewModel,
    profileViewModel: ProfileViewModel,
    content: @Composable () -> Unit,
) {
    val navController = LocalNavController.current
    val auth by authViewModel.currentUser().collectAsState()
    val profile by profileViewModel.activeProfile.collectAsState()

    if (auth != null && auth!!.email == profile.email) {
        content()
    } else {
        navController.navigate(Routes.Auth.route)
    }
}

@Composable
fun RedirectToHome(
    authViewModel: AuthViewModel,
    profileViewModel: ProfileViewModel,
    content: @Composable () -> Unit,
) {
    val navController = LocalNavController.current
    val auth by authViewModel.currentUser().collectAsState()
    val profile by profileViewModel.activeProfile.collectAsState()

    if (auth != null && auth!!.email == profile.email) {
        navController.navigate(Routes.Main.route)
    } else {
        content()
    }
}