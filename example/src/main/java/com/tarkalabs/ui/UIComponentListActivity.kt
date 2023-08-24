package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaicons.Search24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      var searchIcon by remember {
        mutableStateOf(true)
      }
      TUITheme {
        Scaffold(topBar = {
          TUITopBar(
            title = "Android Dev",
            modifier = Modifier.fillMaxWidth(),
            searchIcon = if(searchIcon) TarkaIcons.Regular.Search24 else null,
            onSearchQuery = {
            },
          )
        }) { paddingValues ->
          Column(
            modifier = Modifier
              .fillMaxSize()
              .background(color = TUITheme.colors.surface)
              .padding(paddingValues)
          ) {
          }

        }
      }
    }
  }
}
