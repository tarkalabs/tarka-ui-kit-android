@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.commonui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.TopBar
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TopBarScreenShotTest : ScreenshotTest {

  @get:Rule
  val composeRule = createComposeRule()

  @OptIn(ExperimentalMaterial3Api::class)
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
      TopBar("Screenshot", navigationIcon = TarkaIcons.ArrowExport)
    }

    compareScreenshot(composeRule)
  }
}