package com.tarkalabs.uicomponents.components.radiobutton

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * A composable function that displays a RadioButton with customizable appearance and behavior.
 *
 * @param selected - whether this RadioButton is selected or not
 * @param enabled controls the enabled state of this radio button. When false,
 * this component will not respond to user input, and it will appear
 * visually disabled and disabled to accessibility services.
 * @param tags Additional tags to apply to the radiobutton.
 * @param onOptionSelected Callback triggered when the RadioButton is selected/clicked.
 *
 * How to use TUIRadioButton() composable function
 * TUIRadioButton(
selected = isSelected,
enabled = true)
 */
@Composable fun TUIRadioButton(
  modifier: Modifier = Modifier,
  selected: Boolean,
  enabled: Boolean = true,
  tags: TUIRadioButtonTags = TUIRadioButtonTags(),
  onOptionSelected: (() -> Unit)? = null,
) {
  val borderColor = if (selected) Color.Transparent else TUITheme.colors.utilityOutline
  val backgroundColor = if (selected) TUITheme.colors.primary else Color.Transparent
  val shape = RoundedCornerShape(24.dp)

  Box(
    modifier = modifier
      .size(24.dp)
      .background(
        color = if (enabled) backgroundColor else TUITheme.colors.utilityDisabledBackground,
        shape = shape
      )
      .border(width = 1.dp, color = borderColor, shape = shape)
      .then(
        if (onOptionSelected == null) Modifier else
          Modifier.selectable(
            selected = selected,
            role = Role.RadioButton,
            onClick = { if (enabled) onOptionSelected.invoke() },
            enabled = enabled
          )
      )
      .testTag(tags.parentTag)
  ) {
    if (selected) {
      val color = if (enabled) Color.White else TUITheme.colors.utilityDisabledContent
      Circle(modifier = Modifier.align(Alignment.Center), color)
    }
  }
}

@Composable
fun Circle(
  modifier: Modifier,
  color: Color,
) {
  Canvas(
    modifier = modifier
      .width(8.dp)
      .height(8.dp)
  ) {
    val canvasWidth = size.width
    val canvasHeight = size.height
    drawCircle(
      color = color,
      center = Offset(x = canvasWidth / 2, y = canvasHeight / 2),
      radius = size.minDimension / 2
    )
  }
}

@Preview @Composable fun PreviewTUIRadioButton() {
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
      TUIRadioButton(selected = false, enabled = true) {
      }
      VerticalSpacer(space = 20)
      TUIRadioButton(selected = true, enabled = true) {
      }
      VerticalSpacer(space = 20)
      TUIRadioButton(selected = false, enabled = false) {
      }
      VerticalSpacer(space = 20)
      TUIRadioButton(selected = true, enabled = false) {
      }
    }

  }
}

data class TUIRadioButtonTags(
  val parentTag: String = "TUIRadioButton",
)