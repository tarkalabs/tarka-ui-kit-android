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

/**
 * A composable function for rendering an email area field.
 * @param modifier The modifier to be applied to the composable.
 * @param placeHolder The placeholder text to be displayed when the field is empty.
 * @param text The current text value of the field.
 * @param keyboardOption The keyboard options for the field.
 * @param keyboardAction The keyboard actions for the field.
 * @param maxLines The maximum number of lines for the field.
 * @param minLines The minimum number of lines for the field.
 * @param singleLine Whether the field should be limited to a single line or not.
 * @param onTextChanged The callback function to be invoked when the text changes. It takes the new text value as a parameter.
 * @param testTags The test tags for testing purposes.
 *
 * TUIEmailAreaField(
    modifier = Modifier,
    placeHolder = "Enter email content",
    text = emailContent,
    onTextChanged = { text ->  },
    testTags = TUIEmailAreaFieldTags()
    )
 */

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
    unfocusedTextColor = TUITheme.colors.inputText,
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