package com.codeplace.dictionary.presentation.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codeplace.dictionary.R
import com.codeplace.dictionary.domain.model.Definition
import com.codeplace.dictionary.domain.model.Definitions
import com.codeplace.dictionary.domain.model.Meanings
import com.codeplace.dictionary.domain.model.Phonetics
import com.codeplace.dictionary.presentation.ui.component.definition.BodyDefinitionScreen
import com.codeplace.dictionary.presentation.ui.component.definition.FooterDefinitionScreen
import com.codeplace.dictionary.presentation.ui.component.definition.HeaderDefinitionScreen


@Preview(name = "definitionScreen", showBackground = true)
@Composable
private fun DefinitionScreenPreview() {
    DefinitionScreen(
        navController = rememberNavController(),
        definition = Definition(
            word = stringResource(id = R.string.title),
            phonetic = stringResource(id = R.string.subTitle),
            phonetics = listOf(
                Phonetics(
                    text = stringResource(id = R.string.subTitle),
                    audio = ""
                )
            ),
            meanings = listOf(
                Meanings(
                    listOf(
                        Definitions(
                            definition = stringResource(id = R.string.definition_text),
                            example = stringResource(id = R.string.definition_example)
                        ),
                        Definitions(
                            definition = stringResource(id = R.string.definition_text),
                            example = stringResource(id = R.string.definition_example)
                        ),
                        Definitions(
                            definition = stringResource(id = R.string.definition_text),
                            example = stringResource(id = R.string.definition_example)
                        )
                    )
                )
            )
        )
    )
}


@Composable
fun DefinitionScreen(
    definition: Definition,
    navController: NavController
) {

    Column(
        modifier = Modifier
            .navigationBarsPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())

    ) {


        Column(
            modifier = Modifier
                .padding(top = 37.dp, start = 30.dp, end = 30.dp)
        ) {
            HeaderDefinitionScreen(definition)
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            BodyDefinitionScreen(definition)
        }

        Column(
            modifier = Modifier
                .padding(vertical = 30.dp)
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
        ) {
            FooterDefinitionScreen(navController, definition)
        }
    }
}