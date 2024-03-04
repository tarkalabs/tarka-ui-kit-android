package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.ChipLeadingContent
import com.tarkalabs.tarkaui.components.ChipType
import com.tarkalabs.tarkaui.components.TUIChip
import com.tarkalabs.tarkaui.icons.ClearFormatting16
import com.tarkalabs.tarkaui.icons.Info24
import com.tarkalabs.tarkaui.icons.Search24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.Warning24
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIChipComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIChip", style = TUITheme.typography.heading3)
    //Assist Chip
    TUIChip(type = ChipType.Assist(), label = "Assist", onClick = { /* Handle chip click */ })

//Input Chip
    TUIChip(type = ChipType.Input(
      content = ChipLeadingContent.Icon(icon = TarkaIcons.Regular.Search24),
      trailingIcon = TarkaIcons.Regular.ClearFormatting16,
      containerColor = Color.Gray
    ),
      label = "Input",
      onClick = { /* Handle chip click */ },
      onDismissClick = { /* Handle dismiss click */ })

//Suggestion Chip
    TUIChip(type = ChipType.Suggestion(image = TarkaIcons.Regular.Info24),
      label = "Suggestion",
      onClick = { /* Handle chip click */ })

//Filter Chip
    TUIChip(type = ChipType.Filter(
      selected = true,
      showLeadingCheck = true,
      showTrailingDismiss = true,
      showTrailingCaret = true,
      badgeCount = 3,
      trailingIcon = TarkaIcons.Regular.Warning24
    ),
      label = "Filter",
      onClick = { /* Handle chip click */ },
      onDismissClick = { /* Handle dismiss click */ })
  }
}