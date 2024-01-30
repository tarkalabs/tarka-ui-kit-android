package com.tarkalabs.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Send20
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType
import com.tarkalabs.uicomponents.theme.TUITheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIAttachmentUploadComposable() {
  val bitmap: Bitmap =
    BitmapFactory.decodeResource(LocalContext.current.resources, R.drawable.avatar)
  val someImage: ImageBitmap = bitmap.asImageBitmap()
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUIAttachmentUpload", style = TUITheme.typography.heading3)
    // Example Attachment Uploader of Image
    TUIAttachmentUpload(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      type = TUIMediaThumbnailType.Image(someImage),
      attachmentName = "document.jpg",
      onAttachmentClick = {
        // Handle attachment click
      },
      onTrailingIconClick = {
        // Handle trailing icon click
      },
      trailingIcon = TarkaIcons.Regular.Send20,
      state = UpLoading(50),
      showLeadingIcon = true,
    )

// Example Attachment Uploader of Video
    TUIAttachmentUpload(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      type = TUIMediaThumbnailType.Video(someImage),
      attachmentName = "video.mp4",
      onAttachmentClick = {
        // Handle attachment click
      },
      onTrailingIconClick = {
        // Handle trailing icon click
      },
      trailingIcon = TarkaIcons.Regular.Send20,
      state = TUIAttachmentUpload.AttachmentState.UpLoadSuccessful,
      showLeadingIcon = false,
    )
  }
}