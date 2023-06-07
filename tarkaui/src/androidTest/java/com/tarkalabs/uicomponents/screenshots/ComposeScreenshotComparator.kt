package com.tarkalabs.uicomponents.screenshots

import androidx.compose.runtime.Composable
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.theme.TUITheme
import com.tarkalabs.uicomponents.utils.ComposeBaseTest

open class ComposeScreenshotComparator : ComposeBaseTest(), ScreenshotTest {

  protected fun compareScreenshotFor(darkTheme: Boolean = false, imageName: String? = null, composableToTest: @Composable () -> Unit) {
    composeRule.setContent {
      TUITheme(darkTheme = darkTheme) {
        composableToTest()
      }
    }
    compareScreenshot(composeRule, imageName)
  }
}