package com.tarkalabs.uicomponents.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TarkaColors(
  val primary: Color,
  val onPrimary: Color,
  val primaryAlt: Color,
  val onPrimaryAlt: Color,
  val secondary: Color,
  val onSecondary: Color,
  val secondaryAlt: Color,
  val onSecondaryAlt: Color,
  val tertiary: Color,
  val onTertiary: Color,
  val tertiaryAlt: Color,
  val onTertiaryAlt: Color,
  val success: Color,
  val onSuccess: Color,
  val onSuccess10: Color,
  val onSuccess20: Color,
  val error: Color,
  val onError: Color,
  val onError10: Color,
  val warning: Color,
  val onWarning: Color,
  val onWarning10: Color,
  val background: Color,
  val onBackground: Color,
  val utilityOutline: Color,
  val utilityDisabledContent: Color,
  val utilityDisabledBackground: Color,
  val utilityLink: Color,
  val inputBackground: Color,
  val inputText: Color,
  val inputDim: Color,
  val surface: Color,
  val surface50: Color,
  val onSurface: Color,
  val surfaceVariant: Color,
  val constantLight: Color,
  val constantDark: Color,
)

val LocalTUIColors = staticCompositionLocalOf {
  lightColors()
}

fun lightColors(): TarkaColors {
  return TarkaColors(
    primary = LightColorPrimary,
    onPrimary = LightColorOnPrimary,
    primaryAlt = LightColorAltPrimary,
    onPrimaryAlt = LightColorOnAltPrimary,
    secondary = LightColorSecondary,
    onSecondary = LightColorOnSecondary,
    secondaryAlt = LightColorAltSecondary,
    onSecondaryAlt = LightColorOnAltSecondary,
    tertiary = LightColorTertiary,
    onTertiary = LightColorOnTertiary,
    tertiaryAlt = LightColorAltTertiary,
    onTertiaryAlt = LightColorOnAltTertiary,
    success = LightColorSuccess,
    onSuccess = LightColorOnSuccess,
    onSuccess10 = LightColorSuccess10,
    onSuccess20 = LightColorSuccess20,
    error = LightColorError,
    onError = LightColorOnError,
    onError10 = LightColorError10,
    warning = LightColorWarning,
    onWarning = LightColorOnWarning,
    onWarning10 = LightColorWarning10,
    background = LightColorBackground,
    onBackground = LightColorOnBackground,
    utilityOutline = LightColorUtilityOutline,
    utilityDisabledContent = LightColorUtilityDisabledContent,
    utilityDisabledBackground = LightColorUtilityDisabledBackground,
    utilityLink = LightColorUtilityLink,
    inputBackground = LightColorInputBackground,
    inputText = LightColorInputText,
    inputDim = LightColorInputDim,
    surface = LightColorSurface,
    surface50 = LightColorSurface50,
    onSurface = LightColorOnSurface,
    surfaceVariant = LightColorSurfaceVariant,
    constantLight = ColorLight,
    constantDark = ColorDark
  )
}

fun darkColors(): TarkaColors {
  return TarkaColors(
    primary = DarkColorPrimary,
    onPrimary = DarkColorOnPrimary,
    primaryAlt = DarkColorAltPrimary,
    onPrimaryAlt = DarkColorOnAltPrimary,
    secondary = DarkColorSecondary,
    onSecondary = DarkColorOnSecondary,
    secondaryAlt = DarkColorAltSecondary,
    onSecondaryAlt = DarkColorOnAltSecondary,
    tertiary = DarkColorTertiary,
    onTertiary = DarkColorOnTertiary,
    tertiaryAlt = DarkColorAltTertiary,
    onTertiaryAlt = DarkColorOnAltTertiary,
    success = DarkColorSuccess,
    onSuccess = DarkColorOnSuccess,
    onSuccess10 = DarkColorSuccess10,
    onSuccess20 = DarkColorSuccess20,
    error = DarkColorError,
    onError = DarkColorOnError,
    onError10 = DarkColorError10,
    warning = DarkColorWarning,
    onWarning = DarkColorOnWarning,
    onWarning10 = DarkColorWarning10,
    background = DarkColorBackground,
    onBackground = DarkColorOnBackground,
    utilityOutline = DarkColorUtilityOutline,
    utilityDisabledContent = DarkColorUtilityDisabledContent,
    utilityDisabledBackground = DarkColorUtilityDisabledBackground,
    utilityLink = DarkColorUtilityLink,
    inputBackground = DarkColorInputBackground,
    inputText = DarkColorInputText,
    inputDim = DarkColorInputDim,
    surface = DarkColorSurface,
    surface50 = DarkColorSurface50,
    onSurface = DarkColorOnSurface,
    surfaceVariant = DarkColorSurfaceVariant,
    constantLight = ColorLight,
    constantDark = ColorDark
  )
}
