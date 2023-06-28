package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons

/**
 * A composable function that displays a checkbox and a text row in a horizontal layout.
 *
 * @param checked Whether the checkbox is checked.
 * @param icon The icon to display when the checkbox is checked.
 * @param enabled Whether the checkbox is enabled and can be interacted with.
 * @param title The text to display in the text row.
 * @param style The style to apply to the text row.
 * @param checkBoxTags Additional tags to apply to the checkbox.
 * @param textRowTags Additional tags to apply to the text row.
 * @param onCheckedChange Callback triggered when the checkbox's checked state changes.
 *
 * How to use TUICheckBoxRow() composable function
 *     TUICheckBoxRow(
        checked = isChecked,
        enabled = true,
        title = "Checkbox Row",
        style = TextRowStyle.Title,
        onCheckedChange = { isChecked = !isChecked }
        )
 */
@Composable fun TUICheckBoxRow(
  checked: Boolean,
  icon: TarkaIcon = TarkaIcons.CheckMark,
  enabled: Boolean = true,
  title: String,
  style: TextRowStyle,
  checkBoxTags: TUICheckBoxTags = TUICheckBoxTags(),
  textRowTags: TUITextRowTags = TUITextRowTags(),
  onCheckedChange: () -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier
      .toggleable(value = checked,
        onValueChange = {
        if (enabled) {
          onCheckedChange.invoke()
        }
      })
  ) {
    TUICheckBox(
      checked,
      onCheckedChange = null,
      enabled = enabled,
      icon = icon,
      tags = checkBoxTags
    )
    HorizontalSpacer(space = 16)
    TUITextRow(
      title = title,
      style = style,
      tags = textRowTags,
      onTextRowClick = null
    )
  }
}

@Preview @Composable fun PreviewTUICheckBoxRow() {
  val status = remember {
    mutableStateOf(false)
  }
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
      TUICheckBoxRow(
        checked = status.value,
        enabled = true,
        icon = TarkaIcons.CheckMark,
        title = "TUICheckBoxRow",
        style = TextRowStyle.TitleWithDescription("Description")
      ) {
        status.value = !status.value
      }


    }

  }
}