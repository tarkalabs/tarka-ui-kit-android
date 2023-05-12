package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.BadgeSize.L
import com.tarkalabs.uicomponents.components.BadgeSize.M
import com.tarkalabs.uicomponents.components.BadgeSize.S
import com.tarkalabs.uicomponents.theme.Eam360Theme

enum class BadgeSize(val size: Dp) {
  S(12.dp),
  M(16.dp),
  L(24.dp)
}

@OptIn(ExperimentalMaterial3Api::class) @Composable fun Badge(
  count: Int? = null, badgeSize: BadgeSize = M
) {
  val padding = when (badgeSize) {
    S -> 0.dp
    M -> 4.dp
    L -> 8.dp
  }
  val textStyle = when (badgeSize) {
    S, M -> {
      Eam360Theme.typography.button8
    }
    L -> {
      Eam360Theme.typography.button7
    }
  }
  androidx.compose.material3.Badge(
    containerColor = MaterialTheme.colorScheme.error,
    modifier = Modifier
      .padding(padding)
      .defaultMinSize(
        minWidth = badgeSize.size, minHeight = badgeSize.size
      )

  ) {
    if (count != null) Text(
      text = count.toString(),
      style = textStyle,
      color = MaterialTheme.colorScheme.onTertiary,
    )
  }
}

@Preview(showBackground = true) @Composable fun BadgePreview() {
  Badge(count = 4440440, badgeSize = M)
}
