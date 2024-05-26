package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.ChipLeadingContent.Icon
import com.tarkalabs.tarkaui.components.ChipLeadingContent.Image
import com.tarkalabs.tarkaui.components.ChipType.Filter
import com.tarkalabs.tarkaui.components.base.AvatarSize.XS
import com.tarkalabs.tarkaui.components.base.AvatarType
import com.tarkalabs.tarkaui.components.base.BadgeStyle
import com.tarkalabs.tarkaui.components.base.IconButtonSize.M
import com.tarkalabs.tarkaui.components.base.IconButtonSize.S
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.TUIAvatar
import com.tarkalabs.tarkaui.components.base.TUIBadge
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.icons.ArrowSort20
import com.tarkalabs.tarkaui.icons.CaretDown16
import com.tarkalabs.tarkaui.icons.CaretDown20
import com.tarkalabs.tarkaui.icons.Checkmark16
import com.tarkalabs.tarkaui.icons.Dismiss16
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Represents a generic chip type. The ChipType superclass serves as a generic base for the different chip types in the sealed class hierarchy.
 */
sealed class ChipType {
  /**
   * Represents an assist chip type for TUIChip.
   *
   * @param content The optional leading content for the chip.
   */
  data class Assist(val content: ChipLeadingContent? = null) : ChipType()

  /**
   * Represents an input chip type for TUIChip.
   *
   * @param content The optional leading content for the chip.
   * @param trailingIcon The drawable resource for the trailing icon
   * @param containerColor The color of the chip's container. If null, the default color from the theme will be used.
   */
  data class Input(
    val content: ChipLeadingContent? = null,
    val trailingIcon: TarkaIcon? = null,
    val containerColor: Color? = null,
  ) : ChipType()

  /**
   * Represents a suggestion chip type for TUIChip.
   *
   * @param image The optional image for the chip.
   */
  data class Suggestion(val image: TarkaIcon? = null) : ChipType()

  /**
   * Represents a filter chip type for TUIChip.
   *
   * @param selected Whether the filter is selected.
   * @param showLeadingCheck Whether to show a check icon as a leading icon.
   * @param showTrailingDismiss Whether to show a dismiss icon as a trailing icon.
   * @param showTrailingCaret Whether to show a caret icon as a trailing icon.
   * @param badgeCount The badge count to display on the chip.
   */
  data class Filter(
    val selected: Boolean = false,
    val showLeadingCheck: Boolean = false,
    val showTrailingDismiss: Boolean = false,
    val showTrailingCaret: Boolean = false,
    val badgeCount: Int? = null,
    val trailingIcon: TarkaIcon? = null,
  ) : ChipType()
}

@Stable
sealed class ChipLeadingContent {
  @Stable
  data class Image(val imageBitmap: ImageBitmap) : ChipLeadingContent()

  @Stable
  data class Icon(val icon: TarkaIcon) : ChipLeadingContent()
}

enum class ChipSize(val size: Dp) {
  SMALL(32.dp),
  BIG(40.dp),
}

/**
 * A customizable chip composable that can be used to represent different types of chips.
 *
 * @param modifier The modifier to be applied to the chip.
 * @param type The type of chip to be rendered (Assist, Input, Filter, Suggestion).
 * @param label The label text to be displayed on the chip.
 * @param onClick The callback function to be invoked when the chip is clicked.
 * @param chipSize The size of the chip (default is ChipSize.SMALL).
 * @param tags The tags to be applied to the chip for testing purposes.
 */
@Composable fun TUIChip(
  modifier: Modifier = Modifier,
  type: ChipType,
  label: String,
  onClick: () -> Unit,
  onDismissClick: (() -> Unit)? = null,
  chipSize: ChipSize = ChipSize.SMALL,
  tags: TUIChipTags = TUIChipTags(),
) {

  val commonModifier = modifier
    .testTag(tags.parentTag)
    .height(chipSize.size)
  val commonLabel = getCommonLabel(label)
  val leadingIcon = leadingIcon()

  when (type) {
    is ChipType.Assist -> {
      AssistChip(modifier = commonModifier,
        shape = RoundedCornerShape(8.dp),
        label = commonLabel,
        onClick = onClick,
        colors = AssistChipDefaults.assistChipColors(containerColor = TUITheme.colors.surface),
        leadingIcon = { leadingIcon(type.content) })
    }

    is ChipType.Input -> InputChip(modifier = commonModifier,
      shape = RoundedCornerShape(8.dp),
      selected = false,
      onClick = onClick,
      label = commonLabel,
      colors = InputChipDefaults.inputChipColors(containerColor = TUITheme.colors.surface),
      leadingIcon = { leadingIcon(type.content) },
      trailingIcon = if (type.trailingIcon != null) {
        {
          TUIIconButton(
            icon = type.trailingIcon, iconButtonStyle = Ghost, onIconClick = {
              onDismissClick?.invoke()
            }, buttonSize = M
          )
        }
      } else null)

    is Filter -> {
      FilterChip(
        type = type,
        label = label,
        onClick = onClick,
        modifier = commonModifier,
        onDismissClick = onDismissClick
      )
    }

    is ChipType.Suggestion -> {
      SuggestionChip(colors = SuggestionChipDefaults.suggestionChipColors(containerColor = TUITheme.colors.surface),
        onClick = onClick,
        label = commonLabel,
        shape = RoundedCornerShape(8.dp),
        modifier = commonModifier,
        icon = if (type.image != null) {
          {
            Icon(
              painter = painterResource(id = type.image.iconRes),
              contentDescription = type.image.contentDescription,
              tint = TUITheme.colors.onSecondary
            )
          }
        } else null)
    }
  }
}

