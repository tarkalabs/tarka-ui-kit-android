package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.ButtonSize
import com.tarkalabs.tarkaui.components.base.ButtonStyle.ERROR
import com.tarkalabs.tarkaui.components.base.ButtonStyle.GHOST
import com.tarkalabs.tarkaui.components.base.ButtonStyle.PRIMARY
import com.tarkalabs.tarkaui.components.base.ButtonStyle.SECONDARY
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.icons.ClearFormatting16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable
fun TUIButtonComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUIButton", style = TUITheme.typography.heading3)

    TUIButton(
      label = "Error Button",
      height = ButtonSize.M,
      buttonStyle = ERROR,
      onClick = { /*Handle click*/ }
    )

    TUIButton(
      label = "Primary Button",
      height = ButtonSize.M,
      buttonStyle = PRIMARY,
      onClick = {
      }
    )

    TUIButton(
      label = "Secondary Button",
      height = ButtonSize.M,
      buttonStyle = SECONDARY,
      leadingIcon = TarkaIcons.Regular.ClearFormatting16,
      onClick = {
      }
    )

    TUIButton(
      label = "Ghost Button",
      height = ButtonSize.L,
      buttonStyle = GHOST,
      trailingIcon = TarkaIcons.Regular.ClearFormatting16,
      onClick = {
      }
    )
  }
}