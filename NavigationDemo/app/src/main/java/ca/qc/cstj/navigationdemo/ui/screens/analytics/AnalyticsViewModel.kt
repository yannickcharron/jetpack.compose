package ca.qc.cstj.navigationdemo.ui.screens.analytics

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import ca.qc.cstj.navigationdemo.ui.screens.list.ListUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AnalyticsViewModel(href: String) : ViewModel() {

    private val _uiState = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState.asStateFlow()

    init {
        _uiState.value = href
    }

    companion object {
        fun Factory(href:String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                AnalyticsViewModel(href)
            }
        }
    }


}