package com.codeplace.dictionary.domain.model

data class Definition(
    var word: String,
    var phonetic: String,
    var phonetics: List<Phonetics>,
    var meanings: List<Meanings>
)