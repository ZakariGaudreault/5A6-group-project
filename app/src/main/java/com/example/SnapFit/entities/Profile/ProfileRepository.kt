package com.example.snapfit.entities.Profile

import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    suspend fun saveProfile(profile: Profile)
    fun getProfile(): Flow<Profile>
    suspend fun clear()
}