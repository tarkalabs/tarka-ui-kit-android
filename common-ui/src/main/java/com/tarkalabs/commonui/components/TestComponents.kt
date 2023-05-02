package com.tarkalabs.commonui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.common_ui.R
import com.tarkalabs.commonui.components.ButtonHeight.Large
import com.tarkalabs.commonui.components.ButtonHeight.Regular
import com.tarkalabs.commonui.components.ButtonHeight.Small
import com.tarkalabs.commonui.theme.Eam360Theme

@Composable fun TestText(text: String = "Hello There") {
  Text(text, style = Eam360Theme.typography.button6)
}

@Preview(showBackground = true)
@Composable fun TestButton() {
  PrimaryButton(
    label = "Label",
    leadingIcon = R.drawable.keyboard_arrow_right,
    trailingIcon = R.drawable.keyboard_arrow_right,
    height = Large
  ) {

  }
}

@Composable fun EAMButton(
  onClick: () -> Unit = {},
  modifier: Modifier = Modifier,
  colors : ButtonColors = ButtonDefaults.buttonColors(),
  content: @Composable () -> Unit,
) {
  Button(colors = colors, onClick = onClick, modifier = modifier, content = {
    ProvideTextStyle(
      value = Eam360Theme.typography.heading1
    ) {
      content()
    }
  })
}