package com.example.snapfit.views.workout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.snapfit.MyApp
import com.example.snapfit.entities.workout.IWorkoutRepository
import com.example.snapfit.entities.workout.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WorkoutViewModel(private val workoutRepository: IWorkoutRepository) : ViewModel() {
    // private UI state (MutableStateFlow)
    private val _activeWorkouts = MutableStateFlow<List<Workout>>(emptyList())

    // public getter for the state (StateFlow)
    val activeWorkouts: StateFlow<List<Workout>> = _activeWorkouts.asStateFlow()

    /** Retrieves the list of all workouts */
    fun getAllWorkouts() {
        viewModelScope.launch {
            workoutRepository.getAllWorkouts().collect { workouts: List<Workout> ->
                _activeWorkouts.value = workouts
            }
        }
    }

    /** Adds a new workout to the list */
    fun addWorkout(workout: Workout) {
        viewModelScope.launch {
            workoutRepository.saveWorkout(workout)
            getAllWorkouts() // Refresh the list after adding a new workout
        }
    }
}

/* ViewModel Factory that will create our view model by injecting the
      WorkoutRepository from the module.
 */
class WorkoutViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WorkoutViewModel(MyApp.appModule.workoutRepository) as T
    }
}
