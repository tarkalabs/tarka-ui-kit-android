package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.L
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.R
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.S
import com.tarkalabs.uicomponents.components.TUIFloatingActionButton
import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIFloatingActionButtonScreenShotTest(
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

  @Test fun test_fab_with_small_size() = compareScreenshotFor(darkTheme, testName) {
      TUIFloatingActionButton(fabSize = S, icon = TarkaIcons.ArrowExport, onClick = {})
  }

  @Test fun test_fab_with_large_size() = compareScreenshotFor(darkTheme, testName) {
      TUIFloatingActionButton(fabSize = L, icon = TarkaIcons.ArrowExport, onClick = {})
  }

  @Test fun test_fab_with_regular_size() = compareScreenshotFor(darkTheme, testName) {
      TUIFloatingActionButton(fabSize = R, icon = TarkaIcons.ArrowExport, onClick = {})
  }
}