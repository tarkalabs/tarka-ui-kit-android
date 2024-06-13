package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.IconButtonSize.L
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.BarcodeScanner24
import com.tarkalabs.tarkaui.icons.Dismiss16
import com.tarkalabs.tarkaui.icons.Dismiss24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class) @Composable fun TUISearchBar(
  modifier: Modifier = Modifier,
  query: String,
  placeholder: String,
  trailingIcon: TarkaIcon = TarkaIcons.Regular.Dismiss24,
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  onQueryTextChange: (String) -> Unit,
  leadingIcon: TarkaIcon? = null,
  onLeadingIconClick: (() -> Unit)? = null,
  isInitialAutoFocus: Boolean = true,
  searchBarTags: TUISearchBarTags = TUISearchBarTags(),
) {
  val focusRequester = remember { FocusRequester() }

  LaunchedEffect(isInitialAutoFocus) {
    if (isInitialAutoFocus) {
      delay(500)
      focusRequester.requestFocus()
    }
  }

  val leadingIconLambda: @Composable (() -> Unit)? = if (leadingIcon != null) {
    {
      TUIIconButton(
        icon = leadingIcon, buttonSize = L, iconButtonStyle = Ghost, onIconClick = {
          onLeadingIconClick?.invoke()
        }, tags = searchBarTags.leadingIconTags
      )
    }
  } else null

  val trailingIconLambda: @Composable (() -> Unit)? = if (query.isNotEmpty()) {
    {
      TUIIconButton(
        icon = trailingIcon, buttonSize = L, iconButtonStyle = Ghost, onIconClick = {
          onQueryTextChange.invoke("")
        }, tags = searchBarTags.trailingIconTags
      )
    }
  } else null
  val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

  BasicTextField(
    value = query,
    onValueChange = onQueryTextChange,
    modifier = modifier
      .testTag(searchBarTags.parentTag)
      .focusRequester(focusRequester)
      .height(48.dp),
    singleLine = true,
    interactionSource = interactionSource,
    textStyle = TUITheme.typography.body6.copy(color = TUITheme.colors.inputText),
    keyboardActions = keyboardAction,
    keyboardOptions = keyboardOption
  ) { innerTextField ->
    TextFieldDefaults.DecorationBox(
      value = query,
      innerTextField = innerTextField,
      enabled = true,
      singleLine = true,
      visualTransformation = VisualTransformation.None,
      interactionSource = interactionSource,
      contentPadding = TextFieldDefaults.contentPaddingWithoutLabel(
        top = 0.dp, bottom = 0.dp, end = 10.dp, start = 10.dp
      ),
      colors = TextFieldDefaults.colors(
        cursorColor = TUITheme.colors.inputText,
        focusedTextColor = TUITheme.colors.inputText,
        unfocusedTextColor = TUITheme.colors.inputText,
        unfocusedPlaceholderColor = TUITheme.colors.inputText.copy(alpha = 0.7f),
        focusedPlaceholderColor = TUITheme.colors.inputText.copy(alpha = 0.7f),
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        focusedContainerColor = TUITheme.colors.inputBackground,
        unfocusedContainerColor = TUITheme.colors.inputBackground,
      ),
      shape = RoundedCornerShape(75.dp),
      placeholder = { Text(text = placeholder) },
      leadingIcon = leadingIconLambda,
      trailingIcon = trailingIconLambda,
    )
  }
}

data class TUISearchBarTags(
  val parentTag: String = "TUISearchBar",
  val leadingIconTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUISearchBar_LeadingIcon"),
  val trailingIconTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUISearchBar_TrailingIcon")
)

@Preview(showBackground = true, showSystemUi = true) @Composable fun Preview() {
  TUITheme {
    Column(
      modifier = Modifier.padding(20.dp)
    ) {
      TUISearchBar(
        query = "",
        placeholder = "Search",
        onQueryTextChange = {},
        trailingIcon = TarkaIcons.Filled.Dismiss16,
        leadingIcon = TarkaIcons.Regular.BarcodeScanner24,
        onLeadingIconClick = {},
        modifier = Modifier.padding(10.dp),
      )

      TUISearchBar(
        query = "My Search",
        placeholder = "Search",
        onQueryTextChange = {},
        trailingIcon = TarkaIcons.Filled.Dismiss16,
        leadingIcon = TarkaIcons.Regular.BarcodeScanner24,
        onLeadingIconClick = {},
        modifier = Modifier.padding(10.dp),
      )
    }
  }
}

