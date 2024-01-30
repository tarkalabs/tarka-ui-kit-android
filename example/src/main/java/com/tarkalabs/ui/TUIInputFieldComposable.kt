package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.LockClosed12
import com.tarkalabs.tarkaicons.Mail12
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.TUIInputField
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIInputFieldComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIInputField", style = TUITheme.typography.heading3)
        // Example Simple InputField with label
        TUIInputField(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            value = "",
            label = "Label",
            onValueChange = {
                // Handle input field value change
            },
            status = TUIInputFieldStatus.Normal
        )

// Example InputField with leading icon and error status
        TUIInputField(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            value = "",
            label = "Label",
            onValueChange = {
                // Handle input field value change
            },
            status = TUIInputFieldStatus.Error,
            leadingContent = TUIInputFieldContentType.Icon(TarkaIcons.Regular.Mail12),
            helperMessage = "Please enter a valid email address"
        )

// Example InputField with trailing icon and custom shape
        TUIInputField(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            value = "",
            label = "Label",
            onValueChange = {
                // Handle input field value change
            },
            status = TUIInputFieldStatus.Normal,
            trailingContent = TUIInputFieldContentType.Icon(TarkaIcons.Regular.LockClosed12),
            inputShape = CutCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
        )
    }
}