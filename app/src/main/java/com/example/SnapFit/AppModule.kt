package com.example.snapfit

import android.content.Context
import com.example.snapfit.entities.Progress.IProgressRepository
import com.example.snapfit.entities.Workout.IWorkoutRepository
import com.example.snapfit.entities.Workout.WorkoutRepositoryFirebase
import com.example.snapfit.entities.authentication.IAuthRepository
import com.example.snapfit.entities.authentication.IAuthRepositoryFirebase
import com.example.snapfit.entities.profile.IProfileRepository
import com.example.snapfit.entities.profile.ProfileRepositoryFirebase
import com.example.snapfit.entities.profile.ProgressRepositoryFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/** This module provides the specific object(s) we will inject */
class AppModule(
    private val appContext: Context,
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) {
    /* Create appropriate repository (backed by a DataStore) on first use.
       Only one copy will be created during lifetime of the application. */
    val profileRepository: IProfileRepository by lazy {
        ProfileRepositoryFirebase(firestore)
    }
    val progressRepository: IProgressRepository by lazy {
        ProgressRepositoryFirebase(firestore)
    }
    val workoutRepository: IWorkoutRepository by lazy {
        WorkoutRepositoryFirebase(firestore)
    }
    val authRepository: IAuthRepository by lazy {
        IAuthRepositoryFirebase(auth) // inject Firebase auth
    }
}