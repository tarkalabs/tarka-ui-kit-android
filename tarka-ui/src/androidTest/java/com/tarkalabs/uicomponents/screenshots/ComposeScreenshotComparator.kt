package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.tarkaui.theme.TUITheme
import com.tarkalabs.uicomponents.utils.ComposeBaseTest

open class ComposeScreenshotComparator : ComposeBaseTest(), ScreenshotTest {

  protected fun compareScreenshotFor(
    darkTheme: Boolean = false,
    imageName: String? = null,
    composableToTest: @Composable () -> Unit
  ) {
    composeRule.setContent {
      TUITheme(darkTheme = darkTheme) {
        Box(modifier = Modifier.background(TUITheme.colors.surface)) {
          composableToTest()
        }
      }
    }
    compareScreenshot(composeRule, imageName)
  }
}