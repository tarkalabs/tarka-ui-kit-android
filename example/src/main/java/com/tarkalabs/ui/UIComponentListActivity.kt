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
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUIInputField
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus
import com.tarkalabs.uicomponents.components.TUISnackBarHost
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.components.rememberTUISnackBarState
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        val snackState = rememberTUISnackBarState(
        )
        val coroutineScope = rememberCoroutineScope()

        val textData = remember {
          mutableStateOf("Nilesh")
        }
        val hasError = remember {
          mutableStateOf(false)
        }

        Box(
          modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
        ) {

          Column(modifier = Modifier.fillMaxSize()) {

            TUIInputField(
              value = textData.value,
              onValueChange = {
                textData.value = it
              },
              status = if (hasError.value) TUIInputFieldStatus.Error else TUIInputFieldStatus.Success,
              maxCharLength = 10
            )

            VerticalSpacer(space = 50)
            Button(modifier = Modifier.fillMaxWidth(), onClick = {
              hasError.value = true
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