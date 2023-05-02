package com.tarkalabs.commonui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorPalette = darkColorScheme(
  primary = DarkColorPrimary,
  onPrimary = DarkColorOnPrimary,
  primaryContainer = DarkColorAltPrimary,
  onPrimaryContainer = DarkColorOnAltPrimary,
  secondary = DarkColorSecondary,
  onSecondary = DarkColorOnSecondary,
  secondaryContainer = DarkColorAltSecondary,
  onSecondaryContainer = DarkColorOnAltSecondary,
  tertiary = DarkColorTertiary,
  onTertiary = DarkColorOnTertiary,
  onTertiaryContainer = DarkColorAltTertiary,
  tertiaryContainer = DarkColorOnAltTertiary,
  error = DarkColorError,
  onError = DarkColorOnError,
  background = DarkColorBackGround,
  onBackground = DarkColorOnBackGround,
  surface = DarkColorSurface,
  onSurface = DarkColorOnSurface,
)

private val LightColorPalette = lightColorScheme(
  primary = LightColorPrimary,
  onPrimary = LightColorOnPrimary,
  primaryContainer = LightColorAltPrimary,
  onPrimaryContainer = LightColorOnAltPrimary,
  secondary = LightColorSecondary,
  onSecondary = LightColorOnSecondary,
  secondaryContainer = LightColorAltSecondary,
  onSecondaryContainer = LightColorOnAltSecondary,
  tertiary = LightColorTertiary,
  onTertiary = LightColorOnTertiary,
  onTertiaryContainer = LightColorAltTertiary,
  tertiaryContainer = LightColorOnAltTertiary,
  error = LightColorError,
  onError = LightColorOnError,
  background = LightColorBackGround,
  onBackground = LightColorOnBackGround,
  surface = LightColorSurface,
  onSurface = LightColorOnSurface,
  )

@Composable fun EamTheme(
  darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit,
) {
  val colors = if (darkTheme) DarkColorPalette else LightColorPalette

  CompositionLocalProvider(
    LocalExtendedTypography provides extendedTypography
  ) {
    MaterialTheme(
      typography = Typography, content = content, colorScheme = colors, shapes = Shapes
    )
  }
}


object Eam360Theme {
  val typography: ExtendedTypography
    @Composable
    get() = LocalExtendedTypography.current
}