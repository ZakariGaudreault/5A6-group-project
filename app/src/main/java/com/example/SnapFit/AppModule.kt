package com.example.snapfit

import android.content.Context
import com.example.snapfit.entities.authentication.AuthRepository
import com.example.snapfit.entities.authentication.AuthRepositoryFirebase
import com.example.snapfit.entities.profile.ProfileRepository
import com.example.snapfit.entities.profile.ProfileRepositoryFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

/** This module provides the specific object(s) we will inject */
class AppModule(
    private val appContext: Context,
    private val auth:FirebaseAuth,
    private val firestore:FirebaseFirestore
) {
    /* Create appropriate repository (backed by a DataStore) on first use.
       Only one copy will be created during lifetime of the application. */
    val profileRepository: ProfileRepository by lazy {
        ProfileRepositoryFirebase(firestore)
    }
    val authRepository: AuthRepository by lazy {
        AuthRepositoryFirebase(auth) // inject Firebase auth
    }
}