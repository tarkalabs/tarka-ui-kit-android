package com.tarkalabs.tarkaui.components

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Represents a table cell, this composable function creates the Table Cell with border. It is typically used to create the table.
 *
 * Note: If the table cell is used in the Row, need to provide the height modifier add intrinsicSize.MAX and provide the child element modifier add fillMaxHeight()
 * @param modifier Modifier for the Table cell layout and appearance.
 * @param cellValue The text value to display in the table cell
 * @param isHeader Boolean value represents the cell value is header or not.
 * @param tags Tags used for testing and identifying this Composable.
 * @param isTopBorderVisible Boolean value which represents the top border is visible or not.
 * @param isBottomBorderVisible Boolean value which represents the bottom border is visible or not.
 *
 */

@Composable fun TUITableCell(
  modifier: Modifier = Modifier,
  cellValue: String,
  isHeader: Boolean,
  tags: TUITableCellTags = TUITableCellTags(),
  isTopBorderVisible: Boolean = false,
  isBottomBorderVisible: Boolean = false
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
            strokeWidth = 1.dp.toPx()
          )
        }
        if (isBottomBorderVisible) {
          drawLine(
            color = borderColor,
            start = Offset(x = 0f, y = size.height),
            end = Offset(x = size.width, y = size.height),
            strokeWidth = 1.dp.toPx()
          )
        }
      }
      .testTag(tags.parentTag),
    horizontalArrangement = Arrangement.Start,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      modifier = Modifier
        .padding(top = 8.dp, bottom = 8.dp)
        .fillMaxWidth(),
      style = TUITheme.typography.body7,
      text = cellValue,
      color = if (isHeader) {
        TUITheme.colors.utilityDisabledContent
      } else {
        TUITheme.colors.onSurface
      }
    )
  }
}

data class TUITableCellTags(val parentTag: String = "TUITableCell")

@Preview(showBackground = true)
@Composable
private fun TUITableCellPreview() {
  TUITheme {
    Box {
      Column(modifier = Modifier.padding(10.dp)) {
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
      }
    }
  }
}

@Preview @Composable
private fun CombinedTUITableCellPreview() {
  TUITheme(true) {
    Column(modifier = Modifier.padding(10.dp)) {
      Row(
        modifier = Modifier.height(Max),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
      ) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "Pending to be synced",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "Errored out",
          isHeader = true,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
      }
      Row(
        modifier = Modifier.height(Max)
      ) {
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "General",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "3",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
        TUITableCell(
          modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
          cellValue = "2",
          isHeader = false,
          isBottomBorderVisible = true,
          isTopBorderVisible = false
        )
      }
    }
  }
}