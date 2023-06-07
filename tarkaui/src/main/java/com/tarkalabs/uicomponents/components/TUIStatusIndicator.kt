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
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable fun TUIStatusIndicator(
  text: String, status: Boolean,
  modifier: Modifier = Modifier,
  testTag: String = Tags.TAG_STATUS
) {
  Row(modifier = modifier.testTag(testTag), verticalAlignment = Alignment.CenterVertically) {
    Text(
      text = text,
      style = TUITheme.typography.button8,
      color = TUITheme.colors.utilityDisabledContent.copy(alpha = 0.38f)
    )
    HorizontalSpacer(space = 14)
    Box(
      modifier = Modifier
        .size(8.dp)
        .clip(CircleShape)
        .background(if (status) TUITheme.colors.success else TUITheme.colors.error)
    )

  }
}

@Preview(showBackground = true)
@Composable
fun PreviewTUIStatus() {
  Column {
    TUIStatusIndicator(text = "Connected", status = true)
    VerticalSpacer(space = 10)
    TUIStatusIndicator(text = "Connected", status = false)
  }
}