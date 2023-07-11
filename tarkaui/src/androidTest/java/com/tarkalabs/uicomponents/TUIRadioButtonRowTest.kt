package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.uicomponents.components.TUIRadioButtonRow
import com.tarkalabs.uicomponents.components.TUIRadioButtonRowTags
import com.tarkalabs.uicomponents.components.TUIRadioButtonTags
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.components.TextRowStyle
import org.junit.Rule
import org.junit.Test

class TUIRadioButtonRowTest {

  @get:Rule val composeTestRule = createComposeRule()

  private val radioButtonTags: TUIRadioButtonTags = TUIRadioButtonTags(parentTag = "radio_button_parent_tag")
  private val textRowTag: TUITextRowTags = TUITextRowTags()
  private val radioButtonRowTag: TUIRadioButtonRowTags = TUIRadioButtonRowTags()

  @Test fun radioButtonRowDisplayed() {

    var selectedState = false
    val onOptionSelected: () -> Unit = { selectedState = !selectedState }
    val title = "RadioButton Row"

    composeTestRule.setContent {
      TUIRadioButtonRow(
        selected = selectedState,
        title = title,
        style = TextRowStyle.Title,
        radioButtonTags = radioButtonTags,
        textRowTags = textRowTag,
        onOptionSelected = onOptionSelected,
        radioButRowTags = radioButtonRowTag
      )
    }

    composeTestRule.onNodeWithTag(radioButtonRowTag.parentTag).assertIsDisplayed()

    composeTestRule.onNode(hasTestTag(radioButtonTags.parentTag), useUnmergedTree = true)
      .assertIsDisplayed()

    composeTestRule.onNode(hasTestTag(radioButtonRowTag.parentTag), useUnmergedTree = true)
      .assertIsDisplayed()

    composeTestRule.onNodeWithText(title, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun radioRowClickTriggered() {
    var selectedState = true
    val onOptionSelected: () -> Unit = { selectedState = !selectedState }
    val title = "Radio Button"

    composeTestRule.setContent {
      TUIRadioButtonRow(
        selected = selectedState,
        title = title,
        style = TextRowStyle.Title,
        radioButtonTags = radioButtonTags,
        textRowTags = textRowTag,
        onOptionSelected = onOptionSelected,
        radioButRowTags = radioButtonRowTag
      )
    }

    composeTestRule.onNodeWithTag(radioButtonRowTag.parentTag, useUnmergedTree = true)
      .assertIsSelected()
  }
}