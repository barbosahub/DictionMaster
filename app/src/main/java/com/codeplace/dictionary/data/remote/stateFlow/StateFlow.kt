package com.codeplace.dictionary.data.remote.stateFlow

sealed class StateFlow<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : StateFlow<T>(data)
    class Error<T>(message: String, data: T? = null) : StateFlow<T>(data, message)
    class Loading<T> : StateFlow<T>()
}