package com.codeplace.dictionary.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavHostController

import com.codeplace.dictionary.data.datastore.DataStoreConstants.RESEARCH
import com.codeplace.dictionary.domain.model.Definition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {

//    val getLanguage: Flow<Lang> = context.dataStore.data.map {
//        if (it[LANGUAGE] != null) {
//            when (it[LANGUAGE]) {
//                "es" -> Lang.ES
//                "pt" -> Lang.PT
//                else -> Lang.DEFAULT
//            }
//        } else {
//            Lang.DEFAULT
//        }
//    }
//
//    val hasOnboardingScreen: Flow<Boolean> = context.dataStore.data
//        .map { preferences ->
//            preferences[HAS_ONBOARDING_SCREEN] ?: true
//        }
//
//    suspend fun saveResearch(definition: Definition) {
//
//        context.dataStore.edit {
//            it[RESEARCH] = definition
//        }
//    }

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
    }
}