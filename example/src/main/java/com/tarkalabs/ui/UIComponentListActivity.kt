package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TUITheme {
        TUITopBar(
          title = "Setting Screen",
          navigationIcon = TarkaIcons.ChevronRight,
          onNavigationIconClick = {},
          menuItemIconOne = TarkaIcons.ChevronRight,
          menuItemIconTwo = TarkaIcons.Copy,
          menuItemIconThree = TarkaIcons.Delete
        )
      }
    }
  }
}