package ca.qc.cstj.navigationdemo.ui.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _profileUiState = MutableStateFlow<ProfileUIState>(ProfileUIState.Loading)
    val profileUiState : StateFlow<ProfileUIState> = _profileUiState.asStateFlow()

    private lateinit var  refreshJob : Job

    init {
        refreshState()
    }

    private fun refreshState() {
        refreshJob = viewModelScope.launch {
            while(true) {
                val state = listOf(ProfileUIState.Loading, ProfileUIState.Error("YannickError"), ProfileUIState.Success("YannickProfile")).random()
                _profileUiState.update {
                    state
                }
                delay(30000L)
            }
        }
    }

    fun changeState() {
        _profileUiState.update {
            ProfileUIState.NewState("NewState")
        }

    }

    private fun handle() {
        _profileUiState.update {
            ProfileUIState.Success("Success")
        }
    }

}