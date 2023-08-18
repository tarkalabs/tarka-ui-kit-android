package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.GREEN
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.GREY
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.TRANSPARENT
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.ADD
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.CHECKMARK
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.EMPTY
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent.EMPTY as TrailEMPTY
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.STATUS_DOT
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent.FRONT_ARROW
import com.tarkalabs.uicomponents.extentions.maxHeight
import com.tarkalabs.uicomponents.extentions.maxWidth
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 *
 * This Composable function is used to show the menu item in Bottom Sheet.
 *
 * @param modifier - used  to modify properties, behaviour of compose.
 * @param backgroundColor - BackGround color of menuItem (Grey, Green, None)
 * @param leadingContent - starting Optional Icon in Menu item ( Add (+), CheckMark)
 * @param title - title text of Menu Item
 * @param description - Optional description of Menu Item.
 * @param isSelected - denotes the current clicked state of menu item.
 * @param trailingContent - Optional Icon which comes last in Menu item ( Front Arrow (>), CheckMark)
 * @param tags - data class which contains string to pick a node to test compose.
 *
 * * Note:
 * * Don't pass CheckMark as a Leading & Trailing Icon use it in either one place.
 * * If you pass CheckMark as a Leading Icon then Avoid to pass FrontArrow as Trailing Icon.
 *
 * */

