package com.tarkalabs.tarkaui.components.base

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.R
import com.tarkalabs.tarkaui.components.VerticalSpacer
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
@Composable
fun TUIToggleRow(
  modifier: Modifier = Modifier,
  title: String,
  style: ToggleRowStyle = Title,
  @StringRes primaryNotAvailableText: Int = R.string.not_availble
) {
  Row(
    modifier
      .fillMaxWidth()
      .defaultMinSize(minHeight = 40.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Column(Modifier.weight(1f)) {
      when (style) {
        is TitleWithDescription -> TUIToggleRowTitleWithDescription(
          title,
          style,
          primaryNotAvailableText
        )

        is Title -> TUIToggleRowTitle(title, primaryNotAvailableText)
      }
    }
  }
}

sealed class ToggleRowStyle {
  data class TitleWithDescription(
    val description: String,
    @StringRes val primaryNotAvailableText: Int = R.string.not_availble
  ) : ToggleRowStyle()

  data object Title : ToggleRowStyle()
}

@Composable
private fun TUIToggleRowTitle(title: String?, @StringRes primaryNotAvailableText: Int) {
  if (title.isNullOrEmpty()) {
    Text(
      text = stringResource(id = primaryNotAvailableText),
      style = TUITheme.typography.heading7,
      color = TUITheme.colors.utilityDisabledContent
    )
  } else {
    Text(
      text = title,
      style = TUITheme.typography.heading7,
      color = TUITheme.colors.onSurface
    )
  }
}

@Composable
private fun TUIToggleRowTitleWithDescription(
  title: String,
  style: TitleWithDescription,
  @StringRes primaryNotAvailableText: Int = R.string.not_availble
) {
  TUIToggleRowTitle(title = title, primaryNotAvailableText)
  VerticalSpacer(space = 4)
  Text(
    text = style.description,
    style = TUITheme.typography.body7,
    color = TUITheme.colors.inputTextDim.copy(alpha = 0.7f)
  )
}

@Preview(showBackground = true)
@Composable
private fun TUIToggleRowPreview() {
  TUITheme {
    Column {
      TUIToggleRow(title = "Title", style = Title)
      TUIToggleRow(title = "Title", style = TitleWithDescription("Description"))
      TUIToggleRow(title = "", style = TitleWithDescription("Description"))
      TUIToggleRow(title = "Title", style = Title)
      TUIToggleRow(title = "Title")
    }
  }
}