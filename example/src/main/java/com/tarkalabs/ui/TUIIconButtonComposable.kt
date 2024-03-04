package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.IconButtonSize
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.Edit16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.TextClearFormatting16
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIIconButtonComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUIIconButton", style = TUITheme.typography.heading3)
    // Large IconButton with default style
    TUIIconButton(icon = TarkaIcons.Regular.Delete24,
      buttonSize = IconButtonSize.L,
      iconButtonStyle = IconButtonStyle.defaultStyle,
      onIconClick = {
        // Handle IconButton click
      })

// Medium IconButton with outline style
    TUIIconButton(icon = TarkaIcons.Regular.Edit16,
      buttonSize = IconButtonSize.M,
      iconButtonStyle = IconButtonStyle.OUTLINE,
      onIconClick = {
        // Handle IconButton click
      })

// Small IconButton with Ghost icon
    TUIIconButton(icon = TarkaIcons.Regular.TextClearFormatting16,
      buttonSize = IconButtonSize.S,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = {
        // Handle IconButton click
      })
  }
}