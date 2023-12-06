package com.example.snapfit.entities.progress

import android.net.Uri
import com.google.firebase.Timestamp

data class Progress(
    var email: String,
    var weight: Double,
    var uri: Uri, //used as the id
    var url: String = "",
    var timestamp: Timestamp = Timestamp.now(),
)
