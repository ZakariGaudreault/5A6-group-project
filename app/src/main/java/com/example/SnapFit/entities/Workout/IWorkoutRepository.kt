package com.example.snapfit.entities.workout

import kotlinx.coroutines.flow.Flow

interface IWorkoutRepository {
    suspend fun saveWorkout(workout: Workout)
    suspend fun getAllWorkouts(email:String): Flow<List<Workout>>
}