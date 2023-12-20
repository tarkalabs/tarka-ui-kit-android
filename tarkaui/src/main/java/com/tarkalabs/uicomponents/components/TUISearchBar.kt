package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.SearchBarDefaults.inputFieldColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.BarcodeScanner24
import com.tarkalabs.tarkaicons.Dismiss16
import com.tarkalabs.tarkaicons.Dismiss24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.IconButtonSize.L
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class) @Composable fun TUISearchBar(
  modifier: Modifier = Modifier,
  query: String,
  placeholder: String,
  trailingIcon: TarkaIcon = TarkaIcons.Regular.Dismiss24,
  onQueryTextChange: (String) -> Unit,
  leadingIcon: TarkaIcon? = null,
  onLeadingIconClick: (() -> Unit)? = null,
  searchBarTags: TUISearchBarTags = TUISearchBarTags(),
) {
  val focusRequester = remember { FocusRequester() }

  LaunchedEffect(Unit) {
    delay(500)
    focusRequester.requestFocus()
  }

  val leadingIconLambda: @Composable (() -> Unit)? = if (leadingIcon != null) {
    {
      TUIIconButton(
        icon = leadingIcon,
        buttonSize = L,
        iconButtonStyle = GHOST,
        onIconClick = {
          onLeadingIconClick?.invoke()
        },
        tags = searchBarTags.leadingIconTags
      )
    }
  } else null

  val trailingIconLambda: @Composable (() -> Unit)? = if (query.isNotEmpty()) {
    {
      TUIIconButton(
        icon = trailingIcon, buttonSize = L, iconButtonStyle = GHOST, onIconClick = {
          onQueryTextChange.invoke("")
        }, tags = searchBarTags.trailingIconTags
      )
    }
  } else null

  SearchBar(
    modifier = modifier
      .testTag(searchBarTags.parentTag)
      .focusRequester(focusRequester)
    ,
    query = query,
    onQueryChange = {
      onQueryTextChange.invoke(it)
    },
    onSearch = {
      onQueryTextChange.invoke(it)
    },
    active = false,
    onActiveChange = {},
    shape = RoundedCornerShape(75.dp),
    leadingIcon = leadingIconLambda,
    trailingIcon = trailingIconLambda,
    placeholder = { Text(text = placeholder) },
    colors = SearchBarDefaults.colors(
      containerColor = TUITheme.colors.inputBackground,
      dividerColor = Color.Transparent,
      inputFieldColors = inputFieldColors(
        cursorColor = TUITheme.colors.inputText,
        focusedTextColor = TUITheme.colors.inputText,
        unfocusedPlaceholderColor = TUITheme.colors.inputText,
        focusedPlaceholderColor = TUITheme.colors.inputText,
      ),
    ),
    enabled = true
  ) {}
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

