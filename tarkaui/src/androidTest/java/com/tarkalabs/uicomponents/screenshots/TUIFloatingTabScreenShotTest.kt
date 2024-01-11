package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.base.ButtonSize.L
import com.tarkalabs.uicomponents.components.base.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.base.ButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.base.ButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.components.base.TUIButton
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavBar
import com.tarkalabs.uicomponents.components.tab.TUIFloatingTab
import com.tarkalabs.uicomponents.components.tab.TUIFloatingTabTags
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIFloatingTabScreenShotTest(
  private val testName: String,
  private val title: String,
  private val isSelected: Boolean,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (isSelected in listOf(true, false)){
            for (title in listOf("Specification", "Big Work Order List")){
              val testName = "darkTheme_${darkTheme}_isSelected_${isSelected}_title_$title"
              add(arrayOf(testName, title, isSelected, darkTheme))
            }
          }
        }
      }
    }
  }

  @Test fun testTab() = compareScreenshotFor(darkTheme, "_testTabTest_$testName") {
    TUIFloatingTab(
      title = title,
      selected = isSelected,
      onSelected = {})
  }
}