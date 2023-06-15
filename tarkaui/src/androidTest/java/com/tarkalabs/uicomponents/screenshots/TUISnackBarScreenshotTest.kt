package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.TUISnackBar
import com.tarkalabs.uicomponents.components.TUISnackBarType.*
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUISnackBarScreenshotTest : ComposeScreenshotComparator() {

  @Test fun test_tui_snack_bar_information() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Delete,
      type = Information
    )
  }

  @Test fun test_tui_snack_bar_success() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Delete,
      type = Success
    )
  }

  @Test fun test_tui_snack_bar_warning() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Delete,
      type = Warning
    )
  }

  @Test fun test_tui_snack_bar_error() = compareScreenshotFor {
    TUISnackBar(
      message = "Message",
      actionLabel = "Dismiss",
      leadingIcon = TarkaIcons.Delete,
      type = Error
    )
  }

}