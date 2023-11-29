package com.example.snapfit.entities.profile

data class Profile(
    var email: String = "jon.doe@gmail.com",
    var name: String = "",
    var timeSpent: Double = 5.0,
    var currentWeight: Double = 100.0,
    var originalWeight: Double = 20.0,
    var `amountWorkoutDone`: Int = 0,
)