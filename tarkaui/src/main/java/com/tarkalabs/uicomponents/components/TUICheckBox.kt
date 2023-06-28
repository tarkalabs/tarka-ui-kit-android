package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable fun TUICheckBox(
  checked: Boolean,
  icon: TarkaIcon = TarkaIcons.CheckMark,
  enabled: Boolean = true,
  tags: TUICheckBoxTags = TUICheckBoxTags(),
  onCheckedChange: (() -> Unit)? = null
) {
  val borderColor = if (checked) Color.Transparent else TUITheme.colors.utilityOutline
  val backgroundColor = if (checked) TUITheme.colors.primary else Color.Transparent
  val shape = RoundedCornerShape(6.dp)

  Box(
    modifier = Modifier
      .size(24.dp)
      .background(
        color = if (enabled) backgroundColor else TUITheme.colors.utilityDisabledBackground,
        shape = shape
      )
      .border(width = 1.dp, color = borderColor, shape = shape)
      .testTag(tags.parentTag)
      .then(
        if (onCheckedChange == null) Modifier else Modifier.toggleable(
          value = checked,
          onValueChange = {
            if (enabled) {
              onCheckedChange.invoke()
            }
          })
      )
  ) {
    if (checked) {
      Icon(
        painter = painterResource(id = icon.iconRes),
        contentDescription = icon.contentDescription,
        tint = if (enabled) Color.White else TUITheme.colors.utilityDisabledContent,
        modifier = Modifier
          .align(Alignment.Center)

      )
    }
  }
}

@Preview @Composable fun PreviewTUICheckBox() {
  Column(
    modifier = Modifier
      .padding(20.dp)
      .fillMaxWidth()
      .padding(10.dp)
      .background(color = Color.White)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      TUICheckBox(true, enabled = true, icon = TarkaIcons.CheckMark) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(true, enabled = false, icon = TarkaIcons.CheckMark) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(false, enabled = true, icon = TarkaIcons.CheckMark) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(false, enabled = false, icon = TarkaIcons.CheckMark) {
      }
    }

  }
}

data class TUICheckBoxTags(
  val parentTag: String = Tags.TAG_CHECK_BOX,
)