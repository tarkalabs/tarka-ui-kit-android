package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tarkalabs.uicomponents.components.TUILoadingSpinnerAnimation
import org.junit.Test

class TUILoadingSpinnerAnimationScreenShotTest : ComposeScreenshotComparator() {

  @Test
  fun loaderScreenShotTestInLightTheme() {
    compareScreenshotFor(darkTheme = false, imageName = "darkTheme_false") {
      TUILoadingSpinnerAnimation()
    }
  }

  @Test
  fun loaderScreenShotTestInDarkTheme() {
    compareScreenshotFor(darkTheme = true, imageName = "darkTheme_true") {
      TUILoadingSpinnerAnimation()
    }
  }

  @Test
  fun loaderScreenShotTestInDarkThemeInFullScreen() {
    compareScreenshotFor(darkTheme = true, imageName = "darkTheme_true_fullscreen") {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(Color.Black.copy(alpha = 0.4f)),
        contentAlignment = Alignment.Center
      ) {
        TUILoadingSpinnerAnimation()
      }
    }
  }

  @Test
  fun loaderScreenShotTestInLightThemeInFullScreen() {
    compareScreenshotFor(darkTheme = false, imageName = "darkTheme_false_fullscreen") {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(Color.Black.copy(alpha = 0.4f)),
        contentAlignment = Alignment.Center
      ) {
        TUILoadingSpinnerAnimation()
      }
    }
  }
}