package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsToggleable
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.uicomponents.components.TUICheckBoxRow
import com.tarkalabs.uicomponents.components.TUICheckBoxRowTags
import com.tarkalabs.uicomponents.components.TUICheckBoxTags
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.components.TextRowStyle
import org.junit.Rule
import org.junit.Test

class TUICheckBoxRowTest {

  @get:Rule val composeTestRule = createComposeRule()

  private val checkBoxTag: TUICheckBoxTags = TUICheckBoxTags(parentTag = "check_box_parent_tag")
  private val textRowTag: TUITextRowTags = TUITextRowTags()
  private val tuiCheckBoxRowTag: TUICheckBoxRowTags = TUICheckBoxRowTags()

  @Test fun check_box_row_displayed() {

    var checkedState = false
    val onCheckedChange: () -> Unit = { checkedState = !checkedState }
    val title = "Checkbox Row"

    composeTestRule.setContent {
      TUICheckBoxRow(
        checked = checkedState,
        title = title,
        style = TextRowStyle.Title,
        checkBoxTags = checkBoxTag,
        textRowTags = textRowTag,
        onCheckedChange = onCheckedChange,
        tuiCheckBoxRowTag = tuiCheckBoxRowTag
      )
    }

    composeTestRule.onNodeWithTag(tuiCheckBoxRowTag.parentTag).assertIsDisplayed()

    composeTestRule.onNode(hasTestTag(checkBoxTag.parentTag), useUnmergedTree = true)
      .assertIsDisplayed()

    composeTestRule.onNode(hasTestTag(tuiCheckBoxRowTag.parentTag), useUnmergedTree = true)
      .assertIsDisplayed()

    composeTestRule.onNodeWithText(title, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun check_box_row_click_triggered() {
    var checkedState = true
    val onCheckedChange: () -> Unit = { checkedState = !checkedState }
    val title = "Checkbox Row"

    composeTestRule.setContent {
      TUICheckBoxRow(
        checked = checkedState,
        title = title,
        style = TextRowStyle.Title,
        checkBoxTags = checkBoxTag,
        textRowTags = textRowTag,
        onCheckedChange = onCheckedChange,
        tuiCheckBoxRowTag = tuiCheckBoxRowTag
      )
    }

    composeTestRule.onNodeWithTag(tuiCheckBoxRowTag.parentTag, useUnmergedTree = true)
      .assertIsToggleable()
      .assertIsOn()
  }
}