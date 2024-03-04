package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.FloatingActionButtonSize
import com.tarkalabs.tarkaui.components.base.TUIFloatingActionButton
import com.tarkalabs.tarkaui.icons.Edit16
import com.tarkalabs.tarkaui.icons.Send20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIFloatingActionButtonComposable() {
  Column(
      Modifier
          .fillMaxSize()
          .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIFloatingActionButton", style = TUITheme.typography.heading3)
    // Small FAB with default icon
    TUIFloatingActionButton(fabSize = FloatingActionButtonSize.S,
      icon = TarkaIcons.Regular.Send20,
      onClick = {
        // Handle FAB click
      })

// Large FAB with another custom icon
    TUIFloatingActionButton(fabSize = FloatingActionButtonSize.L,
      icon = TarkaIcons.Regular.Edit16,
      onClick = {
        // Handle FAB click
      })
  }
}