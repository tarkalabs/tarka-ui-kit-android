package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.tarkalabs.tarkaicons.Checkmark24
import com.tarkalabs.tarkaicons.Circle24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUIMenuItemIconStyle.NORMAL
import com.tarkalabs.uicomponents.components.TUIMenuItemIconStyle.SUCCESS
import com.tarkalabs.uicomponents.extentions.maxHeight
import com.tarkalabs.uicomponents.extentions.maxWidth
import com.tarkalabs.uicomponents.theme.TUITheme


/**
 * A composable function that creates a Menu Item
 *
 * @param modifier The optional [Modifier] to customize the appearance and layout of the menu item.
 * @param label The main title text to be displayed in the menu item.
 * @param isSelected A boolean flag indicating whether the menu item is selected or not.
 * @param leadingIconStyle The style of the leading icon i.e [TUIMenuItemIconStyle.NORMAL] or [TUIMenuItemIconStyle.SUCCESS].
 * @param leadingIcon The optional leading icon of the menu item.
 * @param trailingIcon The optional trailing icon of the menu item.
 * @param onMenuItemClick A callback function to handle the click event on the menu item.
 * @param tags Tags for testing purposes to be applied to the various components of the menu item.
 */

@Composable
fun TUIMenuItem(
  modifier: Modifier,
  label: String,
  isSelected: Boolean,
  leadingIcon: TarkaIcon? = null,
  trailingIcon: TarkaIcon? = null,
  leadingIconStyle: TUIMenuItemIconStyle = NORMAL,
  onMenuItemClick: () -> Unit,
  tags: TUIMenuItemTags = TUIMenuItemTags()
) {

  val bgColor = if (isSelected) TUITheme.colors.success10 else Color.Transparent
  val rippleColor = if (isSelected) TUITheme.colors.success20 else TUITheme.colors.surfaceHover
  val tint = when (leadingIconStyle) {
    NORMAL -> TUITheme.colors.onSurface
    SUCCESS -> TUITheme.colors.success
  }

  val interactionSource = remember { MutableInteractionSource() }

  val leadingIconLambda: @Composable () -> Unit = if (leadingIcon != null) {
    {
      val leadingContentModifier =
        Modifier
          .padding(start = 16.dp, end = 8.dp)
          .testTag(tags.leadingContentTag)
      Icon(
        painter = painterResource(id = leadingIcon.iconRes),
        contentDescription = leadingIcon.contentDescription,
        tint = if (leadingIconStyle == SUCCESS) TUITheme.colors.success else leadingIcon.tintColor ?: tint,
        modifier = leadingContentModifier
          .maxHeight(24)
          .maxWidth(24)
      )

    }
  } else {
    {
      HorizontalSpacer(space = 48)
    }
  }

  val trailingContentLambda: (@Composable () -> Unit)? = if (trailingIcon != null) {
    {
      val trailingContentModifier = Modifier
        .padding(start = 8.dp, end = 8.dp)
        .maxHeight(24)
        .maxWidth(24)
        .testTag(tags.trailingContentTag)

      Icon(
        painter = painterResource(id = trailingIcon.iconRes),
        contentDescription = trailingIcon.contentDescription,
        tint = TUITheme.colors.onSurface,
        modifier = trailingContentModifier
      )

    }
  } else null

  val height = when {
    leadingIcon != null && trailingIcon != null -> if (isSelected) 40 else 38
    trailingIcon != null -> 36
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
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(vertical = 8.dp)
    ) {
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

enum class TUIMenuItemIconStyle {
  NORMAL,
  SUCCESS
}

@Preview @Composable fun PreviewTUIMenuItem() {
  TUITheme {
    Column(
      modifier = Modifier
        .background(color = TUITheme.colors.surface)
        .padding(vertical = 10.dp)
    ) {
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = false,
        leadingIcon = null,
        trailingIcon = null,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
      VerticalSpacer(space = 10)
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = false,
        leadingIcon = null,
        trailingIcon = Regular.Circle24,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
      VerticalSpacer(space = 10)
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = false,
        leadingIcon = Regular.Circle24,
        trailingIcon = null,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
      VerticalSpacer(space = 10)
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = false,
        leadingIcon = Regular.Circle24,
        trailingIcon = Regular.Circle24,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
      VerticalSpacer(space = 10)
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = true,
        leadingIconStyle = SUCCESS,
        leadingIcon = Regular.Checkmark24,
        trailingIcon = null,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
      VerticalSpacer(space = 10)
      TUIMenuItem(
        modifier = Modifier.fillMaxWidth(),
        label = "Item",
        isSelected = true,
        leadingIconStyle = SUCCESS,
        leadingIcon = Regular.Checkmark24,
        trailingIcon = Regular.Circle24,
        onMenuItemClick = {},
        tags = TUIMenuItemTags(parentTag = "hello")
      )
    }
  }
}