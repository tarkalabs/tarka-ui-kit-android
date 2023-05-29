package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUIToggleSwitchScreenShotTest : ComposeScreenshotComparator() {

  @Test fun test_checked_status() = compareScreenshotFor {
    TUIToggleSwitch(state = true, onToggleChange = {})
  }

  @Test fun test_unchecked_status() = compareScreenshotFor {
    TUIToggleSwitch(state = false, onToggleChange = {})
  }

  @Test fun test_checked_state_with_disabled_status() = compareScreenshotFor {
    TUIToggleSwitch(state = true, enabled = false, onToggleChange = {})
  }

  @Test fun test_unchecked_state_with_disabled_status() = compareScreenshotFor {
    TUIToggleSwitch(state = false, enabled = false, onToggleChange = {})
  }
}