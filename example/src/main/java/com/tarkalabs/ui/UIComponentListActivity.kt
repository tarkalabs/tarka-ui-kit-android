package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
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
          TUIAttachmentUpload(
            type = Document,
            attachmentName = "abc.png",
            onTrailingIconClick = {
            },
            onAttachmentClick = { },
            showLeadingIcon = false,
            trailingIcon = TarkaIcons.Regular.Delete24
          )

        }
      }
    }
  }
}
