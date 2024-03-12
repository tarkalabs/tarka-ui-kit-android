package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.base.BadgeSize.M
import com.tarkalabs.tarkaui.components.base.BadgeStyle
import com.tarkalabs.tarkaui.components.base.TUIBadge
import com.tarkalabs.tarkaui.icons.Info20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
open class TUIBadgeScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_${darkTheme}"
          add(arrayOf(testName, darkTheme))
        }
      }
    }
  }

  @Test fun test_badge_with_count() = compareScreenshotFor(darkTheme, "_testBadgeWithCount_$testName") {
    TUIBadge(style = BadgeStyle.Count(2), badgeSize = M)
  }

  @Test fun test_badge_with_icon() = compareScreenshotFor(darkTheme, "_testBadgeWithIcon_$testName") {
    TUIBadge(style = BadgeStyle.Icon(TarkaIcons.Regular.Info20), badgeSize = M)
  }
}