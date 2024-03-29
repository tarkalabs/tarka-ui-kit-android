package com.tarkalabs.tarkaui.components.base

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.components.base.IconButtonSize.L
import com.tarkalabs.tarkaui.components.base.IconButtonSize.M
import com.tarkalabs.tarkaui.components.base.IconButtonSize.S
import com.tarkalabs.tarkaui.components.base.IconButtonSize.XL
import com.tarkalabs.tarkaui.components.base.IconButtonSize.XS
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.GHOST
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.OUTLINE
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.PRIMARY
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.SECONDARY
import com.tarkalabs.tarkaui.theme.TUITheme

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
  modifier: Modifier = Modifier,
  icon: TarkaIcon,
  buttonSize: IconButtonSize = L,
  iconButtonStyle: IconButtonStyle = IconButtonStyle.defaultStyle,
  enabled: Boolean = true,
  tags: TUIIconButtonTags = TUIIconButtonTags(),
  onIconClick: () -> Unit = {  },
) {
  var iconButtonColors: IconButtonColors = IconButtonDefaults.iconButtonColors()

  var parentModifier = modifier
    .height(buttonSize.size)
    .width(buttonSize.size)
    .clip(CircleShape)

  when (iconButtonStyle) {
    GHOST -> {
      val contentColor = icon.tintColor ?: TUITheme.colors.onSurface
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = Color.Transparent,
        contentColor =  contentColor,
        disabledContentColor = TUITheme.colors.onSurface.copy(alpha = 0.38f),
      )
    }

    SECONDARY -> {
      val contentColor = icon.tintColor ?: TUITheme.colors.onSecondary
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.secondary,
        contentColor = contentColor,
      )
    }

    PRIMARY -> {
      val contentColor = icon.tintColor ?: TUITheme.colors.onPrimary
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.primary,
        contentColor = contentColor,
      )
    }

    OUTLINE -> {
      val contentColor = icon.tintColor ?: TUITheme.colors.onSurface
      iconButtonColors = IconButtonDefaults.iconButtonColors(
        containerColor = TUITheme.colors.surface,
        contentColor = contentColor,
        disabledContentColor = TUITheme.colors.onSurface.copy(alpha = 0.38f),
      )
      parentModifier = Modifier
        .border(
          width = 0.5.dp, color = TUITheme.colors.utilityOutline, shape = CircleShape
        )
        .size(buttonSize.size)
    }
  }

  IconButton(
    onClick = onIconClick,
    modifier = parentModifier.testTag(tags.parentTag),
    colors = iconButtonColors,
    enabled = enabled
  ) {
    Icon(
      modifier = Modifier.heightIn(max = 24.dp).widthIn(max = 24.dp),
      painter = painterResource(id = icon.iconRes),
      contentDescription = icon.contentDescription
    )
  }
}

data class TUIIconButtonTags(
  val parentTag: String = "TUIIconButton",
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
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XS, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = S, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = M, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = L, iconButtonStyle = PRIMARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XL, iconButtonStyle = PRIMARY
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
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XS, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = S, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = M, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = L, iconButtonStyle = SECONDARY
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XL, iconButtonStyle = SECONDARY
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
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XS, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = S, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = M, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = L, iconButtonStyle = GHOST
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XL, iconButtonStyle = GHOST
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
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XS, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = S, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))

        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = M, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = L, iconButtonStyle = OUTLINE
        )
        Spacer(modifier = Modifier.width(20.dp))
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight20, buttonSize = XL, iconButtonStyle = OUTLINE
        )
      }
    }
  }
}

