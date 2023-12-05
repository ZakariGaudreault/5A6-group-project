package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel

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
    } else navController.navigate(Routes.Auth.route)
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
    } else content()
}