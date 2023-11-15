package com.example.SnapFit.Entities

data class User(
    val id: String,
    val weight: Double,
    val name: String,
    val password: String,
    val snaps: List<Snap>,
)