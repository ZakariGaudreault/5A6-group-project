package com.example.snapfit.entities.Workout

import com.google.firebase.Timestamp

data class Workout(
    var email: String = "Not available",
    var name: String = "Not available",
    var duration: Double = 0.0,
    var date: Timestamp = Timestamp.now(), //used as the id
    var exercises:List<String>
)