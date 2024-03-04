package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.PlayPauseButtonSize
import com.tarkalabs.tarkaui.components.PlayPauseButtonState
import com.tarkalabs.tarkaui.components.TUIPlayPauseButton
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIPlayPauseButtonComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUIPlayPauseButton", style = TUITheme.typography.heading3)
    TUIPlayPauseButton(modifier = Modifier.padding(top = 16.dp),
      buttonSize = PlayPauseButtonSize.M,
      state = PlayPauseButtonState.Pause,
      onClick = { /* Handle pause button click */ })
  }
}