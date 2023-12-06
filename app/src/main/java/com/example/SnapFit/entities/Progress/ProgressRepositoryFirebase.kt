package com.example.snapfit.entities.profile

import com.example.snapfit.entities.progress.IProgressRepository
import com.example.snapfit.entities.progress.Progress
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

//https://github.com/alexmamo/CloudStorageJetpackCompose/blob/master/app/src/main/java/ro/alexmamo/cloudstoragejetpackcompose/data/repository/ProfileImageRepositoryImpl.kt
class ProgressRepositoryFirebase(db: FirebaseFirestore, firebaseStorage: FirebaseStorage) : IProgressRepository {
    private val dbProgress = db.collection("Progress")
    private val storage = firebaseStorage

    // creates download url from storage, then add it to the progress passed in, then saves the progress in the
    // firestore
    override suspend fun addProgress(progress: Progress):Boolean {
        try{
            val downloadUrl = storage.reference.child(progress.email).child(progress.uri.toString())
                .putFile(progress.uri).await()
                .storage.downloadUrl.await()

            progress.url = downloadUrl.path.toString();
            println(progress.url)
            println(progress.uri.toString())
            dbProgress.document(progress.uri.toString()).set(progress)
                .addOnSuccessListener {
                    println("Progress added.")
                }
                .addOnFailureListener { e ->
                    println("Error adding progress: $e")
                }
            return true
        }
        catch (e:Exception){
            return false
        }
    }

    override suspend fun removeProgress(progress: Progress) {
        dbProgress.document(progress.uri.toString())
            .delete()
            .addOnSuccessListener { println("Progress successfully deleted!") }
            .addOnFailureListener { error -> println("Error deleting Progress: $error") }
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
