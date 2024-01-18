package com.codeplace.dictionary.presentation.ui.component.definition

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.dictionary.R
import com.codeplace.dictionary.domain.model.Definition
import com.codeplace.dictionary.domain.model.Definitions
import com.codeplace.dictionary.domain.model.Meanings
import com.codeplace.dictionary.domain.model.Phonetics
import com.codeplace.dictionary.presentation.ui.theme.Gray
import com.codeplace.dictionary.presentation.ui.theme.fontBody
import com.codeplace.dictionary.presentation.ui.theme.fontLight16


@Preview(name = "bodyDefinitionScreen", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    BodyDefinitionScreen(
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
                    definitions = listOf(
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
fun BodyDefinitionScreen(
    definition: Definition
) {
    val meanings = definition.meanings[0].definitions

    var num = 1
    meanings.forEach { meaning ->
        val annotatedString = buildAnnotatedString {
            append("${num})")
            withStyle(style = SpanStyle(Gray)) {
                append(" ${stringResource(id = R.string.description)} ")
            }
            append(meaning.definition)
        }

        Text(
            style = fontBody,
            text = annotatedString,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        )

        if (meaning.example != null) {
            Text(
                style = fontLight16,
                text = "• ${meaning.example}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp)
            )
        }

        num++
    }
}
