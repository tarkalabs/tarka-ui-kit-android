package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.common_ui.R

enum class EamFloatingActionButtonSize(val size: Dp) {
  REGULAR(40.dp),
  SMALL(56.dp),
  LARGE(96.dp),
}

@Preview
@Composable fun EamFloatingActionButton(
  @DrawableRes icon: Int = R.drawable.keyboard_arrow_right,
  iconSize: EamFloatingActionButtonSize = EamFloatingActionButtonSize.REGULAR,
  onClick: () -> Unit = {},
  contentDescription: String? = null,
  containerColor: Color = MaterialTheme.colorScheme.primary,
  iconTint: Color = MaterialTheme.colorScheme.onPrimary,
  shape: Shape = CircleShape,
  ) {
  FloatingActionButton(
    onClick = onClick,
    containerColor = containerColor,
    contentColor = iconTint,
    modifier = Modifier.size(iconSize.size),
    shape = shape,
  ) {
    Icon(
      painter = painterResource(id = icon), contentDescription = contentDescription
    )
  }
}