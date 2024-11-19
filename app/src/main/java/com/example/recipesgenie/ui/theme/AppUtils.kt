package com.example.recipesgenie.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember


// TODO 6: create a new file with a composable function to provide app dimens to the theme using compositionLocal
@Composable
fun ProvideAppUtils(
    appDimens: Dimens,
    content: @Composable () -> Unit,
) {
    val appDimens = remember { appDimens }
    CompositionLocalProvider(LocalAppDimens provides appDimens) {
        content()
    }
}

// this is used when you want your value to be accessed by more than one composable function
val LocalAppDimens = compositionLocalOf {
    CompactDimens
}