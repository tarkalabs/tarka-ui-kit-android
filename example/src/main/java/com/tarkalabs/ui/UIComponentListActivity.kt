package com.tarkalabs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.TUIAppTopBar
import com.tarkalabs.tarkaui.components.TUISearchBarState
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.Search24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {

        var searchbarState by remember {
          mutableStateOf(
            TUISearchBarState(
              searchQuery = "", searchQueryHint = "Search something"
            )
          )
        }

        Scaffold(topBar = {
          TUIAppTopBar(title = "Lorem Ipsum",
            navigationIcon = TarkaIcons.Regular.ChevronRight20,
            searchIcon = TarkaIcons.Regular.Search24,
            onSearchQuery = {
              searchbarState = searchbarState.copy(searchQuery = it)
            },
            onSearchIconClick = {
              searchbarState = searchbarState.copy(showSearchBar = !searchbarState.showSearchBar)
            },
            onSearchCloseIconClick = {
              searchbarState = searchbarState.copy(showSearchBar = !searchbarState.showSearchBar)
            },
            searchBarState = searchbarState
          )

        }) { paddingValues ->
          Column(
            modifier = Modifier
              .padding(paddingValues)
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(horizontal = 8.dp)
          ) {
            TUIButton(label = "Toggle Searchbar") {
              searchbarState = searchbarState.copy(showSearchBar = !searchbarState.showSearchBar, searchQuery = "Hello There")
            }
          }

        }
      }
    }
  }
}
