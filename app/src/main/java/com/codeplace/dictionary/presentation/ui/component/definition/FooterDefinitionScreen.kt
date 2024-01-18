package com.codeplace.dictionary.presentation.ui.component.definition

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.codeplace.dictionary.presentation.ui.component.StandardButton
import com.codeplace.dictionary.presentation.ui.theme.fontLight16
import com.codeplace.dictionary.presentation.ui.theme.fontTitle24
import com.codeplace.dictionary.presentation.util.Screen


@Preview(name = "footerDefinitionScreen", showBackground = true)
@Composable
private fun FooterDefinitionPreview() {
    FooterDefinitionScreen(
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
fun FooterDefinitionScreen(
    navController: NavController,
    definition: Definition
) {

    Column {

        Text(
            style = fontTitle24,
            text = stringResource(id = R.string.that_s_it, definition.word),
        )

        Text(
            style = fontLight16,
            text = stringResource(id = R.string.try_another_search_now),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        StandardButton(text = stringResource(id = R.string.new_search)) {
            navController.navigate(Screen.Home.route)
        }
    }

}
