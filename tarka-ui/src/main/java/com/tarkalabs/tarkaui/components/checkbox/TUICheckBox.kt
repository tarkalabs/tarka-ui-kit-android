package com.tarkalabs.tarkaui.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.icons.Checkmark16
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons.Filled
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * A composable function that displays a checkbox with customizable appearance and behavior.
 *
 * @param checked Whether the checkbox is checked.
 * @param icon The icon to display when the checkbox is checked.
 * @param enabled Whether the checkbox is enabled and can be interacted with.
 * @param tags Additional tags to apply to the checkbox.
 * @param onCheckedChange Callback triggered when the checkbox's checked state changes.

 * How to use TUICheckBox() composable function
 *
 *     TUICheckBox(
        checked = isChecked,
        enabled = true,
        onCheckedChange = { isChecked = !isChecked }
      )
 */
@Composable fun TUICheckBox(
  modifier: Modifier = Modifier,
  checked: Boolean,
  icon: TarkaIcon = Filled.Checkmark16,
  enabled: Boolean = true,
  tags: TUICheckBoxTags = TUICheckBoxTags(),
  onCheckedChange: (() -> Unit)? = null
) {
  val borderColor = if (checked) Color.Transparent else TUITheme.colors.utilityOutline
  val backgroundColor = if (checked) TUITheme.colors.primary else Color.Transparent
  val shape = RoundedCornerShape(6.dp)

  Box(
    modifier = modifier
      .size(24.dp)
      .background(
        color = if (enabled) backgroundColor else TUITheme.colors.utilityDisabledBackground,
        shape = shape
      )
      .border(width = 1.dp, color = borderColor, shape = shape)
      .then(
        if (onCheckedChange == null) Modifier else Modifier.toggleable(value = checked,
          onValueChange = {
            if (enabled) {
              onCheckedChange.invoke()
            }
          })
      )
      .testTag(tags.parentTag)
  ) {
    if (checked) {
      Icon(
        painter = painterResource(id = icon.iconRes),
        contentDescription = icon.contentDescription,
        tint = if (enabled) Color.White else TUITheme.colors.utilityDisabledContent,
        modifier = Modifier
          .align(Alignment.Center)

      )
    }
  }
}

@Preview @Composable fun PreviewTUICheckBox() {
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
      TUICheckBox(checked = true, enabled = true, icon = Filled.Checkmark16) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(checked = true, enabled = false, icon = Filled.Checkmark16) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(checked = false, enabled = true, icon = Filled.Checkmark16) {
      }
      VerticalSpacer(space = 20)
      TUICheckBox(checked = false, enabled = false, icon = Filled.Checkmark16) {
      }
    }

  }
}

data class TUICheckBoxTags(
  val parentTag: String = "TUICheckBox",
)