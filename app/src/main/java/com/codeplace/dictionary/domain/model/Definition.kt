package com.codeplace.dictionary.domain.model

import kotlinx.serialization.Serializable
@Serializable
data class Definition(
    var word: String,
    var phonetic: String? = "",
    var phonetics: List<Phonetics>,
    var meanings: List<Meanings>
)