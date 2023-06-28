package com.tarkalabs.uicomponents.components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.IconButtonSize.L
import com.tarkalabs.uicomponents.components.IconButtonSize.M
import com.tarkalabs.uicomponents.components.IconButtonSize.S
import com.tarkalabs.uicomponents.components.IconButtonSize.XL
import com.tarkalabs.uicomponents.components.IconButtonSize.XS
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.IconButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.IconButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.IconButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

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
 * @param icon The Tarka Icon resource ID of the icon to be displayed inside the button.
 * @param buttonSize The size of the button, which can be one of the values of the IconButtonSize enum.
 * @param iconButtonStyle The style of the button, which can be one of the values of the IconButtonStyle enum.
 * @param enabled Whether the button is clickable or not.
 * @param onIconClick A callback function that is invoked when the button is clicked.
 * @param testTag The test tag for the TUIButton.
 * The function calculates the size of the icon based on the buttonSize parameter and sets the colors of the button
 *
 * How to use IconButton() composable function
 *
 *   IconButton(icon = TarkaIcons.ChevronRight,
 *              buttonSize = IconButtonSize.XS,
 *             iconButtonStyle = IconButtonStyle.OUTLINE)
 *
 */
@Composable fun TUIIconButton(
  icon: TarkaIcon,
  buttonSize: IconButtonSize = L,
  iconButtonStyle: IconButtonStyle = IconButtonStyle.defaultStyle,
  enabled: Boolean = true,
  tags: TUIIconButtonTags = TUIIconButtonTags(),
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
      .size(24.dp)

  }
  when (iconButtonStyle) {
    GHOST -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = Color.Transparent,
        contentColor = TUITheme.colors.onSurface,
        disabledContentColor = TUITheme.colors.onSurface.copy(alpha = 0.38f),
      )
    }

    SECONDARY -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.secondary,
        contentColor = TUITheme.colors.onSecondary,
      )
    }

    PRIMARY -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.primary,
        contentColor = TUITheme.colors.onPrimary,
      )
    }

    OUTLINE -> {
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.surface,
        contentColor = TUITheme.colors.onSurface,
        disabledContentColor = TUITheme.colors.onSurface.copy(alpha = 0.38f),
      )
      modifier = Modifier
        .border(
          width = 0.5.dp, color = TUITheme.colors.utilityOutline, shape = CircleShape
        )
        .size(buttonSize.size)
    }
  }

  IconButton(
    onClick = onIconClick,
    modifier = modifier.testTag(tags.parentTag),
    colors = iconButtonColors,
    enabled = enabled
  ) {
    Icon(
      modifier = iconModifier,
      painter = painterResource(id = icon.iconRes),
      contentDescription = icon.contentDescription
    )
  }
}

data class TUIIconButtonTags(
  val parentTag: String = Tags.TAG_ICON_BUTTON,
)

@Preview(showSystemUi = true) @Composable fun TUIIconButtonPreview() {
  TUITheme {
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
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XS, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = S, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = M, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = L, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XL, iconButtonStyle = PRIMARY
        )
      }

      Text("Secondary Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XS, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = S, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = M, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = L, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XL, iconButtonStyle = SECONDARY
        )
      }


      Text("Ghost Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XS, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = S, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = M, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = L, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XL, iconButtonStyle = GHOST
        )
      }

      Text("Outline Icon Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.width(20.dp))
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XS, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = S, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = M, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = L, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.ChevronRight20Regular, buttonSize = XL, iconButtonStyle = OUTLINE
        )
      }
    }
  }
}

