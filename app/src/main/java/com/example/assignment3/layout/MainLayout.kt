package com.example.assignment3.layout

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.assignment3.navigation.SharedBottomBar
import com.example.assignment3.navigation.SharedTopBar


/**
 * The main/default layout of the screen, with a top and bottom bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MainLayout(content: @Composable () -> Unit) {
    Scaffold(
        topBar = { SharedTopBar("DEATH NOTE") },
        bottomBar = { SharedBottomBar() },
    ) {
        Column(modifier = Modifier.padding(it)) {
            content()
        }
    }
}