package com.codeplace.dictionary.presentation.ui.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.codeplace.dictionary.R
import com.codeplace.dictionary.presentation.ui.theme.Blue
import com.codeplace.dictionary.presentation.ui.theme.fontButton


@Preview(name = "standardButton", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    StandardButton(
        text = stringResource(R.string.search)
    ) {

    }
}

@Composable
fun StandardButton(
    text: String,
    onClick: () -> Unit
) {

    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
            .height(64.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = text.uppercase(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = fontButton,
            letterSpacing = 0.1.em
        )
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StandardButton(
    word: String,
    bringIntoViewRequester: BringIntoViewRequester,
    text: String,
    onClick: () -> Unit
) {
    val alphaValue by animateFloatAsState(
        targetValue = if (word.isNotEmpty()) 1f else 0f, animationSpec = tween(500),
        label = ""
    )

    Button(
        onClick = {
            onClick()
        },
        enabled = word.isNotEmpty(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 27.dp)
            .height(64.dp)
            .bringIntoViewRequester(bringIntoViewRequester)
            .alpha(alphaValue),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            text = text.uppercase(),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = fontButton,
            letterSpacing = 0.1.em
        )
    }
}
