package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaicons.MoreHorizontal24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUICardHeader
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUICardHeaderScreenShotTest(
  private val darkTheme: Boolean,
  private val tagTitle: String?,
  private val trailIcon: TarkaIcon?,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (tagTitle in listOf(null, "Tag1")) {
            for (trailIcon in listOf(TarkaIcons.Filled.MoreHorizontal24, null)) {
              val testName =
                "darkTheme_${darkTheme}_tagShown${if (tagTitle == null) "false" else "true"}_trailIcShown${if (trailIcon == null) "false" else "true"}"
              add(arrayOf(darkTheme, tagTitle, trailIcon, testName))
            }
          }
        }
      }
    }
  }

  @Test fun tui_card_header_test() = compareScreenshotFor(darkTheme, testName) {
    TUICardHeader(title = "Pump Repair Pump", tagTitle = tagTitle, trailingIcon = trailIcon) {}
  }
}