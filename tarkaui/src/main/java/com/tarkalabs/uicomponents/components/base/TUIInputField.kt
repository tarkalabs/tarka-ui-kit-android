package com.tarkalabs.uicomponents.components.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.HorizontalSpacer
import com.tarkalabs.uicomponents.components.base.TUIInputFieldIconContentType.Icon
import com.tarkalabs.uicomponents.components.base.TUIInputFieldIconContentType.Text
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Alert
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Error
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Normal
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Success
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIInputFieldStatus {
  Normal, Error, Success, Alert,
}

sealed class TUIInputFieldIconContentType {
  data class Icon(val icon: TarkaIcon) : TUIInputFieldIconContentType()
  data class Text(val text: String) : TUIInputFieldIconContentType()
}
/**
 * A  Composable function that renders an text field with various options such as label, icons, status, and helper text.
 *
 * @param modifier The modifier for styling or positioning the input field.
 * @param value The current value of the input field.
 * @param label The label text to display above the input field.
 * @param onValueChange A callback function invoked when the value of the input field changes.
 * @param status The status of the input field, such as Enabled, Disabled, Error, etc.
 * @param leadingIcon The icon to display on the leading side of the input field.
 * @param trailingIcon The icon to display on the trailing side of the input field.
 * @param helperMessage The helper message to display below the input field.
 * @param testTags Tags for testing purposes to identify specific elements within the input field.
 */
@Composable
fun TUIInputField(
  modifier: Modifier = Modifier,
  value: String,
  label: String? = null,
  onValueChange: (String) -> Unit,
  status: TUIInputFieldStatus,
  enabled: Boolean = true,
  leadingIcon: TUIInputFieldIconContentType? = null,
  trailingIcon: TUIInputFieldIconContentType? = null,
  helperMessage: String? = null,
  testTags: TUIInputFieldTags = TUIInputFieldTags(),
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  maxLines: Int = 1,
  minLines: Int = 1,
  maxCharLength: Int = Int.MAX_VALUE,
  singleLine: Boolean = false,
  inputShape: Shape = RoundedCornerShape(8.dp)
) {

  val icon = iconFor(status)
  val colors = colorsFor(status)

  val leadingIconLambda: @Composable () -> Unit = {
    if (leadingIcon != null)
      when(leadingIcon){
        is Icon -> Icon(
          painter = painterResource(id = leadingIcon.icon.iconRes),
          contentDescription = leadingIcon.icon.contentDescription,
          modifier = Modifier.testTag(testTags.leadingIconTag),
          tint = TUITheme.colors.inputText
        )
        is Text ->  Text(
          text = leadingIcon.text.take(1),
          style = TUITheme.typography.body5,
          color = TUITheme.colors.inputDim
        )
      }

  }
  val tailingIconLambda: @Composable () -> Unit = {
    if (trailingIcon != null)
      when(trailingIcon){
        is Icon -> Icon(
          painter = painterResource(id = trailingIcon.icon.iconRes),
          contentDescription = trailingIcon.icon.contentDescription,
          modifier = Modifier.testTag(testTags.trailingIconTag),
          tint = TUITheme.colors.inputText
        )
        is Text ->  Text(
          text = trailingIcon.text.take(1),
          style = TUITheme.typography.body5,
          color = TUITheme.colors.inputTextDim
        )
      }

  }
  val labelLambda: @Composable () -> Unit = {
    if (label != null) Text(
      text = label,
      style = TUITheme.typography.body8,
      color = TUITheme.colors.inputTextDim,
      modifier = Modifier.testTag(testTags.labelTag)
    )
  }
  val helperMessageLambda: @Composable (() -> Unit)? = if (helperMessage != null) {
    {
      Row(verticalAlignment = Alignment.CenterVertically) {
        if (icon != null) {
          Icon(
            tint = indicatorColorFor(status),
            painter = painterResource(id = icon.iconRes),
            modifier = Modifier.testTag(testTags.helperIconTag),
            contentDescription = icon.contentDescription
          )
          HorizontalSpacer(space = 5)
        }
        Text(
          text = helperMessage,
          style = TUITheme.typography.body7,
          color = TUITheme.colors.inputText,
          modifier = Modifier.testTag(testTags.helperTextTag)
        )
      }
    }
  } else {
    null
  }
  TextField(
    modifier = modifier
      .fillMaxWidth()
      .testTag(testTags.parentTag)
      .clip(inputShape),
    value = value,
    onValueChange = {
      if (it.length <= maxCharLength) onValueChange(it)
    },
    enabled = enabled,
    singleLine = singleLine,
    colors = colors,
    label = if (label != null) labelLambda else null,
    leadingIcon = if (leadingIcon != null) leadingIconLambda else null,
    trailingIcon = if (trailingIcon != null) tailingIconLambda else null,
    keyboardOptions = keyboardOption,
    keyboardActions = keyboardAction,
    supportingText = helperMessageLambda,
    maxLines = maxLines,
    minLines = minLines,
  )
}

