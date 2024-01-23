package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.tarkalabs.tarkaicons.AddCircle24
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.MenuItemStyle.Title
import com.tarkalabs.uicomponents.components.MenuItemStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemTrailingContentType.Icon
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemTrailingContentType.SubMobileOverlayMenu
import com.tarkalabs.uicomponents.extentions.maxHeight
import com.tarkalabs.uicomponents.extentions.maxWidth
import com.tarkalabs.uicomponents.theme.TUITheme

sealed class MobileOverlayMenuItemLeadingContentType {
  data class Icon(val icon: TarkaIcon) : MobileOverlayMenuItemLeadingContentType()
  object StatusIndicator : MobileOverlayMenuItemLeadingContentType()
}

sealed class MobileOverlayMenuItemTrailingContentType {
  data class Icon(val icon: TarkaIcon) : MobileOverlayMenuItemTrailingContentType()
  object SubMobileOverlayMenu : MobileOverlayMenuItemTrailingContentType()
}

sealed class MenuItemStyle {
  object Title : MenuItemStyle()
  data class TitleWithDescription(val description: String) : MenuItemStyle()
}

/**
 * A composable function that creates a Menu Item.
 *
 * @param modifier The optional [Modifier] to customize the appearance and layout of the menu item.
 * @param title The main title text to be displayed in the menu item.
 * @param isSelected A boolean flag indicating whether the menu item is selected or not.
 * @param style The style of the menu item title. It can be either [MenuItemStyle.Title] or [MenuItemStyle.TitleWithDescription].
 * @param leadingContent The optional leading content to be displayed before the title. It can be an icon or a status indicator.
 * @param trailingContent The optional trailing content to be displayed after the title. It can be an icon or a submenu indicator.
 * @param onMenuItemClick A callback function to handle the click event on the menu item.
 * @param tags Tags for testing purposes to be applied to the various components of the menu item.
 */
@Composable fun TUIMobileOverlayMenuItem(
  modifier: Modifier = Modifier,
  title: String,
  isSelected: Boolean,
  style: MenuItemStyle,
  leadingContent: MobileOverlayMenuItemLeadingContentType? = null,
  trailingContent: MobileOverlayMenuItemTrailingContentType? = null,
  onMenuItemClick: () -> Unit,
  tags: TUIMenuItemTags = TUIMenuItemTags()
) {

  val bgColor = if (isSelected) TUITheme.colors.success10 else Color.Transparent
  val rippleColor = if (isSelected) TUITheme.colors.success20 else TUITheme.colors.surfaceHover

  val interactionSource = remember { MutableInteractionSource() }

  val leadingIconLambda: @Composable () -> Unit = if (leadingContent != null && style is Title) {
    {
      val leadingContentModifier = Modifier.padding(start = 16.dp, end = 8.dp).testTag(tags.leadingContentTag)
      when (leadingContent) {
        is MobileOverlayMenuItemLeadingContentType.Icon -> Icon(
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

  val trailingContentLambda: (@Composable () -> Unit)? = if (trailingContent != null && style is Title) {
    {
      val trailingContentModifier = Modifier
        .padding(start = 8.dp, end = 8.dp)
        .maxHeight(24)
        .maxWidth(24)
        .testTag(tags.trailingContentTag)

      when (trailingContent) {
        is Icon -> Icon(
          painter = painterResource(id = trailingContent.icon.iconRes),
          contentDescription = trailingContent.icon.contentDescription,
          tint = TUITheme.colors.success,
          modifier = trailingContentModifier
        )

        SubMobileOverlayMenu -> {
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
    style is TitleWithDescription -> 62
    else -> 40
  }

  Row(
    modifier = modifier
      .defaultMinSize(minHeight = height.dp)
      .clip(RoundedCornerShape(8.dp))
      .background(color = bgColor)
      .clickable(
        interactionSource = interactionSource,
        indication = rememberRipple(color = rippleColor),
        onClick = onMenuItemClick
      )
      .testTag(tags.parentTag),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween,
  ) {
    leadingIconLambda()
    Column(modifier = Modifier
      .weight(1f)
      .padding(vertical = 8.dp)) {
      when (style) {
        Title -> TUIMenuItemTitle(title)
        is TitleWithDescription -> TUIMenuItemTitleWithDescription(
          title = title, description = style.description
        )
      }
    }
    trailingContentLambda?.invoke()
  }
}

@Composable private fun TUIMenuItemTitle(title: String) {
  Text(
    text = title,
    style = TUITheme.typography.body7,
    color = TUITheme.colors.onSurface,
  )
}

@Composable private fun TUIMenuItemTitleWithDescription(title: String, description: String) {
  Text(
    text = title, style = TUITheme.typography.heading6, color = TUITheme.colors.onSurface
  )
  Text(
    text = description, style = TUITheme.typography.body7, color = TUITheme.colors.onSurface
  )
}

data class TUIMenuItemTags(
  val parentTag: String = "TUIMenuItemParentTag",
  val leadingContentTag: String = "TUIMenuItem_LeadingContent",
  val trailingContentTag: String = "TUIMenuItem_TrailingContent"
)

@Preview @Composable fun PreviewTUIMenuItem() {
  TUITheme {
    Column(
      modifier = Modifier
        .background(color = TUITheme.colors.surface)
        .padding(vertical = 10.dp)
    ) {
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = false,
        modifier = Modifier.fillMaxWidth()
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = MobileOverlayMenuItemLeadingContentType.Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        )
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        trailingContent = Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        )
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = MobileOverlayMenuItemLeadingContentType.Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        ),
        trailingContent = Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        )
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        )
      )

      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = false,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = SubMobileOverlayMenu
      )

      VerticalSpacer(space = 10)
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = TitleWithDescription("Label"),
        onMenuItemClick = {},
        isSelected = false,
        modifier = Modifier.fillMaxWidth(),
      )

    }
  }
}