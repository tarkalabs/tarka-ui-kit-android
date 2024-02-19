package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaui.components.ButtonType
import com.tarkalabs.tarkaui.components.ButtonType.BUTTON
import com.tarkalabs.tarkaui.components.ButtonType.ICON_BUTTON
import com.tarkalabs.tarkaui.components.TUIMobileOverlayFooter
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayFooterScreenShotTest(
  private val showMiddleDismiss: Boolean,
  private val showLeftButton: Boolean,
  private val showRightButton: Boolean,
  private val buttonType: ButtonType,
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false))
          for (showLeftButton in listOf(true, false))
            for (showMiddleDismiss in listOf(true, false))
              for (showRightButton in listOf(true, false))
                for (buttonType in listOf(ICON_BUTTON, BUTTON)){
                if (!showLeftButton && !showRightButton && !showMiddleDismiss) continue
                val testName = "showLeftButton_${showLeftButton}_showMiddleDismiss_${showMiddleDismiss}_showRightButton_${showRightButton}_buttonType_${buttonType}_darkTheme_${darkTheme}"
                add(arrayOf(showMiddleDismiss, showLeftButton, showRightButton, buttonType, testName, darkTheme))
              }

      }
    }
  }

  @Test fun mobileFooterOverlayTest() =
    compareScreenshotFor(darkTheme, "_TestMobileFooter_$testName") {
      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
        showLeftButton = showLeftButton,
        showMiddleDismiss = showMiddleDismiss,
        showRightButton = showRightButton,
        buttonType = buttonType
      )
    }
}