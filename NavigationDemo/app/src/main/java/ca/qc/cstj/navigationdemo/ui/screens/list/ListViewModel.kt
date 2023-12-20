package ca.qc.cstj.navigationdemo.ui.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class ListViewModel : ViewModel() {

    //https://medium.com/geekculture/atomic-updates-with-mutablestateflow-dc0331724405
    private val _uiState = MutableStateFlow(ListUIState())
    val uiState: StateFlow<ListUIState> = _uiState.asStateFlow()

    private var randomJob : Job? = null

    init {
        //_uiState.value = _uiState.value.copy(list = sequence.toList())
        //_uiState.update {
        //    ListUIState(counter = Random.nextInt(from = 0, until = 100) , list = listGenerator(it.counter))
        //}
        random()
    }

    fun random() {
        randomJob?.cancel()
        randomJob = viewModelScope.launch {
            while(true) {
                val counter =  Random.nextInt(from = 0, until = 100)

                _uiState.update {
                    ListUIState(counter = counter , list = listGeneratorV2(counter))
                }
                delay(5000)
            }
        }
        //_uiState.value = uiState.value.copy(counter = Random.nextInt(from = 0, until = 100))
    }


    private fun listGenerator(until: Int) : List<Int> {
        var count = 0
        return generateSequence {
            (++count).takeIf {
                it <= until
            }
        }.toList()
    }

    private fun listGeneratorV2(until: Int) :List<Int> {
        return (1..until).toList()
    }
}