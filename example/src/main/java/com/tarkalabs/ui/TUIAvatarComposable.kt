package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.AvatarSize
import com.tarkalabs.tarkaui.components.base.AvatarType
import com.tarkalabs.tarkaui.components.base.TUIAvatar
import com.tarkalabs.tarkaui.icons.Person16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUIAvatarComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = "TUIAvatar", style = TUITheme.typography.heading3)

    TUIAvatar(
      modifier = Modifier.size(100.dp),
      avatarType = AvatarType.Icon(TarkaIcons.Regular.Person16),
      avatarSize = AvatarSize.M,
      showBadge = true
    )
  }
}