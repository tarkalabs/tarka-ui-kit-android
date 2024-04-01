package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.IconButtonSize.XL
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.ChevronLeft24
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.ChevronRight24
import com.tarkalabs.tarkaui.icons.Search20
import com.tarkalabs.tarkaui.icons.Search24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Displays a customized top app bar with optional navigation icon, search icon, and menu item icons.
 *
 * @param title The title to be displayed in the top app bar.
 * @param navigationIcon The navigation icon to be displayed on the left side of the top app bar.
 * @param searchIcon The search icon to be displayed on the right side of the top app bar.
 * @param menuItemIconOne The first menu item icon to be displayed on the right side of the top app bar.
 * @param menuItemIconTwo The second menu item icon to be displayed on the right side of the top app bar.
 * @param menuItemIconThree The third menu item icon to be displayed on the right side of the top app bar.
 * @param onNavigationIconClick The callback function to be called when the navigation icon is clicked.
 * @param onFirstMenuItemClicked The callback function to be called when the first menu item icon is clicked.
 * @param onSecondMenuItemClicked The callback function to be called when the second menu item icon is clicked.
 * @param onThirdMenuItemClicked The callback function to be called when the third menu item icon is clicked.
 * @param onSearchQuery The callback function to be called when a search query is entered.
 * @param searchQueryHint the default search query hint that we need to show in searchbar
 * @param colors The colors to be applied to the top app bar.
 * @param searchQuery the default search text that we need to show in searchbar
 * @param scrollBehavior The scroll behavior to be applied to the top app bar.
 * How to use TUIAppTopBar()
  TUIAppTopBar(
    title = "My App",
    navigationIcon = TarkaIcon.Back, // Optional: Pass the navigation icon
    searchIcon = TarkaIcon.Search, // Optional: Pass the search icon
    menuItemIconOne = TarkaIcon.Menu, // Optional: Pass the first menu item icon
    menuItemIconTwo = TarkaIcon.Settings, // Optional: Pass the second menu item icon
    menuItemIconThree = TarkaIcon.Notifications, // Optional: Pass the third menu item icon
    onNavigationIconClick = { /* Handle navigation icon click */ },
    onFirstMenuItemClicked = { /* Handle first menu item click */ },
    onSecondMenuItemClicked = { /* Handle second menu item click */ },
    onThirdMenuItemClicked = { /* Handle third menu item click */ },
    onSearchQuery = { query -> /* Handle search query */ },
    colors = TopAppBarColors(/* Specify custom colors if needed */),
    scrollBehavior = TopAppBarScrollBehavior.ScrollOnAppBarScroll, // Optional: Specify scroll behavior
      )
 */
