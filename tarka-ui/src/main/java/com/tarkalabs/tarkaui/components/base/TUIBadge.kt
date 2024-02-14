package com.tarkalabs.tarkaui.components.base

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.BadgeSize.L
import com.tarkalabs.tarkaui.components.base.BadgeSize.M
import com.tarkalabs.tarkaui.components.base.BadgeSize.S
import com.tarkalabs.tarkaui.theme.TUITheme

enum class BadgeSize(val size: Dp) {
  S(12.dp),
  M(16.dp),
  L(24.dp)
}

/**
 * Below TUIBadge() defines a reusable composable function which can be used to create an Badge with various sizes which takes couple of  parameters
 * @param count The Count to be displayed on the badge.
 * @param badgeSize The height size of the badge. Default is [BadgeSize.M].
 * @param tags  Test tag for the TUIBadge.
 *
 * How to use TUIBadge() composable function
 *    TUIBadge(count = 3,badgeSize = M)
 *
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun TUIBadge(
  modifier: Modifier = Modifier,
  count: Int? = null,
  badgeSize: BadgeSize = M,
  tags: TUIBadgeTags = TUIBadgeTags(),
  color: Color = TUITheme.colors.error
) {
  when (badgeSize) {
    S -> 0.dp
    M -> 4.dp
    L -> 8.dp
  }
  val textStyle = when (badgeSize) {
    S, M -> TUITheme.typography.button8
    L -> TUITheme.typography.button7
  }
  androidx.compose.material3.Badge(
    containerColor = color,
    modifier = modifier
      .defaultMinSize(minWidth = badgeSize.size, minHeight = badgeSize.size)
      .testTag(tags.parentTag)
  ) {
    if (count != null) Text(
      text = count.toString(),
      style = textStyle,
      color = TUITheme.colors.onTertiary,
    )
  }
}

data class TUIBadgeTags(
  val parentTag: String = "TUIBadge",
)

@Preview(showBackground = true) @Composable fun BadgePreview() {
  TUIBadge(count = 40, badgeSize = M)
}
