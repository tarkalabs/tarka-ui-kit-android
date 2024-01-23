package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.HorizontalPaddingSize
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.L
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.M
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.S
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.XL
import com.tarkalabs.uicomponents.components.HorizontalPaddingSize.XS
import com.tarkalabs.uicomponents.components.Orientation
import com.tarkalabs.uicomponents.components.Orientation.HORIZONTAL
import com.tarkalabs.uicomponents.components.Orientation.VERTICAL
import com.tarkalabs.uicomponents.components.TUIDivider
import com.tarkalabs.uicomponents.components.TUIDividerTags
import com.tarkalabs.uicomponents.components.VerticalPaddingSize
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIDividerScreenshotTest(
  private val darkTheme: Boolean,
  private val orientation: Orientation,
  private val tuiDividerTags: TUIDividerTags,
  private val horizontalPaddingSize: HorizontalPaddingSize,
  private val verticalPaddingSize: VerticalPaddingSize,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val darkThemeValues = listOf(true, false)
      val orientationValues = listOf(HORIZONTAL, VERTICAL)
      val tuiDividerTags = TUIDividerTags("TUIDivider")
      val horizontalPaddingSize = listOf(XS, S, M, L, XL)
      val verticalPaddingSize = listOf(VerticalPaddingSize.S, VerticalPaddingSize.M)

      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in darkThemeValues) {
        for (orientation in orientationValues) {
          for (horizontalPadding in horizontalPaddingSize) {
            for (verticalPadding in verticalPaddingSize) {

              val testName =
                "darkTheme_${darkTheme}_orientationValues_${orientation}" +
                  "_horizontalPadding_${horizontalPadding}_verticalPadding_${verticalPadding}"
              testData.add(
                arrayOf(
                  darkTheme,
                  orientation,
                  tuiDividerTags,
                  horizontalPadding,
                  verticalPadding,
                  testName
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
  fun test_tui_divider_with_all_possible_params() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUIDivider(
        orientation = orientation, tags = tuiDividerTags,
        horizontalPadding = horizontalPaddingSize, verticalPadding = verticalPaddingSize
      )
    }
  }
}