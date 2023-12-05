package com.example.snapfit.entities.Progress

import kotlinx.coroutines.flow.Flow

interface IProgressRepository {
    suspend fun addProgress(progress: Progress)

    suspend fun removeProgress(progress: Progress)

    suspend fun getAllProgress(): Flow<List<Progress>>

    //TODO having a getSpecificTimeFrameProgress would be good
}