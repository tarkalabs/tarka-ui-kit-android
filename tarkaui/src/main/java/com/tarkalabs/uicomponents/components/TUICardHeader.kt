package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * This Component is used as a Header part in the Card Typed Detail Views.
 *
 * @param title - Title of the Header.
 * @param title - optional Title of the card header.
 * @param tagOneTitle - optional tag title
 * @param tagTwoTitle - optional tag title
 * @param tagThreeTitle - optional tag title
 * @param tagOneClick - optional tag click
 * @param tagTwoClick - optional tag click
 * @param tagThreeClick - optional tag click
 * @param trailingIcon - optional end Icon.
 * @param onTrailingIconClick - optional end Icon click.
 *
 * TUICardHeader(
 *     title = "Pump Repair Pump",
 *     trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
 *   ) {}
 *
 * **/
@Composable fun TUICardHeader(
  modifier: Modifier = Modifier,
  title: String? = null,
  primaryTag: TUICardTag? = null,
  secondaryTag: TUICardTag? = null,
  teritaryTag: TUICardTag? = null,
  trailingIcon: TarkaIcon? = null,
  tags: TUICardHeaderTags = TUICardHeaderTags(),
  onTrailingIconClick: (() -> Unit)? = null,
) {

  Row(
    modifier = modifier
      .testTag(tags.parentTag)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
  ) {
    HorizontalSpacer(space = 16)
    Column(
      modifier = modifier
        .fillMaxWidth()
        .weight(1f)
    ) {
      Row(modifier = modifier.fillMaxWidth()) {
        primaryTag?.let { tag ->
          TUITag(
            title = tag.title,
            tagSize = S,
            tagType = TagType.LOW,
            tags = TUITagTestTags(parentTag = tag.title)
          ) { tag.onClick() }
          HorizontalSpacer(space = 8)
        }
        secondaryTag?.let { tag ->
          TUITag(
            title = tag.title,
            tagSize = S,
            tagType = TagType.LOW,
            tags = TUITagTestTags(parentTag = tag.title)
          ) { tag.onClick() }
          HorizontalSpacer(space = 8)
        }
        teritaryTag?.let { tag ->
          TUITag(
            title = tag.title,
            tagSize = S,
            tagType = TagType.LOW,
            tags = TUITagTestTags(parentTag = tag.title)
          ) { tag.onClick() }
          HorizontalSpacer(space = 8)
        }
      }
      if ((primaryTag != null || secondaryTag != null || teritaryTag != null) &&
        !title.isNullOrEmpty()) {
        VerticalSpacer(space = 8)
      }
      title?.let {
        Text(
          text = it, color = TUITheme.colors.onSurface, style = TUITheme.typography.heading6
        )
      }
    }
    HorizontalSpacer(space = 8)
    trailingIcon?.let {
      TUIIconButton(
        icon = trailingIcon,
        iconButtonStyle = GHOST,
        onIconClick = { onTrailingIconClick?.invoke() },
        tags = TUIIconButtonTags(parentTag = tags.trailingIconTag)
      )
    }
    HorizontalSpacer(space = 16)
  }
}

data class TUICardHeaderTags(
  val parentTag: String = "TUICardHeader",
  val trailingIconTag: String = "TUICardHeader_trailingIconTag",
)

data class TUICardTag(
  val title: String, val onClick: () -> Unit
)

@Preview @Composable fun TUICardHeaderPreview() {
  Column {
    TUITheme {
      Column(modifier = Modifier.background(color = TUITheme.colors.surface)) {
        VerticalSpacer(space = 32)
        TUICardHeader(
          title = "Pump Repair Pump",
          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 16)
        TUICardHeader(
          primaryTag = TUICardTag(title = "Tag One", onClick = {}),
          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 16)
        TUICardHeader(
          title = "Pump Repair Pump",
          primaryTag = TUICardTag(title = "Tag 1", onClick = {}),
          secondaryTag = TUICardTag(title = "Tag 2", onClick = {}),
          teritaryTag = TUICardTag(title = "Tag 3", onClick = {}),
          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 32)
      }
    }
    TUITheme(darkTheme = true) {
      Column(modifier = Modifier.background(color = TUITheme.colors.surface)) {
        VerticalSpacer(space = 32)
        TUICardHeader(
          title = "Pump Repair Pump",
          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 16)
        TUICardHeader(
          primaryTag = TUICardTag(title = "Tag 1", onClick = {}),

          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 16)
        TUICardHeader(
          title = "Pump Repair Pump",
          primaryTag = TUICardTag(title = "Tag 1", onClick = {}),
          secondaryTag = TUICardTag(title = "Tag 2", onClick = {}),
          teritaryTag = TUICardTag(title = "Tag 3", onClick = {}),
          trailingIcon = TarkaIcons.Filled.MoreHorizontal24.copy(tintColor = TUITheme.colors.secondary)
        )
        VerticalSpacer(space = 32)
      }
    }

  }
}