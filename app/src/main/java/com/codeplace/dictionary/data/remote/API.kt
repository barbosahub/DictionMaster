package com.codeplace.dictionary.data.remote

import com.codeplace.dictionary.data.remote.dto.DefinitionDto
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("{language}/{word}")
    suspend fun getDefinitions(
        @Path("language") language: String,
        @Path("word") word: String
    ): List<DefinitionDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/"
    }
}