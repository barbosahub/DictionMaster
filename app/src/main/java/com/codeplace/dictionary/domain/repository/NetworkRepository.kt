package com.codeplace.dictionary.domain.repository

import com.codeplace.dictionary.data.remote.stateFlow.StateFlow
import com.codeplace.dictionary.domain.model.Definition

interface NetworkRepository {
    suspend fun getDefinitions(word: String): StateFlow<List<Definition>>
}