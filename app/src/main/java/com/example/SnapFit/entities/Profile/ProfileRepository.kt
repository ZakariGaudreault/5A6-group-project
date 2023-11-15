package com.example.snapfit.entities.profile

import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun saveProfile(profile: Profile)

    fun getProfile(email: String): Flow<Profile>

    suspend fun clear()
}