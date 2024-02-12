package com.tarkalabs.tarkaui.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Checkmark16
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.TarkaIcons.Filled
import com.tarkalabs.uicomponents.components.HorizontalSpacer
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.components.base.TUIToggleRow
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle.Title
import com.tarkalabs.uicomponents.components.base.ToggleRowStyle.TitleWithDescription

/**
 * A composable function that displays a checkbox and a text row in a horizontal layout.
 *
 * @param checked Whether the checkbox is checked.
 * @param icon The icon to display when the checkbox is checked.
 * @param enabled Whether the checkbox is enabled and can be interacted with.
 * @param title The text to display in the text row.
 * @param style The style to apply to the text row.
 * @param onCheckedChange Callback triggered when the checkbox's checked state changes.
 *
 * How to use TUICheckBoxRow() composable function
 *     TUICheckBoxRow(
          checked = isChecked,
          enabled = true,
          title = "Checkbox Row",
          style = ToggleRowStyle.Title,
          onCheckedChange = { isChecked = !isChecked }
        )
 */
@Composable fun TUICheckBoxRow(
  modifier: Modifier = Modifier,
  checked: Boolean,
  icon: TarkaIcon = TarkaIcons.Filled.Checkmark16,
  enabled: Boolean = true,
  title: String,
  style: ToggleRowStyle,
  tags: TUICheckBoxRowTags = TUICheckBoxRowTags(),
  paddingValues: PaddingValues = PaddingValues(),
  onCheckedChange: () -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
      .toggleable(value = checked,
        onValueChange = {
          if (enabled) {
            onCheckedChange.invoke()
          }
        })
      .padding(paddingValues)
      .testTag(tags.parentTag)
  ) {
    TUICheckBox(
      checked = checked,
      onCheckedChange = null,
      enabled = enabled,
      icon = icon,
      tags = tags.checkBoxTags
    )
    HorizontalSpacer(space = 16)
    TUIToggleRow(
      title = title,
      style = style,
    )
  }
}

data class TUICheckBoxRowTags(
  val parentTag: String = "TUICheckBoxRow",
  val checkBoxTags: TUICheckBoxTags = TUICheckBoxTags(parentTag = "TUICheckBoxRow_CheckBox"),
  val textRowTags: TUITextRowTags = TUITextRowTags(parentTag = "TUICheckBoxRow_TextRow"),
)

@Preview @Composable fun PreviewTUICheckBoxRow() {
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
        checked = true,
        enabled = true,
        icon = Filled.Checkmark16,
        title = "Title",
        style = TitleWithDescription("Description")
      ) {
      }
      TUICheckBoxRow(
        checked = false,
        enabled = true,
        icon = Filled.Checkmark16,
        title = "Title",
        style = TitleWithDescription("Description")
      ) {
      }

      TUICheckBoxRow(
        checked = true,
        enabled = false,
        icon = Filled.Checkmark16,
        title = "Title",
        style = TitleWithDescription("Description")
      ) {
      }

      TUICheckBoxRow(
        checked = true,
        enabled = false,
        icon = Filled.Checkmark16,
        title = "Title",
        style = Title
      ) {
      }

    }

  }
}