package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.TUINavigationRow
import com.tarkalabs.tarkaui.icons.AddCircle24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
open class TUINavigationRowScreenShotTest(
  private val showArrowRight: Boolean,
  private val leadingIcon: TarkaIcon?,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val booleans = listOf(true, false)
      val icons: List<TarkaIcon?> = listOf(null, TarkaIcons.Filled.AddCircle24)
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in booleans)
          for (showArrow in booleans)
            for (icon in icons)
              add(
                arrayOf(
                  showArrow,
                  icon,
                  "darkTheme_${darkTheme}_showArrow_{$showArrow}_${if (icon == null) null else "Icon"}",
                  darkTheme
                )
              )
      }
    }
  }

  @Test fun testNavigationRow() =
    compareScreenshotFor(darkTheme, "_testNavigationRow_$testName") {
      TUINavigationRow(
        title = "Title",
        leadingIcon = leadingIcon,
        onClick = {},
        showRightArrow = showArrowRight
      )
    }
}