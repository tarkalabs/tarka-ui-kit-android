package com.tarkalabs.uicomponents.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable fun TUITheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  lightColors: TUIColors = defaultLightColors,
  darkColors: TUIColors = defaultDarkColors,
  content: @Composable () -> Unit,
) {
  val colors = if (darkTheme) lightColors else darkColors

  CompositionLocalProvider(
    LocalTUITypography provides extendedTypography, LocalTUIColors provides colors
  ) {
    MaterialTheme(
      content = content, shapes = Shapes
    )
  }
}

object TUITheme {
  val typography: TUITypography
    @Composable
    get() = LocalTUITypography.current
  val colors: TUIColors
    @Composable
    get() = LocalTUIColors.current
}