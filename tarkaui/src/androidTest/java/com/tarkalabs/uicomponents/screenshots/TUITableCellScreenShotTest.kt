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
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_${darkTheme}"
          add(arrayOf(testName, darkTheme))
        }
      }
    }
  }

  @Test fun tableCellWithBottomBorder() =
    compareScreenshotFor(darkTheme, "_tableCellWithBottomBorder_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = false,
          isTopBorderVisible = true,
          isBottomBorderVisible = false
        )
      }
    }

  @Test fun tableCellWithTopBorder() =
    compareScreenshotFor(darkTheme, "_tableCellWithTopBorder_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = false,
          isTopBorderVisible = false,
          isBottomBorderVisible = true
        )
      }
    }

  @Test fun tableCellWithTopAndBottomBorder() =
    compareScreenshotFor(darkTheme, "_tableCellWithTopAndBottomBorder_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = false,
          isTopBorderVisible = true,
          isBottomBorderVisible = true
        )
      }
    }

  @Test fun tableCellWithNoBorder() =
    compareScreenshotFor(darkTheme, "_tableCellWithNoBorder_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = false,
          isTopBorderVisible = false,
          isBottomBorderVisible = false
        )
      }
    }

  @Test fun tableCellWithHeaderText() =
    compareScreenshotFor(darkTheme, "_tableCellWithHeaderText_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = true,
          isTopBorderVisible = true,
          isBottomBorderVisible = true
        )
      }
    }

  @Test fun tableCellWithoutHeaderText() =
    compareScreenshotFor(darkTheme, "_tableCellWithoutHeaderText_$testName") {
      Box(
        modifier = Modifier.padding(10.dp)
      ) {
        TUITableCell(
          cellValue = "Label",
          isHeader = false,
          isTopBorderVisible = true,
          isBottomBorderVisible = true
        )
      }
    }
}