package com.tarkalabs.tarkaui.components.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.HorizontalSpacer
import com.tarkalabs.tarkaui.components.base.TUIInputFieldContentType.Icon
import com.tarkalabs.tarkaui.components.base.TUIInputFieldContentType.Text
import com.tarkalabs.tarkaui.components.base.TUIInputFieldStatus.Alert
import com.tarkalabs.tarkaui.components.base.TUIInputFieldStatus.Error
import com.tarkalabs.tarkaui.components.base.TUIInputFieldStatus.Normal
import com.tarkalabs.tarkaui.components.base.TUIInputFieldStatus.Success
import com.tarkalabs.tarkaui.components.base.TUIInputFieldType.InputField
import com.tarkalabs.tarkaui.components.base.TUIInputFieldType.LookupInputField
import com.tarkalabs.tarkaui.extentions.clickableWithoutRipple
import com.tarkalabs.tarkaui.icons.CheckmarkCircle16
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.Timer20
import com.tarkalabs.tarkaui.icons.Warning12
import com.tarkalabs.tarkaui.theme.TUITheme

enum class TUIInputFieldStatus {
  Normal,
  Error,
  Success,
  Alert,
}

/**
 * this enum defines the type of TUIInputField
 * NormalInputField -> it will allow user to input via keyboard in TUIInputField
 * LookupInputField -> it will restrict user's to input via keyboard and allow user's to get click event and set different color style of TUIInputField
 */
enum class TUIInputFieldType {
  InputField,
  LookupInputField
}

sealed class TUIInputFieldContentType {
  data class Icon(val icon: TarkaIcon, val onIconClick: (() -> Unit)? = null,) : TUIInputFieldContentType()
  data class Text(val text: String) : TUIInputFieldContentType()
}

/**
 * A  Composable function that renders an text field with various options such as label, icons, status, and helper text.
 *
 * @param modifier The modifier for styling or positioning the input field.
 * @param value The current value of the input field.
 * @param label The label text to display above the input field.
 * @param onValueChange A callback function invoked when the value of the input field changes.
 * @param status The status of the input field, such as Enabled, Disabled, Error, etc.
 * @param leadingContent The icon to display on the leading side of the input field.
 * @param trailingContent The icon to display on the trailing side of the input field.
 * @param helperMessage The helper message to display below the input field.
 * @param testTags Tags for testing purposes to identify specific elements within the input field.
 * @param inputFieldTye Set the type of InputField either NormalInputField or LookupInputField
 */
