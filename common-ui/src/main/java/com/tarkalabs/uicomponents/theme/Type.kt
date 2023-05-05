package com.tarkalabs.uicomponents.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tarkalabs.uicomponents.R

// Set of Material typography styles to start with
val Typography = Typography(
  bodySmall = TextStyle(
    fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal, fontSize = 16.sp
  ),
)

val EamFontFamily = FontFamily(
  Font(R.font.inter_regular, FontWeight.Normal),
  Font(R.font.inter_light, FontWeight.Light),
  Font(R.font.inter_semibold, FontWeight.SemiBold),
  Font(R.font.inter_bold, FontWeight.Bold)
)

@Immutable
data class ExtendedTypography(
  val heading1: TextStyle,
  val heading2: TextStyle,
  val heading3: TextStyle,
  val heading4: TextStyle,
  val heading5: TextStyle,
  val heading6: TextStyle,
  val heading7: TextStyle,
  val body5: TextStyle,
  val body6: TextStyle,
  val body7: TextStyle,
  val body8: TextStyle,
  val button6: TextStyle,
  val button7: TextStyle,
  val button8: TextStyle,
)

val LocalExtendedTypography = staticCompositionLocalOf {
  extendedTypography
}

val extendedTypography = ExtendedTypography(
  heading1 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Bold, fontSize = 30.sp,
  ),
  heading2 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Bold, fontSize = 24.sp
  ),
  heading3 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Bold, fontSize = 22.sp
  ),
  heading4 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp
  ),
  heading5 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
  ),
  heading6 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
  ),
  heading7 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp
  ),
  body5 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp
  ),
  body6 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp
  ),
  body7 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp
  ),
  body8 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp
  ),
  button6 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 16.sp
  ),
  button7 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 14.sp
  ),
  button8 = TextStyle(
    fontFamily = EamFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 12.sp
  ),
)
