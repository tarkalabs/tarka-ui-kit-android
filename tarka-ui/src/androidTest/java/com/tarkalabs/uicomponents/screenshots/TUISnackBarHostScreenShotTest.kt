package com.tarkalabs.uicomponents.screenshots

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaui.components.TUISnackBarHost
import com.tarkalabs.tarkaui.components.TUISnackBarState
import com.tarkalabs.tarkaui.components.TUISnackBarType.*
import com.tarkalabs.tarkaui.components.rememberTUISnackBarState
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUISnackBarHostScreenShotTest : ComposeScreenshotComparator() {

  @Composable
  private fun showSnackbar(snackState: TUISnackBarState) {
    LaunchedEffect(key1 = true) {
      snackState.showSnackBar("Screenshot Test")
    }
  }

  @Test
  fun test_tui_snack_bar_host_information() = compareScreenshotFor {
    val snackState = rememberTUISnackBarState(type = Information)

    TUISnackBarHost(modifier = Modifier, state = snackState)
    showSnackbar(snackState)
  }



  @Test
  fun test_tui_snack_bar_host_success() = compareScreenshotFor {
    val snackState = rememberTUISnackBarState(type = Success)

    TUISnackBarHost(modifier = Modifier, state = snackState)
    showSnackbar(snackState)
  }

  @Test
  fun test_tui_snack_bar_host_warning() = compareScreenshotFor {
    val snackState = rememberTUISnackBarState(type = Warning)

    TUISnackBarHost(modifier = Modifier, state = snackState)
    showSnackbar(snackState)
  }

  @Test
  fun test_tui_snack_bar_host_error() = compareScreenshotFor {
    val snackState = rememberTUISnackBarState(type = Error)

    TUISnackBarHost(modifier = Modifier, state = snackState)
    showSnackbar(snackState)
  }

}