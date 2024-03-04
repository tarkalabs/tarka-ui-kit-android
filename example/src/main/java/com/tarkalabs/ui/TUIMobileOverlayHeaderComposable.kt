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
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeader
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithBackIcon
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithTitle
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.HeaderWithTrailingIcon
import com.tarkalabs.tarkaui.components.TUIMobileOverlayHeaderStyle.None
import com.tarkalabs.tarkaui.icons.Dismiss24
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIMobileOverlayHeaderComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIMobileOverlayHeader", style = TUITheme.typography.heading3)

//Without style
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(), style = None
    )

// Header with title
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(), style = HeaderWithTitle("Select Asset")
    )

// Header with trailing icon
    TUIMobileOverlayHeader(modifier = Modifier.fillMaxWidth(),
      style = HeaderWithTrailingIcon(title = "Select Asset",
        trailingIcon = Regular.Dismiss24,
        onTrailingIconClick = { /* Handle trailing icon click */ }))

//Header with back icon
    TUIMobileOverlayHeader(modifier = Modifier.fillMaxWidth(),
      style = HeaderWithBackIcon(title = "Select Asset",
        onBackIconClick = { /* Handle back icon click */ }))
  }
}