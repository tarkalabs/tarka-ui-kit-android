package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.radiobutton.TUIRadioButton
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIRadioButtonComposable() {
  Column(
      Modifier
          .fillMaxSize()
          .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIRadioButton", style = TUITheme.typography.heading3)
    TUIRadioButton(
      modifier = Modifier.padding(8.dp),
      selected = true,
      onOptionSelected = {},
    )

    TUIRadioButton(
      modifier = Modifier.padding(8.dp),
      selected = false,
      enabled = false,
      onOptionSelected = {},
    )
  }
}