package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.checkbox.TUICheckBox
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
open class TUICheckBoxScreenShotTest(
  private val isChecked: Boolean,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      val booleanList = listOf(true, false)
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in booleanList)
          for (isChecked in booleanList)
            add(arrayOf(isChecked, "darkTheme_${darkTheme}_checked_{$isChecked}", darkTheme))
      }
    }
  }

  @Test fun testTUICheckBoxScreenshot() =
    compareScreenshotFor(darkTheme, "_testTUICheckBox_$testName") {
      TUICheckBox(checked = isChecked, onCheckedChange = {})
    }
}