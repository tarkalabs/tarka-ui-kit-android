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
 * A composable function for rendering an email subject field.
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
 * @param maxCharLength the maximum numbers of text allowed in email subject field
 *
 * TUIEmailSubjectField(
    modifier = Modifier,
    placeHolder = "Enter subject",
    text = emailSubject,
    onTextChanged = { text -> },
    testTags = TUIEmailSubjectFieldTags()
    )
 */
@Composable fun TUIEmailSubjectField(
  modifier: Modifier = Modifier,
  placeHolder: String,
  text: String,
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  maxLines: Int = 5,
  minLines: Int = 1,
  maxCharLength: Int = Int.MAX_VALUE,
  singleLine: Boolean = false,
  onTextChanged: (String) -> Unit,
  testTags: TUIEmailSubjectFieldTags = TUIEmailSubjectFieldTags()
) {

  val colors = TextFieldDefaults.colors(
    unfocusedIndicatorColor = TUITheme.colors.surfaceVariant,
    focusedIndicatorColor = TUITheme.colors.primary,
    focusedTextColor = TUITheme.colors.inputText,
    unfocusedContainerColor = Color.Transparent,
    focusedContainerColor = Color.Transparent,

    )
  TextField(
    modifier = modifier,
    value = text,
    onValueChange = {
      if (it.length <= maxCharLength) onTextChanged(it)
    },
    singleLine = singleLine,
    keyboardOptions = keyboardOption,
    keyboardActions = keyboardAction,
    maxLines = maxLines,
    minLines = minLines,
    textStyle = TUITheme.typography.heading7,
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

data class TUIEmailSubjectFieldTags(
  val parentTag: String = "TUIEmailSubjectField", val placeHolderTag: String = "TUIEmailSubjectField_PlaceHolder"
)

@Preview @Composable fun TUIEmailSubjectFieldPreview() {
  TUITheme {
    var data by remember {
      mutableStateOf("")
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
      TUIEmailSubjectField(
        placeHolder = "Subject", text = data, onTextChanged = {
          data = it

        }, modifier = Modifier.fillMaxWidth()
      )

    }
  }
}