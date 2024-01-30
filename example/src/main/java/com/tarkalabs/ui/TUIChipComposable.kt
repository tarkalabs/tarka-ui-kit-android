package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ClearFormatting16
import com.tarkalabs.tarkaicons.Info24
import com.tarkalabs.tarkaicons.Search24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.Warning24
import com.tarkalabs.uicomponents.components.ChipLeadingContent
import com.tarkalabs.uicomponents.components.ChipType
import com.tarkalabs.uicomponents.components.TUIChip
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIChipComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIChip", style = TUITheme.typography.heading3)
        //Assist Chip
        TUIChip(
            type = ChipType.Assist(),
            label = "Assist",
            onClick = { /* Handle chip click */ }
        )

//Input Chip
        TUIChip(
            type = ChipType.Input(
                content = ChipLeadingContent.Icon(icon = TarkaIcons.Regular.Search24),
                trailingIcon = TarkaIcons.Regular.ClearFormatting16,
                containerColor = Color.Gray
            ),
            label = "Input",
            onClick = { /* Handle chip click */ },
            onDismissClick = { /* Handle dismiss click */ }
        )

//Suggestion Chip
        TUIChip(
            type = ChipType.Suggestion(image = TarkaIcons.Regular.Info24),
            label = "Suggestion",
            onClick = { /* Handle chip click */ }
        )

//Filter Chip
        TUIChip(
            type = ChipType.Filter(
                selected = true,
                showLeadingCheck = true,
                showTrailingDismiss = true,
                showTrailingCaret = true,
                badgeCount = 3,
                trailingIcon = TarkaIcons.Regular.Warning24
            ),
            label = "Filter",
            onClick = { /* Handle chip click */ },
            onDismissClick = { /* Handle dismiss click */ }
        )
    }
}