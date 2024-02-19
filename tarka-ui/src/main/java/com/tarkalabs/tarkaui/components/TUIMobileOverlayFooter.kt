package com.tarkalabs.tarkaui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.ButtonType.BUTTON
import com.tarkalabs.tarkaui.components.ButtonType.ICON_BUTTON
import com.tarkalabs.tarkaui.components.base.ButtonStyle.ERROR
import com.tarkalabs.tarkaui.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.icons.ChevronLeft24
import com.tarkalabs.tarkaui.icons.ChevronRight24
import com.tarkalabs.tarkaui.icons.Dismiss24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

enum class ButtonType {
  ICON_BUTTON,
  BUTTON
}

/**
 * Composable function to create a mobile overlay footer.
 * @param modifier The modifier for styling and layout customization.
 * @param showRightButton Determines whether the right Button is shown.
 * @param showLeftButton Determines whether the left Button is shown.
 * @param showMiddleDismiss Determines whether the middle dismiss icon is shown.
 * @param onRightButtonClick The click listener for the right Button.
 * @param onLeftButtonClick The click listener for the left Button.
 * @param onMiddleDismissClick The click listener for the middle dismiss icon.
 * @param buttonType Determines the Left and Right button type. Default is [ButtonType.ICON_BUTTON].
 */
@Composable
fun TUIMobileOverlayFooter(
  modifier: Modifier = Modifier,
  showRightButton: Boolean = true,
  showLeftButton: Boolean = true,
  showMiddleDismiss: Boolean = true,
  onRightButtonClick: (() -> Unit)? = null,
  onLeftButtonClick: (() -> Unit)? = null,
  onMiddleDismissClick: (() -> Unit)? = null,
  buttonType: ButtonType = ICON_BUTTON,
) {
  Row(
    modifier
      .height(64.dp)
      .padding(vertical = 8.dp, horizontal = 24.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    if (showLeftButton) when (buttonType) {
      ICON_BUTTON -> {
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronLeft24,
          iconButtonStyle = IconButtonStyle.GHOST,
          onIconClick = { onLeftButtonClick?.invoke() }
        )
      }

      BUTTON -> {
        TUIButton(
          label = "Cancel",
          buttonStyle = OUTLINE,
          onClick = {}
        )
      }
    }
    Spacer(modifier = Modifier.weight(1f))
    if (showMiddleDismiss) TUIIconButton(
      icon = TarkaIcons.Regular.Dismiss24,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = { onMiddleDismissClick?.invoke() }
    )
    Spacer(modifier = Modifier.weight(1f))
    if (showRightButton) when (buttonType) {
      ICON_BUTTON -> {
        TUIIconButton(
          icon = TarkaIcons.Regular.ChevronRight24,
          iconButtonStyle = IconButtonStyle.GHOST,
          onIconClick = { onRightButtonClick?.invoke() }
        )
      }

      BUTTON -> {
        TUIButton(
          label = "Delete",
          buttonStyle = ERROR,
          onClick = {}
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TUIMobileOverlayFooterPreview() {
  TUITheme {
    Column(
      modifier = Modifier
        .background(TUITheme.colors.surface)
        .fillMaxSize()
    ) {
      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
        buttonType = ICON_BUTTON
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = false,
        showLeftButton = false,
        showMiddleDismiss = true,
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = true,
        showLeftButton = true,
        showMiddleDismiss = false,
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = true,
        showLeftButton = false,
        showMiddleDismiss = false,
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = false,
        showLeftButton = true,
        showMiddleDismiss = false,
      )

      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
        buttonType = BUTTON
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = false,
        showLeftButton = false,
        showMiddleDismiss = true,
        buttonType = BUTTON
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = true,
        showLeftButton = true,
        showMiddleDismiss = false,
        buttonType = BUTTON
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = true,
        showLeftButton = false,
        showMiddleDismiss = false,
        buttonType = BUTTON
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showRightButton = false,
        showLeftButton = true,
        showMiddleDismiss = false,
        buttonType = BUTTON
      )
    }
  }
}