package com.tarkalabs.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.components.TextRowStyle.Title
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        val query by remember {
          mutableStateOf("")
        }

        Scaffold(topBar = {
          TUITopBar(
            title = "Lorem Ipsum",
            navigationIcon = Regular.ChevronRight20,
            searchIcon = Regular.ChevronRight20,
            searchQuery = query,
            searchQueryHint = "search Query Hint"
          )
        }) { paddingValues ->
          Column(
            modifier = Modifier
              .fillMaxSize()
              .background(color = TUITheme.colors.surface)
              .padding(paddingValues)

          ) {

            TUITextRow(
              title = "Title",
              style = Title,
              infoIcon = Regular.ChevronRight20,
              onTextRowClick = {
                Log.d("TAG", "TUITextRowPreview: ")
              },
              onInfoIconClick = null,
              paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
            )

            TUITextRow(
              title = "Title",
              style = Title,
              infoIcon = Regular.ChevronRight20,
              onTextRowClick = {
                Log.d("TAG", "TUITextRowPreview: ")
              },
              onInfoIconClick = null,
              paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
            )
            TUITextRow(
              title = "Title",
              style = Title,
              infoIcon = Regular.ChevronRight20,
              onTextRowClick = {
                Log.d("TAG", "TUITextRowPreview: ")
              },
              onInfoIconClick = null,
              paddingValues = PaddingValues(horizontal = 20.dp, vertical = 0.dp)
            )
          }

        }
      }
    }
  }
}
