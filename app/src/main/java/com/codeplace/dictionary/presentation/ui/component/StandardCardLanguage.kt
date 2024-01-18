package com.codeplace.dictionary.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codeplace.dictionary.R
import com.codeplace.dictionary.presentation.ui.theme.Gray10
import com.codeplace.dictionary.presentation.ui.theme.fontLight18


@Preview(name = "standardCardLanguage", showBackground = true)
@Composable
private fun StandardButtonPreview() {
    StandardCardLanguage()
}

@Composable
fun StandardCardLanguage() {
    Card(
        modifier = Modifier
            .width(130.dp)
            .height(40.dp),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Gray10
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_en),
                contentDescription = null,
                modifier = Modifier
                    .width(26.dp)
                    .height(26.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(7.dp))

            Text(
                style = fontLight18,
                text = "English".uppercase(),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }
    }
}