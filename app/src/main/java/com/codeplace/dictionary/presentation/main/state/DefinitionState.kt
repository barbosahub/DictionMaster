package com.codeplace.dictionary.presentation.main.state

import com.codeplace.dictionary.domain.model.Definition

data class DefinitionState(
    var result: List<Definition>? = null,
    val isLoading:Boolean? = false,
    val error:String? = ""
)
