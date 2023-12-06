package com.example.snapfit.entities.progress

import android.media.Image
import com.google.firebase.Timestamp

data class Progress(
    var email: String = "Not available",
    var weight: Double = 0.0,
    var date: Timestamp = Timestamp.now(), //used as the id
    var image: Image
)
