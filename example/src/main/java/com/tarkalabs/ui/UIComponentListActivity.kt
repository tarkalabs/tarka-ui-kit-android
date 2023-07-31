package com.tarkalabs.ui

import android.graphics.BitmapFactory
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
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoadSuccessful
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.uicomponents.components.TUIThumbnailType
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Image
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        val listState: LazyListState = rememberLazyListState()
        val bitmap = BitmapFactory.decodeResource(resources, com.tarkalabs.uicomponents.R.drawable.tarka)
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
                type = TUIThumbnailType.Audio,
                attachmentName = "bone.jpg4",
                onMenuClick = {},
                onAttachmentClick = { },
                state = UpLoadSuccessful,
                showLeadingIcon = false
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "whisper.jpg4",
                onMenuClick = {},
                onAttachmentClick = { },
                state = UpLoadSuccessful,
                showLeadingIcon = false
              )

            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Image(bitmap.asImageBitmap()),
                attachmentName = "store.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                state = UpLoading(progress),
                showLeadingIcon = false
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = TUIThumbnailType.Video(bitmap.asImageBitmap()),
                attachmentName = "remedy.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                state = UpLoading(progress),
                showLeadingIcon = false
              )

            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = TUIThumbnailType.Audio,
                attachmentName = "touch.mp3",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                showLeadingIcon = true
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Image(bitmap.asImageBitmap()),
                attachmentName = "cart.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                showLeadingIcon = true
              )
            }
            item {
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = Document,
                attachmentName = "draw.jpg4",
                onMenuClick = {
                  progress += 10
                },
                onAttachmentClick = { progress += 10 },
                showLeadingIcon = true
              )
              VerticalSpacer(space = 8)
              TUIAttachmentUpload(
                type = TUIThumbnailType.Video(bitmap.asImageBitmap()),
                attachmentName = "motherly.jpg4",
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
