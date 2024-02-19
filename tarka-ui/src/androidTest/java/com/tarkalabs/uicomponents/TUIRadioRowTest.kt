package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.tarkalabs.tarkaui.components.base.ToggleRowStyle.Title
import com.tarkalabs.tarkaui.components.radiobutton.TUIRadioButtonTags
import com.tarkalabs.tarkaui.components.radiobutton.TUIRadioRow
import com.tarkalabs.tarkaui.components.radiobutton.TUIRadioRowTags
import org.junit.Rule
import org.junit.Test

class TUIRadioRowTest {

  @get:Rule val composeTestRule = createComposeRule()

  private val radioButtonTags: TUIRadioButtonTags = TUIRadioButtonTags(parentTag = "radio_button_parent_tag")
  private val radioButtonRowTag: TUIRadioRowTags = TUIRadioRowTags(radioButtonTags = radioButtonTags)

  @Test fun radioButton_Row_IsDisplayed() {

    var selectedState = false
    val onOptionSelected: () -> Unit = { selectedState = !selectedState }
    val title = "RadioButton Row"

    composeTestRule.setContent {
      TUIRadioRow(
        selected = selectedState,
        title = title,
        style = Title,
        onOptionSelected = onOptionSelected,
        tags = radioButtonRowTag
      )
    }

    composeTestRule.onNodeWithTag(radioButtonRowTag.parentTag).assertIsDisplayed()
    composeTestRule.onRoot(useUnmergedTree = true).printToLog("somehting")
    //Thread.sleep(50_000)
    composeTestRule.onNodeWithTag(radioButtonTags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNode(hasTestTag(radioButtonRowTag.parentTag), useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText(title, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun radioButton_Row_Click_Triggered() {
    var selectedState = true
    val onOptionSelected: () -> Unit = { selectedState = !selectedState }
    val title = "Radio Button"

    composeTestRule.setContent {
      TUIRadioRow(
        selected = selectedState,
        title = title,
        style = Title,
        onOptionSelected = onOptionSelected,
        tags = radioButtonRowTag
      )
    }

    composeTestRule.onNodeWithTag(radioButtonRowTag.parentTag, useUnmergedTree = true)
      .assertIsSelected()
  }
}