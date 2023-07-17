package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUIRadioButton
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIRadioButtonScreenShotTest(
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

  @Test fun test_selected_status() = compareScreenshotFor(darkTheme, "_testSelectedStatus_$testName") {
    TUIRadioButton(selected = true, onOptionSelected = {})
  }

  @Test fun test_unSelected_status() = compareScreenshotFor(darkTheme, "_testUnSelectedStatus_$testName") {
    TUIRadioButton(selected = false, onOptionSelected = {})
  }

  @Test fun test_selected_state_with_disabled_status() = compareScreenshotFor(darkTheme, "_testSelectedStateWithDisabledStatus_$testName") {
    TUIRadioButton(selected = true, enabled = false, onOptionSelected = {})
  }

  @Test fun test_unSelected_state_with_disabled_status() = compareScreenshotFor(darkTheme, "_testUncheckedStateWithDisabledStatus_$testName") {
    TUIRadioButton(selected = false, enabled = false, onOptionSelected = {})
  }
}