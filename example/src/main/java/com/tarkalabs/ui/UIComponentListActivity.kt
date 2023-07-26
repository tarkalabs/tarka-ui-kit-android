package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUIEmailAreaField
import com.tarkalabs.uicomponents.components.TUIEmailSubjectField
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.components.base.TUIInputField
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Icon
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Text
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Normal
import com.tarkalabs.uicomponents.components.base.TUIInputFieldType.LookupInputField
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        var data by rememberSaveable  {
          mutableStateOf("")
        }
        var data2 by rememberSaveable {
          mutableStateOf("")
        }
        Column(
          modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = TUITheme.colors.surface)
        ) {

          var textValue by remember {
            mutableStateOf("hello world")
          }
          TUIInputField(
            leadingContent = Text("$"),
            trailingContent = Icon(TarkaIcons.Timer20Regular),
            value = textValue,
            onValueChange = { textValue = it },
            status = Normal,
            label = "Label",
            inputFieldTye = LookupInputField,
            enabled = false
          )
          VerticalSpacer(space = 20)
          TUIInputField(
            leadingContent = Text("$"),
            trailingContent = Icon(TarkaIcons.Timer20Regular),
            value = textValue,
            onValueChange = { textValue = it },
            status = Normal,
            label = "Label",
          )
          VerticalSpacer(space = 20)

          TUIEmailSubjectField(
            placeHolder = "Subject", text = data, onTextChanged = {
              data = it

            }, modifier = Modifier.fillMaxWidth()
          )
          VerticalSpacer(space = 20)

          TUIEmailAreaField(
            placeHolder = "Subject", text = data2, onTextChanged = {
              data2 = it

            }, modifier = Modifier.fillMaxWidth()
          )

        }
      }
    }
  }
}
