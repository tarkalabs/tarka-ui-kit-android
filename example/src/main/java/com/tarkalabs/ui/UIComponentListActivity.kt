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
import com.tarkalabs.tarkaicons.BarcodeScanner24
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.Dismiss16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.TarkaIcons.Filled
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUISearchBar
import com.tarkalabs.uicomponents.components.TUIAppTopBar
import com.tarkalabs.uicomponents.theme.TUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        var query by remember {
          mutableStateOf("")
        }

        Scaffold(topBar = {
          TUIAppTopBar(
            title = "Lorem Ipsum",
            navigationIcon = TarkaIcons.Regular.ChevronRight20,
            menuItemIconOne = TarkaIcons.Regular.ChevronRight20,
            menuItemIconTwo = TarkaIcons.Regular.ChevronRight20,
            menuItemIconThree = TarkaIcons.Regular.ChevronRight20,
          )

        }) { paddingValues ->
          Column(
            modifier = Modifier
              .padding(paddingValues)
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(horizontal = 8.dp)
          ) {
            TUISearchBar(
              query = "My Search",
              placeholder = "Search",
              onQueryTextChange = {},
              trailingIcon = Filled.Dismiss16,
              leadingIcon = Regular.BarcodeScanner24,
              onLeadingIconClick = {},
              modifier = Modifier.fillMaxWidth().padding(10.dp),
            )
            TUISearchBar(
              query = "Search",
              placeholder = "Search Here",
              onQueryTextChange = {},
              trailingIcon = Filled.Dismiss16,
              leadingIcon = Regular.BarcodeScanner24,
              onLeadingIconClick = {},
              modifier = Modifier.fillMaxWidth().padding(10.dp),
            )

          }

        }
      }
    }
  }
}
