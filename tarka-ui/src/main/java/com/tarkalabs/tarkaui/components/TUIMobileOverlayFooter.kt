package com.tarkalabs.tarkaui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
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
import com.tarkalabs.tarkaui.components.base.ButtonStyle.ERROR
import com.tarkalabs.tarkaui.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.tarkaui.components.base.IconButtonStyle
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.icons.ArrowLeft24
import com.tarkalabs.tarkaui.icons.ChevronLeft24
import com.tarkalabs.tarkaui.icons.ChevronRight24
import com.tarkalabs.tarkaui.icons.Dismiss24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Composable function to create a mobile overlay footer.
 * @param modifier The modifier for styling and layout customization.
 * @param showMiddleDismiss Determines whether the middle dismiss icon is shown.
 * @param onMiddleDismissClick The click listener for the middle dismiss icon.
 */

@Composable
fun TUIMobileOverlayFooter(
  modifier: Modifier = Modifier,
  showMiddleDismiss: Boolean = true,
  onMiddleDismissClick: (() -> Unit)? = null,
  leftContent: (@Composable RowScope.() -> Unit)? = null,
  rightContent: (@Composable RowScope.() -> Unit)? = null,
) {
  Row(
    modifier
      .height(64.dp)
      .padding(vertical = 8.dp, horizontal = 24.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
  ) {
    leftContent?.invoke(this)
    Spacer(modifier = Modifier.weight(1f))
    if (showMiddleDismiss) TUIIconButton(
      icon = TarkaIcons.Regular.Dismiss24,
      iconButtonStyle = IconButtonStyle.GHOST,
      onIconClick = { onMiddleDismissClick?.invoke() }
    )
    Spacer(modifier = Modifier.weight(1f))
    rightContent?.invoke(this)
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
        leftContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronLeft24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        },
        rightContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronRight24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        }
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = true,
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        leftContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronLeft24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        },
        rightContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronRight24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        }
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        rightContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronRight24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        }
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        leftContent = {
          TUIIconButton(
            icon = TarkaIcons.Regular.ChevronLeft24,
            iconButtonStyle = IconButtonStyle.GHOST
          )
        }
      )

      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = true,
        leftContent = {
          TUIButton(
            label = "Cancel",
            onClick = {},
            buttonStyle = OUTLINE
          )
        },
        rightContent = {
          TUIButton(
            label = "Delete",
            onClick = {},
            buttonStyle = ERROR
          )
        }
      )
      TUIMobileOverlayFooter(
        modifier = Modifier.fillMaxWidth(),
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        leftContent = {
          TUIButton(
            label = "Cancel",
            onClick = {},
            buttonStyle = OUTLINE
          )
        },
        rightContent = {
          TUIButton(
            label = "Delete",
            onClick = {},
            buttonStyle = ERROR
          )
        }
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        rightContent = {
          TUIButton(
            label = "Delete",
            onClick = {},
            buttonStyle = ERROR
          )
        }
      )
      TUIMobileOverlayFooter(
        Modifier.fillMaxWidth(),
        showMiddleDismiss = false,
        leftContent = {
          TUIButton(
            label = "Cancel",
            onClick = {},
            buttonStyle = OUTLINE
          )
        }
      )
    }
  }
}