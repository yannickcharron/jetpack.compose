package ca.qc.cstj.jetbizcard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.jetbizcard.core.ApiResult
import ca.qc.cstj.jetbizcard.data.repositories.ProfileRepository
import ca.qc.cstj.jetbizcard.models.Profile
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _mainUiState = MutableStateFlow<MainUIState>(MainUIState.Loading)
    val mainUIState : StateFlow<MainUIState> = _mainUiState.asStateFlow()

    private val _profileRepository = ProfileRepository()

    init {
        viewModelScope.launch {
            _profileRepository.retrieveOne().collect {apiResult ->
                _mainUiState.update {
                    when(apiResult) {
                        is ApiResult.Error -> MainUIState.Error(IllegalStateException(apiResult.throwable))
                        ApiResult.Loading -> MainUIState.Loading
                        is ApiResult.Success -> MainUIState.Success(apiResult.data)
                    }

                }
            }
        }

    }

//    fun testCoroutine() {
//        viewModelScope.launch {
//            repeat(5) {
//                _mainUiState.update {state ->
//                    MainUIState.Success(Profile("View Model $it"))
//                }
//                delay(2500)
//            }
//        }
//    }

}