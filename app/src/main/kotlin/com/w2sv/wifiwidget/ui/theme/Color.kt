package com.w2sv.wifiwidget.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

val ColorScheme.onSurfaceVariantLowAlpha: Color
    @Composable
    @ReadOnlyComposable
    get() = onSurfaceVariant.copy(0.6f)

val lightColors = lightColorScheme(
    primary = Color(0xFF2359B7),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD9E2FF),
    onPrimaryContainer = Color(0xFF001945),
    secondary = Color(0xFF6457C6),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE6DEFF),
    onSecondaryContainer = Color(0xFF1D0C79),
    tertiary = Color(0xFFB24B73),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFD9E3),
    onTertiaryContainer = Color(0xFF4A102A),
    error = Color(0xFFBA1A1A),
    errorContainer = Color(0xFFFFDAD6),
    onError = Color(0xFFFFFFFF),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFF8F7FB),
    onBackground = Color(0xFF181A24),
    surface = Color(0xFFF8F7FB),
    onSurface = Color(0xFF181A24),
    surfaceVariant = Color(0xFFE0E1EC),
    onSurfaceVariant = Color(0xFF444655),
    outline = Color(0xFF757786),
    inverseOnSurface = Color(0xFFEFF0FF),
    inverseSurface = Color(0xFF2D2F3A),
    inversePrimary = Color(0xFFADC6FF),
    surfaceTint = Color(0xFF2359B7),
    outlineVariant = Color(0xFFC4C5D0),
    surfaceDim = Color(0xFFD9DAE3),
    surfaceBright = Color(0xFFF8F7FB),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFF1F1F8),
    surfaceContainer = Color(0xFFEDEDF5),
    surfaceContainerHigh = Color(0xFFE7E8F0),
    surfaceContainerHighest = Color(0xFFE1E2EA),
    scrim = Color(0xFF000000)
)

val darkColors = darkColorScheme(
    primary = Color(0xFFADC6FF),
    onPrimary = Color(0xFF002E6B),
    primaryContainer = Color(0xFF004398),
    onPrimaryContainer = Color(0xFFD9E2FF),
    secondary = Color(0xFFC8BCFF),
    onSecondary = Color(0xFF34208F),
    secondaryContainer = Color(0xFF4B3DAE),
    onSecondaryContainer = Color(0xFFE6DEFF),
    tertiary = Color(0xFFFFB1C8),
    onTertiary = Color(0xFF6A1D43),
    tertiaryContainer = Color(0xFF8D335B),
    onTertiaryContainer = Color(0xFFFFD9E3),
    error = Color(0xFFFFB4AB),
    errorContainer = Color(0xFF93000A),
    onError = Color(0xFF690005),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF11131B),
    onBackground = Color(0xFFE2E2EE),
    surface = Color(0xFF11131B),
    onSurface = Color(0xFFE2E2EE),
    surfaceVariant = Color(0xFF444655),
    onSurfaceVariant = Color(0xFFC4C5D0),
    outline = Color(0xFF8E90A0),
    inverseOnSurface = Color(0xFF11131B),
    inverseSurface = Color(0xFFE2E2EE),
    inversePrimary = Color(0xFF2359B7),
    surfaceTint = Color(0xFFADC6FF),
    outlineVariant = Color(0xFF444655),
    surfaceDim = Color(0xFF11131B),
    surfaceBright = Color(0xFF373944),
    surfaceContainerLowest = Color(0xFF0C0E16),
    surfaceContainerLow = Color(0xFF191B23),
    surfaceContainer = Color(0xFF1D1F28),
    surfaceContainerHigh = Color(0xFF282A33),
    surfaceContainerHighest = Color(0xFF32343E),
    scrim = Color(0xFF000000)
)
