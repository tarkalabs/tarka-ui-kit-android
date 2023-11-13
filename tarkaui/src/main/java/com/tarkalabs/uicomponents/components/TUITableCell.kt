package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable fun TUITableCell(
  modifier: Modifier = Modifier,
  cellValue: String,
  isHeader: Boolean,
  tags: TUITableCellTags = TUITableCellTags(),
  isTopBorderVisible: Boolean,
  isBottomBorderVisible: Boolean,
) {
  val borderColor = TUITheme.colors.surfaceVariantHover
  Row(
    modifier = modifier
      .drawBehind {
        if (isTopBorderVisible) {
          drawLine(
            color = borderColor,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = 0f),
            strokeWidth = 3f
          )
        }
        if (isBottomBorderVisible) {
          drawLine(
            color = borderColor,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = size.height),
            strokeWidth = 3f
          )
        }
      },
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).fillMaxWidth(),
      style = TUITheme.typography.body7,
      text = cellValue,
      color = if (isHeader)
        TUITheme.colors.onSurface
      else
        TUITheme.colors.utilityDisabledContent,
    )
  }
}

data class TUITableCellTags(
  val parentTag: String = "TUITableCell",
)

@Preview(showBackground = true)
@Composable
fun PreviewTUITableCell() {
  Box {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(modifier = Modifier.height(Max)) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = false,
          isBottomBorderVisible = false,
          isTopBorderVisible = true
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = true
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = false,
          isBottomBorderVisible = false,
          isTopBorderVisible = false
        )
      }
      Row(modifier = Modifier.height(Max)) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = true,
          isBottomBorderVisible = false,
          isTopBorderVisible = true
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = true
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .padding(5.dp)
            .fillMaxHeight(),
          cellValue = "Label",
          isHeader = true,
          isBottomBorderVisible = false,
          isTopBorderVisible = false
        )
      }
    }
  }
}

@Preview(showBackground = true) @Composable
fun PreviewCombinedTUITableCell() {
  TUITheme {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier.height(Max),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "Pending to be synced",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "Errored out",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
      }
      Row(
        modifier = Modifier.height(Max),
      ) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "General",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "3",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "2",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
      }
    }
  }
}