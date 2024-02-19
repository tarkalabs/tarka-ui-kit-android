package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.HorizontalPaddingSize
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.L
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.M
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.NONE
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.S
import com.tarkalabs.tarkaui.components.HorizontalPaddingSize.XL
import com.tarkalabs.tarkaui.components.Orientation
import com.tarkalabs.tarkaui.components.Orientation.HORIZONTAL
import com.tarkalabs.tarkaui.components.Orientation.VERTICAL
import com.tarkalabs.tarkaui.components.TUIDivider
import com.tarkalabs.tarkaui.components.TUIDividerTags
import com.tarkalabs.tarkaui.components.VerticalPaddingSize
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
      val horizontalPaddingSize = listOf(NONE, S, M, L, XL)
      val verticalPaddingSize = listOf(VerticalPaddingSize.NONE, VerticalPaddingSize.M)

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