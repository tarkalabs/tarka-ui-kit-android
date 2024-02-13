package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUISnackBar
import com.tarkalabs.uicomponents.components.TUISnackBarType.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUISnackBarScreenshotTest : ComposeScreenshotComparator() {

  @Test fun test_tui_snack_bar_information() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Regular.Delete24,
      type = Information
    )
  }

  @Test fun test_tui_snack_bar_success() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Regular.Delete24,
      type = Success
    )
  }

  @Test fun test_tui_snack_bar_warning() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Regular.Delete24,
      type = Warning
    )
  }

  @Test fun test_tui_snack_bar_error() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Regular.Delete24,
      type = Error
    )
  }

}