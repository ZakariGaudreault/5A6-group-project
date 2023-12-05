package com.example.snapfit.entities.Workout

import kotlinx.coroutines.flow.Flow

interface IWorkoutRepository {
    suspend fun saveWorkout(workout: Workout)
    suspend fun getAllWorkouts(): Flow<List<Workout>>
}