package ca.qc.cstj.jetbizcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.jetbizcard.models.Profile
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _mainUiState = MutableStateFlow<MainUIState>(MainUIState.Loading)
    val mainUIState : StateFlow<MainUIState> = _mainUiState.asStateFlow()

    init {
        viewModelScope.launch {
            repeat(5) {
                _mainUiState.update {state ->
                    MainUIState.Success(Profile("View Model $it"))
                }
                delay(2500)
            }
        }

    }

}