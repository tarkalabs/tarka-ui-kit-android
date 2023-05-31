package com.tarkalabs.uicomponents.screenshots

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import org.junit.Rule

open class ComposeScreenshotComparator : ScreenshotTest {

  @get:Rule val composeRule = createComposeRule()

  protected fun compareScreenshotFor(imageName: String? = null, composableToTest: @Composable () -> Unit) {
    composeRule.setContent {
      composableToTest()
    }
    compareScreenshot(composeRule, imageName)
  }

}