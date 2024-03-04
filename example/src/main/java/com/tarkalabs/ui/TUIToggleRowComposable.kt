package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.base.TUIToggleRow
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIToggleRowComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIToggleRow", style = TUITheme.typography.heading3)
        TUIToggleRow(
            title = "Title",
            style = ToggleRowStyle.Title
        )

        TUIToggleRow(
            title = "Title",
            style = ToggleRowStyle.TitleWithDescription("Description")
        )
    }
}