@Composable
fun TUIMobileOverlayMenuItem(
  modifier: Modifier = Modifier,
  backgroundColor: MobileOverlayMenuItemBgColor = TRANSPARENT,
  leadingContent: MobileOverlayMenuLeadingContent = EMPTY,
  title: String,
  description: String? = null,
  isSelected: Boolean = false,
  trailingContent: MobileOverlayMenuTrailingContent = TrailEMPTY,
  tags: TUIMobileOverlayMenuItemTags = TUIMobileOverlayMenuItemTags(),
  onItemClicked: () -> Unit,
) {

  val isMenuItemClicked = remember {
    mutableStateOf(isSelected)
  }

  val leadingContentCompose: @Composable () -> Unit = when (leadingContent) {
    CHECKMARK -> {
      {
        Icon(
          modifier = Modifier
            .testTag(tags.leadingIconTag)
            .maxHeight(24)
            .maxWidth(24),
          //.padding(top = 6.dp, bottom = 5.dp, start = 3.dp, end = 4.dp),
          painter = painterResource(id = TarkaIcons.CheckMark24Filled.iconRes),
          contentDescription = TarkaIcons.CheckMark24Filled.contentDescription,
          tint = TUITheme.colors.success
        )
        HorizontalSpacer(space = 8)
      }
    }

    ADD -> {
      {
        Icon(
          modifier = Modifier
            .testTag(tags.leadingIconTag)
            .maxHeight(24)
            .maxWidth(24),
          //.padding(3.dp),
          painter = painterResource(id = TarkaIcons.Add24Filled.iconRes),
          contentDescription = TarkaIcons.Add24Filled.contentDescription,
          tint = TUITheme.colors.onSurface
        )
        HorizontalSpacer(space = 8)
      }
    }

    STATUS_DOT -> {
      {
        Box(
          modifier = Modifier
            .size(16.dp)
            .testTag(tags.leadingIconTag),
          contentAlignment = Alignment.Center
        ) {
          Box(
            modifier = Modifier
              .size(8.dp)
              .clip(CircleShape)
              .background(TUITheme.colors.success)
          )
        }
        HorizontalSpacer(space = 8)
      }
    }

    EMPTY -> {
      {
        HorizontalSpacer(space = 32)
      }
    }
  }

  val trailingContentCompose: @Composable () -> Unit = when (trailingContent) {
    MobileOverlayMenuTrailingContent.CHECKMARK -> {
      {
        Icon(
          modifier = Modifier
            .testTag(tags.trailingIconTag)
            .maxHeight(24)
            .maxWidth(24),
          //.padding(top = 6.dp, bottom = 5.dp, start = 3.dp, end = 4.dp),
          painter = painterResource(id = TarkaIcons.CheckMark24Filled.iconRes),
          contentDescription = TarkaIcons.CheckMark24Filled.contentDescription,
          tint = TUITheme.colors.success
        )
        HorizontalSpacer(space = 8)
      }
    }

    FRONT_ARROW -> {
      {
        Icon(
          modifier = Modifier
            .testTag(tags.trailingIconTag)
            .maxHeight(20)
            .maxWidth(20),
          //.padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 6.dp),
          painter = painterResource(id = TarkaIcons.ChevronRight20Filled.iconRes),
          contentDescription = TarkaIcons.ChevronRight20Filled.contentDescription,
          tint = TUITheme.colors.utilityOutline
        )
        HorizontalSpacer(space = 8)
      }
    }

    MobileOverlayMenuTrailingContent.EMPTY -> {
      {
        HorizontalSpacer(space = 32)
      }
    }
  }

  val bgColor = when (backgroundColor) {
    TRANSPARENT -> Color.Transparent
    GREY -> TUITheme.colors.surfaceHover
    GREEN -> TUITheme.colors.success10.copy(alpha = 0.1f)
  }

  Row(
    modifier = modifier
      .testTag(tags.parentTag)
      .clickable {
        isMenuItemClicked.value = !isMenuItemClicked.value
        onItemClicked.invoke()
      }
      .background(
        color = if (isMenuItemClicked.value && backgroundColor == GREEN) TUITheme.colors.success10.copy(
          alpha = 0.2f
        ) else bgColor,
        shape = RoundedCornerShape(8.dp)

      )
      .padding(start = 16.dp, top = 8.dp, bottom = 8.dp, end = 8.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround
  ) {

    leadingContentCompose.invoke()

    Column(
      modifier = Modifier.weight(1f),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {
      Text(
        modifier = Modifier.testTag(tags.titleTag),
        text = title,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.onSurface
      )
      description?.let {
        VerticalSpacer(space = 2)
        Text(
          modifier = Modifier.testTag(tags.descriptionTag),
          text = description,
          style = TUITheme.typography.body6,
          color = TUITheme.colors.onSurface
        )
      }
    }

    trailingContentCompose.invoke()
  }
}

data class TUIMobileOverlayMenuItemTags(
  val parentTag: String = "ParentTag",
  val leadingIconTag: String = "LeadingIconTag",
  val trailingIconTag: String = "TrailingIconTag",
  val titleTag: String = "TitleTag",
  val descriptionTag: String = "DescriptionTag",
)

enum class MobileOverlayMenuLeadingContent {
  EMPTY,
  CHECKMARK,
  ADD,
  STATUS_DOT
}

enum class MobileOverlayMenuItemBgColor {
  TRANSPARENT,
  GREY,
  GREEN,
}

enum class MobileOverlayMenuTrailingContent {
  EMPTY,
  CHECKMARK,
  FRONT_ARROW,
}

@Preview
@Composable
fun MobileOverlayMenuItemPreview() {

  TUITheme {
    LazyColumn(
      modifier = Modifier
        //.background(TUITheme.colors.surface)
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Top
    ) {

      item {
        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = TRANSPARENT,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREY,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREEN,
          leadingContent = CHECKMARK
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREEN,
          leadingContent = CHECKMARK,
          isSelected = true
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREEN,
          leadingContent = ADD,
          trailingContent = MobileOverlayMenuTrailingContent.CHECKMARK,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREEN,
          leadingContent = ADD,
          trailingContent = MobileOverlayMenuTrailingContent.CHECKMARK,
          isSelected = true
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = TRANSPARENT,
          leadingContent = ADD,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREY,
          leadingContent = ADD,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = TRANSPARENT,
          leadingContent = ADD,
          trailingContent = FRONT_ARROW,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREY,
          leadingContent = ADD,
          trailingContent = FRONT_ARROW,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = TRANSPARENT,
          trailingContent = FRONT_ARROW,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          backgroundColor = GREY,
          trailingContent = FRONT_ARROW,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Completed",
          backgroundColor = TRANSPARENT,
          leadingContent = STATUS_DOT
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Completed",
          backgroundColor = GREY,
          leadingContent = STATUS_DOT
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Completed",
          backgroundColor = GREEN,
          leadingContent = STATUS_DOT,
          trailingContent = MobileOverlayMenuTrailingContent.CHECKMARK
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Completed",
          backgroundColor = GREEN,
          leadingContent = STATUS_DOT,
          trailingContent = MobileOverlayMenuTrailingContent.CHECKMARK,
          isSelected = true
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          description = "Description",
          backgroundColor = TRANSPARENT,
        ) {}

        VerticalSpacer(space = 16)

        TUIMobileOverlayMenuItem(
          title = "Label",
          description = "Description",
          backgroundColor = GREY,
        ) {}

        VerticalSpacer(space = 16)
      }
    }
  }
}
