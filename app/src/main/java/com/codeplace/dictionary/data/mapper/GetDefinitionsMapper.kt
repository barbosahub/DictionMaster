package com.codeplace.dictionary.data.mapper

import com.codeplace.dictionary.data.remote.dto.DefinitionDto
import com.codeplace.dictionary.domain.model.Definition

object GetDefinitionsMapper {
    fun mapListDtoToDomain(dtoList: List<DefinitionDto>): List<Definition> {
        return dtoList.map { mapDtoToDomain(it) }
    }

    private fun mapDtoToDomain(dto: DefinitionDto): Definition {
        return Definition(
            word = dto.word,
            phonetic = dto.phonetic,
            phonetics = dto.phonetics,
            meanings = dto.meanings
        )
    }
}
