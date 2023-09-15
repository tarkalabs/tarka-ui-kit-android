package com.tarkalabs.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.components.TextRowStyle.Title
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
          // .padding(30.dp)
        ) {


          TUITextRow(title = "Title",
            style = Title,
            infoIcon = Regular.ChevronRight20,
            onTextRowClick = {
              Log.d("TAG", "TUITextRowPreview: ")
            }, onInfoIconClick = null,
            paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
          )

          TUITextRow(title = "Title",
            style = Title,
            infoIcon = Regular.ChevronRight20,
            onTextRowClick = {
              Log.d("TAG", "TUITextRowPreview: ")
            }, onInfoIconClick = null,
            paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
          )
          TUITextRow(title = "Title",
            style = Title,
            infoIcon = Regular.ChevronRight20,
            onTextRowClick = {
              Log.d("TAG", "TUITextRowPreview: ")
            }, onInfoIconClick = null,
            paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
          )
        }
      }
    }
  }
}
