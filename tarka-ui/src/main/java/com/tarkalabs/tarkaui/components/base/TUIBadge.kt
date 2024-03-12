package com.tarkalabs.tarkaui.components.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.components.base.BadgeSize.L
import com.tarkalabs.tarkaui.components.base.BadgeSize.M
import com.tarkalabs.tarkaui.components.base.BadgeSize.S
import com.tarkalabs.tarkaui.icons.ErrorCircle12
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

enum class BadgeSize(val size: Dp) {
  S(12.dp),
  M(16.dp),
  L(24.dp)
}

sealed class BadgeStyle {
  data class Icon(val icon: TarkaIcon) : BadgeStyle()
  data class Count(val count: Int = 0) : BadgeStyle()
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
@Composable fun TUIBadge(
  modifier: Modifier = Modifier,
  style: BadgeStyle = BadgeStyle.Count(),
  badgeSize: BadgeSize = M,
  tags: TUIBadgeTags = TUIBadgeTags(),
  color: Color = TUITheme.colors.error
) {

  val textStyle = when (badgeSize) {
    S, M -> TUITheme.typography.button8
    L -> TUITheme.typography.button7
  }

  Box(
    modifier = modifier
      .defaultMinSize(minWidth = badgeSize.size, minHeight = badgeSize.size)
      .testTag(tags.parentTag)
      .clip(CircleShape)
      .background(color),
    contentAlignment = Alignment.Center,
  ) {
    when (style) {
      is BadgeStyle.Count -> {
        if (style.count != 0) {
          Text(
            modifier = Modifier
              .padding(horizontal = 2.dp)
              .align(Alignment.Center),
            textAlign = TextAlign.Center,
            text = style.count.toString(),
            style = textStyle,
            color = TUITheme.colors.onTertiary,
          )
        }
      }

      is BadgeStyle.Icon -> {
        Icon(
          modifier = Modifier
            .testTag(tags.iconTag)
            .defaultMinSize(minHeight = 10.dp, minWidth = 10.dp)
            .wrapContentSize(),
          painter = painterResource(id = style.icon.iconRes),
          contentDescription = style.icon.contentDescription
        )
      }
    }
  }
}

data class TUIBadgeTags(
  val parentTag: String = "TUIBadge",
  val iconTag: String = "BadgeIcon",
)

@Preview(showBackground = true) @Composable fun BadgePreview() {
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    TUIBadge(style = BadgeStyle.Count(4), badgeSize = M)
    VerticalSpacer(space = 8)
    TUIBadge(
      style = BadgeStyle.Icon(TarkaIcons.Regular.ErrorCircle12),
      badgeSize = M,
      color = TUITheme.colors.warning
    )
  }
}
