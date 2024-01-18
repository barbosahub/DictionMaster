package com.codeplace.dictionary.presentation.main.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.codeplace.dictionary.R
import com.codeplace.dictionary.presentation.main.activity.MainActivity
import com.codeplace.dictionary.presentation.main.activity.MainActivity.Companion.word
import com.codeplace.dictionary.presentation.ui.component.StandardButton
import com.codeplace.dictionary.presentation.ui.theme.Blue
import com.codeplace.dictionary.presentation.ui.theme.fontLight16
import com.codeplace.dictionary.presentation.ui.theme.fontTitle20
import com.codeplace.dictionary.presentation.util.Screen


@Preview(name = "purchaseScreen", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    PurchaseScreen(
        navController = rememberNavController()
    )
}

@Composable
fun PurchaseScreen(
    navController: NavController
) {
    val annotatedTitle = buildAnnotatedString {
        append("Subscribe now to get")
        withStyle(style = SpanStyle(Blue)) {
            append(" unlimited ")
        }
        append("searches and full access to")
        withStyle(style = SpanStyle(Blue)) {
            append(" all features")
        }
        append(".")
    }
    val annotatedSubTitle = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("Try 7 Days Free")
        }
        append(", then only")
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("  \$19,99 ")
        }
        append("per year.\n")
        append("Cancel anytime.")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (image, logo, name, title, subtitle, button) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                painter = painterResource(id = R.drawable.img_purchase),
                contentDescription = null
            )

            Image(
                modifier = Modifier
                    .constrainAs(logo) {
                        bottom.linkTo(image.bottom)
                        top.linkTo(image.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                painter = painterResource(id = R.drawable.icon),
                contentDescription = null
            )

            Image(
                modifier = Modifier.constrainAs(name) {
                    top.linkTo(logo.bottom)
                    bottom.linkTo(logo.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                painter = painterResource(id = R.drawable.ic_title),
                contentDescription = null
            )

            Text(
                style = fontTitle20,
                text = annotatedTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
                    .constrainAs(title) {
                        top.linkTo(name.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                textAlign = TextAlign.Center
            )

            Text(
                style = fontLight16,
                text = annotatedSubTitle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 27.dp)
                    .constrainAs(subtitle) {
                        top.linkTo(title.bottom)
                        bottom.linkTo(button.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                textAlign = TextAlign.Center
            )

            Column(modifier = Modifier
                .padding(horizontal = 27.dp)
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }) {
                StandardButton(text = stringResource(id = R.string.subscribe)) {
                    word = ""
                    navController.navigate(Screen.Home.route)
                }
            }
        }
    }
}
