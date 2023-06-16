package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarDuration.Short
import androidx.compose.material3.Text
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUISnackBarHost
import com.tarkalabs.uicomponents.components.TUISnackBarType.Information
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.components.rememberTUISnackBarState
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.launch

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TUITheme {
        val snackState = rememberTUISnackBarState(
        )
        val coroutineScope = rememberCoroutineScope()

        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {

          Column(modifier = Modifier.fillMaxSize()) {
            Button(
              modifier = Modifier.fillMaxWidth(),
              onClick = {
                coroutineScope.launch {
                  snackState.type = Success
                  snackState.leadingIcon = TarkaIcons.Info20Filled

                  snackState.showSnackBar(
                    "success snackbar. ",
                    duration = Short,
                    actionLabel = "Dismiss"
                  )
                }
              }) {
              Text("Show Snackbar")
            }

            Button(
              modifier = Modifier.fillMaxWidth(),
              onClick = {
                coroutineScope.launch {
                  snackState.type = Information
                  snackState.leadingIcon = TarkaIcons.Info20Filled
                  snackState.showSnackBar(
                    "Information snackbar. ",
                    duration = Short,
                    actionLabel = "Dismiss"
                  )
                }
              }) {
              Text("Show Snackbar")
            }

          }
          TUISnackBarHost(modifier = Modifier.align(Alignment.BottomCenter), state = snackState)
        }
      }
    }
  }
}