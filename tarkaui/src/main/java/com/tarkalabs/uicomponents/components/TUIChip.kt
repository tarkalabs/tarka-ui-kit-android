package com.tarkalabs.uicomponents.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap

sealed class ChipType {
  object Assist : ChipType()/*  data class Input(val selected: Boolean = false) : ChipType()
  class Suggestion() : ChipType()
  data class Filter(val selected: Boolean = false) : ChipType()*/
}

sealed class ChipLeadingContent {
  data class Image(val imageBitmap: ImageBitmap) : ChipLeadingContent()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIChip(
  modifier: Modifier = Modifier,
  type: ChipType,
  label: String,
  leadingContent: ChipLeadingContent? = null,
  onClick: () -> Unit,
) {

  AssistChip(label = { Text(text = label) }, onClick = onClick, leadingIcon = {
    if (leadingContent != null && leadingContent is ChipLeadingContent.Image)
      TUIAvatar(avatarType = AvatarType.Image(leadingContent.imageBitmap), avatarSize = AvatarSize.XS)
  })
}