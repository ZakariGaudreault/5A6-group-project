package com.example.snapfit

import android.content.Context
import com.example.snapfit.entities.authentication.AuthRepositoryFirebase
import com.example.snapfit.entities.authentication.IAuthRepository
import com.example.snapfit.entities.profile.IProfileRepository
import com.example.snapfit.entities.profile.ProfileRepositoryFirebase
import com.example.snapfit.entities.profile.ProgressRepositoryFirebase
import com.example.snapfit.entities.progress.IProgressRepository
import com.example.snapfit.entities.workout.IWorkoutRepository
import com.example.snapfit.entities.workout.WorkoutRepositoryFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

/** This module provides the specific object(s) we will inject */
class AppModule(
    private val appContext: Context,
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage,
) {
    /* Create appropriate repository (backed by a DataStore) on first use.
       Only one copy will be created during lifetime of the application. */
    val profileRepository: IProfileRepository by lazy {
        ProfileRepositoryFirebase(firestore)
    }
    val progressRepository: IProgressRepository by lazy {
        ProgressRepositoryFirebase(firestore, storage)
    }
    val workoutRepository: IWorkoutRepository by lazy {
        WorkoutRepositoryFirebase(firestore)
    }
    val authRepository: IAuthRepository by lazy {
        AuthRepositoryFirebase(auth) // inject Firebase auth
    }
}