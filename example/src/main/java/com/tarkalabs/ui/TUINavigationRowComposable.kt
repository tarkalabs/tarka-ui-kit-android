package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUINavigationRow
import com.tarkalabs.tarkaui.icons.Call20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUINavigationRowComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUINavigationRow", style = TUITheme.typography.heading3)
    TUINavigationRow(
      title = "Label",
      leadingIcon = TarkaIcons.Regular.Call20,
      onClick = { /*Handle click*/ },
    ) {
      Text(text = "NILESH")
    }

  }
}