package com.example.snapfit.views.snap

import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import coil.annotation.ExperimentalCoilApi
import java.util.*

@OptIn(ExperimentalCoilApi::class)
class SnapViewModel(): ViewModel() {

    private val _capturedImageUri = mutableStateOf<Uri>(Uri.EMPTY)
    val capturedImageUri: State<Uri> = _capturedImageUri

    fun setUri(uri: Uri) {
        _capturedImageUri.value = uri
    }
}
