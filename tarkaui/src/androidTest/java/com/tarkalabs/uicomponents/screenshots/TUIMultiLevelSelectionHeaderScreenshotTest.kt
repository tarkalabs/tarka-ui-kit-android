package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUIMultiLevelSelectorHeader
import com.tarkalabs.uicomponents.components.TUIStatus
import com.tarkalabs.uicomponents.components.TUIStatusIndicator
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMultiLevelSelectionHeaderScreenshotTest(
  private val darkTheme: Boolean,
  private val isSelected: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val booleanValues = listOf(true, false)

      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in booleanValues)
        for (isSelected in booleanValues)
          testData.add(
            arrayOf(
              darkTheme, isSelected, "darkTheme_${darkTheme}_isSelected_${isSelected}"
            )
          )

      return testData
    }
  }

  @Test
  fun testTUMultiLevelSelectionHeader() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUIMultiLevelSelectorHeader(title = "Title", isSelected = isSelected, onClick = {})
    }
  }
}