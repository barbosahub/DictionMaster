package com.codeplace.dictionary.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import com.codeplace.dictionary.domain.model.Definition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.time.LocalDate

class DataStoreManager(private val context: Context) {
    fun getSearch(word: String): Flow<Definition?> {
        return context.dataStore.data.map { preferences ->
            val result = preferences[stringPreferencesKey(word)] ?: ""
            if (result.isNotEmpty()) Json.decodeFromString<Definition>(result)
            else null
        }
    }

    suspend fun saveSearch(definition: Definition, word: String) {
        val search: String = Json.encodeToString(definition)
        context.dataStore.edit {
            it[stringPreferencesKey(word)] = search
        }
    }

    fun getCount(): Flow<Int> {
        return context.dataStore.data.map { preferences ->
            preferences[intPreferencesKey("count")] ?: 0
        }
    }

    fun getLastSearchDate(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[stringPreferencesKey("last_search")] ?: ""
        }
    }

    suspend fun incrementSearch() {
        context.dataStore.edit {
            val count = it[intPreferencesKey("count")] ?: 0
            it[intPreferencesKey("count")] = count + 1

            it[stringPreferencesKey("last_search")] = LocalDate.now().toString()
        }
    }

    suspend fun resetIncrementSearch() {
        context.dataStore.edit {
            it[intPreferencesKey("count")] = 0
        }
    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
    }
}

