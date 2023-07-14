package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable fun TUIEmailAreaField(
  modifier: Modifier = Modifier,
  placeHolder: String,
  text: String,
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  maxLines: Int = 20,
  minLines: Int = 1,
  singleLine: Boolean = false,
  onTextChanged: (String) -> Unit,
  testTags: TUIEmailAreaFieldTags = TUIEmailAreaFieldTags()
) {

  val colors = TextFieldDefaults.colors(
    unfocusedIndicatorColor =  Color.Transparent,
    focusedIndicatorColor = Color.Transparent,
    focusedTextColor = TUITheme.colors.inputText,
    unfocusedContainerColor = Color.Transparent,
    focusedContainerColor = Color.Transparent,

    )
  TextField(
    modifier = modifier,
    value = text,
    onValueChange = {
      onTextChanged(it)
    },
    singleLine = singleLine,
    keyboardOptions = keyboardOption,
    keyboardActions = keyboardAction,
    maxLines = maxLines,
    minLines = minLines,
    textStyle = TUITheme.typography.body7,
    placeholder = {
      Text(
        text = placeHolder,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.utilityOutline,
        modifier = Modifier.testTag(testTags.placeHolderTag)
      )
    },
    colors = colors
  )
}

data class TUIEmailAreaFieldTags(
  val parentTag: String = "TUIEmailSubjectFieldTag", val placeHolderTag: String = "PlaceHolderTag"
)

@Preview @Composable fun TUIEmailAreaFieldPreview() {
  TUITheme {
    var data by remember {
      mutableStateOf("")
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
      TUIEmailAreaField(
        placeHolder = "Subject", text = data, onTextChanged = {
          data = it

        }, modifier = Modifier.fillMaxWidth()
      )

    }
  }
}