package com.example.snapfit.views.snap

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.snapfit.BuildConfig
import com.example.snapfit.entities.progress.Progress
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.example.snapfit.views.authentication.AuthViewModel
import com.example.snapfit.views.profile.ProfileViewModel
import com.example.snapfit.views.progress.ProgressViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects

// https://github.com/dheeraj-bhadoria/android-camera-example-and-compose-capture-image-jetpack-compose
@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SnapScreen(progressViewModel: ProgressViewModel, authViewModel: AuthViewModel,profileViewModel: ProfileViewModel) {
    val context = LocalContext.current
    val file = context.createImageFile()
    var capturedImageUri by rememberSaveable { mutableStateOf<Uri>(Uri.EMPTY) }
    val profile by profileViewModel.activeProfile.collectAsState()
    var weight by rememberSaveable { mutableStateOf("") }
    val auth by authViewModel.currentUser().collectAsState()
    val navController = LocalNavController.current

    val uri = FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        BuildConfig.APPLICATION_ID + ".provider", file
    )

    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {
            capturedImageUri = uri
        }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) {
            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
            cameraLauncher.launch(uri)
        } else {
            Toast.makeText(context, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val permissionCheckResult =
                ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
            if (permissionCheckResult == PackageManager.PERMISSION_GRANTED) {
                cameraLauncher.launch(uri)
            } else {
                // Request a permission
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }) {
            Text(text = "Capture Image From Camera")
        }

        if (capturedImageUri.path?.isNotEmpty() == true) {
            Image(
                modifier = Modifier
                    .padding(16.dp, 8.dp),
                painter = rememberImagePainter(capturedImageUri),
                contentDescription = "null"
            )
        }

        TextField(
            value = weight,
            onValueChange = { if (!it.contains("\n")) weight = it },
            modifier =
            Modifier
                .size(325.dp, 90.dp)
                .padding(8.dp)
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 14.sp),
            keyboardOptions =
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done,
            ),
            placeholder = { Text("Current Weight (lb)", color = Color.Gray) },
        )

        Row {
            Button(onClick = {
                navController.navigate(Routes.Main.route)
            }) {
                Text(text = "Cancel")
            }
            Button(onClick = {
                val progress = Progress(auth!!.email, weight.toDouble(), capturedImageUri)
                progressViewModel.addProgress(progress)
                profile.currentWeight = weight.toDouble() //Sets the new current weight
                profileViewModel.setProfile(profile) // saves it in the db
                navController.navigate(Routes.Profile.route)
            }) {
                Text(text = "Save")
            }
        }
    }
}

fun Context.createImageFile(): File {
    // Create an image file name
    val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
    val imageFileName = "JPEG_" + timeStamp + "_"
    return File.createTempFile(
        imageFileName, /* prefix */
        ".jpg", /* suffix */
        externalCacheDir      /* directory */
    )
}
