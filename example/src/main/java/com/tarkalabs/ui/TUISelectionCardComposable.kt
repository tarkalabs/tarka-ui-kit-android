package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Edit16
import com.tarkalabs.tarkaicons.Send20
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.card.SecondaryDetailsStyle
import com.tarkalabs.uicomponents.components.card.TUISelectionCard
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUISelectionCardComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUISelectionCard", style = TUITheme.typography.heading3)
        // Example Selection card with primary and secondary descriptions
        TUISelectionCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = TarkaIcons.Regular.Send20,
            label = "Label",
            primaryDescription = "Description 1",
            secondaryDescription = "Description 2",
            primaryDetails = "Details 1",
            secondaryDetails = "Details 2",
            secondaryDetailStyle = SecondaryDetailsStyle.NORMAL,
            badgeCount = 4,
            showTrailingIcon = true,
            isSelected = true,
            showCheckMarkIcon = true,
            onCardClicked = {
                // Handle card click
            },
        )

// Example Selection card without secondary details
        TUISelectionCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = TarkaIcons.Regular.Edit16,
            label = "Label",
            primaryDescription = "Description",
            onCardClicked = {
                // Handle card click
            },
        )
    }
}