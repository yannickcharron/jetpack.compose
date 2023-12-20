package ca.qc.cstj.jetbizcard

import ca.qc.cstj.jetbizcard.models.Profile

sealed class MainUIState {
    class Success(val profile: Profile) : MainUIState()
    object Loading: MainUIState()
    class Error(val exception: Exception): MainUIState()
}