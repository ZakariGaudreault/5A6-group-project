package com.example.snapfit.entities.profile

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow

class ProfileRepositoryFirebase (val db: FirebaseFirestore) : ProfileRepository {

    override suspend fun saveProfile(profile: Profile) {
        TODO("Not yet implemented")
    }

    override fun getProfile(): Flow<Profile> {
        // Access a Cloud Firestore instance from your Activity

        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }

}