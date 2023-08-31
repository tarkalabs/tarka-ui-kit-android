package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Checkmark16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUICheckBoxRow
import com.tarkalabs.uicomponents.components.TextRowStyle
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {

        Column(
          modifier = Modifier
            .fillMaxSize()
            .background(color = TUITheme.colors.surface)
        ) {
          TUICheckBoxRow(
            checked = true,
            enabled = false,
            icon = TarkaIcons.Filled.Checkmark16,
            title = "Title",
            style = TextRowStyle.TitleWithDescription("Description"),
            modifier = Modifier,
            paddingValues = PaddingValues(bottom = 8.dp, start = 16.dp, end = 16.dp)
          ) {
          }

        }
      }
    }
  }
}
