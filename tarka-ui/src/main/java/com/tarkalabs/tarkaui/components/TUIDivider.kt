package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.NONE
import com.tarkalabs.tarkaui.components.Orientation.HORIZONTAL
import com.tarkalabs.tarkaui.components.Orientation.VERTICAL
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 *
 * TUIDivider creates a divider , in two orientations Horizontal and Vertical.
 *
 * @param orientation: The orientation of divider is passed as param (Horizontal or Vertical)
 * @param thickness: The thickness of divider , default is one.
 * @param horizontalPadding: Horizontal padding of this divider.
 * @param verticalPadding: The Vertical padding of this divider.
 * @param tags: The test tag for the row.
 * @param color: The color of the divider, by default we're using surfaceVariantHover.
 *
 * Example usage:
 *
 *  TUIDivider(
 *     orientation = HORIZONTAL,
 *     thickness = 2,
 *     horizontalPadding = L,
 *     verticalPadding = M,
 *   )
 *
 */

@Composable
fun TUIDivider(
  modifier: Modifier = Modifier,
  orientation: Orientation = HORIZONTAL,
  thickness: Int = 1,
  color: Color = TUITheme.colors.surfaceVariantHover,
  horizontalPadding: HorizontalPaddingSize = NONE,
  verticalPadding: VerticalPaddingSize = VerticalPaddingSize.NONE,
  tags: TUIDividerTags = TUIDividerTags()
) {
  when (orientation) {
    VERTICAL -> {
      // todo vertical divider is not yet implemented in any of the components so we don't know height
      // .height(40.dp)
      Row {
        HorizontalSpacer(space = horizontalPadding.size)
        VerticalDivider(
          modifier = modifier
            .fillMaxHeight()
            .padding(vertical = verticalPadding.size.dp)
            .testTag(tag = tags.parentTag),
          color = color,
          thickness = thickness.dp
        )
        HorizontalSpacer(space = horizontalPadding.size)
      }
    }

    HORIZONTAL -> {
      Column {
        VerticalSpacer(space = verticalPadding.size)
        HorizontalDivider(
          modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding.size.dp)
            .testTag(tag = tags.parentTag),
          color = color,
          thickness = thickness.dp
        )
        VerticalSpacer(space = verticalPadding.size)
      }
    }
  }
}

@Preview
@Composable
private fun TUIDividerPreview() {
  Column(
    modifier = Modifier
      .background(Color.Black)
      .fillMaxSize()
  ) {
    VerticalSpacer(space = 10)
    TUIDivider(color = TUITheme.colors.secondaryAlt)
    VerticalSpacer(space = 10)
    TUIDivider()
  }
}

data class TUIDividerTags(val parentTag: String = "TUIDivider")

enum class Orientation {
  VERTICAL,
  HORIZONTAL
}

enum class HorizontalPaddingSize(val size: Int) {
  XL(32),
  L(24),
  M(16),
  S(8),
  NONE(0)
}

enum class VerticalPaddingSize(val size: Int) {
  M(8),
  NONE(0)
}