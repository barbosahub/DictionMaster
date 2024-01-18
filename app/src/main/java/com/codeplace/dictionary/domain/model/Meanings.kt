package com.codeplace.dictionary.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Meanings(
    var definitions: List<Definitions>
)