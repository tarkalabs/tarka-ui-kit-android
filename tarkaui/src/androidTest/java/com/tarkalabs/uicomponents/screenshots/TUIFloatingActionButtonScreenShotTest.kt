package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.L
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.R
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.S
import com.tarkalabs.uicomponents.components.TUIFloatingActionButton
import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUIFloatingActionButtonScreenShotTest : ComposeScreenshotComparator() {

  @Test fun test_fab_with_small_size() = compareScreenshotFor {
      TUIFloatingActionButton(fabSize = S, icon = TarkaIcons.ArrowExport, onClick = {})
  }

  @Test fun test_fab_with_large_size() = compareScreenshotFor {
      TUIFloatingActionButton(fabSize = L, icon = TarkaIcons.ArrowExport, onClick = {})
  }

  @Test fun test_fab_with_regular_size() = compareScreenshotFor {
      TUIFloatingActionButton(fabSize = R, icon = TarkaIcons.ArrowExport, onClick = {})
  }

  @Test fun test_unchecked_state_with_disabled_status() = compareScreenshotFor {
      TUIToggleSwitch(state = false, enabled = false, onToggleChange = {})
  }
}