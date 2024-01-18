package com.codeplace.dictionary.presentation.main.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeplace.dictionary.data.remote.stateFlow.StateFlow
import com.codeplace.dictionary.domain.repository.NetworkRepository
import com.codeplace.dictionary.presentation.main.activity.MainActivity.Companion.word
import com.codeplace.dictionary.presentation.main.event.DefinitionEvent
import com.codeplace.dictionary.presentation.main.state.DefinitionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: NetworkRepository) :
    ViewModel() {

//
//    var definition by mutableStateOf(DefinitionState())
//        private set

    private val _state = mutableStateOf(DefinitionState())
    val state: State<DefinitionState> = _state

    fun onEvent(event: DefinitionEvent) {
        when (event) {
            DefinitionEvent.GetDefinitionsClick -> {
                getDefinitions()
            }
        }
    }

        private fun getDefinitions() {
         _state.value = _state.value.copy(isLoading = true)

         viewModelScope.launch {
            val mDefinition = async { repository.getDefinitions(word) }
            when (val result = mDefinition.await()) {
                is StateFlow.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = null,
                        result = result.data ?: emptyList()
                    )
                }

                is StateFlow.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }

                is StateFlow.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true,
                        error = null
                    )
                }
            }
        }
    }

//    private fun getDefinitions() {
//        definition = definition.copy(isLoading = true)
//
//         viewModelScope.launch {
//            val mDefinition = async { repository.getDefinitions(word) }
//            when (val result = mDefinition.await()) {
//                is StateFlow.Success -> {
//                    definition = definition.copy(
//                        isLoading = false,
//                        error = null,
//                        result = result.data
//                    )
//                }
//
//                is StateFlow.Error -> {
//                    definition = definition.copy(
//                        isLoading = false,
//                        error = result.message
//                    )
//                }
//
//                is StateFlow.Loading -> {
//                    definition = definition.copy(
//                        isLoading = true,
//                        error = null
//                    )
//                }
//            }
//        }
//    }
}