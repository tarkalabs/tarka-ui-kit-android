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
import com.tarkalabs.commonui.theme.Eam360Theme

@Preview(showBackground = true) @Composable fun TestText(text: String = "Hello There") {
  Text(text, style = Eam360Theme.typography.button6)
}

@Composable fun TestButton() {
  EAMButton(modifier = Modifier
    .fillMaxWidth()
    .padding(10.dp), onClick = {}) {
    Text(text = "Hello")
    // Text(text = "World", style = Eam360Theme.typography.button6)
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