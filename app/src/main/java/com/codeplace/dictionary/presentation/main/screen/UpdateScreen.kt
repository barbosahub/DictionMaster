package com.codeplace.dictionary.presentation.main.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.codeplace.dictionary.R
import com.codeplace.dictionary.presentation.main.activity.MainActivity
import com.codeplace.dictionary.presentation.main.state.DefinitionState

@Composable
fun UpdateScreen(activity: MainActivity, latestVersion: DefinitionState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.undraw_android_jr64),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )

        AlertDialog(
            onDismissRequest = {
                activity.finish()
            },
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "New Version"
                )
            },
            text = {
              //  Text(text = "Version ${latestVersion.result?.versionName} is available on the PlayStore.")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        activity.finish()
                    }
                ) {
                    Text("Update")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        activity.finish()
                    }
                ) {
                    Text("Close")
                }
            }
        )
    }
}