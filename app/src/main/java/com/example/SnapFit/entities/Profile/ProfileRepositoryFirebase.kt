package com.example.snapfit.entities.profile

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ProfileRepositoryFirebase(db: FirebaseFirestore) : IProfileRepository {
    private val dbProfile = db.collection("Profiles")

    override suspend fun saveProfile(profile: Profile) {
        // We are storing only a single profile at a time, so use a unique document name to refer to it
        dbProfile.document(profile.email).set(profile)
            .addOnSuccessListener {
                println("Profile saved.")
            }
            .addOnFailureListener { e ->
                println("Error saving profile: $e")
            }
    }

    override fun getProfile(email: String): Flow<Profile> =
        callbackFlow {
            val docRef = dbProfile.document(email)
            val subscription =
                docRef.addSnapshotListener { snapshot, error ->
                    if (error != null) {
                        // An error occurred
                        println("Listen failed: $error")
                        return@addSnapshotListener
                    }
                    if (snapshot != null && snapshot.exists()) {
                        // The user document has data
                        val profile = snapshot.toObject<Profile>()

                        if (profile != null) {
                            println("Real-time update to profile")
                            trySend(profile)
                        }
                    }
                }
            awaitClose { subscription.remove() }
        }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}