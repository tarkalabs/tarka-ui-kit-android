package com.tarkalabs.commonui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TestText(text: String) {
  Text(text, style = TextStyle(fontSize = 88.sp))
}