package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.uicomponents.components.BadgeSize.L
import com.tarkalabs.uicomponents.components.TUIBadge
import com.tarkalabs.uicomponents.components.TUIBadgeTags
import org.junit.Rule
import org.junit.Test

class TUIBadgeTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val tags = TUIBadgeTags(parentTag = "testTag")

  @Test fun badge_Displayed() {
    composeTestRule.setContent {
      TUIBadge(
        badgeSize = L, tags = tags, count = 299
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag).assertIsDisplayed()
  }
}