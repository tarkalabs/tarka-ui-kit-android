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
import com.tarkalabs.tarkaicons.BarcodeScanner24
import com.tarkalabs.tarkaicons.Dismiss16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUISearchBar
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUISearchBarComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUISearchBar", style = TUITheme.typography.heading3)

        TUISearchBar(
            query = "My Search",
            placeholder = "Search",
            onQueryTextChange = { /* Handle query text change */ },
            trailingIcon = TarkaIcons.Filled.Dismiss16,
            leadingIcon = TarkaIcons.Regular.BarcodeScanner24,
            onLeadingIconClick = { /* Handle leading icon click */ },
            modifier = Modifier.padding(10.dp),
        )

    }
}