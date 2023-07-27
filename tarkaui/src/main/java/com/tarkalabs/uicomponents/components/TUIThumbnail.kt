package com.tarkalabs.uicomponents.components

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.R
import com.tarkalabs.uicomponents.components.TUIThumbnailSize.Large
import com.tarkalabs.uicomponents.components.TUIThumbnailSize.Medium
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Audio
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Image
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Video
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

sealed class TUIThumbnailType {
  object Document : TUIThumbnailType()
  object Audio : TUIThumbnailType()
  data class Video(val image: ImageBitmap) : TUIThumbnailType()
  data class Image(val image: ImageBitmap) : TUIThumbnailType()
}

enum class TUIThumbnailSize {
  Large,
  Medium
}

@Composable fun TUIThumbnail(
  modifier: Modifier = Modifier,
  size: TUIThumbnailSize = Large,
  type: TUIThumbnailType,
  showTrailingIcon: Boolean,
  onThumbnailClick: (() -> Unit)? = null,
  onTrailingIconClick: (() -> Unit)? = null,
  tags: TUIThumbnailTags = TUIThumbnailTags(),
) {
  val (height, width) = when (size) {
    Large -> 60.dp to 80.dp
    Medium -> 40.dp to 52.dp
  }
  Box(
    modifier = modifier
      .height(height)
      .width(width)
      .background(color = TUITheme.colors.surfaceVariant, shape = RoundedCornerShape(8.dp))
      .testTag(tags.parentTag), contentAlignment = Alignment.Center
  ) {

    val iconModifier = Modifier
      .heightIn(max = 24.dp)
      .widthIn(max = 24.dp)
      .testTag(tags.centerIconTag)
      .then(if (onThumbnailClick != null) Modifier.clickable { onThumbnailClick.invoke() } else Modifier)
    when (type) {
      Audio -> {
        Icon(
          painter = painterResource(id = TarkaIcons.Wave24Regular.iconRes),
          contentDescription = TarkaIcons.Wave24Regular.contentDescription,
          modifier = iconModifier,
          tint = TUITheme.colors.onSurface
        )
      }

      Document -> {
        Icon(
          painter = painterResource(id = TarkaIcons.Document24Regular.iconRes),
          contentDescription = TarkaIcons.Document24Regular.contentDescription,
          modifier = iconModifier,
          tint = TUITheme.colors.onSurface
        )
      }

      is Image -> {
        Image(
          bitmap = type.image,
          contentDescription = "",
          modifier = Modifier
            .then(if (onThumbnailClick != null) Modifier.clickable { onThumbnailClick.invoke() } else Modifier)
            .fillMaxSize()
            .clip(RoundedCornerShape(8.dp)),
          contentScale = ContentScale.Crop
        )
      }

      is Video -> {
        Box(contentAlignment = Alignment.Center) {
          Image(
            bitmap = type.image,
            contentDescription = "",
            modifier = Modifier
              .fillMaxSize()
              .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
          )
          Icon(
            painter = painterResource(id = TarkaIcons.Play16Filled.iconRes),
            modifier = iconModifier
              .background(color = Color(0xFF000000).copy(alpha = 0.5f))
              .clip(CircleShape),
            contentDescription = TarkaIcons.Play16Filled.contentDescription,
            tint = Color.White
          )
        }
      }
    }


    if (showTrailingIcon) {
      Icon(
        painter = painterResource(id = TarkaIcons.Eye12Regular.iconRes),
        contentDescription = TarkaIcons.Eye12Regular.contentDescription,
        tint = Color.White,
        modifier = Modifier
          .align(Alignment.TopEnd)
          .padding(4.dp)
          .testTag(tags.trailingIconTag)
          .clip(CircleShape)
          .background(color = Color(0xFF000000).copy(alpha = 0.5f))
          .size(20.dp)
          .then(if (onTrailingIconClick != null) Modifier.clickable { onTrailingIconClick.invoke() } else Modifier)

      )
    }
  }
}

data class TUIThumbnailTags(
  val parentTag: String = "TUIThumbnailParentTag",
  val centerIconTag: String = "TUIThumbnailCenterIconTag",
  val trailingIconTag: String = "TUIThumbnailTrailingIconTag",
  val thumbImageTag: String = "TUIThumbnailThumbImageTag"
)

@Preview @Composable fun PreviewTUIThumbnail() {
  TUITheme {
    val option = BitmapFactory.Options()
    option.inPreferredConfig = Bitmap.Config.ARGB_8888
    val bitmap = BitmapFactory.decodeResource(
      LocalContext.current.resources, R.drawable.tarka, option
    ).asImageBitmap()
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = TUITheme.colors.surface),
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        VerticalSpacer(space = 50)
        TUIThumbnail(type = Image(image = bitmap), showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Video(image = bitmap), showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Audio, showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Document, showTrailingIcon = false)
        VerticalSpacer(space = 50)
        TUIThumbnail(type = Image(image = bitmap), showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Video(image = bitmap), showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Audio, showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Document, showTrailingIcon = false, size = Medium)
      }

      HorizontalSpacer(space = 100)
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        VerticalSpacer(space = 50)
        TUIThumbnail(type = Image(image = bitmap), showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Video(image = bitmap), showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Audio, showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Document, showTrailingIcon = true)
        VerticalSpacer(space = 50)
        TUIThumbnail(type = Image(image = bitmap), showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Video(image = bitmap), showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Audio, showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIThumbnail(type = Document, showTrailingIcon = true, size = Medium)

      }

    }
  }
}