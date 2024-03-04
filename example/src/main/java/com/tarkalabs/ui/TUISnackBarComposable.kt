package com.tarkalabs.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUISnackBarState
import com.tarkalabs.tarkaui.components.TUISnackBarType.Error
import com.tarkalabs.tarkaui.icons.Info24
import com.tarkalabs.tarkaui.icons.TarkaIcons.Filled
import com.tarkalabs.tarkaui.theme.TUITheme
import kotlinx.coroutines.launch

@Composable fun TUISnackBarComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {

    val snackState by remember {
      mutableStateOf(
        TUISnackBarState(
          SnackbarHostState(), Error, Filled.Info24
        )
      )
    }
    val coroutineScope = rememberCoroutineScope()

    Text(text = "TUISnackBar", style = TUITheme.typography.heading3)
    Text(text = "Click Here",
      style = TUITheme.typography.heading1,
      modifier = Modifier
        .padding(top = 20.dp)
        .clickable {
          coroutineScope.launch {
            snackState.showSnackBar("Message")
          }
        })

    LaunchedEffect(true) {
      snackState.showSnackBar("Hello When Starting")
    }

  }
}