package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.TUIStatus
import com.tarkalabs.tarkaui.components.TUIStatusIndicator
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIStatusIndicatorScreenshotTest(
  private val darkTheme: Boolean,
  private val status: TUIStatus,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(true, false)
      val tuiStatuses = TUIStatus.values()

      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in darkThemeValues)
        for (tuiStatus in tuiStatuses)
          testData.add(
            arrayOf(
              darkTheme, tuiStatus, "darkTheme_${darkTheme}_TUIStatus_${tuiStatus}"
            )
          )

      return testData
    }
  }

  @Test
  fun testTUIStatusIndicator() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUIStatusIndicator(text = "Value", status = status)
    }
  }
}