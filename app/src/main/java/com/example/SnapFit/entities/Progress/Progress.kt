package com.example.snapfit.entities.progress

import com.google.firebase.Timestamp

data class Progress(
    var email: String = "",
    var weight: Double = 0.0,
    var uri: String ="",
    var url: String = "",
    var timestamp: Timestamp = Timestamp.now()
) {
    constructor() : this("", 0.0, "", "", Timestamp.now())
}
