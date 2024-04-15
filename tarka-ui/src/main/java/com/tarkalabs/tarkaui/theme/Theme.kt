package com.tarkalabs.tarkaui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable fun TUITheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  lightColors: TUIColors = defaultLightColors,
  darkColors: TUIColors = defaultDarkColors,
  content: @Composable () -> Unit,
) {
  val colors = if (darkTheme) darkColors else lightColors
  val view = LocalView.current
  val  context = LocalContext.current

  if (!view.isInEditMode) {
    val activity = context as? Activity
    if (activity != null) {
      SideEffect {
        val window = activity.window
        window.statusBarColor = colors.surface.toArgb()
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
      }
    }
  }

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