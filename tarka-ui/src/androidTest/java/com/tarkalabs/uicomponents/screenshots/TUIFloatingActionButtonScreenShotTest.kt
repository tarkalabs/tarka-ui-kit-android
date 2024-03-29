package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.base.FloatingActionButtonSize.L
import com.tarkalabs.tarkaui.components.base.FloatingActionButtonSize.R
import com.tarkalabs.tarkaui.components.base.FloatingActionButtonSize.S
import com.tarkalabs.tarkaui.components.base.TUIFloatingActionButton
import com.tarkalabs.tarkaui.icons.ArrowExportLtr24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
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

  @Test fun test_fab_with_small_size() = compareScreenshotFor(darkTheme, "_testFabWithSmallSize_$testName") {
      TUIFloatingActionButton(fabSize = S, icon = TarkaIcons.Regular.ArrowExportLtr24, onClick = {})
  }

  @Test fun test_fab_with_large_size() = compareScreenshotFor(darkTheme, "_testFabWithLargeSize_$testName") {
      TUIFloatingActionButton(fabSize = L, icon = TarkaIcons.Regular.ArrowExportLtr24, onClick = {})
  }

  @Test fun test_fab_with_regular_size() = compareScreenshotFor(darkTheme, "_testFabWithRegularSize_$testName") {
      TUIFloatingActionButton(fabSize = R, icon = TarkaIcons.Regular.ArrowExportLtr24, onClick = {})
  }
}