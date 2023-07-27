package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.PlayPauseButtonSize
import com.tarkalabs.uicomponents.components.PlayPauseButtonState
import com.tarkalabs.uicomponents.components.PlayPauseButtonType
import com.tarkalabs.uicomponents.components.TUIPlayPauseButtons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIPlayPauseButtonsScreenShotTest(
  private val buttonType: PlayPauseButtonType,
  private val buttonState: PlayPauseButtonState,
  private val buttonSize: PlayPauseButtonSize,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val darkThemeValues = listOf(true, false)
      val buttonTypeValues = listOf(
        PlayPauseButtonType.HOVER,
        PlayPauseButtonType.NON_HOVER
      )
      val buttonStateValues = listOf(
        PlayPauseButtonState.Play,
        PlayPauseButtonState.Pause,
      )
      val buttonSizeValues = listOf(
        PlayPauseButtonSize.L,
        PlayPauseButtonSize.M,
      )

      val testData = ArrayList<Array<Any?>>()
      for (buttonType in buttonTypeValues) {
        for (buttonState in buttonStateValues) {
          for (buttonSize in buttonSizeValues) {
            for (darkTheme in darkThemeValues) {
              val testName =
                "BType_${buttonType.name}_BTState_${buttonState.name}_BTSize${buttonSize.name}_darkTheme_${darkTheme}"
              testData.add(
                arrayOf(
                  buttonType,
                  buttonState,
                  buttonSize,
                  testName,
                  darkTheme
                )
              )
            }
          }
        }
      }
      return testData
    }
  }

  @Test fun test_play_pause_buttons() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "PlayPauseButton_$testName") {
      TUIPlayPauseButtons(
        modifier = Modifier.padding(5.dp),
        buttonType = buttonType,
        buttonSize = buttonSize,
        state = buttonState
      ) {}
    }
  }
}