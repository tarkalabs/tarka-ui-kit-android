package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult.ActionPerformed
import androidx.compose.material3.SnackbarResult.Dismissed
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUISnackBar
import com.tarkalabs.uicomponents.components.TUISnackBarTags
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUISnackBarTest {

  @get:Rule val composable = createComposeRule()
  val tags: TUISnackBarTags = TUISnackBarTags()

  @Test fun snackBar_Displayed() {
    composable.setContent {
      TUITheme {
        val snackState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()

        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
          Column(modifier = Modifier.fillMaxSize()) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
              coroutineScope.launch {
                val result = snackState.showSnackbar(
                  "This is a success snackbar. ", duration = Short, actionLabel = "Dismiss"
                )
                when (result) {
                  Dismissed -> {}
                  ActionPerformed -> {}
                }
              }
            }) {
              Text("Show Snackbar")
            }
          }
          SnackbarHost(
            modifier = Modifier.align(Alignment.BottomStart),
            hostState = snackState,
          ) { snackbarData: SnackbarData ->
            TUISnackBar(
              message = snackbarData.visuals.message,
              actionLabel = snackbarData.visuals.actionLabel,
              leadingIcon = TarkaIcons.Regular.Delete24,
              type = Success,
            ) {
              snackbarData.performAction()
            }
          }
        }
      }
    }

    composable.onNodeWithText("Show Snackbar").performClick()

    composable.onNodeWithTag(tags.parentTag).assertIsDisplayed()
    composable.onNodeWithTag(tags.leadingIconTag).assertIsDisplayed()
    composable.onNodeWithTag(tags.dismissActionTag).assertIsDisplayed()
  }

  @Test fun snack_bar_Dismiss_Triggered() {
    val onDismissClick: () -> Unit = mock()

    composable.setContent {
      TUITheme {
        val snackState = remember { SnackbarHostState() }
        val coroutineScope = rememberCoroutineScope()

        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {
          Column(modifier = Modifier.fillMaxSize()) {
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
              coroutineScope.launch {
                val result = snackState.showSnackbar(
                  "This is a success snackbar. ", duration = Short, actionLabel = "Dismiss"
                )
                when (result) {
                  Dismissed -> {}
                  ActionPerformed -> {}
                }
              }
            }) {
              Text("Show Snackbar")
            }
          }
          SnackbarHost(
            modifier = Modifier.align(Alignment.BottomStart),
            hostState = snackState,
          ) { snackbarData: SnackbarData ->
            TUISnackBar(
              message = snackbarData.visuals.message,
              actionLabel = snackbarData.visuals.actionLabel,
              leadingIcon = TarkaIcons.Regular.Delete24,
              type = Success,
              action = onDismissClick
            )
          }
        }
      }
    }
    composable.onNodeWithText("Show Snackbar").performClick()

    composable.onNodeWithTag(tags.dismissActionTag).performClick()
    verify(onDismissClick).invoke()
  }
}