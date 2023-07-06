package com.tarkalabs.uicomponents.components

import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.theme.TUITheme

sealed class ChipType {
  object Assist : ChipType()/*  data class Input(val selected: Boolean = false) : ChipType()
  class Suggestion() : ChipType()
  data class Filter(val selected: Boolean = false) : ChipType()*/
}

sealed class ChipLeadingContent {
  data class Image(val imageBitmap: ImageBitmap) : ChipLeadingContent()
  data class Icon(val icon: TarkaIcon) : ChipLeadingContent()

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
    when (leadingContent) {
      is ChipLeadingContent.Icon -> Icon(
        painter = painterResource(id = leadingContent.icon.iconRes),
        contentDescription = leadingContent.icon.contentDescription,
        tint = TUITheme.colors.onSurface
      )
      is ChipLeadingContent.Image -> TUIAvatar(
        avatarType = AvatarType.Image(leadingContent.imageBitmap),
        avatarSize = AvatarSize.XS
      )
      null -> {}
    }
  }
  )
}