package com.tarkalabs.uicomponents.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.AvatarSize.XS
import com.tarkalabs.uicomponents.components.ChipLeadingContent.Icon
import com.tarkalabs.uicomponents.components.ChipLeadingContent.Image
import com.tarkalabs.uicomponents.components.ChipType.Filter
import com.tarkalabs.uicomponents.components.IconButtonSize.M
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme


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
   * @param showTrailingDismiss Whether to show a dismiss icon as a trailing icon.
   * @param containerColor The color of the chip's container. If null, the default color from the theme will be used.
   */
  data class Input(
    val content: ChipLeadingContent? = null,
    val showTrailingDismiss: Boolean = false,
    val containerColor : Color? = null
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
    val badgeCount: Int? = null
  ) : ChipType()
}

sealed class ChipLeadingContent {
  data class Image(val imageBitmap: ImageBitmap) : ChipLeadingContent()
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
@OptIn(ExperimentalMaterial3Api::class) @Composable fun TUIChip(
  modifier: Modifier = Modifier,
  type: ChipType,
  label: String,
  onClick: () -> Unit,
  onDismissClick: (() -> Unit)? = null,
  chipSize: ChipSize = ChipSize.SMALL,
  tags: TUIChipTags = TUIChipTags()
) {

  val commonModifier = modifier
    .testTag(tags.parentTag)
    .height(chipSize.size)
  val commonLabel = getCommonLabel(label)
  val leadingIcon = getLeadingIcon()


  when (type) {
    is ChipType.Assist -> {
      AssistChip(modifier = commonModifier,
        label = commonLabel,
        onClick = onClick,
        leadingIcon = { leadingIcon(type.content) })
    }

    is ChipType.Input -> InputChip(modifier = commonModifier,
      selected = false,
      onClick = onClick,
      label = commonLabel,
      colors = InputChipDefaults.inputChipColors(
        containerColor = type.containerColor ?: TUITheme.colors.onSurface
      ),
      leadingIcon = { leadingIcon(type.content) },
      trailingIcon = if (type.showTrailingDismiss) {
        {
          TUIIconButton(icon = TarkaIcons.Dismiss20Filled,
            iconButtonStyle = GHOST,
            onIconClick = {
            onDismissClick?.invoke()
          },
          buttonSize = M
          )
        }
      } else null)

    is Filter -> {
      FilterChip(type, onClick, commonLabel, commonModifier)
    }

    is ChipType.Suggestion -> {
      SuggestionChip(onClick = onClick,
        label = commonLabel,
        modifier = commonModifier,
        icon = if (type.image != null) {
          {
            Icon(
              painter = painterResource(id = type.image.iconRes),
              contentDescription = type.image.contentDescription
            )
          }
        } else null)
    }
  }
}

@Composable @OptIn(ExperimentalMaterial3Api::class) private fun FilterChip(
  type: Filter, onClick: () -> Unit, commonLabel: @Composable () -> Unit, modifier: Modifier
) {
  Box(modifier = Modifier.wrapContentWidth()) {
    FilterChip(selected = type.selected,
      onClick = onClick,
      label = commonLabel,
      modifier = modifier,
      leadingIcon = if (type.showLeadingCheck) {
        {
          Icon(
            painter = painterResource(id = TarkaIcons.CheckMark20Filled.iconRes),
            contentDescription = TarkaIcons.CheckMark20Filled.contentDescription
          )
        }
      } else null,
      trailingIcon = if (type.showTrailingDismiss) {
        {
          TUIIconButton(
            icon = TarkaIcons.Dismiss20Filled, iconButtonStyle = GHOST
          )
        }
      } else if (type.showTrailingCaret) {
        {
          Icon(
            painter = painterResource(id = TarkaIcons.CaretDown20Filled.iconRes),
            contentDescription = TarkaIcons.CaretDown20Filled.contentDescription
          )
        }
      } else null)
    if (type.badgeCount != null) {
      TUIBadge(count = type.badgeCount, modifier = Modifier.align(Alignment.TopEnd))
    }
  }
}

@Composable private fun getCommonLabel(label: String) = (@Composable {
  Text(
    text = label, style = TUITheme.typography.button7, color = TUITheme.colors.onSurface
  )
})

@Composable private fun getLeadingIcon(): @Composable (ChipLeadingContent?) -> Unit {
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
  val parentTag: String = Tags.TAG_CHIP_TAG
)

@Preview @Composable fun TUIChipPreview() {

  Column {
    TUIChip(
      type = ChipType.Input(showTrailingDismiss = true, containerColor = TUITheme.colors.surfaceVariant),
      label = "Something",
      onClick = { Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED") }
    )

    TUIChip(
      type = ChipType.Assist(),
      label = "Something",
      onClick = { Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED") }
    )
  }

}