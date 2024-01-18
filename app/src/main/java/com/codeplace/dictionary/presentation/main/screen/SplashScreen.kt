package com.codeplace.dictionary.presentation.main.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.codeplace.dictionary.R

@Composable
fun SplashScreen(
    onAnimationFinished: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
    val progress by animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.fillMaxSize()
    )

    LaunchedEffect(key1 = progress) {
        if (progress >= 1) {
            onAnimationFinished()
        }
    }
}