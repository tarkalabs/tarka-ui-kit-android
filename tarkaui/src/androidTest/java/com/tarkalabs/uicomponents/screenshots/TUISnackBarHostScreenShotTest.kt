package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.tarkalabs.uicomponents.components.TUISnackBarHost
import com.tarkalabs.uicomponents.components.TUISnackBarState
import com.tarkalabs.uicomponents.components.TUISnackBarType.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUISnackBarHostScreenShotTest : ComposeScreenshotComparator() {

  @Test fun test_tui_snack_bar_host_information() = compareScreenshotFor {
    val snackState by remember {
      mutableStateOf(TUISnackBarState(SnackbarHostState(), Information, null))
    }

    TUISnackBarHost(modifier = Modifier, state = snackState)
  }

  @Test fun test_tui_snack_bar_host_success() = compareScreenshotFor {
    val snackState by remember {
      mutableStateOf(TUISnackBarState(SnackbarHostState(), Success, null))
    }

    TUISnackBarHost(modifier = Modifier, state = snackState)
  }

  @Test fun test_tui_snack_bar_host_warning() = compareScreenshotFor {
    val snackState by remember {
      mutableStateOf(TUISnackBarState(SnackbarHostState(), Warning, null))
    }

    TUISnackBarHost(modifier = Modifier, state = snackState)
  }

  @Test fun test_tui_snack_bar_host_error() = compareScreenshotFor {
    val snackState by remember {
      mutableStateOf(TUISnackBarState(SnackbarHostState(), Error, null))
    }

    TUISnackBarHost(modifier = Modifier, state = snackState)
  }

}