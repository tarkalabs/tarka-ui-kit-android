package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ApprovalsApp24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.extentions.maxHeight
import com.tarkalabs.uicomponents.extentions.maxWidth
import com.tarkalabs.uicomponents.theme.TUITheme

object TUIMultiLevelSelectorHeader {

  /**
   * Composable representing a header for a multi-level selector.
   *
   * This composable function creates a header with a title, icons, and interactive behavior.
   * It is typically used in multi-level selection components.
   *
   * @param modifier Modifier for the header layout and appearance.
   * @param isSelected Boolean indicating whether the header is selected.
   * @param title Title text to be displayed in the header.
   * @param leadingIcon Icon to be displayed on the leading (left) side of the header.
   * @param trailingIcon Icon to be displayed on the trailing (right) side of the header (optional).
   * @param paddingValues Padding values for the header content.
   * @param tags Tags used for testing and identifying this Composable.
   * @param onClick Lambda function invoked when the header is clicked.
   */
  @Composable operator fun invoke(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    title: String,
    leadingIcon: TarkaIcon,
    trailingIcon: TarkaIcon? = null,
    paddingValues: PaddingValues = PaddingValues(),
    tags: TUIMultiLevelSelectorHeaderTags = TUIMultiLevelSelectorHeaderTags(),
    onClick: () -> Unit,
  ) {
    val color = if (isSelected) TUITheme.colors.onPrimaryAlt else TUITheme.colors.onSurface

    Box(modifier = modifier
      .background(color = if (isSelected) TUITheme.colors.primaryAlt else TUITheme.colors.surface)
      .clickable { onClick() }
      .padding(paddingValues)
      .testTag(tags.parentTag)) {
      Row(
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          painter = painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          modifier = Modifier
            .maxHeight(24)
            .maxWidth(24),
          tint = color
        )
        HorizontalSpacer(space = 4)
        Text(
          modifier = Modifier
            .weight(1f)
            .padding(vertical = 8.dp),
          text = title,
          style = TUITheme.typography.heading6,
          color = color
        )
        HorizontalSpacer(space = 12)
        if (trailingIcon != null) {
          Icon(
            painter = painterResource(id = trailingIcon.iconRes),
            contentDescription = trailingIcon.contentDescription,
            modifier = Modifier
              .maxHeight(24)
              .maxWidth(24),
            tint = color
          )
          HorizontalSpacer(space = 12)
        }
      }

    }
  }

  data class TUIMultiLevelSelectorHeaderTags(
    val parentTag: String = "TUIMultiLevelSelectorHeader_ParentTag",
  )
}

@Preview @Composable fun TUIMultiLevelSelectorHeaderPreview() {
  TUITheme {
    Column {
      VerticalSpacer(space = 40)
      TUIMultiLevelSelectorHeader(
        modifier = Modifier.fillMaxWidth(),
        isSelected = true,
        leadingIcon = TarkaIcons.Filled.ApprovalsApp24,
        trailingIcon = TarkaIcons.Filled.ApprovalsApp24,
        title = "Hello There",
      ) {}

      VerticalSpacer(space = 20)

      TUIMultiLevelSelectorHeader(
        modifier = Modifier.fillMaxWidth(),
        isSelected = false,
        title = "Hello There",
        leadingIcon = TarkaIcons.Filled.ApprovalsApp24,
        ) {}

    }
  }
}