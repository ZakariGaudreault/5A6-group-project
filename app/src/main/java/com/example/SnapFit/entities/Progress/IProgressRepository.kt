package com.example.snapfit.entities.progress

import kotlinx.coroutines.flow.Flow

interface IProgressRepository {
    suspend fun addProgress(progress: Progress): Boolean

    suspend fun removeProgress(progress: Progress)

    suspend fun getAllProgress(email: String): Flow<List<Progress>>

    // TODO having a getSpecificTimeFrameProgress would be good
}