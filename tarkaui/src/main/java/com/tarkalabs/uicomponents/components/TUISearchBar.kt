package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun TUISearchBar(
  modifier: Modifier = Modifier,
  value: String,
  label: String,
  onValueChange: (String) -> Unit,
  leadingIcon: TarkaIcon? = null,
  trailingIcon: TarkaIcon? = null,
  onTrailingIconClick: (() -> Unit)? = null,
  onLeadingIconClick: (() -> Unit)? = null,
) {
  TextField(
    colors = TextFieldDefaults.colors(
      focusedContainerColor = TUITheme.colors.inputBackground,
      focusedIndicatorColor = Color.Transparent,
      disabledIndicatorColor = Color.Transparent,
      errorIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent,
    ),
    label = { Text(text = label) },
    shape = RoundedCornerShape(75.dp),
    modifier = modifier,
    value = value,
    onValueChange = onValueChange,
    leadingIcon = {
      if (leadingIcon != null)
        TUIIconButton(
          icon = leadingIcon,
          buttonSize = IconButtonSize.L,
          iconButtonStyle = GHOST,
          onIconClick = onLeadingIconClick!!
        )
    },
    trailingIcon = {
      if (trailingIcon != null)
        TUIIconButton(
          icon = trailingIcon,
          buttonSize = IconButtonSize.L,
          iconButtonStyle = GHOST,
          onIconClick = onTrailingIconClick!!
        )
    }
  )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
  TUISearchBar(
    value = "",
    label = "Search",
    onValueChange = {},
    leadingIcon = TarkaIcons.Dismiss16Filled
  )
}

// todo how to deal with the bottom indicator? currently I am changing its color