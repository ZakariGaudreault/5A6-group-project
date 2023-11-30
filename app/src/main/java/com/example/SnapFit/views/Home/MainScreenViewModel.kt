package com.example.snapfit.views.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.snapfit.MyApp
import com.example.snapfit.entities.profile.IProfileRepository
import com.example.snapfit.entities.profile.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenViewModel(private val profileRepository: IProfileRepository) : ViewModel() {
    private val _activeProfile = MutableStateFlow(Profile())

    // public getter for the state (StateFlow)
    val activeProfile: StateFlow<Profile> = _activeProfile.asStateFlow()

    /** Changes the active profile to the profile with the indicated name */
    fun getProfile(email: String) {
        viewModelScope.launch {
            profileRepository.getProfile(email).collect { profile: Profile ->
                _activeProfile.value = profile
                println("this is the profile" + _activeProfile.value.email)
            }
        }
    }
}

/* ViewModel Factory that will create our view MainScreenViewModel by injecting the
      ProfileDataStore from the module.
 */
class MainScreenViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainScreenViewModel(MyApp.appModule.profileRepository) as T
    }
}