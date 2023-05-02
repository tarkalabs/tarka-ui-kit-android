package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.commonui.components.ButtonType.PRIMARY

enum class IconButtonSize(val size: Dp) {
  Size20(20.dp),
  Size24(24.dp),
  Size32(32.dp),
  Size40(40.dp),
  Size48(48.dp),
}

enum class ButtonType {
  GHOST,
  SECONDARY,
  PRIMARY,
  OUTLINE,
}

@Composable fun IconButton(
  @DrawableRes icon: Int,
  contentDescription: String,
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
  buttonSize: IconButtonSize = IconButtonSize.Size40,
  buttonType: ButtonType = PRIMARY,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},

  ) {
  IconButton(
    onClick = onIconClick, modifier = Modifier.size(buttonSize.size),
    colors = colors
  ) {
    Icon(painter = painterResource(id = icon), contentDescription = contentDescription)
  }
}

@Preview(showBackground = true)
@Composable fun GhostIconButton(
  @DrawableRes icon: Int = androidx.core.R.drawable.ic_call_answer,
  contentDescription: String = "Test",
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
  buttonSize: IconButtonSize = IconButtonSize.Size40,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},
) {
  IconButton(
    onClick = onIconClick,
    modifier = Modifier
      .size(buttonSize.size)
      .clip(CircleShape),
    colors = colors
  ) {
    Icon(
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}

@Preview(showBackground = true)
@Composable fun SecondaryIconButton(
  @DrawableRes icon: Int = androidx.core.R.drawable.ic_call_answer,
  contentDescription: String = "Test",
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
    containerColor = Color(0xff4D80B3),
    contentColor = Color.White
  ),
  buttonSize: IconButtonSize = IconButtonSize.Size40,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},
) {
  IconButton(
    onClick = onIconClick,
    modifier = Modifier
      .size(buttonSize.size)
      .clip(CircleShape),
    colors = colors
  ) {
    Icon(
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}

@Preview(showBackground = true)
@Composable fun PrimaryIconButton(
  @DrawableRes icon: Int = androidx.core.R.drawable.ic_call_answer,
  contentDescription: String = "Test",
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
    containerColor = Color(0xff0052D6),
    contentColor = Color.White
  ),
  buttonSize: IconButtonSize = IconButtonSize.Size40,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},
) {
  IconButton(
    onClick = onIconClick,
    modifier = Modifier
      .size(buttonSize.size)
      .clip(CircleShape),
    colors = colors
  ) {
    Icon(
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}

@Preview(showBackground = true)
@Composable fun OutlineIconButton(
  @DrawableRes icon: Int = androidx.core.R.drawable.ic_call_answer,
  contentDescription: String = "Test",
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(
    containerColor = Color.Transparent,
  ),
  buttonSize: IconButtonSize = IconButtonSize.Size40,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},
) {
  IconButton(
    onClick = onIconClick,
    modifier = Modifier
      .border(
        width = 0.5.dp,
        color = Color.Black,
        shape = CircleShape
      )
      .size(buttonSize.size),
    colors = colors
  ) {
    Icon(
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}


