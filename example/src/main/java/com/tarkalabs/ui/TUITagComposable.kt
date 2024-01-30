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
import com.tarkalabs.tarkaicons.Circle12
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.Warning12
import com.tarkalabs.uicomponents.components.TUITag
import com.tarkalabs.uicomponents.components.TagSize
import com.tarkalabs.uicomponents.components.TagType
import com.tarkalabs.uicomponents.theme.TUITheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUITagComposable() {
    Column(Modifier.fillMaxSize(). padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUITag", style = TUITheme.typography.heading3)
        // Normal tag with high priority
        TUITag(
            title = "Title",
            tagType = TagType.HIGH,
            tagSize = TagSize.M,
            leadingIcon = TarkaIcons.Regular.Circle12,
            onClick = { /* Handle tag click */ }
        )

// Large tag with Custom type
        TUITag(
            title = "Title",
            tagType = TagType.CUSTOM(
                bgContentColor = TUITheme.colors.warning,
                titleColor = TUITheme.colors.onWarning,
                iconTint = TUITheme.colors.onWarning
            ),
            tagSize = TagSize.L,
            trailingIcon = TarkaIcons.Regular.Warning12,
            onClick = { /* Handle tag click */ }
        )
    }
}