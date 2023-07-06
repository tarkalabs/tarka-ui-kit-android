package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

sealed class ChipType {
  object Assist : ChipType()
  data class Input(
    val showTrailingDismiss: Boolean = false
  ) : ChipType()

  data class Suggestion(val image: TarkaIcon? = null) : ChipType()
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
  SMALL(32.dp), BIG(40.dp),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIChip(
  modifier: Modifier = Modifier,
  type: ChipType,
  label: String,
  leadingContent: ChipLeadingContent? = null,
  onClick: () -> Unit,
  chipSize: ChipSize = ChipSize.SMALL,
  tags: TUIChipTags = TUIChipTags()
) {

  val commonModifier = modifier
    .testTag(tags.parentTag)
    .width(chipSize.size)
  val commonLabel = @Composable {
    Text(
      text = label, style = TUITheme.typography.button7, color = TUITheme.colors.onSurface
    )
  }
  val leadingIcon = @Composable {
    when (leadingContent) {
      is ChipLeadingContent.Icon -> Icon(
        painter = painterResource(id = leadingContent.icon.iconRes),
        contentDescription = leadingContent.icon.contentDescription,
        tint = TUITheme.colors.onSurface
      )

      is ChipLeadingContent.Image -> TUIAvatar(
        avatarType = AvatarType.Image(leadingContent.imageBitmap), avatarSize = AvatarSize.XS
      )

      null -> {}
    }
  }


  when (type) {
    ChipType.Assist -> {
      AssistChip(
        modifier = commonModifier, label = commonLabel, onClick = onClick, leadingIcon = leadingIcon
      )
    }

    is ChipType.Input -> InputChip(modifier = commonModifier,
      selected = false,
      onClick = onClick,
      label = commonLabel,
      leadingIcon = leadingIcon,
      trailingIcon = if (type.showTrailingDismiss) {
        {
          TUIIconButton(icon = TarkaIcons.Dismiss20Filled)
        }
      } else null)

    is ChipType.Filter -> {
      Box(modifier = Modifier.wrapContentSize()) {
        FilterChip(selected = type.selected,
          onClick = onClick,
          label = commonLabel,
          modifier = commonModifier,
          leadingIcon = if (type.showLeadingCheck) {
            {
              Icon(
                painter = painterResource(id = TarkaIcons.CheckMark20Filled.iconRes),
                contentDescription = TarkaIcons.CheckMark20Filled.contentDescription
              )
            }
          } else null,
          trailingIcon = if (type.showTrailingDismiss) {
            { TUIIconButton(icon = TarkaIcons.Dismiss20Filled) }
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

    is ChipType.Suggestion -> {
      SuggestionChip(
        onClick = onClick,
        label = commonLabel,
        modifier = commonModifier,
        icon = if (type.image != null) {
          {
            Icon(
              painter = painterResource(id = type.image.iconRes),
              contentDescription = type.image.contentDescription
            )
          }
        } else null
      )
    }
  }

}

data class TUIChipTags(
  val parentTag: String = Tags.TAG_CHIP_TAG
)