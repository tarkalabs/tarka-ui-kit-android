package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.base.ButtonSize.XL
import com.tarkalabs.uicomponents.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.base.TUIButton
import com.tarkalabs.uicomponents.components.base.TUIButtonTags
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * A composable function that displays a block of two buttons for main action and secondary action.
 *
 * @param modifier The modifier to be applied to the row block containing the buttons.
 * @param primaryButtonLabel The label text for the primary button.
 * @param primaryButtonOnClick The callback function to be invoked when the primary button is clicked.
 * @param outlineButtonLabel The optional label text for the outline button. If null, the outline button will not be displayed.
 * @param outlineButtonOnClick The optional callback function to be invoked when the outline button is clicked.
 * @param primaryButtonWeight The optional weight of the primary button relative to the outline button.
 * @param leadingIcon The drawable resource for the leading icon, if any. Default is null.
 * @param trailingIcon The drawable resource for the trailing icon, if any. Default is null.
 *
 * If null, the primary button will occupy all available space.
 */

@Composable
fun TUIMobileButtonBlock(
  modifier: Modifier = Modifier,
  primaryButtonLabel: String?,
  primaryButtonOnClick: (() -> Unit)?,
  outlineButtonLabel: String?,
  outlineButtonOnClick: (() -> Unit)?,
  primaryButtonWeight: Float? = null,
  primaryLeadingIcon: TarkaIcon? = null,
  primaryTrailingIcon: TarkaIcon? = null,
  tags: TUIMobileButtonBlockTags = TUIMobileButtonBlockTags()
) {
  Column(modifier.fillMaxWidth()) {
    Divider(color = TUITheme.colors.surfaceVariant, thickness = 1.dp)
    Row(
      modifier
        .background(TUITheme.colors.surface50)
        .padding(start = 24.dp, end = 24.dp, top = 15.dp, bottom = 16.dp)
    ) {
      if (outlineButtonLabel != null) {
        TUIButton(
          height = XL,
          label = outlineButtonLabel,
          onClick = { outlineButtonOnClick?.invoke() },
          buttonStyle = OUTLINE,
          leadingIcon = null,
          trailingIcon = null,
          modifier = if (primaryButtonWeight == null) Modifier.weight(1f) else Modifier.wrapContentWidth(),
          tags = TUIButtonTags(parentTag = tags.outlineButtonTag)
        )
        HorizontalSpacer(space = 8)
      }
      primaryButtonLabel?.let {
        TUIButton(
          height = XL,
          label = it,
          onClick = { primaryButtonOnClick?.invoke() },
          buttonStyle = PRIMARY,
          leadingIcon = primaryLeadingIcon,
          trailingIcon = primaryTrailingIcon,
          modifier = Modifier.weight(
            if (outlineButtonLabel == null) 1f else primaryButtonWeight ?: 1f
          ),
          tags = TUIButtonTags(parentTag = tags.primaryButtonTag)
        )
      }
    }
  }
}

data class TUIMobileButtonBlockTags(
  val primaryButtonTag: String = "TUIMobileButtonBlock_Primary",
  val outlineButtonTag: String = "TUIMobileButtonBlock_Outline",
)

@Preview @Composable fun TUIMobileButtonPreview() {
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
fun TUIMobileButtonPreview2() {
  TUIMobileButtonBlock(
    primaryButtonLabel = "Label",
    primaryButtonOnClick = { /*TODO*/ },
    outlineButtonLabel = null,
    outlineButtonOnClick = { /*TODO*/ },
    primaryTrailingIcon = Regular.ChevronDown24
  )
}

@Preview
@Composable
fun TUIMobileButtonPreview3() {
  TUIMobileButtonBlock(
    primaryButtonLabel = "Label",
    primaryButtonOnClick = { /*TODO*/ },
    outlineButtonLabel = null,
    outlineButtonOnClick = { /*TODO*/ },
    primaryLeadingIcon = Regular.ChevronDown24
  )
}

@Preview
@Composable
fun TUIMobileButtonPreview4() {
  TUITheme {
    Column {
      TUIMobileButtonBlock(
        primaryButtonLabel = "Label",
        primaryButtonOnClick = { /*TODO*/ },
        outlineButtonLabel = "Label",
        outlineButtonOnClick = { /*TODO*/ },
        primaryButtonWeight = 3f
      )
      TUIMobileButtonBlock(
        primaryButtonLabel = null,
        primaryButtonOnClick = null,
        outlineButtonLabel = "Label",
        outlineButtonOnClick = { /*TODO*/ },
        primaryButtonWeight = null
      )
    }
  }
}