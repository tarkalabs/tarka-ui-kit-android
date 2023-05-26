package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUIToggleSwitchScreenShotTest : ScreenshotTest {

  @get:Rule val composeRule = createComposeRule()

  @Test fun test_checked_status() {
    composeRule.setContent {
      TUIToggleSwitch(state = true) {

      }
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_unchecked_status() {
    composeRule.setContent {
      TUIToggleSwitch(state = false) {

      }
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_checked_state_with_disabled_status() {
    composeRule.setContent {
      TUIToggleSwitch(state = true, enabled = false) {

      }
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_unchecked_state_with_disabled_status() {
    composeRule.setContent {
      TUIToggleSwitch(state = false, enabled = false) {

      }
    }
    compareScreenshot(composeRule)
  }
}