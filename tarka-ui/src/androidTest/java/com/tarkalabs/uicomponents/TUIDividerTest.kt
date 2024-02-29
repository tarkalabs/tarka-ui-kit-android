package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.tarkaui.components.Orientation.HORIZONTAL
import com.tarkalabs.tarkaui.components.TUIDivider
import com.tarkalabs.tarkaui.components.TUIDividerTags
import org.junit.Rule
import org.junit.Test

class TUIDividerTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val tags = TUIDividerTags(parentTag = "testTag")

  @Test fun divider_Displayed() {
    composeTestRule.setContent {
      TUIDivider(
        tags = tags, orientation = HORIZONTAL
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag).assertIsDisplayed()
  }
}