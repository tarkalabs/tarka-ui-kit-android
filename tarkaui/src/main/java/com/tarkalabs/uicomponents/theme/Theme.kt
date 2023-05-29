package com.tarkalabs.uicomponents.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider


@Composable fun TUITheme(
  darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit,
) {
  val colors = if (darkTheme) darkColors else lightColors

  CompositionLocalProvider(
    LocalTUITypography provides extendedTypography,
    LocalTUIColors provides colors
  ) {
    MaterialTheme(
      content = content, shapes = Shapes
    )
  }
}


object TUITheme {
  val typography: TarkaTypography
    @Composable
    get() = LocalTUITypography.current
  val colors: TarkaColors
    @Composable
    get() = LocalTUIColors.current
}