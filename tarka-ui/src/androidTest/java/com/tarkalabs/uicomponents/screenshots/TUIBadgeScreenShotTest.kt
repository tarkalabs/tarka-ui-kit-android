package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.base.BadgeSize.M
import com.tarkalabs.tarkaui.components.base.BadgeSize.S
import com.tarkalabs.tarkaui.components.base.TUIBadge
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
    TUIBadge(count = 2, badgeSize = M)
  }

  @Test fun test_badge_with_out_count() = compareScreenshotFor(darkTheme, "_testBadgeWithoutCount_$testName") {
    TUIBadge(badgeSize = S)
  }
}