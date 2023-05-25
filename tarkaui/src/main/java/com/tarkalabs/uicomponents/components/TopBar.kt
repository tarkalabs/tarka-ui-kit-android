package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.theme.TUITheme

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
    containerColor = MaterialTheme.colorScheme.surface
  ),
  scrollBehavior: TopAppBarScrollBehavior? = null
) {

  var showSearchBar by remember {
    mutableStateOf(false)
  }

  TopAppBar(
    title = {
      Text(
        text = title,
        style = TUITheme.typography.heading5,
        color = MaterialTheme.colorScheme.onSurface
      )
    },
    navigationIcon = {
      if (navigationIcon != null) {
        IconButton(onClick = onNavigationIconClick) {
          Icon(
            painter = painterResource(id = navigationIcon.iconRes),
            contentDescription = "Back arrow"
          )
        }
      }
    },
    actions = {
      if (searchIcon != null) {
        IconButton(onClick = {
          showSearchBar = true
        }) {
          Icon(painter = painterResource(id = searchIcon.iconRes), contentDescription = "Search")
        }
      }

      if (menuItemIconThree != null) {
        IconButton(onClick = onThirdMenuItemClicked) {
          Icon(
            painter = painterResource(id = menuItemIconThree.iconRes),
            contentDescription = "Menu Item  three"
          )
        }
      }

      if (menuItemIconTwo != null) {
        IconButton(onClick = onSecondMenuItemClicked) {
          Icon(
            painter = painterResource(id = menuItemIconTwo.iconRes),
            contentDescription = "Menu Item two"
          )
        }
      }

      if (menuItemIconOne != null) {
        IconButton(onClick = onFirstMenuItemClicked) {
          Icon(
            painter = painterResource(id = menuItemIconOne.iconRes),
            contentDescription = "Menu Item one"
          )
        }
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
