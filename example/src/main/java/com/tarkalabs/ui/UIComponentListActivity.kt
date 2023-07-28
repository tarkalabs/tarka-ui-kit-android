package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.OnUpLoadSuccessful
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        val listState: LazyListState = rememberLazyListState()

        var progress by remember {
          mutableStateOf(78)
        }
        Column(
          modifier = Modifier
            .fillMaxSize()
            .background(color = TUITheme.colors.surface)
        ) {

          LazyColumn(
            state = listState, modifier = Modifier.fillMaxSize()
          ) {
            item {
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {},
                onAttachmentClick = { },
                state = OnUpLoadSuccessful
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {},
                onAttachmentClick = { },
                state = OnUpLoadSuccessful
              )

            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                state = UpLoading(progress)
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                state = UpLoading(progress)
              )

            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
              )

            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                showLeadingIcon = true
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "13djksafhjdkshfsdbfjkshdgfugsdf.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                showLeadingIcon = true
              )
            }
          }
        }
      }
    }
  }
}
