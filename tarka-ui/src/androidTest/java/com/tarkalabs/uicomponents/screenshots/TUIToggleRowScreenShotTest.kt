package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.checkbox.TUICheckBoxRow
import com.tarkalabs.uicomponents.components.radiobutton.TUIRadioRow
import com.tarkalabs.uicomponents.components.base.TUIToggleRow
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle.Title
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle.TitleWithDescription
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
open class TUIToggleRowScreenShotTest(
  private val isChecked: Boolean,
  private val testName: String,
  private val darkTheme: Boolean
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

  @Test fun testToggleRowStyleTitle() =
    compareScreenshotFor(darkTheme, "_testToggleRowStyleTitle_$testName") {
      TUICheckBoxRow(title = "Title", style = Title, checked = isChecked, onCheckedChange = {})
    }

  @Test fun testToggleRowStyleTitleWithDescription() =
    compareScreenshotFor(darkTheme, "_testToggleRowStyleTitleWithDescription_$testName") {
      TUIToggleRow(title = "Title", style = ToggleRowStyle.TitleWithDescription("Description"))
    }

  @Test fun testCheckboxRowStyleTitle() =
    compareScreenshotFor(darkTheme, "_testCheckboxRowStyleTitle_$testName") {
      TUICheckBoxRow(title = "Title", style = Title, checked = isChecked, onCheckedChange = {})
    }

  @Test fun testCheckboxRowStyleTitleDescription() =
    compareScreenshotFor(darkTheme, "_testCheckboxRowStyleTitleDescription_$testName") {
      TUICheckBoxRow(
        title = "Title",
        style = TitleWithDescription("Description"),
        checked = isChecked,
        onCheckedChange = {})
    }

  @Test fun testRadioRowStyleTitleDescription() =
    compareScreenshotFor(darkTheme, "_testRadioRowStyleTitleDescription_$testName") {
      TUIRadioRow(
        title = "Title",
        style = TitleWithDescription("Description"),
        selected = isChecked,
        onOptionSelected = {})
    }

  @Test fun testRadioRowStyleTitle() =
    compareScreenshotFor(darkTheme, "_testRadioRowStyleTitle_$testName") {
      TUIRadioRow(title = "Title", style = Title, selected = isChecked, onOptionSelected = {})
    }
}