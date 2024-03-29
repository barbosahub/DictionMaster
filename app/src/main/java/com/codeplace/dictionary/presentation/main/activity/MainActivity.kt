package com.codeplace.dictionary.presentation.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codeplace.dictionary.data.datastore.DataStoreManager
import com.codeplace.dictionary.presentation.main.screen.DefinitionScreen
import com.codeplace.dictionary.presentation.main.screen.HomeScreen
import com.codeplace.dictionary.presentation.main.screen.PurchaseScreen
import com.codeplace.dictionary.presentation.main.screen.SplashScreen
import com.codeplace.dictionary.presentation.main.viewModel.MainViewModel
import com.codeplace.dictionary.presentation.ui.theme.DictionaryTheme
import com.codeplace.dictionary.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            DictionaryTheme {
                // This fun adjust the keyboard
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { view, insets ->
                    val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
                    view.updatePadding(bottom = bottom)
                    insets
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<MainViewModel>()
                    val navController = rememberNavController()
                    val scope = rememberCoroutineScope()
                    val dataStore = DataStoreManager(LocalContext.current)
                    val state = viewModel.state.value

                    LaunchedEffect(key1 = state) {
                        if (state.result != null) {
                            dataStore.saveSearch(
                                state.result?.get(0)!!,
                                word.trim().lowercase()
                            )
                            navController.navigate(Screen.Definition.route)
                        }
                    }

                    NavHost(navController = navController, startDestination = Screen.Splash.route) {
                        composable(route = Screen.Splash.route) {
                            SplashScreen {
                                navController.navigate(Screen.Home.route)
                            }
                        }

                        composable(route = Screen.Home.route) {
                            HomeScreen(
                                coroutineScope = scope,
                                navController = navController,
                                definitionState = state,
                                onEvent = viewModel::onEvent
                            )
                        }

                        composable(route = Screen.Definition.route) {
                            val result = state.result?.get(0)!!
                            DefinitionScreen(result, navController)
                        }

                        composable(route = Screen.Purchase.route) {
                            PurchaseScreen(navController)
                        }
                    }

                }
            }
        }
    }

    companion object {
        var word = ""
    }
}



