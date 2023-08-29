package com.tarkalabs.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.Timer20
import com.tarkalabs.uicomponents.components.base.TUIInputField
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Icon
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Text
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Success
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
          TUIInputField(
            leadingContent = Text("$"),
            trailingContent = Icon(TarkaIcons.Regular.Timer20, onIconClick = {
              Log.e("ICON_CLICK_TAG","Hello There")
            }),
            value = "Hello There",
            onValueChange = { },
            status = Success
          )

        }
      }
    }
  }
}
