package com.tarkalabs.uicomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarkalabs.uicomponents.R
import com.tarkalabs.uicomponents.components.IconButtonSize.L
import com.tarkalabs.uicomponents.components.IconButtonSize.M
import com.tarkalabs.uicomponents.components.IconButtonSize.S
import com.tarkalabs.uicomponents.components.IconButtonSize.XL
import com.tarkalabs.uicomponents.components.IconButtonSize.XS
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.IconButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.IconButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.IconButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.theme.ColorUtilityOutline
import com.tarkalabs.uicomponents.theme.EamTheme

//  Created by Nilesh Rathod on 12/05/23.

enum class IconButtonSize(val size: Dp) {
  XS(20.dp),
  S(24.dp),
  M(32.dp),
  L(40.dp),
  XL(48.dp),
}

enum class IconButtonStyle {
  PRIMARY,
  SECONDARY,
  GHOST,
  OUTLINE;

  companion object {
    val defaultStyle: IconButtonStyle = PRIMARY
  }
}

/**
 * Below function defines a reusable composable function which can be used to create an IconButton with various styles and sizes which takes several parameters such as
 * @param icon The drawable resource ID of the icon to be displayed inside the button.
 * @param contentDescription The textual description of the icon for accessibility purposes.
 * @param buttonSize The size of the button, which can be one of the values of the IconButtonSize enum.
 * @param iconButtonStyle The style of the button, which can be one of the values of the IconButtonStyle enum.
 * @param enabled Whether the button is clickable or not.
 * @param badgeCount The count to be displayed as a badge on top of the icon.
 * @param onIconClick A callback function that is invoked when the button is clicked.
 * The function calculates the size of the icon based on the buttonSize parameter and sets the colors of the button
 *
 * How to use IconButton() composable function
 *
     IconButton(
       icon = R.drawable.keyboard_arrow_right,
       contentDescription = "",
       buttonSize = IconButtonSize.XS,
       iconButtonStyle = IconButtonStyle.OUTLINE,
      )
 *
 */
@Composable fun IconButton(
  @DrawableRes icon: Int,
  contentDescription: String,
  buttonSize: IconButtonSize = L,
  iconButtonStyle: IconButtonStyle = IconButtonStyle.defaultStyle,
  enabled: Boolean = true,
  badgeCount: String? = null,
  onIconClick: () -> Unit = {},
) {
  var iconButtonColors: IconButtonColors = IconButtonDefaults.iconButtonColors()

  var modifier = Modifier
    .height(buttonSize.size)
    .width(buttonSize.size)
    .clip(CircleShape)

  val iconModifier = when (buttonSize) {
    XS, S, M -> Modifier
      .height(12.dp)
      .width(12.dp)
    L, XL -> Modifier
      .size(24.dp)
      .size(23.dp)

  }
  when (iconButtonStyle) {
    GHOST -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onSurface,
        disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
      )
    }

    SECONDARY -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary,
      )
    }

    PRIMARY -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
      )
    }

    OUTLINE -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
      )
      modifier = Modifier
        .border(
          width = 0.5.dp, color = ColorUtilityOutline, shape = CircleShape
        )
        .size(buttonSize.size)
    }
  }

  IconButton(
    onClick = onIconClick, modifier = modifier, colors = iconButtonColors, enabled = enabled
  ) {
    Icon(
      modifier = iconModifier,
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}

@Preview(showSystemUi = true) @Composable fun DefaultIconButtonPreview() {
  EamTheme {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {
      Text("Primary Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XS,
          iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = S,
          iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = M,
          iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = L,
          iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XL,
          iconButtonStyle = PRIMARY
        )
      }

      Text("Secondary Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XS,
          iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = S,
          iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = M,
          iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = L,
          iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XL,
          iconButtonStyle = SECONDARY
        )
      }


      Text("Ghost Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XS,
          iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = S,
          iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))

        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = M,
          iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = L,
          iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XL,
          iconButtonStyle = GHOST
        )
      }

      Text("Outline Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XS,
          iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = S,
          iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))

        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = M,
          iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = L,
          iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        IconButton(
          icon = R.drawable.keyboard_arrow_right,
          contentDescription = "",
          buttonSize = XL,
          iconButtonStyle = OUTLINE
        )
      }
    }
  }
}

@Composable fun GhostIconButton(
  @DrawableRes icon: Int,
  contentDescription: String,
  colors: IconButtonColors = IconButtonDefaults.iconButtonColors(),
  buttonSize: IconButtonSize = L,
  badgeCount: String? = null,
  onIconClick: () -> Unit,
) {
  IconButton(
    onClick = onIconClick,
    modifier = Modifier
      .size(buttonSize.size)
      .clip(CircleShape),
    colors = colors
  ) {
    Icon(
      painter = painterResource(id = icon), contentDescription = contentDescription
    )
  }
}


