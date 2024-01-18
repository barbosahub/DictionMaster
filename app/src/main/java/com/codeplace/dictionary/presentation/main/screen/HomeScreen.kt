package com.codeplace.dictionary.presentation.main.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codeplace.dictionary.R
import com.codeplace.dictionary.data.datastore.DataStoreManager
import com.codeplace.dictionary.presentation.main.activity.MainActivity.Companion.word
import com.codeplace.dictionary.presentation.main.event.DefinitionEvent
import com.codeplace.dictionary.presentation.main.state.DefinitionState
import com.codeplace.dictionary.presentation.ui.component.StandardButton
import com.codeplace.dictionary.presentation.ui.component.StandardCardLanguage
import com.codeplace.dictionary.presentation.ui.component.StandardTextField
import com.codeplace.dictionary.presentation.util.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate

@Preview(name = "homeScreen", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    HomeScreen(
        coroutineScope = rememberCoroutineScope(),
        navController = rememberNavController(),
        definitionState = DefinitionState(),
        onEvent = {}
    )
}

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    coroutineScope: CoroutineScope,
    navController: NavController,
    definitionState: DefinitionState,
    onEvent: (DefinitionEvent) -> Unit
) {
    val focusManager = LocalFocusManager.current
    val bringIntoViewRequester = BringIntoViewRequester()
    var text by remember { mutableStateOf(word) }

    word = text.trim().lowercase()

    val dataStore = DataStoreManager(LocalContext.current)
    val definitionPref by dataStore.getSearch(word).collectAsState(initial = null)
    val countPref by dataStore.getCount().collectAsState(initial = 0)
    val lastSearchPref by dataStore.getLastSearchDate().collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        if (definitionState.isLoading!!)
            LinearProgressIndicator()

        Column(modifier = Modifier.padding(top = 38.dp)) {
            StandardCardLanguage()
        }

        StandardTextField(focusManager, coroutineScope, bringIntoViewRequester) {
            text = it
        }

        StandardButton(
            text,
            bringIntoViewRequester,
            text = stringResource(id = R.string.search)
        ) {

            if (word != definitionPref?.word) {
                coroutineScope.launch {
                    if (countPref <= 10) {
                        dataStore.incrementSearch()
                        onEvent(DefinitionEvent.GetDefinitionsClick)
                    } else {
                        if (lastSearchPref != LocalDate.now().toString()) {
                            dataStore.resetIncrementSearch()
                            onEvent(DefinitionEvent.GetDefinitionsClick)
                        } else {
                            navController.navigate(Screen.Purchase.route)
                        }
                    }
                }
            } else {
                definitionState.result = listOf(definitionPref!!)
                navController.navigate(Screen.Definition.route)
            }
        }
    }
}








