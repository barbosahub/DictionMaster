package com.codeplace.dictionary.domain.model

import kotlinx.serialization.Serializable
@Serializable
data class Phonetics(
    var text: String? = "",
    var audio: String? = ""
)