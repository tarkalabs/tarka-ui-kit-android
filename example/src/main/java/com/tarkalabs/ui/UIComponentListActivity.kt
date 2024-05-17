package com.tarkalabs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUIAppTopBar
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Document
import com.tarkalabs.tarkaui.components.TUITextRow
import com.tarkalabs.tarkaui.components.TextRowStyle
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        var query by remember {
          mutableStateOf("")
        }

        var showSearchbar by remember {
          mutableStateOf(false)
        }

        Scaffold(topBar = {
          TUIAppTopBar(
            title = "Lorem Ipsum",
            navigationIcon = TarkaIcons.Regular.ChevronRight20,
            menuItemIconOne = TarkaIcons.Regular.ChevronRight20,
            menuItemIconTwo = TarkaIcons.Regular.ChevronRight20,
            menuItemIconThree = TarkaIcons.Regular.ChevronRight20,
          )
        }) { paddingValues ->
          Column(
            modifier = Modifier
              .padding(paddingValues)
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(horizontal = 8.dp)
          ) {
            TUIAttachmentUpload(
              type = Document,
              attachmentName = "document.jpg",
              onTrailingIconClick = {},
              onAttachmentClick = { },
              state = UpLoading(50),
              showLeadingIcon = true,
              trailingIcon = Regular.Delete24,
              showDeleteButton = true
            )
          }

        }
      }
    }
  }
}
