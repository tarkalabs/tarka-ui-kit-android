package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithBackIcon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithTitle
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.HeaderWithTrailingIcon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayHeaderStyle.None
import com.tarkalabs.uicomponents.components.base.IconButtonSize
import com.tarkalabs.uicomponents.components.base.IconButtonStyle
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

sealed class TUIMobileOverlayHeaderStyle {
  object None : TUIMobileOverlayHeaderStyle()
  data class HeaderWithTitle(val title: String) : TUIMobileOverlayHeaderStyle()
  data class HeaderWithTrailingIcon(
    val title: String, val trailingIcon: TarkaIcon, val onTrailingIconClick: () -> Unit
  ) : TUIMobileOverlayHeaderStyle()

  data class HeaderWithBackIcon(
    val title: String, val onBackIconClick: () -> Unit
  ) : TUIMobileOverlayHeaderStyle()
}

@Composable fun TUIMobileOverlayHeader(
  modifier: Modifier = Modifier,
  showBackButton: Boolean,
  style: TUIMobileOverlayHeaderStyle,
  title: String? = null,
) {

  val height = when {
    !showBackButton && title == null -> 24.dp
    else -> 64.dp
  }

  Box(
    modifier = modifier
      .height(height)
      .fillMaxWidth()
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Box(
        modifier = Modifier
          .height(4.dp)
          .width(68.dp)
          .background(TUITheme.colors.surfaceVariant)
          .clip(RoundedCornerShape(45.dp))
          .align(Alignment.CenterHorizontally)
      )
      Row(verticalAlignment = Alignment.CenterVertically) {
        when (style) {
          is HeaderWithBackIcon -> {
            TUIIconButton(
              icon = TarkaIcons.ChevronLeft24Regular,
              buttonSize = IconButtonSize.XL,
              iconButtonStyle = IconButtonStyle.GHOST,
              onIconClick = style.onBackIconClick
            )
            HeaderText(
              title = style.title,
              TextAlign.Center,
              modifier = Modifier
                .weight(1f)
                .padding(end = 48.dp)
            )
          }

          is HeaderWithTitle -> {
            HeaderText(title = style.title, TextAlign.Center, modifier = Modifier.weight(1f))
          }

          is HeaderWithTrailingIcon -> {
            HeaderText(
              title = style.title,
              textAlign = TextAlign.Start,
              modifier = Modifier
                .weight(1f)

            )
            TUIIconButton(
              icon = style.trailingIcon,
              buttonSize = IconButtonSize.L,
              iconButtonStyle = IconButtonStyle.GHOST,
              onIconClick = style.onTrailingIconClick
            )
          }

          None -> {
          }
        }

      }
    }
  }
}

@Composable private fun HeaderText(title: String, textAlign: TextAlign, modifier: Modifier) {
  Text(
    text = title,
    modifier = modifier,
    textAlign = textAlign,
    style = TUITheme.typography.heading5
  )
}

@Preview(showBackground = true) @Composable fun TUIMobileOverlayHeaderPreview() {
  TUITheme {
    Column(
      Modifier
        .fillMaxSize()
        .background(TUITheme.colors.surface)
    ) {
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        showBackButton = false,
        title = null,
        style = None
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        showBackButton = false,
        title = "Select Asset",
        style = HeaderWithTitle("Select Asset")
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        showBackButton = false,
        title = "Title",
        style = HeaderWithTrailingIcon(title = "Select Asset",
          trailingIcon = TarkaIcons.Dismiss24Regular,
          onTrailingIconClick = {

          })
      )
      VerticalSpacer(space = 10)
      TUIMobileOverlayHeader(
        modifier = Modifier.fillMaxWidth(),
        showBackButton = true,
        title = "Title",
        style = HeaderWithBackIcon(title = "Select Asset", onBackIconClick = {

        })
      )
      VerticalSpacer(space = 10)
    }

  }
}