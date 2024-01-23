package com.tarkalabs.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.MenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.HorizontalSpacer
import com.tarkalabs.uicomponents.extentions.maxHeight
import com.tarkalabs.uicomponents.extentions.maxWidth
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun TUIMenuItem(
  label: String,
  isSelected: Boolean,
  leadingContent: MenuItemLeadingContentType? = null,
  trailingContent: MenuItemTrailingContentType? = null,
  onMobileOverlayMenuItemClick: () -> Unit,
  tags: TUIMenuItemTags = TUIMenuItemTags()
) {

  val bgColor = if (isSelected) TUITheme.colors.success10 else Color.Transparent
  val rippleColor = if (isSelected) TUITheme.colors.success20 else TUITheme.colors.surfaceHover

  val interactionSource = remember { MutableInteractionSource() }

  val leadingIconLambda: @Composable () -> Unit = if (leadingContent != null) {
    {
      val leadingContentModifier =
        Modifier
          .padding(start = 16.dp, end = 8.dp)
          .testTag(tags.leadingContentTag)
      when (leadingContent) {
        is MenuItemLeadingContentType.Icon -> Icon(
          painter = painterResource(id = leadingContent.icon.iconRes),
          contentDescription = leadingContent.icon.contentDescription,
          tint = leadingContent.icon.tintColor ?: TUITheme.colors.onSurface,
          modifier = leadingContentModifier
            .maxHeight(24)
            .maxWidth(24)
        )

        StatusIndicator -> Box(
          modifier = leadingContentModifier
            .size(8.dp)
            .clip(CircleShape)
            .background(color = TUITheme.colors.success)
        )
      }

    }
  } else {
    {
      HorizontalSpacer(space = 48)
    }
  }


  val trailingContentLambda: (@Composable () -> Unit)? = if (trailingContent != null) {
    {
      val trailingContentModifier = Modifier
        .padding(start = 8.dp, end = 8.dp)
        .maxHeight(24)
        .maxWidth(24)
        .testTag(tags.trailingContentTag)

      when (trailingContent) {
        is MenuItemTrailingContentType.Icon -> Icon(
          painter = painterResource(id = trailingContent.icon.iconRes),
          contentDescription = trailingContent.icon.contentDescription,
          tint = TUITheme.colors.success,
          modifier = trailingContentModifier
        )

        MenuItemTrailingContentType.SubMenu -> {
          Icon(
            painter = painterResource(id = TarkaIcons.Regular.ChevronRight20.iconRes),
            contentDescription = TarkaIcons.Regular.ChevronRight20.contentDescription,
            tint = TUITheme.colors.onSurface,
            modifier = trailingContentModifier
          )
        }
      }
    }
  } else null

  val height = when {
    leadingContent != null && trailingContent != null -> if (isSelected) 40 else 38
    trailingContent != null -> 36
    leadingContent is StatusIndicator -> if (isSelected) 40 else 34
    else -> 40
  }

  Row(
    modifier = Modifier
      .defaultMinSize(minHeight = height.dp)
      .clip(RoundedCornerShape(8.dp))
      .background(color = bgColor)
      .clickable(
        interactionSource = interactionSource,
        indication = rememberRipple(color = rippleColor),
        onClick = onMobileOverlayMenuItemClick
      )
      .testTag(tags.parentTag),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    leadingIconLambda()
    Column(modifier = Modifier
      .weight(1f)
      .padding(vertical = 8.dp)) {
      Text(
        text = label,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.onSurface,
      )
    }
    trailingContentLambda?.invoke()
  }
}

data class TUIMenuItemTags(
  val parentTag: String = "TUIMenuItemParentTag",
  val leadingContentTag: String = "TUIMenuItem_LeadingContent",
  val trailingContentTag: String = "TUIMenuItem_TrailingContent"
)

sealed class MenuItemLeadingContentType {
  data class Icon(val icon: TarkaIcon) : MenuItemLeadingContentType()
  object StatusIndicator : MenuItemLeadingContentType()
}

sealed class MenuItemTrailingContentType {
  data class Icon(val icon: TarkaIcon) : MenuItemTrailingContentType()
  object SubMenu : MenuItemTrailingContentType()
}

@Preview @Composable fun PreviewTUIMenuItem() {
  TUITheme {
    Column(
      modifier = Modifier
        .background(color = TUITheme.colors.surface)
        .padding(vertical = 10.dp)
    ) {

    }
  }
}