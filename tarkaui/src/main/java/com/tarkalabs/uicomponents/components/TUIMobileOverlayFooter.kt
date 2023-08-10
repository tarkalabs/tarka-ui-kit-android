package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.base.IconButtonStyle
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.models.TarkaIcons

@Composable
fun TUIMobileOverlayFooter(
  modifier: Modifier = Modifier,
  showRightArrow: Boolean = true,
  showLeftArrow: Boolean = true,
  showMiddleDismiss: Boolean = true,
  onRightArrowClick: (() -> Unit)? = null,
  onLeftArrowClick: (() -> Unit)? = null,
  onMiddleDismissClick: (() -> Unit)? = null,
) {
  Row(
    modifier.height(64.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceEvenly
  ) {
    if (showLeftArrow) TUIIconButton(
      icon = TarkaIcons.ChevronLeft24Regular,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = {onLeftArrowClick?.invoke()}
    )
    if (showMiddleDismiss) TUIIconButton(
      icon = TarkaIcons.Dismiss24Regular,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = {onMiddleDismissClick?.invoke()}
    )
    if (showRightArrow) TUIIconButton(
      icon = TarkaIcons.ChevronRight24Regular,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = {onRightArrowClick?.invoke()}
    )
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TUIMobileOverlayFooterPreview() {
  TUIMobileOverlayFooter(Modifier.fillMaxWidth())
}