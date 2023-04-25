package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.commonui.components.EamButtonType.GHOST
import com.tarkalabs.commonui.components.EamButtonType.OUTLINE
import com.tarkalabs.commonui.components.EamButtonType.PRIMARY
import com.tarkalabs.commonui.components.EamButtonType.SECONDARY

enum class EamIconButtonSize(val size: Dp) {
  Size20(20.dp),
  Size24(24.dp),
  Size32(32.dp),
  Size40(40.dp),
  Size48(48.dp),
}

enum class EamButtonType {
  GHOST,
  SECONDARY,
  PRIMARY,
  OUTLINE,
}

@Composable fun EamIconButton(
  @DrawableRes icon: Int,
  contentDescription: String,
  colors : IconButtonColors = IconButtonDefaults.iconButtonColors(),
  buttonSize: EamIconButtonSize = EamIconButtonSize.Size40,
  buttonType: EamButtonType = EamButtonType.PRIMARY,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},

  ) {
  when(buttonType){
    GHOST -> TODO()
    SECONDARY -> TODO()
    PRIMARY -> TODO()
    OUTLINE -> TODO()
  }
  IconButton(
    onClick = onIconClick, modifier = Modifier.size(buttonSize.size),
    colors = colors
  ) {
    Icon(painter = painterResource(id = icon), contentDescription = contentDescription)
  }
}


