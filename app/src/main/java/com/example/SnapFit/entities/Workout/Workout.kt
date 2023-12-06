package com.example.snapfit.entities.workout

import com.google.firebase.Timestamp

data class Workout(
    var email: String = "Not available",
    var name: String = "Not available",
    var duration: Double = 0.0,
    var exercises: List<String> = emptyList(),
    var date: Timestamp = Timestamp.now(), // used as the id
) {
    constructor() : this("", "", 0.0, emptyList(), Timestamp.now())
}
