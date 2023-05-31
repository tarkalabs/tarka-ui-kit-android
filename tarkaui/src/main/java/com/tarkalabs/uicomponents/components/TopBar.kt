package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.theme.TUITheme

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
 * @param colors The colors to be applied to the top app bar.
 * @param scrollBehavior The scroll behavior to be applied to the top app bar.
 * How to use TopBar()
TopBar(
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
@OptIn(ExperimentalMaterial3Api::class) @Composable fun TopBar(
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
  colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
    containerColor = TUITheme.colors.surface
  ),
  scrollBehavior: TopAppBarScrollBehavior? = null,
) {

  var showSearchBar by remember {
    mutableStateOf(false)
  }

  TopAppBar(
    title = {
      Text(
        text = title,
        style = TUITheme.typography.heading5,
        color = TUITheme.colors.onSurface
      )
    },
    navigationIcon = {
      if (navigationIcon != null) {
        TUIIconButton(
          onIconClick = onNavigationIconClick,
          icon = navigationIcon,
          testTag = navigationIcon.contentDescription,
          iconButtonStyle = GHOST
        )
      }
    },
    actions = {
      if (searchIcon != null) {
        TUIIconButton(
          icon = searchIcon,
          testTag = searchIcon.contentDescription,
          iconButtonStyle = GHOST, onIconClick = {
            showSearchBar = true
          }
        )
      }

      if (menuItemIconThree != null) {
        TUIIconButton(
          icon = menuItemIconThree,
          testTag = menuItemIconThree.contentDescription,
          iconButtonStyle = GHOST,
          onIconClick = onThirdMenuItemClicked
        )

      }

      if (menuItemIconTwo != null) {
        TUIIconButton(
          onIconClick = onSecondMenuItemClicked,
          icon = menuItemIconTwo,
          testTag = menuItemIconTwo.contentDescription,
          iconButtonStyle = GHOST,
        )
      }

      if (menuItemIconOne != null) {
        TUIIconButton(
          onIconClick = onFirstMenuItemClicked,
          testTag = menuItemIconOne.contentDescription,
          icon = menuItemIconOne,
          iconButtonStyle = GHOST,
        )
      }

    },
    colors = colors,
    modifier = Modifier.fillMaxWidth(),
    scrollBehavior = scrollBehavior,
  )
}

@OptIn(ExperimentalMaterial3Api::class) @Composable fun EamNormalTopBar(
  title: String, navigationIcon: TarkaIcon? = null
) {
  TopBar(title = title, navigationIcon = navigationIcon)
}
