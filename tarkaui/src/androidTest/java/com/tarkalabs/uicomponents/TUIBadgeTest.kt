package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.uicomponents.components.BadgeSize.L
import com.tarkalabs.uicomponents.components.TUIBadge
import org.junit.Rule
import org.junit.Test

class TUIBadgeTest {
  @get:Rule val composeTestRule = createComposeRule()
  private val TEST_TAG = "TEST_TAG"

  @Test fun badge_Displayed() {
    composeTestRule.setContent {
      TUIBadge(
        badgeSize = L,
        testTag = TEST_TAG,
        count = 299
      )
    }

    composeTestRule.onNodeWithTag(TEST_TAG).assertIsDisplayed()
  }
}