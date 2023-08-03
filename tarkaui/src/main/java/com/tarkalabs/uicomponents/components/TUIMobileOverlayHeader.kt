package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.base.IconButtonSize
import com.tarkalabs.uicomponents.components.base.IconButtonStyle
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun TUIMobileOverlayHeader(
  modifier: Modifier = Modifier,
  showBackButton: Boolean,
  buttonTitle: String? = null,
  trailingIcon: TarkaIcon? = null,
  handleOnly: Boolean,
  onTrailingIconClick: (() -> Unit)? = null,
  onBackButtonClick: (() -> Unit)? = null,
) {

  val width = 375.dp
  val height = when {
    !showBackButton && buttonTitle == null && handleOnly -> 24.dp
    else -> 64.dp
  }

  Box(
    modifier = modifier
      .height(height)
      .width(width)
  ) {
    Column {
      Box(
        modifier = Modifier
          .height(4.dp)
          .width(68.dp)
          .background(TUITheme.colors.surfaceVariant)
          .clip(RoundedCornerShape(45.dp))
          .align(Alignment.CenterHorizontally)
      )
      if (!handleOnly) Row {
        if (showBackButton) TUIIconButton(icon = TarkaIcons.ChevronLeft24Regular,
          buttonSize = IconButtonSize.XL,
          iconButtonStyle = IconButtonStyle.GHOST,
          onIconClick = { onBackButtonClick?.invoke() })
        if (buttonTitle != null) Text(
          text = buttonTitle,
          modifier = Modifier
            .weight(1f)
            .align(CenterVertically),
          textAlign = if (showBackButton) TextAlign.Center else TextAlign.Start,
          style = TUITheme.typography.heading5
        )

        if (trailingIcon != null) TUIIconButton(icon = trailingIcon,
          buttonSize = IconButtonSize.L,
          iconButtonStyle = IconButtonStyle.GHOST,
          onIconClick = { onTrailingIconClick?.invoke() })
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun TUIMobileOverlayHeaderPreview() {
  Column(Modifier.fillMaxSize()) {
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(),
      showBackButton = false,
      buttonTitle = null,
      trailingIcon = null,
      handleOnly = true
    )
    VerticalSpacer(space = 10)
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(),
      showBackButton = false,
      buttonTitle = "Title",
      trailingIcon = null,
      handleOnly = false
    )
    VerticalSpacer(space = 10)
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(),
      showBackButton = false,
      buttonTitle = "Title",
      trailingIcon = TarkaIcons.Dismiss24Regular,
      handleOnly = false
    )
    VerticalSpacer(space = 10)
    TUIMobileOverlayHeader(
      modifier = Modifier.fillMaxWidth(),
      showBackButton = true,
      buttonTitle = "Title",
      trailingIcon = null,
      handleOnly = false
    )
    VerticalSpacer(space = 10)
  }
}