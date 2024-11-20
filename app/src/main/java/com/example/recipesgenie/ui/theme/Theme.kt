package com.example.recipesgenie.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.recipesgenie.MainActivity

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    error = DarkRed,
    surface = LightBlack
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    error = LightRed,
    surface = Color.White
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun RecipesGenieTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    activity: Activity = LocalContext.current as MainActivity,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // TODO 4: create typography & dimens objects
    val typography: Typography
    val appDimens: Dimens


    // TODO 5: assign values to the typography and dimens according to the current screen size
    // note that the size category differs if the device orientation is changed
    // TIP: add debug break points here to check the category of your device
    val window = calculateWindowSizeClass(activity = activity)
    val config = LocalConfiguration.current

    when (window.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            if (config.screenWidthDp <= 360) {
                appDimens = CompactSmallDimens
                typography = CompactSmallTypography
            } else if (config.screenWidthDp < 599) {
                appDimens = CompactMediumDimens
                typography = CompactMediumTypography
            } else {
                appDimens = MediumDimens
                typography = mediumTypography
            }
        }

        WindowWidthSizeClass.Medium -> {
            appDimens = MediumDimens
            typography = mediumTypography
        }

        WindowWidthSizeClass.Expanded -> {
            appDimens = ExpandedDimens
            typography = ExpandedTypography
        }

        else -> {
            appDimens = CompactMediumDimens
            typography = CompactMediumTypography
        }
    }

    // TODO 7: wrap MaterialTheme inside the call of ProvidedAppUtils -the method created in step 6- to provide appDimens to the theme
    ProvideAppUtils(appDimens = appDimens) {
            MaterialTheme(
                colorScheme = colorScheme,
                typography = typography,
                content = content
            )
    }
}

// TODO 8: create a dimens composable getter to access it by the composables
val dimens
    @Composable
    get() = LocalAppDimens.current