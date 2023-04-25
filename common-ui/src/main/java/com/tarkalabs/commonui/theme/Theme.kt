package com.tarkalabs.commonui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
  primary = Color.Red,
  primaryContainer = Color.Green,
  secondary = Teal200
)

private val LightColorPalette = lightColorScheme(
  primary = ColorPrimary,
  onPrimary = ColorOnPrimary,
  primaryContainer = ColorAltPrimary,
  onPrimaryContainer = ColorOnAltPrimary,

  secondary = ColorSecondary,
  onSecondary = ColorOnSecondary,
  secondaryContainer = ColorAltSecondary,
  onSecondaryContainer = ColorOnAltSecondary,

  tertiary = ColorTertiary,
  onTertiary = ColorOnTertiary,
  onTertiaryContainer = ColorAltTertiary,
  tertiaryContainer = ColorOnAltTertiary,

  error = ColorError,
  onError = ColorOnError,

  background = Color.White,
  onBackground = Color.Black,
  surface = Color.White,
  onSurface = Color.Black,
  )

@Composable fun Eam360uiandroidTheme(
  darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    LightColorPalette
  }


  CompositionLocalProvider(
    LocalExtendedTypography provides extendedTypography
  ) {
    MaterialTheme(
      typography = Typography, content = content, colorScheme = colors, shapes = Shapes
    )
  }
}


@Composable fun Eam360uiandroidTheme2(
  darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit
) {
  val colors = if (darkTheme) {
    DarkColorPalette
  } else {
    DarkColorPalette
  }


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