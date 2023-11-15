package com.example.SnapFit.Entities

import android.media.Image
import java.time.LocalDate


data class Snap(
    val image: Image,
    val weight: Double,
    val date: LocalDate
)