package com.example.snapfit.views.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.snapfit.MyApp
import com.example.snapfit.entities.progress.IProgressRepository
import com.example.snapfit.entities.progress.Progress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProgressViewModel(private val progressRepository: IProgressRepository) : ViewModel() {
    private val _activeProgress = MutableStateFlow<List<Progress>>(emptyList())

    // public getter for the state (StateFlow)
    val activeProgress: StateFlow<List<Progress>> = _activeProgress.asStateFlow()

    /** Retrieves the list of all progress entries */
    fun getAllProgress(email: String) {
        viewModelScope.launch {
            progressRepository.getAllProgress(email).collect { progress: List<Progress> ->
                _activeProgress.value = progress
            }
        }
    }

    /** Adds a new progress entry to the list */
    fun addProgress(progress: Progress) {
        viewModelScope.launch {
            progressRepository.addProgress(progress)
        }
    }

    /** Deletes a progress entry from the list */
    fun removeProgress(progress: Progress) {
        viewModelScope.launch {
            progressRepository.removeProgress(progress)
        }
    }
}

/* ViewModel Factory that will create our view model by injecting the
      ProgressRepository from the module.
 */
class ProgressViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProgressViewModel(MyApp.appModule.progressRepository) as T
    }
}