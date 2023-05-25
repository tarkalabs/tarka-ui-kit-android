package com.tarkalabs.uicomponents.icons

import androidx.annotation.DrawableRes
import com.microsoft.fluent.mobile.icons.R

data class TarkaIcon constructor(
  @DrawableRes val iconRes: Int,
  val contentDescription: String,
)

object TarkaIcons {

  object Filled

  object Regular
}