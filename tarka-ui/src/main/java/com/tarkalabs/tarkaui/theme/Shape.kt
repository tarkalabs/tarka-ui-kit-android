package com.tarkalabs.tarkaui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
  small = RoundedCornerShape(4.dp),
  medium = RoundedCornerShape(4.dp),
  large = RoundedCornerShape(0.dp),
  // extraSmall is used to set rounded corner of DropdownMenu
  extraSmall = RoundedCornerShape(16.dp)
)