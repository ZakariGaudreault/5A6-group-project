package com.example.snapfit.views.profile

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

/** Simple view MainScreenViewModel that keeps track of a single value (count in this case) */
class ProfileViewModel(private val profileRepository: IProfileRepository) : ViewModel() {
    // private UI state (MutableStateFlow)
    private val _activeProfile = MutableStateFlow(Profile())

    // public getter for the state (StateFlow)
    val activeProfile: StateFlow<Profile> = _activeProfile.asStateFlow()

    /** Changes the active profile to the profile with the indicated name */
    fun getProfile(email: String) {
        viewModelScope.launch {
            profileRepository.getProfile(email).collect { profile:Profile ->
                _activeProfile.value = profile
                println("this is the profile" + _activeProfile.value.email)
            }
        }
    }

    fun setProfile(profile: Profile) {
        viewModelScope.launch {
            profileRepository.saveProfile(profile)
            _activeProfile.value = profile
        }
    }

//    fun setName(newName: String) {
//        viewModelScope.launch {
//            if (_activeProfile == null || _activeProfile.value.name.isEmpty()) {
//                val newProfile = ProfileData(newName)
//                _activeProfile.update { newProfile }
//                userProfileRepository.saveProfile(newName, newProfile)
//            } else {
//                var oldName = _activeProfile.value.name
//                _activeProfile.update { it.copy(name = newName) }
//                userProfileRepository.saveProfile(oldName, _activeProfile.value)
//            }
//        }
//    }

//    fun deleteProfile(name: String) {
//        viewModelScope.launch {
//            userProfileRepository.delete(name)
//        }
//    }
}

/* ViewModel Factory that will create our view MainScreenViewModel by injecting the
      ProfileDataStore from the module.
 */
class ProfileViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(MyApp.appModule.profileRepository) as T
    }
}