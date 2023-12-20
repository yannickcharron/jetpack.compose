package ca.qc.cstj.navigationdemo.ui.screens.profile

import ca.qc.cstj.navigationdemo.models.Profile

sealed class ProfileUIState {

    //class Success(val profile: Profile) : ProfileUIState()
    data class Success(val profile: String) : ProfileUIState()
    object Loading : ProfileUIState()
    data class Error(val message: String): ProfileUIState()
    //class Error(val exception: Exception): ProfileUIState()
    data class NewState(val message: String): ProfileUIState()
}