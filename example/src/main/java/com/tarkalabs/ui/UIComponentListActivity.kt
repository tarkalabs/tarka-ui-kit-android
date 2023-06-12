package com.tarkalabs.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUISnackBar
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.launch

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TUITheme {
        val snackState = remember { SnackbarHostState() }
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
                 val result =  snackState.showSnackbar("This is a success snackbar. ",
                    duration = Short,
                  actionLabel = "Dismiss")
                  when(result){
                    Dismissed -> {
                      Log.d("SNACK_BAR_ACTION", "SnackBar Dismissed")
                    }
                    ActionPerformed -> {
                      Log.d("SNACK_BAR_ACTION", "SnackBar Action Clicked")
                    }
                  }
                }
              }) {
              Text("Show Snackbar")
            }
          }
          SnackbarHost(
            modifier= Modifier.align(Alignment.BottomStart),
            hostState = snackState,
          ) { snackbarData: SnackbarData ->
            TUISnackBar(
              snackbarData.visuals.message,
              actionLabel = snackbarData.visuals.actionLabel,
              leadingIcon = TarkaIcons.Delete,
              type = Success,
            ){
              snackbarData.performAction()
            }
          }
        }
      }
    }
  }
}