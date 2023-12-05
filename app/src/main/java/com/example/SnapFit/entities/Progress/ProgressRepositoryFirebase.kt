package com.example.snapfit.entities.profile

import com.example.snapfit.entities.Progress.IProgressRepository
import com.example.snapfit.entities.Progress.Progress
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class ProgressRepositoryFirebase(db: FirebaseFirestore, storage: FirebaseStorage) : IProgressRepository {
    private val dbProgress = db.collection("Progress")

    override suspend fun addProgress(progress: Progress) {
        dbProgress.document(progress.date.toString()).set(progress)
            .addOnSuccessListener {
                println("Progress added.")
            }
            .addOnFailureListener { e ->
                println("Error adding progress: $e")
            }
    }

    override suspend fun removeProgress(progress: Progress) {
        dbProgress.document(progress.date.toString())
            .delete()
            .addOnSuccessListener { println("Profile successfully deleted!") }
            .addOnFailureListener { error -> println("Error deleting profile: $error") }
    }

    override suspend fun getAllProgress(): Flow<List<Progress>> =
        callbackFlow {
            // Listen for changes on entire collection
            val subscription = dbProgress.addSnapshotListener{ snapshot, error ->
                if (error != null) {
                    // An error occurred
                    println("Listen failed: $error")
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    // The collection has documents, so convert them all to ProfileData objects
                    val progress = snapshot.toObjects(Progress::class.java)
                    if (progress != null) {
                        println("Real-time update to progress")
                        trySend(progress)
                    } else {
                        println("Progress has become null")
                        trySend(listOf<Progress>()) // If there is no saved profile, then send a default object
                    }
                } else {
                    // The user document does not exist or has no data
                    println("Progress collection does not exist")
                    trySend(listOf<Progress>()) // send default object
                }
            }
            awaitClose { subscription.remove() }
        }
}
