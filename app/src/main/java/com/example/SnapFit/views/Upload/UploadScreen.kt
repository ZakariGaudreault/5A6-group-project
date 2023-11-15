package com.example.SnapFit.views.Upload

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.widget.DatePicker
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import com.example.snapfit.R
import com.example.snapfit.navigation.LocalNavController
import com.example.snapfit.navigation.Routes
import com.google.android.engage.common.datamodel.Image
import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadScreen() {

    val navController = LocalNavController.current
    var sliderPosition by remember { mutableStateOf(0f) }
    val colors = MaterialTheme.colorScheme
    val takePicture = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture(),
        onResult = { success ->
            if (success) {
            }
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Centered Title
        Text(
            text = "Upload",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )

        // Custom Date Picker
        var selectedDate by remember { mutableStateOf(Calendar.getInstance()) }
        var isDatePickerVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            value = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time),
            onValueChange = {},
            label = { Text("Select Date") },
            trailingIcon = {
                IconButton(
                    onClick = {
                        // Toggle date picker visibility
                        isDatePickerVisible = !isDatePickerVisible
                    }
                ) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    // Show date picker on click
                    isDatePickerVisible = true
                }
        )

        if (isDatePickerVisible) {
            DatePickerDialog(
                LocalContext.current,
                { _, year, month, dayOfMonth ->
                    // Handle date selection here
                    selectedDate = Calendar.getInstance().apply {
                        set(Calendar.YEAR, year)
                        set(Calendar.MONTH, month)
                        set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    }
                    isDatePickerVisible = false
                },
                selectedDate.get(Calendar.YEAR),
                selectedDate.get(Calendar.MONTH),
                selectedDate.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        var capturedPhotoUri by remember { mutableStateOf<Uri?>(null) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    //takePicture.launch(createImageUri(LocalContext.current))
                }
        ) {
            if (capturedPhotoUri != null) {
                Image(
                    painter = painterResource(id = R.drawable.chocolate),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Gray)
                        .clip(MaterialTheme.shapes.medium)
                        .align(Alignment.CenterHorizontally)
                )
            } else {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

        var weight by remember { mutableStateOf("") }

        TextField(
            value = weight,
            onValueChange = { weight = it },
            modifier =
            Modifier
                .align(Alignment.CenterHorizontally)
                .size(400.dp, 100.dp)
                .padding(8.dp)
                .border(3.dp, Color.Black)
                .padding(top = 16.dp),

            textStyle = TextStyle(fontSize = 16.sp),
            keyboardOptions =
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
            ),
            placeholder = { Text("Enter weight", color = Color.Gray) },
        )


        Button(
            onClick = {
                navController.navigate(Routes.Profile.route)
            },
            modifier =
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp)
                .size(180.dp, 60.dp),
        ) {
            Text("Upload")
        }

    }
}

private fun createImageUri(context: Context): Uri {
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
    val storageDir: File = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        FileProvider.getUriForFile(
            context,
            "${context.packageName}.fileprovider",
            File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
        )
    } else {
        Uri.fromFile(File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir))
    }
}