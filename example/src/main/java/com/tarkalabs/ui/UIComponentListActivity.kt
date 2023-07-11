package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUICheckBoxRow
import com.tarkalabs.uicomponents.components.TUIRadioButtonRow
import com.tarkalabs.uicomponents.components.TextRowStyle.Title
import com.tarkalabs.uicomponents.components.TextRowStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        val status = remember {
          mutableStateOf(true)
        }
        Column(
          modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = Color.White)
        ) {
          TUICheckBoxRow(
            checked = status.value,
            enabled = true,
            icon = TarkaIcons.CheckMark20Filled,
            title = "TUICheckBoxRow",
            style = TitleWithDescription("Description")
          ) {
            status.value = !status.value
          }
          VerticalSpacer(space = 20)

          TUIRadioButtonRow(
            selected = status.value,
            enabled = true,
            title = "TUIRadioButtonRowRow",
            style = Title
          ) {
            status.value = !status.value
          }

        }
      }
    }
  }
}
