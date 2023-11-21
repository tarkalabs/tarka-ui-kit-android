package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUITableCell
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITableCellScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean,
  private val isHeader: Boolean,
  private val isTopBorderVisible: Boolean,
  private val isBottomBorderVisible: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (isHeader in listOf(true, false)) {
            for (isTopBorderVisible in listOf(true, false)) {
              for (isBottomBorderVisible in listOf(true, false)) {
                val testName =
                  "darkTheme_${darkTheme}_isHeader_${isHeader}_isTopBorder_${isTopBorderVisible}_isBottomBorder_${isBottomBorderVisible}"
                add(
                  arrayOf(testName, darkTheme, isHeader, isTopBorderVisible, isBottomBorderVisible)
                )
              }
            }
          }
        }
      }
    }
  }

  @Test fun tableCellWithBottomBorder() =
    compareScreenshotFor(darkTheme, "TableCell_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = isHeader,
          isTopBorderVisible = isTopBorderVisible,
          isBottomBorderVisible = isBottomBorderVisible
        )
      }
    }
}