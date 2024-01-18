package com.codeplace.dictionary.data.remote.dto

import com.codeplace.dictionary.domain.model.Meanings
import com.codeplace.dictionary.domain.model.Phonetics
import com.squareup.moshi.Json
import java.io.Serializable
data class DefinitionDto(
    @field:Json(name = "word") val word: String,
    @field:Json(name = "phonetic") val phonetic: String? = "",
    @field:Json(name = "phonetics") val phonetics: List<Phonetics>,
    @field:Json(name = "meanings") val meanings: List<Meanings>
): Serializable