package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUIThumbnailSize.Large
import com.tarkalabs.uicomponents.components.TUIThumbnailSize.Medium
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIThumbnailSize {
  Large,
  Medium
}

@Composable fun TUIThumbnail(
  modifier: Modifier = Modifier,
  size: TUIThumbnailSize = Large,
  tags: TUIThumbnailTags = TUIThumbnailTags()
) {
  var height = 60.dp
  var width = 80.dp
  when (size) {
    Large -> {
      height = 60.dp
      width = 80.dp
    }

    Medium -> {
      height = 40.dp
      width = 52.dp
    }
  }

  Box(
    modifier = modifier
      .height(height)
      .width(width)
      .background(color = TUITheme.colors.surfaceVariant, shape = RoundedCornerShape(8.dp))
      .testTag(tags.parentTag), contentAlignment = Alignment.Center
  ) {
    Icon(
      painter = painterResource(id = TarkaIcons.AddCircle24Regular.iconRes),
      contentDescription = TarkaIcons.AddCircle24Regular.contentDescription,
      modifier = Modifier
        .heightIn(max = 24.dp)
        .widthIn(max = 24.dp)
        .testTag(tags.centerIconTag)
    )

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
    )

  }
}

data class TUIThumbnailTags(
  val parentTag: String = "TUIThumbnailParentTag",
  val centerIconTag: String = "TUIThumbnailCenterIconTag",
  val trailingIconTag: String = "TUIThumbnailTrailingIconTag"
)

@Preview @Composable fun PreviewTUIThumbnail() {
  TUITheme {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = TUITheme.colors.surface),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      VerticalSpacer(space = 50)
      TUIThumbnail()
      VerticalSpacer(space = 20)
      TUIThumbnail(size = Medium)
    }
  }
}