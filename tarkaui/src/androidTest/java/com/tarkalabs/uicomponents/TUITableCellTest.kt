package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.uicomponents.components.TUITableCell
import com.tarkalabs.uicomponents.components.TUITableCellTags
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Rule
import org.junit.Test

class TUITableCellTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val testTags: TUITableCellTags = TUITableCellTags()

  @Test fun tuiTableCellDisplayed() {
    val cellValue = "Label"
    composeTestRule.setContent {
      TUITheme {
        TUITableCell(
          cellValue = cellValue,
          isHeader = true,
          isTopBorderVisible = true,
          isBottomBorderVisible = true
        )
      }
    }
    composeTestRule.onNodeWithTag(testTags.parentTag).assertExists().assertIsDisplayed()
  }
}