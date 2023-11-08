package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.BorderPlacement.Bottom
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable fun TUITableCell(
  modifier: Modifier = Modifier,
  cellValue: String? = null,
  border: BorderPlacement = Bottom,
  header: Boolean,
  tags: TUITableCellTags = TUITableCellTags(),
) {
  val color = TUITheme.colors.surfaceVariantHover
  Column(modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center) {
    Divider(thickness = .5.dp)
    Text(
      text = cellValue.toString(),
      color = if (header) TUITheme.colors.onSurface else TUITheme.colors.utilityDisabledContent,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center
    )
    Divider(thickness = .5.dp)
  }
}

enum class BorderPlacement {
  Top,
  Bottom,
  TopAndBottom,
  None
}

data class TUITableCellTags(
  val parentTag: String = "TUITableCell",
)

@Preview(showBackground = true) @Composable fun PreviewTUITableCell() {
  TUITheme {
    Column(Modifier.fillMaxWidth()) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
      ) {
        TUITableCell(
          modifier = Modifier.weight(1f), cellValue = "World", header = false
        )
        TUITableCell(
          modifier = Modifier.weight(1f), cellValue = "Hello", header = false
        )
        TUITableCell(
          modifier = Modifier.weight(1f), cellValue = "Hello", header = false
        )
      }
      // Row(
      //   verticalAlignment = Alignment.CenterVertically,
      // ) {
      //   TUITableCell(
      //     modifier = Modifier,
      //     cellValue = "Work orders",
      //     header = true
      //   )
      //   TUITableCell(
      //     modifier = Modifier,
      //     cellValue = "1",
      //     header = true
      //   )
      //   TUITableCell(
      //     modifier = Modifier,
      //     cellValue = "2",
      //     header = true
      //   )
      // }
    }
  }
}