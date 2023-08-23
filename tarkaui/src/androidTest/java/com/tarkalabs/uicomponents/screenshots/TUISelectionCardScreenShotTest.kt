package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Person24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUISelectionCard
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUISelectionCardScreenShotTest(
  private val darkTheme: Boolean,
  private val isSelected: Boolean,
  private val leadingIcon: TarkaIcon?,
  private val description2: String?,
  private val detail: String?,
  private val detail2: String?,
  private val badgeCount: Int?,
  private val trailingIconEnabled: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(true, false)
      val isSelectedValues = listOf(false, true)
      val leadingIconValues = listOf(TarkaIcons.Regular.Person24, null)
      val description2Values = listOf(null, "Description2")
      val detailValues = listOf(null, "Detail")
      val detail2Values = listOf(null, "Detail2")
      val badgeCountValues = listOf(null, 4)
      val trailingIconEnabledValues = listOf(false, true)

      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in darkThemeValues) {
        for (isSelected in isSelectedValues) {
          for (leadingIcon in leadingIconValues) {
            for (description2 in description2Values) {
              for (detail in detailValues) {
                for (detail2 in detail2Values) {
                  for (badgeCount in badgeCountValues) {
                    for (trailingIconEnabled in trailingIconEnabledValues) {

                      val testName =
                        "darkTheme_${darkTheme}_isSelected${isSelected}_leadIcShown_${if (leadingIcon != null) "true" else "false"}" +
                          "_desc2Shown_${if (description2 != null) "true" else "false"}_detailShown${if (detail != null) "true" else "false"}_detail2Shown${if (detail2 != null) "true" else "false"}" +
                          "badgeShown_${if (badgeCount != null) "true" else "false"}_trailIcShown_$trailingIconEnabled"

                      testData.add(
                        arrayOf(
                          darkTheme,
                          isSelected,
                          leadingIcon,
                          description2,
                          detail,
                          detail2,
                          badgeCount,
                          trailingIconEnabled,
                          testName
                        )
                      )
                    }
                  }
                }
              }
            }
          }
        }
      }

      return testData
    }
  }

  @Test
  fun test_tui_selection_card_with_all_possible_params() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      // we are using different background for light theme to differentiate from component
      TUISelectionCard(
        modifier = Modifier.padding(14.dp),
        label = "Label",
        description = "Description",
        isSelected = isSelected,
        leadingIcon = leadingIcon,
        description2 = description2,
        details = detail,
        details2 = detail2,
        badgeCount = badgeCount,
        showTrailingIcon = trailingIconEnabled
      ) {}
    }
  }
}