@Composable private fun FilterChip(
  type: Filter,
  label: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  onDismissClick: (() -> Unit)? = null,
) {
  Box(
    modifier = Modifier
      .wrapContentWidth()
      .background(
        color = if (type.selected) TUITheme.colors.secondary else TUITheme.colors.surface,
        shape = RoundedCornerShape(8.dp)
      )
      .border(
        color = if (type.selected) TUITheme.colors.secondary else TUITheme.colors.utilityOutline,
        width = 1.dp,
        shape = RoundedCornerShape(8.dp)
      )
  ) {
    Row(
      modifier = modifier
        .clickable {
          onClick()
        }, horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (type.showLeadingCheck) {
        HorizontalSpacer(space = 6)
        Icon(
          painter = painterResource(id = TarkaIcons.Filled.Checkmark16.iconRes),
          contentDescription = TarkaIcons.Filled.Checkmark16.contentDescription,
          tint = if (type.selected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
        )
        HorizontalSpacer(space = 6)
      } else {
        HorizontalSpacer(space = 20)
      }
      Text(
        text = label,
        style = TUITheme.typography.button7,
        color = if (type.selected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
      )

      if (type.showTrailingDismiss) {
        HorizontalSpacer(space = 6)
        TUIIconButton(
          icon = TarkaIcons.Filled.Dismiss16.copy(tintColor = if (type.selected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface),
          iconButtonStyle = Ghost,
          onIconClick = {
            onDismissClick?.invoke()
          },
          buttonSize = S
        )
        HorizontalSpacer(space = 6)
      } else if (type.showTrailingCaret) {
        HorizontalSpacer(space = 6)
        Icon(
          painter = painterResource(
            id = type.trailingIcon?.iconRes ?: TarkaIcons.Filled.CaretDown20.iconRes
          ),
          contentDescription = type.trailingIcon?.contentDescription
            ?: TarkaIcons.Filled.CaretDown16.contentDescription,
          tint = if (type.selected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface
        )
        HorizontalSpacer(space = 6)
      } else {
        HorizontalSpacer(space = 20)
      }

    }
    if (type.badgeCount != null) {
      TUIBadge(
        style = BadgeStyle.Count(count = type.badgeCount),
        modifier = Modifier.align(Alignment.TopEnd)
      )
    }

  }
}

@Composable private fun getCommonLabel(label: String) = (@Composable {
  Text(
    text = label, style = TUITheme.typography.button7, color = TUITheme.colors.onSurface
  )
})

@Composable private fun leadingIcon(): @Composable (ChipLeadingContent?) -> Unit {
  val leadingIcon: @Composable (ChipLeadingContent?) -> Unit = @Composable {
    when (it) {
      is Icon -> Icon(
        painter = painterResource(id = it.icon.iconRes),
        contentDescription = it.icon.contentDescription,
        tint = TUITheme.colors.onSurface
      )

      is Image -> TUIAvatar(
        avatarType = AvatarType.Image(it.imageBitmap), avatarSize = XS
      )

      null -> {}
    }
  }
  return leadingIcon
}

data class TUIChipTags(
  val parentTag: String = "TUIChip",
)

@Preview @Composable fun TUIChipPreview() {
  TUITheme {
    Column(modifier = Modifier.padding(20.dp)) {
      var showSearchbar by remember {
        mutableStateOf(
          false
        )
      }
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight()
          .padding(horizontal = 8.dp)
      ) {
        VerticalSpacer(space = 20)
        TUIChip(
          type = Filter(
            trailingIcon = Regular.ArrowSort20, showTrailingDismiss = true, selected = showSearchbar
          ),
          label = "Something",
          onClick = {
            showSearchbar = true
          },
          onDismissClick = {
            showSearchbar = !showSearchbar
          },
        )
        VerticalSpacer(space = 20)
      }
    }
  }
}