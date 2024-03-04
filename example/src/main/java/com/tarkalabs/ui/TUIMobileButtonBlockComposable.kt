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
import com.tarkalabs.tarkaicons.AnimalCat16
import com.tarkalabs.tarkaicons.FStop16
import com.tarkalabs.tarkaicons.Home12
import com.tarkalabs.tarkaicons.Send20
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIMobileButtonBlock
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIMobileButtonBlockComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIMobileButtonBlock", style = TUITheme.typography.heading3)
        TUIMobileButtonBlock(
            primaryButtonLabel = "Label",
            primaryButtonOnClick = {
                // Handle Click
            },
            outlineButtonLabel = "Label",
            outlineButtonOnClick = {
                // Handle Click
            },
            primaryButtonWeight = 1f,
            primaryLeadingIcon = TarkaIcons.Regular.AnimalCat16,
            primaryTrailingIcon = TarkaIcons.Regular.Home12,
            outlineLeadingIcon = TarkaIcons.Regular.FStop16,
            outlineTrailingIcon = TarkaIcons.Regular.Send20,
        )
    }
}