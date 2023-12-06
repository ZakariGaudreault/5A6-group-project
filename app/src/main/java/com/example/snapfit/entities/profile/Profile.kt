package com.example.snapfit.entities.profile

/**
 * Defines the properties that a user should have on the app
 */

data class Profile(
    var email: String = "Not available",
    var name: String = "Not available",
    var timeSpent: Double = 0.0,
    var currentWeight: Double = 100.0,
    var originalWeight: Double = 0.0,
    var amountWorkoutDone: Int = 0,
)