package com.tarkalabs.tarkaui.icons

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class TarkaIcon internal constructor(
  @DrawableRes val iconRes: Int,
  val contentDescription: String,
  val tintColor: Color? = null,
){
  fun copy(contentDescription: String): TarkaIcon {
    return TarkaIcon(this.iconRes, contentDescription)
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as TarkaIcon

    if (iconRes != other.iconRes) return false
    if (contentDescription != other.contentDescription) return false

    return true
  }

  override fun hashCode(): Int {
    var result = iconRes
    result = 31 * result + contentDescription.hashCode()
    return result
  }

  override fun toString(): String {
    return "TarkaIcon(iconRes=$iconRes, contentDescription='$contentDescription')"
  }
}

object TarkaIcons {

  object Filled

  object Regular
}