@OptIn(ExperimentalMaterial3Api::class) @Composable fun TUIAppTopBar(
  modifier: Modifier = Modifier,
  title: String,
  navigationIcon: TarkaIcon? = null,
  searchIcon: TarkaIcon? = null,
  menuItemIconOne: TarkaIcon? = null,
  menuItemIconTwo: TarkaIcon? = null,
  menuItemIconThree: TarkaIcon? = null,
  onNavigationIconClick: () -> Unit = {},
  onFirstMenuItemClicked: () -> Unit = {},
  onSecondMenuItemClicked: () -> Unit = {},
  onThirdMenuItemClicked: () -> Unit = {},
  onSearchQuery: (String) -> Unit = {},
  searchQuery: String = "",
  searchQueryHint: String = "",
  disableSearchIcon: Boolean = false,
  clearQueryAndHideSearchBar: Boolean = false,
  showSearchBar: Boolean = false,
  colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
    containerColor = TUITheme.colors.surface
  ),
  scrollBehavior: TopAppBarScrollBehavior? = null,
  keyboardOption: KeyboardOptions = KeyboardOptions.Default,
  keyboardAction: KeyboardActions = KeyboardActions.Default,
  tags: TUIAppTopBarTags = TUIAppTopBarTags(),
) {

  var showSearchBarState by remember {
    mutableStateOf(false)
  }

  if (clearQueryAndHideSearchBar && showSearchBarState) {
    showSearchBarState = false
    onSearchQuery("")
  }
  LaunchedEffect(key1 = showSearchBar) {
    showSearchBarState = showSearchBar
  }

  Column(
    modifier = modifier
      .background(color = TUITheme.colors.surface)
      .fillMaxWidth()
      .sizeIn(maxHeight = 64.dp)
      .wrapContentHeight(), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    if (showSearchBarState) {
      TUISearchBar(
        modifier = Modifier
          .fillMaxWidth()
          .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 8.dp),
        query = searchQuery,
        placeholder = searchQueryHint,
        leadingIcon = TarkaIcons.Regular.ChevronLeft24,
        onLeadingIconClick = {
          showSearchBarState = false
          onSearchQuery("")
        },
        onQueryTextChange = {
          onSearchQuery(it)
        },
        keyboardAction = keyboardAction,
        keyboardOption = keyboardOption)
    } else {
      TopAppBar(
        title = {
          Text(
            text = title,
            style = TUITheme.typography.heading5,
            color = TUITheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
          )
        },
        navigationIcon = {
          if (navigationIcon != null) {
            if (!showSearchBarState) {
              TUIIconButton(
                onIconClick = onNavigationIconClick,
                icon = navigationIcon,
                tags = tags.navigationIconTags,
                iconButtonStyle = Ghost,
                buttonSize = XL
              )
            }
          }
        },
        actions = {
          if (!showSearchBarState) {
            if (searchIcon != null) {
              TUIIconButton(
                icon = searchIcon,
                tags = tags.searchIconTags,
                iconButtonStyle = Ghost,
                onIconClick = {
                  if (!disableSearchIcon) {
                    showSearchBarState = true
                  }
                },
                buttonSize = XL
              )
            }

            if (menuItemIconThree != null) {
              TUIIconButton(
                icon = menuItemIconThree,
                tags = tags.menuIconThreeTags,
                iconButtonStyle = Ghost,
                onIconClick = onThirdMenuItemClicked,
                buttonSize = XL
              )
            }

            if (menuItemIconTwo != null) {
              TUIIconButton(
                onIconClick = onSecondMenuItemClicked,
                icon = menuItemIconTwo,
                tags = tags.menuIconTwoTags,
                iconButtonStyle = Ghost,
                buttonSize = XL
              )
            }

            if (menuItemIconOne != null) {
              TUIIconButton(
                onIconClick = onFirstMenuItemClicked,
                tags = tags.menuIconOneTags,
                icon = menuItemIconOne,
                iconButtonStyle = Ghost,
                buttonSize = XL
              )
            }
          }
        },
        colors = colors,
        modifier = Modifier.fillMaxWidth(),
        scrollBehavior = scrollBehavior,
      )
    }
    TUIDivider()
  }
}

data class TUIAppTopBarTags(
  val parentTag: String = "TUITopBar",
  val navigationIconTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_NavigationIcon"),
  val searchIconTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_SearchIcon"),
  val menuIconOneTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_MenuIconOne"),
  val menuIconTwoTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_MenuIconTwo"),
  val menuIconThreeTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUITopBar_MenuIconThree"),
)

@OptIn(ExperimentalMaterial3Api::class) @Preview @Composable fun EamNormalTopBar(
) {
  TUITheme {
    Column {
      TUIAppTopBar(
        title = "Lorem Ipsum",
        navigationIcon = TarkaIcons.Regular.ChevronRight24,
        menuItemIconOne = TarkaIcons.Regular.ChevronRight20,
        menuItemIconTwo = TarkaIcons.Regular.ChevronRight20,
        menuItemIconThree = TarkaIcons.Regular.ChevronRight20,
        searchQuery = "Search",
        onSearchQuery = { _ ->
        }, searchIcon = TarkaIcons.Regular.Search24, searchQueryHint = "Search"
      )
      VerticalSpacer(space = 5)
      TUIAppTopBar(
        title = "Lorem Ipsum",
        navigationIcon = TarkaIcons.Regular.ChevronRight20,
        searchIcon = TarkaIcons.Regular.Search20
      )
      VerticalSpacer(space = 5)
      TUIAppTopBar(
        title = "Lorem Ipsum",
        navigationIcon = TarkaIcons.Regular.ChevronRight20,
        searchIcon = TarkaIcons.Regular.Search20,
        showSearchBar = true
      )
    }
  }
}
