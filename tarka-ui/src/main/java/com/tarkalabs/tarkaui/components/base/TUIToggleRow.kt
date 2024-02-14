package com.tarkalabs.tarkaui.components.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.ToggleRowStyle.Title
import com.tarkalabs.tarkaui.components.base.ToggleRowStyle.TitleWithDescription
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * A composable function that represents a row containing a toggle-style UI element with an optional title and description.
 *
 * @param title The title to be displayed for the toggle row.
 * @param style The style of the toggle row. Can be [ToggleRowStyle.Title] or [ToggleRowStyle.TitleWithDescription].
 * @param modifier A [Modifier] to apply custom styling and layout modifications to the toggle row.
 *
 * @sample TUIToggleRow
 *
 *  TUIToggleRow(title = "Title", style = Title)
 *  TUIToggleRow(title = "Title", style = TitleWithDescription("Description"))
 *
 */
@Composable fun TUIToggleRow(
  title: String,
  style: ToggleRowStyle = Title,
  modifier: Modifier = Modifier,
) {
  Row(
    modifier
      .fillMaxWidth()
      .defaultMinSize(minHeight = 40.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(Modifier.weight(1f)) {
      when (style) {
        is TitleWithDescription ->  TUIToggleRowTitleWithDescription(title, style)
        is Title ->  TUIToggleRowTitle(title)
      }
    }
  }
}

sealed class ToggleRowStyle {
  data class TitleWithDescription(val description: String) : ToggleRowStyle()
  object Title : ToggleRowStyle()
}

@Composable private fun TUIToggleRowTitle(title: String) {
  Text(
    text = title,
    style = TUITheme.typography.heading7,
    color = TUITheme.colors.onSurface
  )
}

@Composable private fun TUIToggleRowTitleWithDescription(
  title: String,
  style: TitleWithDescription
) {
  TUIToggleRowTitle(title = title,)
  Text(
    text = style.description,
    style = TUITheme.typography.body7,
    color = TUITheme.colors.inputTextDim.copy(alpha = 0.7f)
  )
}

@Preview(showBackground = true) @Composable fun TUIToggleRowPreview() {
  TUITheme {
    Column {
      TUIToggleRow(title = "Title", style = Title)
      TUIToggleRow(title = "Title", style = TitleWithDescription("Description"))
      TUIToggleRow(title = "Title", style = Title)
    }
  }
}