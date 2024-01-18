package com.codeplace.dictionary.domain.model

import kotlinx.serialization.Serializable
@Serializable
data class Definitions(
    var definition: String? = "",
    var example: String? = ""
)