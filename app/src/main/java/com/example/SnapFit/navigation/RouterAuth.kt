package com.example.snapfit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.snapfit.layout.AuthLayout
import com.example.snapfit.layout.MainLayout
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel

@Composable
fun RedirectToAuth(
    authViewModel: AuthViewModel,
    content: @Composable () -> Unit,
) {
    val navController = LocalNavController.current
    val auth by authViewModel.currentUser().collectAsState()


    if (auth != null) {
        MainLayout {
            content()
        }
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


    if (auth != null) {
        profileViewModel.getProfile(auth!!.email)
        navController.navigate(Routes.Main.route)
    } else {
        AuthLayout {
            content()
        }
    }
}