fun iconFor(status: TUIInputFieldStatus): TarkaIcon? {
  return when (status) {
    Success -> TarkaIcons.CheckMarkCircle16Regular
    Alert -> TarkaIcons.Warning12Regular
    else -> null
  }
}

@Composable
fun colorsFor(status: TUIInputFieldStatus): TextFieldColors {
  val focusedIndicatorColor = indicatorColorFor(status)
  return TextFieldDefaults.colors(
    focusedIndicatorColor = focusedIndicatorColor,
    unfocusedIndicatorColor = TUITheme.colors.utilityDisabledBackground,
    focusedTextColor = TUITheme.colors.inputText,
    unfocusedTextColor = TUITheme.colors.inputText,
    disabledTextColor = TUITheme.colors.utilityDisabledContent,
    focusedContainerColor = TUITheme.colors.inputBackground,
    unfocusedContainerColor = TUITheme.colors.inputBackground,
    disabledContainerColor = TUITheme.colors.inputBackground,
    errorContainerColor = TUITheme.colors.inputBackground,
    focusedLabelColor = TUITheme.colors.inputDim,
    unfocusedLabelColor = TUITheme.colors.inputDim,
    disabledLabelColor = TUITheme.colors.inputDim,
    errorLabelColor = TUITheme.colors.inputDim,
  )
}

@Composable
private fun indicatorColorFor(status: TUIInputFieldStatus) = when (status) {
  Normal -> TUITheme.colors.primary
  Error -> TUITheme.colors.error
  Success -> TUITheme.colors.success
  Alert -> TUITheme.colors.warning
}

@Preview(showBackground = true)
@Composable
fun TUIPreview() {
  TUITheme(false) {
    var textValue by remember {
      mutableStateOf("hello world")
    }
    TUIInputField(
      leadingIcon = TUIInputFieldIconContentType.Text("$"),
      trailingIcon = TUIInputFieldIconContentType.Icon(TarkaIcons.Timer20Regular),
      value = textValue,
      onValueChange = { textValue = it },
      status = Success
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TUIPreviewDark() {
  TUITheme(true) {
    var textValue by remember {
      mutableStateOf("hello world")
    }
    TUIInputField(
      leadingIcon = TUIInputFieldIconContentType.Text("$"),
      trailingIcon = TUIInputFieldIconContentType.Icon(TarkaIcons.Timer20Regular),
      value = textValue,
      onValueChange = { textValue = it },
      status = Success
    )
  }
}

data class TUIInputFieldTags(
  val parentTag: String = "TUIInputField_InputField",
  val trailingIconTag: String = "TUIInputField_TrailingIcon",
  val leadingIconTag: String = "TUIInputField_LeadingIcon",
  val labelTag: String = "TUIInputField_Label",
  val helperTextTag: String = "TUIInputField_HelperText",
  val helperIconTag: String = "TUIInputField_HelperIcon",
)