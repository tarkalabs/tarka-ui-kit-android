package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronLeft24
import com.tarkalabs.tarkaicons.ChevronRight24
import com.tarkalabs.tarkaicons.Dismiss24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.IconButtonStyle
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * Composable function to create a mobile overlay footer.
 *
 * @param modifier The modifier for styling and layout customization.
 * @param showRightArrow Determines whether the right arrow icon is shown.
 * @param showLeftArrow Determines whether the left arrow icon is shown.
 * @param showMiddleDismiss Determines whether the middle dismiss icon is shown.
 * @param onRightArrowClick The click listener for the right arrow icon.
 * @param onLeftArrowClick The click listener for the left arrow icon.
 * @param onMiddleDismissClick The click listener for the middle dismiss icon.
 */
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
    modifier
      .height(64.dp)
      .padding(vertical = 8.dp, horizontal = 24.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    if (showLeftArrow) TUIIconButton(
      icon = TarkaIcons.Regular.ChevronLeft24,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = { onLeftArrowClick?.invoke() }
    )
    Spacer(modifier = Modifier.weight(1f))
    if (showMiddleDismiss) TUIIconButton(
      icon = TarkaIcons.Regular.Dismiss24,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = { onMiddleDismissClick?.invoke() }
    )
    Spacer(modifier = Modifier.weight(1f))
    if (showRightArrow) TUIIconButton(
      icon = TarkaIcons.Regular.ChevronRight24,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = { onRightArrowClick?.invoke() }
    )
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TUIMobileOverlayFooterPreview() {
  TUITheme {
    Column {
      TUIMobileOverlayFooter(Modifier.fillMaxWidth())
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightArrow = false,
        showLeftArrow = false,
        showMiddleDismiss = true
      )

      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightArrow = true,
        showLeftArrow = true,
        showMiddleDismiss = false
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightArrow = true,
        showLeftArrow = false,
        showMiddleDismiss = false
      )

      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightArrow = false,
        showLeftArrow = true,
        showMiddleDismiss = false
      )

    }
  }
}