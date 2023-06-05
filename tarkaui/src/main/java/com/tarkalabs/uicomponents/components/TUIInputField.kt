package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Alert
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Disabled
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Error
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Focused
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Inactive
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Success
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIInputFieldStatus {
  Inactive,
  Focused,
  Error,
  Success,
  Alert,
  Disabled
}

@Composable
fun TUIInputField(
  modifier: Modifier = Modifier,
  value: String,
  label: String? = null,
  onValueChange: (String) -> Unit,
  status: TUIInputFieldStatus,
  leadingIcon: TarkaIcon? = null,
  trailingIcon: TarkaIcon? = null,
  helperMessage: String? = null
) {

  val icon = iconFor(status)
  val colors = colorsFor(status)

  val leadingIconLambda: @Composable () -> Unit = {
    if (leadingIcon != null)
      Icon(
        painter = painterResource(id = leadingIcon.iconRes),
        contentDescription = leadingIcon.contentDescription
      )
  }
  val tailingIconLambda: @Composable () -> Unit = {
    if (trailingIcon != null)
      Icon(
        painter = painterResource(id = trailingIcon.iconRes),
        contentDescription = trailingIcon.contentDescription
      )
  }
  val labelLambda: @Composable () -> Unit = {
    if (label != null)
      Text(text = label, style = TUITheme.typography.body6, color = TUITheme.colors.inputDim)
  }
  TextField(
    shape = RoundedCornerShape(8.dp),
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    enabled = status != Disabled,
    colors = colors,
    singleLine = true,
    label = if (label != null) labelLambda else null,
    leadingIcon = if (leadingIcon != null) leadingIconLambda else null,
    trailingIcon = if (trailingIcon != null) tailingIconLambda else null,
    supportingText = {
      if (helperMessage != null) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          if (icon != null)
            Icon(
              painter = painterResource(id = icon.iconRes),
              contentDescription = icon.contentDescription
            )
          Text(
            text = helperMessage,
            style = TUITheme.typography.heading7,
            color = TUITheme.colors.inputText
          )
        }
      }
    }
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
  val focusedIndicatorColor = when (status) {
    Inactive -> TUITheme.colors.utilityDisabledBackground
    Focused -> TUITheme.colors.primary
    Error -> TUITheme.colors.error
    Success -> TUITheme.colors.success
    Alert -> TUITheme.colors.warning
    Disabled -> TUITheme.colors.utilityDisabledBackground
  }
  return TextFieldDefaults.colors()
  return TextFieldDefaults.colors(
    focusedIndicatorColor = focusedIndicatorColor,
    unfocusedIndicatorColor = TUITheme.colors.utilityDisabledContent,
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
