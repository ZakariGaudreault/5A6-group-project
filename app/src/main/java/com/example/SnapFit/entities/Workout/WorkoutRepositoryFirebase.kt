package com.example.snapfit.entities.Workout

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class WorkoutRepositoryFirebase(db: FirebaseFirestore) : IWorkoutRepository {
    private val dbWorkouts = db.collection("Workouts")

    override suspend fun saveWorkout(workout: Workout) {
        dbWorkouts.document(workout.date.toString()).set(workout)
            .addOnSuccessListener {
                println("Workout saved.")
            }
            .addOnFailureListener { e ->
                println("Error saving workout: $e")
            }
    }

    override suspend fun getAllWorkouts(): Flow<List<Workout>> =
        callbackFlow {
            // Listen for changes on the entire collection
            val subscription = dbWorkouts.addSnapshotListener { snapshot, error ->
                if (error != null) {
                    // An error occurred
                    println("Listen failed: $error")
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    // The collection has documents, so convert them all to Workout objects
                    val workouts = snapshot.toObjects(Workout::class.java)
                    if (workouts != null) {
                        println("Real-time update to workouts")
                        trySend(workouts)
                    } else {
                        println("Workouts have become null")
                        trySend(listOf<Workout>()) // If there are no saved workouts, then send a default object
                    }
                } else {
                    // The workouts collection does not exist or has no data
                    println("Workouts collection does not exist")
                    trySend(listOf<Workout>()) // Send default object
                }
            }
            awaitClose { subscription.remove() }
        }
}
