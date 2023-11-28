package ca.qc.cstj.navigationdemo.ui.screens.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class ListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ListUIState())
    val uiState: StateFlow<ListUIState> = _uiState.asStateFlow()

    fun random() {
        _uiState.value = uiState.value.copy(counter = Random.nextInt(from = 0, until = 100))
    }
}