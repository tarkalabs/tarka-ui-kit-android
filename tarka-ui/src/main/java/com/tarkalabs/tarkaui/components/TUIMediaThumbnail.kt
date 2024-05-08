package com.tarkalabs.tarkaui.components

import android.content.res.Configuration
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
import androidx.compose.runtime.Stable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.R
import com.tarkalabs.tarkaui.components.PlayPauseButtonSize.M
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailSize.Large
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailSize.Medium
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Audio
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Document
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Image
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Video
import com.tarkalabs.tarkaui.icons.DeviceEq24
import com.tarkalabs.tarkaui.icons.Document24
import com.tarkalabs.tarkaui.icons.Eye12
import com.tarkalabs.tarkaui.icons.Image24
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.icons.Video24
import com.tarkalabs.tarkaui.theme.TUITheme

@Stable
sealed class TUIMediaThumbnailType {
  object Document : TUIMediaThumbnailType()
  object Audio : TUIMediaThumbnailType()
  @Stable
  data class Video(val image: ImageBitmap? = null) : TUIMediaThumbnailType()
  @Stable
  data class Image(val image: ImageBitmap? = null) : TUIMediaThumbnailType()
}

enum class TUIMediaThumbnailSize {
  Large,
  Medium
}

@Composable fun TUIMediaThumbnail(
  modifier: Modifier = Modifier,
  size: TUIMediaThumbnailSize = Large,
  type: TUIMediaThumbnailType?,
  showTrailingIcon: Boolean,
  onThumbnailClick: (() -> Unit)? = null,
  onTrailingIconClick: (() -> Unit)? = null,
  tags: TUIMediaThumbnailTags = TUIMediaThumbnailTags(),
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

    if (onThumbnailClick != null){
      iconModifier.clickable {onThumbnailClick.invoke()}
    }
    when (type) {
      Audio -> {
        Icon(
          painter = painterResource(id = Regular.DeviceEq24.iconRes),
          contentDescription = Regular.DeviceEq24.contentDescription,
          modifier = iconModifier,
          tint = TUITheme.colors.onSurface
        )
      }

      Document -> {
        Icon(
          painter = painterResource(id = Regular.Document24.iconRes),
          contentDescription = Regular.Document24.contentDescription,
          modifier = iconModifier,
          tint = TUITheme.colors.onSurface
        )
      }

      is Image -> {
        if (type.image != null) {
          Image(bitmap = type.image,
            contentDescription = stringResource(id = R.string.image_thumbnail),
            modifier = Modifier
              .then(
                if (onThumbnailClick != null) Modifier.clickable { onThumbnailClick.invoke() } else Modifier)
              .fillMaxSize()
              .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop)
        } else {
          Icon(
            painter = painterResource(id = Regular.Image24.iconRes),
            contentDescription = Regular.Image24.contentDescription,
            modifier = iconModifier,
            tint = TUITheme.colors.onSurface
          )
        }
      }

      is Video -> {
        if (type.image != null) {
          Image(
            bitmap = type.image,
            contentDescription = stringResource(id = R.string.video_thumbnail),
            modifier = Modifier
              .fillMaxSize()
              .testTag(tags.centerIconTag)
              .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
          )
          TUIPlayPauseButton(buttonSize = M, onClick = { onThumbnailClick?.invoke() })
        } else {
          Icon(
            painter = painterResource(id = Regular.Video24.iconRes),
            contentDescription = Regular.Video24.contentDescription,
            modifier = iconModifier,
            tint = TUITheme.colors.onSurface
          )
        }
      }
      else -> {}
    }

    if (showTrailingIcon) {
      Icon(
        painter = painterResource(id = Regular.Eye12.iconRes),
        contentDescription = Regular.Eye12.contentDescription,
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

data class TUIMediaThumbnailTags(
  val parentTag: String = "TUIMediaThumbnail",
  val centerIconTag: String = "TUIMediaThumbnail_CenterIcon",
  val trailingIconTag: String = "TUIMediaThumbnail_TrailingIcon",
  val thumbImageTag: String = "TUIMediaThumbnail_ThumbImage"
)

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable fun PreviewTUIThumbnail() {
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
        TUIMediaThumbnail(type = Image(image = bitmap), showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(image = bitmap), showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Audio, showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Document, showTrailingIcon = false)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Image(), showTrailingIcon = false)
        VerticalSpacer(space = 50)
        TUIMediaThumbnail(type = Image(image = bitmap), showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(image = bitmap), showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Audio, showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Document, showTrailingIcon = false, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Image(), showTrailingIcon = false, size = Medium)
      }

      HorizontalSpacer(space = 100)
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        VerticalSpacer(space = 50)
        TUIMediaThumbnail(type = Image(image = bitmap), showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(image = bitmap), showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Audio, showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Document, showTrailingIcon = true)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(), showTrailingIcon = false)
        VerticalSpacer(space = 50)
        TUIMediaThumbnail(type = Image(image = bitmap), showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(image = bitmap), showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Audio, showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Document, showTrailingIcon = true, size = Medium)
        VerticalSpacer(space = 5)
        TUIMediaThumbnail(type = Video(), showTrailingIcon = false, size = Medium)
      }
    }
  }
}