package com.codeplace.dictionary.presentation.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codeplace.dictionary.R
import com.codeplace.dictionary.presentation.ui.theme.fontBold
import com.codeplace.dictionary.presentation.ui.theme.fontLight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StandardTextField(
    focusManager: FocusManager,
    coroutineScope: CoroutineScope,
    bringIntoViewRequester: BringIntoViewRequester,
    onText: (text: String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    val isTextFieldEmpty by derivedStateOf { text.isEmpty() }

    Box(
        modifier = Modifier
            .padding(horizontal = 27.dp, vertical = 124.dp)
            .background(Color.Transparent)
    ) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onText(text)
            },
            textStyle = LocalTextStyle.current.copy(
                color = Color.Black,
                fontFamily = fontBold.fontFamily,
                fontWeight = fontBold.fontWeight,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .onFocusEvent {
                    if (it.isFocused) {
                        coroutineScope.launch {
                            bringIntoViewRequester.bringIntoView()
                        }
                    }
                }
        )

        if (isTextFieldEmpty) {
            Text(
                text = stringResource(R.string.type_a_word),
                style = fontLight,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 12.dp)
                    .background(Color.Transparent)
                    .align(Alignment.Center)
                    .alpha(0.5f)
            )
        }
    }
}