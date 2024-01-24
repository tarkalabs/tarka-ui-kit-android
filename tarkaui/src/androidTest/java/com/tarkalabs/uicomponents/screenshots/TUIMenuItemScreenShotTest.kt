package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.Modifier
import com.tarkalabs.uicomponents.components.TUIMenuItem
import com.tarkalabs.uicomponents.components.TUIMenuItemIconStyle
import com.tarkalabs.uicomponents.components.TUIMenuItemIconStyle.SUCCESS
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMenuItemScreenShotTest(
  private val leadingIconStyle: TUIMenuItemIconStyle,
  private val isSelected: Boolean,
  private val darkTheme: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {

    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val leadingIconStyleValues = listOf(TUIMenuItemIconStyle.NORMAL, SUCCESS)
      val isSelectedValues = listOf(true, false)
      val darkThemeValues = listOf(true, false)

      val testData = ArrayList<Array<Any?>>()

      for (style in leadingIconStyleValues) {
        for (selectedValue in isSelectedValues) {
          for (darkThemeValue in darkThemeValues) {
            val testName =
              "LeadingIconStyle_${style}_isSelected_${selectedValue}_darkTheme_${darkThemeValue}"
            testData.add(
              arrayOf(
                style, selectedValue, darkThemeValue, testName
              )
            )
          }
        }
      }
      return testData
    }
  }

  @Test
  fun testTuiMenuItem() {
    compareScreenshotFor(darkTheme, testName) {
      TUIMenuItem(
        modifier = Modifier,
        label = "Label",
        isSelected = isSelected,
        onMenuItemClick = { /*TODO*/ },
        leadingIconStyle = leadingIconStyle
      )
    }
  }
}