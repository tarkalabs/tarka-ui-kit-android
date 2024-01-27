package com.tarkalabs.uicomponents.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * The TUIFloatingNavBar is a composable function designed to create a customizable floating tab in a user interface.
 * @param modifier A modifier for the tab's layout and behavior.
 * @param tabItems list of tab title.
 * @param selectedTabIndex  current selected tab in the tab bar.
 * @param onTabSelected callback method when tab is selected.
 *
 * How To use TUIFloatingTab()
 *
 * TUIFloatingNavBar(tabItems = listOf("Tab 1","Tab 1"), onTabSelected = {]})
 *
 */
@Composable fun TUIFloatingNavBar(
  modifier: Modifier = Modifier,
  tabItems: List<String>,
  selectedTabIndex: Int = 0,
  onTabSelected: (currentTabItem: Int) -> Unit
) {
  Row(
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = modifier
      .horizontalScroll(rememberScrollState())
      .background(color = TUITheme.colors.primaryAltHover, shape = RoundedCornerShape(32.dp))
      .border(
        width = 1.dp,
        color = TUITheme.colors.primaryAltHover,
        shape = RoundedCornerShape(32.dp)
      )
      .padding(4.dp),
  ) {
    tabItems.forEachIndexed { index, tab ->
      TUIFloatingTab(title = tab,
        selected = selectedTabIndex == index,
        onSelected = {
        onTabSelected.invoke(index)
      },
        tags = TUIFloatingTabTags(parentTag = "${tab}_${index}")
      )
    }

  }
}

@Preview @Composable fun TUIFloatingNavBarPreview() {
  TUITheme {

    var currentTabItem by remember {
      mutableStateOf(0)
    }

    val tabItems = listOf(
      "Tab 1",
      "Tab 2",
      "Tab 3",
      "Tab 4",
      "Tab 5",
      "Tab 6",
      "Tab 7",
      "Tab 8",
      "Tab 9",
      "Tab 10",
      "Tab 11",
    )
    Column(
      modifier = Modifier
        .background(color = TUITheme.colors.error)
        .fillMaxWidth()
        .padding(10.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      VerticalSpacer(space = 40)
      TUIFloatingNavBar(tabItems = tabItems, onTabSelected = {
        currentTabItem = it
      }, selectedTabIndex = currentTabItem)
      VerticalSpacer(space = 40)
    }
  }
}