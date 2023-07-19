package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIToggleSwitchScreenShotTest(
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
  @Test fun test_checked_status() = compareScreenshotFor(darkTheme, "_testCheckedStatus_$testName") {
    TUIToggleSwitch(state = true, onToggleChange = {})
  }

  @Test fun test_unchecked_status() = compareScreenshotFor(darkTheme, "_testUncheckedStatus_$testName") {
    TUIToggleSwitch(state = false, onToggleChange = {})
  }

  @Test fun test_checked_state_with_disabled_status() = compareScreenshotFor(darkTheme, "_testCheckedStateWithDisabledStatus_$testName") {
    TUIToggleSwitch(state = true, enabled = false, onToggleChange = {})
  }

  @Test fun test_unchecked_state_with_disabled_status() = compareScreenshotFor(darkTheme, "_testUncheckedStateWithDisabledStatus_$testName") {
    TUIToggleSwitch(state = false, enabled = false, onToggleChange = {})
  }
}