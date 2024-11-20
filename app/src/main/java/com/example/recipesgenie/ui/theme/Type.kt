package com.example.recipesgenie.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// TODO 3: create typography objects for each screen size by overriding the Typography parameters with the desired TextStyles
// you don't have to override all the params, just the ones you need to use.. but note that using one that's not overridden will not achieve responsiveness
// here we just overrode the ones that we need, check the rest in Typography class
val CompactSmallTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)

val CompactMediumTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val mediumTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)

val ExpandedTypography = Typography(
    headlineLarge = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 42.sp
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    titleMedium = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
)