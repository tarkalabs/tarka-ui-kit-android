package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.tab.TUITabBar
import com.tarkalabs.tarkaui.components.tab.TabItem
import com.tarkalabs.tarkaui.icons.Circle12
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable fun TUITabBarComposable() {
  Column(
    Modifier
      .fillMaxSize()
      .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "TUITabBar", style = TUITheme.typography.heading3)
    TUITabBar(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
      tabItems = listOf(
        TabItem("Tab", leadingTabIcon = Regular.Circle12),
        TabItem("Tab", leadingTabIcon = Regular.Circle12),
        TabItem("Tab", leadingTabIcon = Regular.Circle12)
      ),
      selectedTabIndex = 0,
      onTabChanged = {},
    )
  }
}