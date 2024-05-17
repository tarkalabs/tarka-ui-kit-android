package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemLeadingContentType.Icon
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemStyle.Title
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithBackIcon
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithTitle
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithTrailingIcon
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.None
import com.tarkalabs.tarkaui.components.base.IconButtonSize
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.ChevronLeft24
import com.tarkalabs.tarkaui.icons.MoreHorizontal24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Represents different styles for a mobile overlay header.
 */
sealed class TUIMobileOverlayHeaderStyle {

  /**
   * No additional header content.
   */
  object None : TUIMobileOverlayHeaderStyle()

  /**
   * Header style with a title.
   *
   * @property title The title text to be displayed.
   */
  data class HeaderWithTitle(val title: String) : TUIMobileOverlayHeaderStyle()

  /**
   * Header style with a title, a trailing icon, and a click listener for the icon.
   *
   * @property title The title text to be displayed.
   * @property trailingIcon The icon to be displayed at the trailing edge.
   * @property onTrailingIconClick The click listener for the trailing icon.
   */
  data class HeaderWithTrailingIcon(
    val title: String,
    val trailingIcon: TarkaIcon,
    val onTrailingIconClick: () -> Unit,
    val menuItemList: List<TUIPopUpMenu>? = null,
    val onMenuItemClick: ((TUIPopUpMenu) -> Unit)? = null,
  ) : TUIMobileOverlayHeaderStyle()

  /**
   * Header style with a title and a click listener for a back icon.
   *
   * @property title The title text to be displayed.
   * @property onBackIconClick The click listener for the back icon.
   */
  data class HeaderWithBackIcon(
    val title: String, val onBackIconClick: () -> Unit
  ) : TUIMobileOverlayHeaderStyle()
}

/**
 * Composable function to create a mobile overlay header.
 *
 * @param modifier The modifier for styling and layout customization.
 * @param style The style of the header based on TUIMobileOverlayHeaderStyle.
 * @param tags The tags to be applied to the chip for testing purposes.
 */
@Composable
fun TUIMobileOverlayHeader(
  modifier: Modifier = Modifier,
  style: TUIMobileOverlayHeaderStyle,
  tags: TUIMobileOverlayHeaderTags = TUIMobileOverlayHeaderTags()
) {

  val height = when (style) {
    is None -> 24.dp
    else -> 64.dp
  }
  var expanded by remember { mutableStateOf(false) }

  Box(
    modifier = modifier
      .height(height)
      .fillMaxWidth()
      .testTag(tags.parentTag)
  ) {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.Center
    ) {
      Box(
        modifier = Modifier
          .padding(vertical = 8.dp)
          .height(4.dp)
          .width(68.dp)
          .background(TUITheme.colors.surfaceVariant)
          .clip(RoundedCornerShape(45.dp))
          .align(Alignment.CenterHorizontally)
          .testTag(tags.dividerTag)
      )
      Row(verticalAlignment = Alignment.CenterVertically) {
        when (style) {
          is HeaderWithBackIcon -> {
            TUIIconButton(
              icon = TarkaIcons.Regular.ChevronLeft24,
              buttonSize = IconButtonSize.XL,
              iconButtonStyle = IconButtonStyle.Ghost,
              onIconClick = style.onBackIconClick,
              tags = tags.leadingIconButtonTag
            )
            HeaderText(
              title = style.title,
              TextAlign.Center,
              modifier = Modifier
                .weight(1f)
                .padding(end = 48.dp)
            )
          }

          is HeaderWithTitle -> {
            HeaderText(
              title = style.title,
              TextAlign.Center,
              modifier = Modifier.weight(1f)
            )
          }

          is HeaderWithTrailingIcon -> {
            HeaderText(
              title = style.title,
              textAlign = TextAlign.Start,
              modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)

            )
            Box(modifier = Modifier.wrapContentSize(Alignment.BottomEnd)) {
              TUIIconButton(
                icon = style.trailingIcon,
                buttonSize = IconButtonSize.L,
                iconButtonStyle = IconButtonStyle.Ghost,
                onIconClick = {
                  if (!style.menuItemList.isNullOrEmpty()) {
                    expanded = !expanded
                  } else {
                    style.onTrailingIconClick.invoke()
                  }
                },
                tags = tags.trailingIconButtonTag
              )
              DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                  .background(TUITheme.colors.surface)
                  .align(Alignment.TopEnd),
              ) {
                style.menuItemList?.forEach { item ->
                  TUIMobileOverlayMenuItem(
                    title = stringResource(id = item.title),
                    isSelected = false,
                    style = Title,
                    onMobileOverlayMenuItemClick = {
                      expanded = false
                      style.onMenuItemClick?.invoke(item)
                    },
                    modifier = Modifier.defaultMinSize(minWidth = 160.dp),
                    leadingContent = Icon(item.icon)
                  )
                }
              }
            }
          }

          None -> {
          }
        }
      }
      when (style) {
        is HeaderWithBackIcon -> {
          VerticalSpacer(space = 8)
          TUIDivider()
        }

        is HeaderWithTitle -> {
          VerticalSpacer(space = 16)
          TUIDivider()
        }

        is HeaderWithTrailingIcon -> {
          VerticalSpacer(space = 12)
          TUIDivider()
        }

        None -> {}
      }
    }
  }
}

data class TUIMobileOverlayHeaderTags(
  val parentTag: String = "TUIMobileOverlayHeader_Parent",
  val dividerTag: String = "TUIMobileOverlayHeader_Divider",
  val leadingIconButtonTag: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUIMobileOverlayHeader_LeadingIcon"),
  val trailingIconButtonTag: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUIMobileOverlayHeader_TrailingIcon"),
)

@Composable
private fun HeaderText(title: String, textAlign: TextAlign, modifier: Modifier) {
  Text(
    text = title,
    modifier = modifier,
    textAlign = textAlign,
    style = TUITheme.typography.heading5,
    color = TUITheme.colors.onSurface
  )
}

@Preview(showBackground = true)
@Composable
fun TUIMobileOverlayHeaderPreview() {
  TUITheme {
    Column(
      Modifier
        .fillMaxSize()
        .background(TUITheme.colors.surface)
    ) {
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(), style = None
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(), style = HeaderWithTitle("Select Asset")
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        style = HeaderWithTrailingIcon(title = "Select Asset",
          trailingIcon = TarkaIcons.Regular.MoreHorizontal24,
          onTrailingIconClick = {}
        )
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        style = HeaderWithBackIcon(title = "Select Asset", onBackIconClick = {})
      )
      VerticalSpacer(space = 10)
    }

  }
}