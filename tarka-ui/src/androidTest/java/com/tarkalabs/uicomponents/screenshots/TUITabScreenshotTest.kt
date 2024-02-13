package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.icons.Circle20
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.tab.TUITab
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITabScreenshotTest(
  private val isSelected: Boolean,
  private val leadingIcon: TarkaIcon?,
  private val darkTheme: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic @Parameterized.Parameters fun data(): Collection<Array<Any?>> {
      val testData = ArrayList<Array<Any?>>()
      for (darkTheme in listOf(true, false)) {
        for (leadIc in listOf(null, TarkaIcons.Regular.Circle20)) {
          for (isSelected in listOf(true, false)) {
            val testName =
              "TUITab_darkTheme_${darkTheme}_leadIc_exists_${if (leadIc == null) "false" else "true"}_isSelected_${isSelected}"
            testData.add(
              arrayOf(
                isSelected, leadIc, darkTheme, testName,
              )
            )
          }
        }
      }
      return testData
    }
  }

  @Test fun test_tui_tab_without_lead_icon_in_dark_theme() {
    compareScreenshotFor(darkTheme, testName) {
      TUITab(
        title = "Tab", leadingIcon = leadingIcon, isSelected = isSelected
      ) {}
    }
  }
}