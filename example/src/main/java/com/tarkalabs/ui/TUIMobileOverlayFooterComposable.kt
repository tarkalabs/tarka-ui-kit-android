package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUIMobileOverlayFooter
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIMobileOverlayFooterComposable() {
  Column(
      Modifier
          .fillMaxSize()
          .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIMobileOverlayFooter", style = TUITheme.typography.heading3)

// Default Overlay Footer
    TUIMobileOverlayFooter(Modifier.fillMaxWidth())

// Overlay Footer with left arrow enabled.
    TUIMobileOverlayFooter(
      Modifier.fillMaxWidth(), showMiddleDismiss = false
    )
  }
}