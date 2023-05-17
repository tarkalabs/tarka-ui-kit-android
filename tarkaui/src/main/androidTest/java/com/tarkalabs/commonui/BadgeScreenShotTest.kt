package com.tarkalabs.commonui

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.Badge
import com.tarkalabs.uicomponents.components.BadgeSize.M
import com.tarkalabs.uicomponents.components.BadgeSize.S
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BadgeScreenShotTest : ScreenshotTest {

  @get:Rule val composeRule = createComposeRule()

  @Test fun test_badge_with_count() {
    composeRule.setContent {
      Badge(count = 2, badgeSize = M)
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_badge_with_out_count() {
    composeRule.setContent {
      Badge(badgeSize = S)
    }
    compareScreenshot(composeRule)
  }
}