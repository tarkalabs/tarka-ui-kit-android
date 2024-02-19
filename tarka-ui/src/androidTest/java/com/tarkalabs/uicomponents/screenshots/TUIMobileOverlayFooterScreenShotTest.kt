@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaui.components.TUIMobileOverlayFooter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayFooterScreenShotTest(
  private val showMiddleDismiss: Boolean,
  private val showLeftArrow: Boolean,
  private val showRightArrow: Boolean,
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false))
          for (showLeftArrow in listOf(true, false))
            for (showMiddleDismiss in listOf(true, false))
              for (showRightArrow in listOf(true, false)) {
                if (!showLeftArrow && !showRightArrow && !showMiddleDismiss) continue
                val testName = "showLeftArrow_${showLeftArrow}_showMiddleDismiss_${showMiddleDismiss}_showRightArrow_${showRightArrow}_darkTheme_${darkTheme}"
                add(arrayOf(showMiddleDismiss, showLeftArrow, showRightArrow, testName, darkTheme))
              }

      }
    }
  }

  @Test fun mobileFooterOverlayTest() =
    compareScreenshotFor(darkTheme, "_TestMobileFooter_$testName") {
      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
        showLeftArrow = showLeftArrow,
        showMiddleDismiss = showMiddleDismiss,
        showRightArrow = showRightArrow,
      )
    }
}