package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.GREEN
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.GREY
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.TRANSPARENT
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.ADD
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.CHECKMARK
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent.CHECKMARK as TrailCheckMark
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.EMPTY
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent.EMPTY as TrailEmpty
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent.FRONT_ARROW
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItem
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayMenuItemScreenshotTest(
  private val darkTheme: Boolean,
  private val bgColor: MobileOverlayMenuItemBgColor,
  private val leadingContent: MobileOverlayMenuLeadingContent,
  private val trailingContent: MobileOverlayMenuTrailingContent,
  private val description: String?,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {

    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(false, true)
      val backgroundValues = listOf(GREEN, GREY, TRANSPARENT)
      val leadingContentValues = listOf(ADD, CHECKMARK, EMPTY)
      val trailingContentValues = listOf(FRONT_ARROW, TrailCheckMark, TrailEmpty)
      val descriptionValues = listOf(null, "Description")

      val testData = mutableListOf<Array<Any?>>()
      for (darkTheme in darkThemeValues) {
        for (bgColor in backgroundValues) {
          for (leadContent in leadingContentValues) {
            for (trailContent in trailingContentValues) {
              for (desc in descriptionValues) {
                val testName =
                  "darkTheme_${darkTheme}_bgColor_${bgColor.name}_leadIc_${leadContent.name}_trailIc_${trailContent.name}_descShown_${if (desc != null) "true" else "false"}"
                testData.add(
                  arrayOf(
                    darkTheme,
                    bgColor,
                    leadContent,
                    trailContent,
                    desc,
                    testName
                  )
                )
              }
            }
          }
        }
      }
      return testData
    }
  }

  @Test
  fun test_tui_mobile_overlay_menu_item_with_all_params() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUIMobileOverlayMenuItem(
        title = "Title",
        backgroundColor = bgColor,
        leadingContent = leadingContent,
        description = description,
        trailingContent = trailingContent
      ) {}
    }
  }
}