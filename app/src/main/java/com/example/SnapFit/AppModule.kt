package com.example.snapfit

import android.content.Context
import com.example.snapfit.entities.authentication.AuthRepository
import com.example.snapfit.entities.authentication.AuthRepositoryFirebase
import com.example.snapfit.entities.Profile.ProfileRepository
import com.example.snapfit.entities.Profile.ProfileRepositoryFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

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
        AuthRepositoryFirebase(Firebase.auth) // inject Firebase auth
    }
}