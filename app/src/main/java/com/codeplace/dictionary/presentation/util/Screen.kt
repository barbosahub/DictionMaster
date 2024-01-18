package com.codeplace.dictionary.presentation.util

import androidx.annotation.StringRes
import com.codeplace.dictionary.R

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int
) {

    data object Splash : Screen(
        "splash_screen",
        R.string.splash
    )

    data object Home : Screen(
        "home_screen",
        R.string.home
    )

    data object Definition : Screen(
        "definition_screen",
        R.string.definition
    )

    data object Purchase : Screen(
        "purchase_screen",
        R.string.purchase
    )

}
