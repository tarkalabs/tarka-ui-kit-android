package com.tarkalabs.uicomponents.components

import ButtonStyle.OUTLINE
import ButtonStyle.PRIMARY
import TUIButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun TUIMobileButtonBlock(
  modifier: Modifier = Modifier,
  primaryButtonLabel: String,
  primaryButtonOnClick: () -> Unit,
  outlineButtonLabel: String?,
  outlineButtonOnClick: (() -> Unit)?,
  primaryButtonWeight: Float? = null
) {
  Row(
    modifier
      .background(TUITheme.colors.surface50)
      .padding(horizontal = 24.dp, vertical = 16.dp)) {
    if (outlineButtonLabel != null){

      TUIButton(
        label = outlineButtonLabel,
        onClick = { outlineButtonOnClick?.invoke() },
        buttonStyle = OUTLINE,
        modifier = if (primaryButtonWeight == null) Modifier.weight(1f) else Modifier.wrapContentWidth()
      )
      HorizontalSpacer(space = 8)
    }
    TUIButton(
      label = primaryButtonLabel, onClick = primaryButtonOnClick, buttonStyle = PRIMARY,
      modifier = Modifier.weight(if (outlineButtonLabel == null) 1f else primaryButtonWeight ?: 1f)
    )
  }
}

@Preview
@Composable
fun TUIMobileButtonPreview() {
  TUIMobileButtonBlock(
    primaryButtonLabel = "Label",
    primaryButtonOnClick = { /*TODO*/ },
    outlineButtonLabel = null,
    outlineButtonOnClick = null
  )
}

@Preview
@Composable
fun TUIMobileButtonPreview1() {
  TUIMobileButtonBlock(
    primaryButtonLabel = "Label",
    primaryButtonOnClick = { /*TODO*/ },
    outlineButtonLabel = "Label",
    outlineButtonOnClick = { /*TODO*/ }
  )
}

@Preview
@Composable
fun TUIMobileButtonPreview3() {
  TUIMobileButtonBlock(
    primaryButtonLabel = "Label",
    primaryButtonOnClick = { /*TODO*/ },
    outlineButtonLabel = "Label",
    outlineButtonOnClick = { /*TODO*/ },
    primaryButtonWeight = 3f
  )
}