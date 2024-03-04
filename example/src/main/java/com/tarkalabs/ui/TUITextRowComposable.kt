package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUITextRow
import com.tarkalabs.tarkaui.components.TextRowStyle.Title
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUITextRowComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUITextRow", style = TUITheme.typography.heading3)

    TUITextRow(title = "Title",
      style = Title,
      infoIcon = TarkaIcons.Regular.ChevronRight20,
      onTextRowClick = { /* Handle text row click */ },
      onInfoIconClick = { /* Handle info icon click */ })
  }
}