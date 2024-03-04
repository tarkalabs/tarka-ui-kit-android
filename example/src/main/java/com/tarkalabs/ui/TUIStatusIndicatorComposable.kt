package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUIStatus.OFF
import com.tarkalabs.tarkaui.components.TUIStatus.ON
import com.tarkalabs.tarkaui.components.TUIStatusIndicator
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIStatusIndicatorComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUIStatusIndicator", style = TUITheme.typography.heading3)

    TUIStatusIndicator(text = "Connected", status = ON)

    TUIStatusIndicator(text = "Connected", status = OFF)
  }
}