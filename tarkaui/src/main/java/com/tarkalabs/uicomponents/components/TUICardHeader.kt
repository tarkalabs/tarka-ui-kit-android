package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.tarkalabs.tarkaicons.MoreHorizontal24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TagSize.S
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * This Component is used as a Header part in the Card Typed Detail Views.
 *
 * @param title - Title of the Header.
 * @param tagTitle - optional Title of the TUITag.
 * @param trailingIcon - optional end Icon.
 *
 * TUICardHeader(
 *     title = "Pump Repair Pump",
 *     tagTitle = "Tag1",
 *     trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
 *   ) {}
 *
 * **/
@Composable
fun TUICardHeader(
  modifier: Modifier = Modifier,
  title: String,
  tagTitle: String? = null,
  trailingIcon: TarkaIcon? = null,
  tags: TUICardHeaderTags = TUICardHeaderTags(),
  onTrailingIconClick: () -> Unit,
) {

  Row(
    modifier = modifier
      .testTag(tags.parentTag)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {

    HorizontalSpacer(space = 16)

    Column {
      tagTitle?.let {
        TUITag(
          modifier = Modifier.testTag(tags.tagTitleTag),
          title = tagTitle,
          tagSize = S,
          tagType = TagType.LOW
        ) {}
        VerticalSpacer(space = 8)
      }

      Text(
        text = title,
        color = TUITheme.colors.onSurface,
        style = TUITheme.typography.heading6
      )
    }

    HorizontalSpacer(space = 8)

    trailingIcon?.let {
      Spacer(modifier = Modifier.weight(1f))
      TUIIconButton(
        modifier = Modifier
          .testTag(tags.trailingIconTag),
        icon = trailingIcon,
        iconButtonStyle = GHOST,
        onIconClick = { onTrailingIconClick.invoke() }
      )
    }

    HorizontalSpacer(space = 16)

  }
}

data class TUICardHeaderTags(
  val parentTag: String = "TUICardHeader",
  val tagTitleTag: String = "TUICardHeader_tagTitleTag",
  val trailingIconTag: String = "TUICardHeader_trailingIconTag",
)

@Preview
@Composable
fun TUICardHeaderPreview() {
  TUICardHeader(
    title = "Pump Repair Pump",
    tagTitle = "Tag1",
    trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
  ) {}
}