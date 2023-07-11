package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags

/**
 * A composable function that displays a RadioButton and a text row in a horizontal layout.
 *
 * @param selected whether this radio button is selected or not
 * @param enabled controls the enabled state of this radio button. When false,
 * this component will not respond to user input, and it will appear
 * visually disabled and disabled to accessibility services.
 * @param title The text to display in the text row.
 * @param style The style to apply to the text row.
 * @param radioButtonTags Additional tags to apply to the RadioButton.
 * @param textRowTags Additional tags to apply to the text row.
 * @param onOptionSelected Callback triggered when the RadioButton is selected/clicked.
 *
 * How to use TUIRadioButtonRow() composable function
 * TUIRadioButtonRow(
selected = isSelected,
enabled = true,
title = "RadioButton Row",
style = TextRowStyle.Title,
onOptionSelected = { selected = !isSelected }
)
 */
@Composable fun TUIRadioButtonRow(
  modifier: Modifier = Modifier,
  selected: Boolean,
  enabled: Boolean = true,
  title: String,
  style: TextRowStyle,
  radioButtonTags: TUIRadioButtonTags = TUIRadioButtonTags(),
  textRowTags: TUITextRowTags = TUITextRowTags(),
  radioButRowTags: TUIRadioButtonRowTags = TUIRadioButtonRowTags(),
  onOptionSelected: () -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .selectable(
        selected = selected,
        role = Role.RadioButton,
        onClick = { if (enabled) onOptionSelected.invoke() },
        enabled = enabled
      )
      .testTag(radioButRowTags.parentTag)
  ) {
    TUIRadioButton(
      selected = selected,
      onOptionSelected = null,
      enabled = enabled,
      tags = radioButtonTags
    )
    HorizontalSpacer(space = 16)
    TUITextRow(
      title = title,
      style = style,
      tags = textRowTags,
      onTextRowClick = null,
    )
  }
}

data class TUIRadioButtonRowTags(
  val parentTag: String = Tags.TAG_RADIO_BUTTON_ROW,
)

@Preview @Composable fun PreviewTUIRadioButtonRow() {
  Column(
    modifier = Modifier
      .padding(20.dp)
      .fillMaxWidth()
      .padding(10.dp)
      .background(color = Color.White)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      TUIRadioButtonRow(
        selected = true,
        enabled = true,
        title = "Title",
        style = TextRowStyle.TitleWithDescription("Description")
      ) {
      }
      TUIRadioButtonRow(
        selected = false,
        enabled = true,
        title = "Title",
        style = TextRowStyle.TitleWithDescription("Description")
      ) {
      }
      TUIRadioButtonRow(
        selected = true,
        enabled = true,
        title = "Title",
        style = TextRowStyle.Title
      ) {
      }
      TUIRadioButtonRow(
        selected = false,
        enabled = true,
        title = "Title",
        style = TextRowStyle.Title
      ) {
      }
    }

  }
}