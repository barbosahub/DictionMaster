package com.codeplace.dictionary.data.remote.repository

import com.codeplace.dictionary.data.mapper.GetDefinitionsMapper
import com.codeplace.dictionary.data.remote.API
import com.codeplace.dictionary.data.remote.stateFlow.StateFlow
import com.codeplace.dictionary.domain.model.Definition
import com.codeplace.dictionary.domain.repository.NetworkRepository
import retrofit2.HttpException
import java.io.IOException

class NetworkRepositoryImpl(val api: API) : NetworkRepository {
    override suspend fun getDefinitions(word: String): StateFlow<List<Definition>> {
        return try {
            val result = api.getDefinitions(language = "en", word)
            StateFlow.Success(GetDefinitionsMapper.mapListDtoToDomain(result))
        } catch (e: IOException) {
            StateFlow.Error(e.message.toString())
        } catch (e: HttpException) {
            StateFlow.Error(e.message.toString())
        }
    }
}