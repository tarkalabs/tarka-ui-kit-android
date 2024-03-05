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
import com.tarkalabs.tarkaui.components.VerticalSpacer
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
        var query by remember {
          mutableStateOf("")
        }

        var showSearchbar by remember {
          mutableStateOf(false)
        }

        Scaffold(topBar = {
          TUIAppTopBar(
            title = "Lorem Ipsum",
            navigationIcon = TarkaIcons.Regular.ChevronRight20,
            menuItemIconOne = TarkaIcons.Regular.ChevronRight20,
            menuItemIconTwo = TarkaIcons.Regular.ChevronRight20,
            menuItemIconThree = TarkaIcons.Regular.ChevronRight20,
            searchIcon = TarkaIcons.Regular.Search24,
            searchQuery = query,
            searchQueryHint = "Search something",
            onSearchQuery = {
              query = it
            },
            showSearchBar = showSearchbar
          )

        }) { paddingValues ->
          Column(
            modifier = Modifier
              .padding(paddingValues)
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(horizontal = 8.dp)
          ) {
            VerticalSpacer(space = 20)
            TUIButton(label = "Show Searchbar") {
              query = "Hello there"
              showSearchbar = true
            }
            VerticalSpacer(space = 20)
            TUIButton(label = "Hide Searchbar") {
              query = ""
              showSearchbar = false
            }
          }

        }
      }
    }
  }
}
