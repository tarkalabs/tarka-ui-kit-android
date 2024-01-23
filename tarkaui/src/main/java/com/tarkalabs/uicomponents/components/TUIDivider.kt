package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.Orientation.HORIZONTAL
import com.tarkalabs.uicomponents.components.Orientation.VERTICAL
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.L
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.S
import com.tarkalabs.uicomponents.components.VerticalPaddingSize.M
import com.tarkalabs.uicomponents.theme.TUITheme


/**
 *
 * TUIDivider creates a divider , in two orientations Horizontal and Vertical.
 *
 * @param orientation: The orientation of divider is passed as param (Horizontal or Vertical)
 * @param thickness: The thickness of divider , default is one.
 * @param horizontalPadding: Horizontal padding of this divider.
 * @param verticalPadding: The Vertical padding of this divider.
 * @param tags: The test tag for the row.
 * @param color: The color of the divider, by default we're using surface.
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
  orientation: Orientation,
  tags: TUIDividerTags = TUIDividerTags(),
  thickness: Int = 1,
  horizontalPadding: HorizontalPaddingSize = S,
  verticalPadding: VerticalPaddingSize = M,
  color: Color = TUITheme.colors.surface
) {
  when (orientation) {
    VERTICAL -> {
      Row {
        HorizontalSpacer(space = horizontalPadding.size)
        Divider(
          modifier = Modifier
            .fillMaxHeight()
            //todo vertical divider is not yet implemented in any of the components so we don't know height
            // .height(40.dp)
            .width(thickness.dp)
            .padding(vertical = verticalPadding.size.dp)
            .testTag(tag = tags.parentTag),
          color = color
        )
        HorizontalSpacer(space = horizontalPadding.size)
      }
    }

    HORIZONTAL -> {
      Column {
        VerticalSpacer(space = verticalPadding.size)
        Divider(
          modifier = Modifier
            .fillMaxWidth()
            .height(thickness.dp)
            .padding(horizontal = horizontalPadding.size.dp)
            .testTag(tag = tags.parentTag),
          color = color,
        )
        VerticalSpacer(space = verticalPadding.size)
      }
    }
  }
}

@Preview
@Composable
fun TuiDivider() {
  TUIDivider(
    orientation = VERTICAL,
    thickness = 20,
    horizontalPadding = L,
    verticalPadding = M,
  )
  TUIDivider(
    orientation = HORIZONTAL,
    thickness = 20,
    horizontalPadding = L,
    verticalPadding = M,
  )
}


data class TUIDividerTags(
  val parentTag: String = "TUIDivider",
)

enum class Orientation {
  VERTICAL,
  HORIZONTAL
}

enum class HorizontalPaddingSize(val size: Int) {
  XL(32),
  L(24),
  M(16),
  S(8),
  XS(0);
}

enum class VerticalPaddingSize(val size: Int) {
  M(8),
  S(0)
}
