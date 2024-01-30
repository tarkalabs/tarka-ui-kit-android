package com.tarkalabs.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.card.TUIDraggableCard
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIDraggableCardComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIDraggableCard", style = TUITheme.typography.heading3)
        // Example Draggable card with switch
        TUIDraggableCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            dragIconModifier = Modifier
                .size(24.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .padding(8.dp),
            title = "Description 1",
            switchCheckedState = true,
            onSwitchCheckedChange = {
                // Handle switch state change
            },
        )

// Example Draggable card without switch
        TUIDraggableCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            dragIconModifier = Modifier
                .size(24.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .padding(8.dp),
            title = "Description 1",
            switchCheckedState = false,
            onSwitchCheckedChange = {
                // Handle switch state change
            },
        )
    }
}