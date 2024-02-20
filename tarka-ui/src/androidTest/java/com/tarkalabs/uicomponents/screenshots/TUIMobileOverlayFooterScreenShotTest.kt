package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaui.components.TUIMobileOverlayFooter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayFooterScreenShotTest(
  private val showMiddleDismiss: Boolean,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (showMiddleDismiss in listOf(true, false)) {
            val testName = "showMiddleDismiss_${showMiddleDismiss}_darkTheme_${darkTheme}"
            add(arrayOf(showMiddleDismiss, testName, darkTheme))
          }
        }
      }
    }
  }

  @Test fun mobileFooterOverlayTest() =
    compareScreenshotFor(darkTheme, "_TestMobileFooter_$testName") {
      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
        showMiddleDismiss = showMiddleDismiss,
      )
    }
}