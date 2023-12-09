package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.base.ButtonSize.L
import com.tarkalabs.uicomponents.components.base.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.base.ButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.base.ButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.components.base.TUIButton
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavBar
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIFloatingNavBarScreenShotTest(
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

  @Test fun testTwoItems() = compareScreenshotFor(darkTheme, "_twoItemsTest_$testName") {
    TUIFloatingNavBar(tabItems = listOf("One", "Two"), onTabSelected = {})
  }

  @Test fun testFourItems() = compareScreenshotFor(darkTheme, "_twoFourTest_$testName") {
    TUIFloatingNavBar(tabItems = listOf("One", "Two", "Three", "Four"), onTabSelected = {})
  }
}