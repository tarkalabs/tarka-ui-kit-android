package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.base.TUIToggleRow
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle.Title
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
open class TUIToggleRowScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          add(arrayOf("darkTheme_${darkTheme}", darkTheme))
        }
      }
    }
  }

  @Test fun testToggleRowStyleTitle() = compareScreenshotFor(darkTheme, "_testToggleRowStyleTitle_$testName") {
    TUIToggleRow(title = "Title", style = Title)
  }

  @Test fun testToggleRowStyleTitleWithDescription() = compareScreenshotFor(darkTheme, "_testToggleRowStyleTitleWithDescription_$testName") {
    TUIToggleRow(title = "Title", style = ToggleRowStyle.TitleWithDescription("Description"))
  }
}