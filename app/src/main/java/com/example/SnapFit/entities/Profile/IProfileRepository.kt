package com.example.snapfit.entities.profile

import kotlinx.coroutines.flow.Flow

/**
 * Interface for the ProfileRepositoryFirebase class
 */

interface IProfileRepository {
    suspend fun saveProfile(profile: Profile)

    suspend fun getProfile(email: String): Flow<Profile>

    suspend fun clear()
}