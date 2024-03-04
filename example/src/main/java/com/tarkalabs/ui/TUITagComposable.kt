package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUITag
import com.tarkalabs.tarkaui.components.TagSize
import com.tarkalabs.tarkaui.components.TagType
import com.tarkalabs.tarkaui.icons.Circle12
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.Warning12
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUITagComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUITag", style = TUITheme.typography.heading3)
    // Normal tag with high priority
    TUITag(title = "Title",
      tagType = TagType.HIGH,
      tagSize = TagSize.M,
      leadingIcon = TarkaIcons.Regular.Circle12,
      onClick = { /* Handle tag click */ })

// Large tag with Custom type
    TUITag(title = "Title",
      tagType = TagType.CUSTOM(
        bgContentColor = TUITheme.colors.warning,
        titleColor = TUITheme.colors.onWarning,
        iconTint = TUITheme.colors.onWarning
      ),
      tagSize = TagSize.L,
      trailingIcon = TarkaIcons.Regular.Warning12,
      onClick = { /* Handle tag click */ })
  }
}