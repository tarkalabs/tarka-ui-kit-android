@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.commonui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.TopBar
import org.junit.Rule
import org.junit.Test
import com.tarkalabs.uicomponents.R
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TopBarScreenShotTest : ScreenshotTest {

  @get:Rule
  val composeRule = createComposeRule()

  @Test
  fun renderTopAppBarTextOnly() {
    composeRule.setContent {
      TopBar("Screenshot")
    }

    compareScreenshot(composeRule)
  }

  @Test
  fun renderTopAppBarTextWithIcon() {
    composeRule.setContent {
      TopBar("Screenshot", navigationIcon = R.drawable.keyboard_arrow_right)
    }

    compareScreenshot(composeRule)
  }
}