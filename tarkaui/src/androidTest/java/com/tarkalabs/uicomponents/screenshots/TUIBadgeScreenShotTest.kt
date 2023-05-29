package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUIBadge
import com.tarkalabs.uicomponents.components.BadgeSize.M
import com.tarkalabs.uicomponents.components.BadgeSize.S
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
open class TUIBadgeScreenShotTest : ComposeScreenshotComparator() {

  @Test fun test_badge_with_count()  = compareScreenshotFor {
      TUIBadge(count = 2, badgeSize = M)
  }

  @Test fun test_badge_with_out_count() = compareScreenshotFor {
      TUIBadge(badgeSize = S)
  }
}