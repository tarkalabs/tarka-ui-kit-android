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
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.Search24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.ChipType.Filter
import com.tarkalabs.uicomponents.components.TUIChip
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.components.VerticalSpacer
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
          TUITopBar(
            title = "Lorem Ipsum",
            navigationIcon = TarkaIcons.Regular.ChevronRight20,
            menuItemIconOne = TarkaIcons.Regular.ChevronRight20,
            menuItemIconTwo = TarkaIcons.Regular.ChevronRight20,
            menuItemIconThree = TarkaIcons.Regular.ChevronRight20,
            searchQuery = query,
            onSearchQuery = { searchQuery ->
              query = searchQuery
            },
            searchIcon = TarkaIcons.Regular.Search24,
            searchQueryHint = "Search Here"
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
            TUIChip(
              type = Filter(
                showLeadingCheck = true,
                selected = true,
              ),
              label = "spare_parts",
              onClick = {
              },
            )
            VerticalSpacer(space = 20)
            TUIChip(
              type = Filter(
                showLeadingCheck = true,
                selected = true,
                showTrailingCaret = true,
                trailingIcon = TarkaIcons.Regular.ChevronRight20,
              ),
              label = "spare_parts",
              onClick = {
              },
            )
            VerticalSpacer(space = 20)
            TUIChip(
              type = Filter(
                showLeadingCheck = true,
                selected = false,
                showTrailingCaret = true
              ),
              label = "Reset",
              onClick = {
              },
            )
            VerticalSpacer(space = 20)

          }

        }
      }
    }
  }
}
