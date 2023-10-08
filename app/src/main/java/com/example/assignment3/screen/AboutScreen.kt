package com.example.assignment3.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.md_theme_light_onErrorContainer
import com.example.kotlinwithcompose.screens.LocalNavController

/**
 * The about screen of the app, to display the use of the app.
 */
@Composable
fun AboutScreen() {
    val errorColor = md_theme_light_onErrorContainer
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "This app has been inspired by the anime Death Note, that I have never seen. " +
                        "Please be careful while using the app, unforeseeable consequences might happen. It might not be reversible.",
                color = errorColor
            )
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(20.dp)
            )

            // These text have been generated by chatGPT
            // https://chat.openai.com/share/9f088be3-121f-401d-833f-4be69ab2d799
            Text(
                text = "Unresolved reference: Modifier",
                color = errorColor
            )

            Text(
                text = "Type mismatch: The required type is Modifier, but the provided type is AlignmentModifier",
                color = errorColor
            )

            Text(
                text = "'Text' expects a 'String' but a '@StringRes Int' was found",
                color = errorColor
            )

            Text(
                text = "'Modifier.fillMaxSize' is deprecated. Use 'Modifier.fillMaxSize()' instead",
                color = errorColor
            )

            Text(
                text = "Missing composable function: 'Column' requires a composable child",
                color = errorColor
            )

            Text(
                text = "Ambiguous references: Multiple 'Modifier' imports found in different packages",
                color = errorColor
            )

            Text(
                text = "'Modifier.clickable' requires an 'onClick' parameter",
                color = errorColor
            )

            Text(
                text = "'Modifier.background' expects a 'Color' parameter, but 'ColorResource' was given",
                color = errorColor
            )

            Text(
                text = "'Image' composable requires a 'Painter' parameter",
                color = errorColor
            )

            Text(
                text = "'Column' composable requires at least one child element",
                color = errorColor
            )
        }
    }
}