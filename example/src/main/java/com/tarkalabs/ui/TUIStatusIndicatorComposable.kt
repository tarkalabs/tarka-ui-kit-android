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
import com.tarkalabs.uicomponents.components.TUIStatus.OFF
import com.tarkalabs.uicomponents.components.TUIStatus.ON
import com.tarkalabs.uicomponents.components.TUIStatusIndicator
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIStatusIndicatorComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIStatusIndicator", style = TUITheme.typography.heading3)

        TUIStatusIndicator(text = "Connected", status = ON)

        TUIStatusIndicator(text = "Connected", status = OFF)
    }
}