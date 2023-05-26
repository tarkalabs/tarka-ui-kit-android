@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.R.drawable
import com.tarkalabs.uicomponents.components.TopBar
import com.tarkalabs.uicomponents.models.TarkaIcon
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUITopBarScreenShotTest : ScreenshotTest {

  @get:Rule val composeRule = createComposeRule()

  @OptIn(ExperimentalMaterial3Api::class)
  @Test fun renderTopAppBarTextOnly() {
    composeRule.setContent {
      TopBar("Screenshot")
    }

    compareScreenshot(composeRule,)
  }

  @Test fun renderTopAppBarTextWithIcon() {
    composeRule.setContent {
      TopBar(
        "Screenshot", navigationIcon = TarkaIcon(drawable.keyboard_arrow_right, "Arrow Right")
      )
    }

    compareScreenshot(composeRule)
  }
}