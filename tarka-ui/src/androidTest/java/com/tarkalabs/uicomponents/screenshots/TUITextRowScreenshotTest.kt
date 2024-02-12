package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaicons.Person24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.components.TextRowStyle
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITextRowScreenshotTest(
  private val darkTheme: Boolean,
  private val style: TextRowStyle,
  private val iconOne: TarkaIcon?,
  private val iconTwo: TarkaIcon?,
  private val infoIcon: TarkaIcon?,
  private val buttonTitle: String?,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(true, false)
      val iconValues = listOf(TarkaIcons.Regular.Person24, null)
      val buttonTitleValues = listOf(null, "Button")
      val styles = listOf(TextRowStyle.Title, TextRowStyle.TitleWithDescription("description"))
      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in darkThemeValues)
        for (style in styles)
          for (iconOne in iconValues) {
            for (iconTwo in iconValues) {
              for (infoIcon in iconValues) {
                for (buttonTitleValue in buttonTitleValues) {
                  testData.add(
                    arrayOf(
                      darkTheme,
                      style,
                      iconOne,
                      iconTwo,
                      infoIcon,
                      buttonTitleValue,
                      "darkTheme_${darkTheme}_style_${style}_iconOne_${iconOne.iconName()}_iconTwo_${iconTwo.iconName()}_infoicon_${infoIcon.iconName()}_buttonTitle_${buttonTitleValue}"
                    )
                  )
                }
              }
            }
          }


      return testData
    }
  }

  @Test
  fun testTUIStatusIndicator() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUITextRow(
        title = "Some Title",
        style = style,
        iconOne = iconOne,
        iconTwo = iconTwo,
        buttonTitle = buttonTitle,
        infoIcon = infoIcon,
      )
    }
  }
}

fun TarkaIcon?.iconName(name: String = "normal"): String {
  return if (this == null) "null" else name
}