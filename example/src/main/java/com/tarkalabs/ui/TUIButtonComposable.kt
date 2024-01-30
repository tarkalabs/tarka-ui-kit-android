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
import com.tarkalabs.tarkaicons.ClearFormatting16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.ButtonSize
import com.tarkalabs.uicomponents.components.base.ButtonSize.M
import com.tarkalabs.uicomponents.components.base.ButtonStyle
import com.tarkalabs.uicomponents.components.base.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.base.TUIButton
import com.tarkalabs.uicomponents.theme.TUITheme

@OptIn(ExperimentalMaterial3Api::class)
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
      height = M,
      buttonStyle = ERROR,
      onClick = { /*Handle click*/ }
    )

    TUIButton(
      label = "Primary Button",
      height = ButtonSize.M,
      buttonStyle = ButtonStyle.PRIMARY,
      onClick = {
      }
    )

    TUIButton(
      label = "Secondary Button",
      height = ButtonSize.M,
      buttonStyle = ButtonStyle.SECONDARY,
      leadingIcon = TarkaIcons.Regular.ClearFormatting16,
      onClick = {
      }
    )

    TUIButton(
      label = "Ghost Button",
      height = ButtonSize.L,
      buttonStyle = ButtonStyle.GHOST,
      trailingIcon = TarkaIcons.Regular.ClearFormatting16,
      onClick = {
      }
    )
  }
}