package com.codeplace.dictionary.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.codeplace.dictionary.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val font = GoogleFont(name = "Roboto")

val fontFamily = FontFamily(
    Font(googleFont = font, fontProvider = provider)
)


val fontLight = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Light,
    fontSize = 32.sp,
    color = Black
)

val fontLight18 = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Light,
    fontSize = 18.sp,
    color = Black
)

val fontLight16 = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Light,
    fontSize = 16.sp,
    color = Black
)

val fontBold = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 32.sp,
    color = Black
)


val fontTitle = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 45.sp,
    color = Black
)

val fontTitle24 = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    color = Black
)

val fontSubTitle = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 22.sp,
    color = Black
)

val fontBody = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp,
    color = Black
)





val fontButton = TextStyle(
    fontFamily = fontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 18.sp,
    color = White
)

