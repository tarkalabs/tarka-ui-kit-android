package com.tarkalabs.uicomponents.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
open class TUIColors(
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
  val success10: Color,
  val success20: Color,
  val error: Color,
  val onError: Color,
  val error10: Color,
  val warning: Color,
  val onWarning: Color,
  val warning10: Color,
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
  val surfaceVariantHover: Color,
  val constantLight: Color,
  val constantDark: Color,
  val inputTextDim: Color,
  val surfaceHover: Color,
)

val LocalTUIColors = staticCompositionLocalOf {
  defaultLightColors
}

val defaultLightColors = TUIColors(
  primary = Color(0xFF0052D6),
  onPrimary = Color(0xFFF5F9FF),
  primaryAlt = Color(0xFFD5E2F6),
  onPrimaryAlt = Color(0xFF002766),
  secondary = Color(0xFF4D80B3),
  onSecondary = Color(0xFFF0F7FF),
  secondaryAlt = Color(0xFFD2DEE9),
  onSecondaryAlt = Color(0xFF003366),
  tertiary = Color(0xFF924F92),
  onTertiary = Color(0xFFFFF5FF),
  tertiaryAlt = Color(0xFFF3CEF3),
  onTertiaryAlt = Color(0xFF530953),
  success = Color(0xFF148F47),
  onSuccess = Color(0xFFF2FDF6),
  success10 = Color(0xFF148F47).copy(alpha = 0.10f),
  success20 = Color(0xFF148F47).copy(alpha = 0.20f),
  error = Color(0xFFCD1D32),
  onError = Color(0xFFFEFBFB),
  error10 = Color(0xFFFEFBFB).copy(alpha = 0.10f),
  warning = Color(0xFFFFB938),
  onWarning = Color(0xFF241D0F),
  warning10 = Color(0xFF241D0F).copy(alpha = 0.10f),
  background = Color(0xFFECECEC),
  onBackground = Color(0xFF171B21),
  utilityOutline = Color(0xFF878B92),
  utilityDisabledContent = Color(0XFF1A1B1F).copy(alpha = 0.38f),
  utilityDisabledBackground = Color(0XFF1A1B1F).copy(alpha = 0.06f),
  utilityLink = Color(0xFF3381FF),
  inputBackground = Color(0XFFEAECF0).copy(alpha = 0.85f),
  inputText = Color(0XFF1A1B1F),
  inputDim = Color(0XFF1A1B1F).copy(alpha = 0.70f),
  surface = Color(0xFFF9FAFB),
  surface50 = Color(0xFFF9FAFB).copy(alpha = 0.50f),
  onSurface = Color(0xFF1A1B1F),
  surfaceVariant = Color(0xFFEBEFF4),
  constantLight = Color(0xFFFFFFFF),
  constantDark = Color(0xFF000000),
  surfaceVariantHover = Color(0xFFE1E7EF),
  inputTextDim = Color(0xFF1A1C1F).copy(0.70f),
  surfaceHover = Color(0xFFF0F2F5),
)

val defaultDarkColors = TUIColors(
  primary = Color(0xFF5294FF),
  onPrimary = Color(0xFFFAFCFF),
  primaryAlt = Color(0xFF293B56),
  onPrimaryAlt = Color(0xFFD6E6FF),
  secondary = Color(0xFFA8CCF0),
  onSecondary = Color(0xFF002B57),
  secondaryAlt = Color(0xFF294056),
  onSecondaryAlt = Color(0xFFD6EBFF),
  tertiary = Color(0xFFE6B3E6),
  onTertiary = Color(0xFF5C0A5C),
  tertiaryAlt = Color(0xFF532D53),
  onTertiaryAlt = Color(0xFFFFD6FF),
  success = Color(0xFF55E792),
  onSuccess = Color(0xFF003817),
  success10 = Color(0xFF55E792).copy(alpha = 0.10f),
  success20 = Color(0xFF55E792).copy(alpha = 0.20f),
  error = Color(0xFFD42136),
  onError = Color(0xFFFFFAFA),
  error10 = Color(0xFFFFFAFA).copy(alpha = 0.10f),
  warning = Color(0xFFFFB938),
  onWarning = Color(0xFF241D0F),
  warning10 = Color(0xFF241D0F).copy(alpha = 0.10f),
  background = Color(0xFF0F1115),
  onBackground = Color(0xFFF0F2F4),
  utilityOutline = Color(0xFF878B92),
  utilityDisabledContent = Color(0XFFFCFCFD).copy(alpha = 0.38f),
  utilityDisabledBackground = Color(0XFFFCFCFD).copy(alpha = 0.12f),
  utilityLink = Color(0xFF80B0FF),
  inputBackground = Color(0XFF0F1115).copy(alpha = 0.60f),
  inputText = Color(0XFFFCFCFD),
  inputDim = Color(0XFFFCFCFD).copy(alpha = 0.70f),
  surface = Color(0xFF212731),
  surface50 = Color(0xFF212731).copy(alpha = 0.50f),
  onSurface = Color(0xFFFCFCFD),
  surfaceVariant = Color(0xFF2D3543),
  constantLight = Color(0xFFFFFFFF),
  constantDark = Color(0xFF000000),
  surfaceVariantHover = Color(0xFFE1E7EF),
  inputTextDim = Color(0xFF1A1C1F).copy(0.70f),
  surfaceHover = Color(0xFFF0F2F5),
  )

