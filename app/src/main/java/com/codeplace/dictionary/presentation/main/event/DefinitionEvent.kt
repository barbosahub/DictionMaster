package com.codeplace.dictionary.presentation.main.event


sealed class DefinitionEvent {
    data object GetDefinitionsClick : DefinitionEvent()
}