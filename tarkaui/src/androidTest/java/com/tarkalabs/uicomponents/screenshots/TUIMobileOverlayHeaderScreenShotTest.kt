@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.tarkaicons.Dismiss16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeader
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithBackIcon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithTitle
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithTrailingIcon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.None
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayHeaderScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_${darkTheme}"
          add(arrayOf(testName, darkTheme))
        }
      }
    }
  }

  @Test fun tuiMobileHeaderOverlayWithTitle() = compareScreenshotFor(darkTheme, "_tuiMobileHeaderOverlayWithTitle_$testName") {
    TUIMobileOverlayHeader(style = HeaderWithTitle("Title"))
  }

  @Test fun tuiMobileHeaderOverlayWithTitleAndBackButton() = compareScreenshotFor(darkTheme, "_tuiMobileHeaderOverlayWithTitleAndBackButton_$testName") {
    TUIMobileOverlayHeader(style = HeaderWithBackIcon("Title", {}))
  }

  @Test fun tuiMobileHeaderOverlayWithNone() = compareScreenshotFor(darkTheme, "_tuiMobileHeaderOverlayWithNone_$testName") {
    TUIMobileOverlayHeader(style = None)
  }

  @Test fun tuiMobileHeaderOverlayWithTrailing() = compareScreenshotFor(darkTheme, "_tuiMobileHeaderOverlayWithTrailing_$testName") {
    TUIMobileOverlayHeader(style = HeaderWithTrailingIcon("Title", TarkaIcons.Filled.Dismiss16, {}))
  }
}