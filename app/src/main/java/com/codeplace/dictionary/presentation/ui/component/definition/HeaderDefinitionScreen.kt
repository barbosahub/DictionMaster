package com.codeplace.dictionary.presentation.ui.component.definition

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.dictionary.R
import com.codeplace.dictionary.domain.model.Definition
import com.codeplace.dictionary.domain.model.Definitions
import com.codeplace.dictionary.domain.model.Meanings
import com.codeplace.dictionary.domain.model.Phonetics
import com.codeplace.dictionary.presentation.ui.theme.Blue
import com.codeplace.dictionary.presentation.ui.theme.fontSubTitle
import com.codeplace.dictionary.presentation.ui.theme.fontTitle
import com.codeplace.dictionary.util.playAudio
import java.util.Locale


@Preview(name = "headerDefinitionScreen", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    HeaderDefinitionScreen(
        Definition(
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
                        )
                    )
                )
            )
        )
    )
}

@Composable
fun HeaderDefinitionScreen(
    definition: Definition
) {
    val context = LocalContext.current
    var firstMp3File: String? = null
    definition.phonetics.forEach { phonetics ->
        if (phonetics.audio?.contains(".mp3") == true) {
            firstMp3File = phonetics.audio
            return@forEach
        }
    }


    Column {
        Text(
            style = fontTitle,
            text = definition.word.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 13.dp)
        ) {
            Box(
                modifier = Modifier.background(
                    color = Blue,
                    shape = RoundedCornerShape(corner = CornerSize(50.dp))
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_audio),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                           context.playAudio(firstMp3File)
                        }
                        .width(46.dp)
                        .height(46.dp)
                        .padding(11.dp)
                        .clip(shape = RoundedCornerShape(8.dp)),
                )
            }

            Spacer(modifier = Modifier.width(7.dp))

            Text(
                style = fontSubTitle,
                text = definition.phonetic,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .alpha(0.4f)
                    .padding(horizontal = 11.dp)
            )
        }
    }
}
