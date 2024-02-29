package com.tarkalabs.tarkaui.components

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
import com.tarkalabs.tarkaui.components.TUIStatus.OFF
import com.tarkalabs.tarkaui.components.TUIStatus.ON
import com.tarkalabs.tarkaui.theme.TUITheme

enum class TUIStatus {
  ON,
  OFF
}

/**
 * A composable function that displays a status indicator with a text and a colored circle representing the status.
 *
 * @param text The text to display alongside the status indicator.
 * @param status The status of the indicator (ON or OFF).
 * @param modifier The modifier for the status indicator.
 * @param tags The tags for testing purposes.
 * Usage example:
 * TUIStatusIndicator("Connected", TUIStatus.ON)
 * TUIStatusIndicator("Disconnected", TUIStatus.OFF)
 */
@Composable fun TUIStatusIndicator(
  text: String,
  status: TUIStatus,
  modifier: Modifier = Modifier,
  tags: TUIStatusIndicatorTags = TUIStatusIndicatorTags()
) {
  val statusColor = if (status == ON) TUITheme.colors.success else TUITheme.colors.error
  Row(modifier = modifier.testTag(tags.parentTag), verticalAlignment = Alignment.CenterVertically) {
    Text(
      text = text,
      style = TUITheme.typography.button8,
      color = TUITheme.colors.utilityDisabledContent
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
  val parentTag: String = "TUIStatusIndicator",
  val circleTag: String = "TUIStatusIndicator_Cirlce",
)

@Preview(showBackground = true) @Composable fun PreviewTUIStatus() {
  Column {
    TUIStatusIndicator(text = "Connected", status = ON)
    VerticalSpacer(space = 10)
    TUIStatusIndicator(text = "Disconnected", status = OFF)
  }
}

