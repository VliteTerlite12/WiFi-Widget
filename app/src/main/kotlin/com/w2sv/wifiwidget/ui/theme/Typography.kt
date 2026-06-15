package com.w2sv.wifiwidget.ui.theme

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.sp
import com.w2sv.wifiwidget.R

private val defaultTypography = Typography()
private val jost = Font(R.font.jost).toFontFamily()

val expressiveTypography = Typography(
    displayLarge = defaultTypography.displayLarge.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 56.sp
    ),
    displayMedium = defaultTypography.displayMedium.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 48.sp
    ),
    displaySmall = defaultTypography.displaySmall.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 42.sp
    ),
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 40.sp
    ),
    headlineMedium = defaultTypography.headlineMedium.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 34.sp
    ),
    headlineSmall = defaultTypography.headlineSmall.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 30.sp
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = jost,
        fontWeight = FontWeight.Medium,
        lineHeight = 24.sp
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontFamily = jost,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = jost,
        lineHeight = 24.sp
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = jost,
        lineHeight = 21.sp
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontFamily = jost,
        lineHeight = 18.sp
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontFamily = jost,
        fontWeight = FontWeight.SemiBold
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontFamily = jost,
        fontWeight = FontWeight.Medium
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontFamily = jost,
        fontWeight = FontWeight.Medium
    )
)

val Typography.explanation
    @ReadOnlyComposable
    @Composable
    get() = bodyMedium.copy(fontSize = 13.sp, color = colorScheme.onSurfaceVariantLowAlpha)