@Composable fun TUIInputField(
  modifier: Modifier = Modifier,
  value: String,
  label: String? = null,
  onValueChange: (String) -> Unit,
  status: TUIInputFieldStatus,
  enabled: Boolean = true,
  leadingContent: TUIInputFieldContentType? = null,
  trailingContent: TUIInputFieldContentType? = null,
  helperMessage: String? = null,
  testTags: TUIInputFieldTags = TUIInputFieldTags(),
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  maxLines: Int = 1,
  minLines: Int = 1,
  maxCharLength: Int = Int.MAX_VALUE,
  singleLine: Boolean = false,
  inputShape: Shape = RoundedCornerShape(8.dp),
  inputFieldTye: TUIInputFieldType = InputField
) {

  val icon = iconFor(status)
  val colors = colorsFor(status, inputFieldTye)

  val leadingIconLambda: @Composable () -> Unit = {
    if (leadingContent != null) when (leadingContent) {
      is Icon -> Icon(
        painter = painterResource(id = leadingContent.icon.iconRes),
        contentDescription = leadingContent.icon.contentDescription,
        modifier = Modifier.testTag(testTags.leadingContentTag),
        tint = TUITheme.colors.inputText
      )

      is Text -> Text(
        text = leadingContent.text.take(1),
        style = TUITheme.typography.body5,
        color = TUITheme.colors.inputDim,
        modifier = Modifier.testTag(testTags.leadingContentTag),
      )
    }

  }
  val tailingIconLambda: @Composable () -> Unit = {
    if (trailingContent != null) when (trailingContent) {
      is Icon -> Icon(painter = painterResource(id = trailingContent.icon.iconRes),
        contentDescription = trailingContent.icon.contentDescription,
        modifier = Modifier
          .testTag(testTags.trailingContentTag)
          .then(if (trailingContent.onIconClick == null) Modifier else Modifier.clickableWithoutRipple {
            trailingContent.onIconClick.invoke()
          }),
        tint = TUITheme.colors.inputText)

      is Text -> Text(
        text = trailingContent.text.take(1),
        style = TUITheme.typography.body5,
        color = TUITheme.colors.inputTextDim.copy(alpha = 0.7f),
        modifier = Modifier.testTag(testTags.trailingContentTag),
      )
    }

  }
  val labelLambda: @Composable () -> Unit = {
    if (label != null) Text(
      text = label,
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
    enabled = enabled && inputFieldTye == InputField,
    singleLine = singleLine,
    colors = colors,
    label = if (label != null) labelLambda else null,
    leadingIcon = if (leadingContent != null) leadingIconLambda else null,
    trailingIcon = if (trailingContent != null) tailingIconLambda else null,
    keyboardOptions = keyboardOption,
    keyboardActions = keyboardAction,
    supportingText = helperMessageLambda,
    maxLines = maxLines,
    minLines = minLines,
    textStyle = TUITheme.typography.body6
  )
}

fun iconFor(status: TUIInputFieldStatus): TarkaIcon? {
  return when (status) {
    Success -> TarkaIcons.Regular.CheckmarkCircle16
    Alert -> TarkaIcons.Regular.Warning12
    else -> null
  }
}

@Composable fun colorsFor(
  status: TUIInputFieldStatus,
  inputFieldTye: TUIInputFieldType
): TextFieldColors {
  val focusedIndicatorColor = indicatorColorFor(status)

  var disabledLabelColor = TUITheme.colors.inputDim
  var disabledTextColor = TUITheme.colors.utilityDisabledContent

  when (inputFieldTye) {
    InputField -> {
      disabledTextColor = TUITheme.colors.utilityDisabledContent
      disabledLabelColor = TUITheme.colors.inputDim
    }
    LookupInputField -> {
      disabledLabelColor = TUITheme.colors.inputDim
      disabledTextColor = TUITheme.colors.inputText
    }
  }

  return TextFieldDefaults.colors(
    focusedLabelColor = TUITheme.colors.inputDim,
    focusedTextColor = TUITheme.colors.inputText,
    focusedIndicatorColor = focusedIndicatorColor,
    focusedContainerColor = TUITheme.colors.inputBackground,
    unfocusedLabelColor = TUITheme.colors.inputDim,
    unfocusedTextColor = TUITheme.colors.inputText,
    unfocusedIndicatorColor = TUITheme.colors.utilityDisabledBackground,
    unfocusedContainerColor = TUITheme.colors.inputBackground,
    disabledLabelColor = disabledLabelColor,
    disabledTextColor = disabledTextColor,
    disabledContainerColor = TUITheme.colors.inputBackground,
    disabledIndicatorColor =  Color.Transparent,
    errorLabelColor = TUITheme.colors.inputDim,
    errorContainerColor = TUITheme.colors.inputBackground,
  )
}

@Composable private fun indicatorColorFor(status: TUIInputFieldStatus) = when (status) {
  Normal -> TUITheme.colors.primary
  Error -> TUITheme.colors.error
  Success -> TUITheme.colors.success
  Alert -> TUITheme.colors.warning
}

@Preview(showBackground = true) @Composable fun TUIPreview() {
  TUITheme {
    var textValue by remember {
      mutableStateOf("")
    }
    Box(modifier = Modifier.padding(10.dp)) {
      TUIInputField(leadingContent = Text("$"),
        trailingContent = Icon(TarkaIcons.Regular.Timer20),
        value = textValue,
        onValueChange = { textValue = it },
        status = Success,
        inputFieldTye = LookupInputField,
        label = "Label",
        modifier = Modifier.clickable {
          textValue = "Hello World"
        })

    }
  }
}

@Preview(showBackground = true) @Composable fun TUIPreviewDark() {
  TUITheme(true) {
    var textValue by remember {
      mutableStateOf("hello world")
    }
    TUIInputField(
      leadingContent = Text("$"),
      trailingContent = Icon(TarkaIcons.Regular.Timer20),
      value = textValue,
      onValueChange = { textValue = it },
      status = Success
    )
  }
}

data class TUIInputFieldTags(
  val parentTag: String = "TUIInputField_InputField",
  val trailingContentTag: String = "TUIInputField_TrailingContent",
  val leadingContentTag: String = "TUIInputField_LeadingContent",
  val labelTag: String = "TUIInputField_Label",
  val helperTextTag: String = "TUIInputField_HelperText",
  val helperIconTag: String = "TUIInputField_HelperIcon",
)