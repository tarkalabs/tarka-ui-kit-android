package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.L
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.R
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.S
import com.tarkalabs.uicomponents.components.TUIFloatingActionButton
import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUIFloatingActionButtonScreenShotTest : ScreenshotTest {

  @get:Rule val composeRule = createComposeRule()

  @Test fun test_fab_with_small_size() {
    composeRule.setContent {
      TUIFloatingActionButton(fabSize = S, icon = TarkaIcons.ArrowExport) {

      }
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_fab_with_large_size() {
    composeRule.setContent {
      TUIFloatingActionButton(fabSize = L, icon = TarkaIcons.ArrowExport) {

      }
    }
    compareScreenshot(composeRule)
  }

  @Test fun test_fab_with_regular_size() {
    composeRule.setContent {
      TUIFloatingActionButton(fabSize = R, icon = TarkaIcons.ArrowExport) {

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