package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.TUIStatus.OFF
import com.tarkalabs.uicomponents.components.TUIStatus.ON
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIStatus {
  ON,
  OFF
}

@Composable fun TUIStatusIndicator(
  text: String, status: TUIStatus,
  modifier: Modifier = Modifier, tags: TUIStatusIndicatorTags = TUIStatusIndicatorTags()
) {
  val statusColor = if (status == ON) TUITheme.colors.success else TUITheme.colors.error
  Row(modifier = modifier.testTag(tags.parentTag), verticalAlignment = Alignment.CenterVertically) {
    Text(
      text = text,
      style = TUITheme.typography.button8,
      color = TUITheme.colors.utilityDisabledContent.copy(alpha = 0.38f)
    )
    HorizontalSpacer(space = 14)
    Box(
      modifier = Modifier
        .testTag(tags.circleTag)
        .size(8.dp)
        .clip(CircleShape)
        .background(statusColor)
    )
  }
}

data class TUIStatusIndicatorTags(
  val parentTag: String = Tags.TAG_STATUS_INDICATOR,
  val circleTag: String = Tags.TAG_STATUS_INDICATOR_CIRCLE,
)

@Preview(showBackground = true) @Composable fun PreviewTUIStatus() {
  Column {
    TUIStatusIndicator(text = "Connected", status = ON)
    VerticalSpacer(space = 10)
    TUIStatusIndicator(text = "Disconnected", status = OFF)
  }
}

