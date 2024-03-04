package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.tab.TUITab
import com.tarkalabs.tarkaui.icons.Send20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUITabComposable() {
  Column(
      Modifier
          .fillMaxSize()
          .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUITab", style = TUITheme.typography.heading3)
    // Example Tab with default appearance
    TUITab(
      modifier = Modifier
          .width(105.dp)
          .padding(8.dp),
      title = "Tab 1",
      isSelected = true,
      leadingIcon = TarkaIcons.Regular.Send20,
      onTabClicked = {
        // Handle tab click
      },
    )
  }
}