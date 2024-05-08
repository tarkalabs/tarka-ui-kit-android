package com.tarkalabs.tarkaui.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.Circle12
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.theme.TUITheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

/**
 * A composable function that displays a horizontal tabRow with Tabs with or without icons.
 *
 * @param modifier - used to modify the properties of composable function
 * @param tabItems - list of items used to set the tab title & tab content in pager.
 * recommended to pass tabs that exceeds more than the device's width to use scroll feature effectively.
 * @param selectedTabIndex - int which decides the initial selected tab in tabRow. first tab index is 0 not 1.
 * @param tags - tags used to test the components.
 * @param onTabChanged - callback Invoked when the tab is changed by clicking tabRow or while scrolling content in pager.
 *
 * How to use TUITab() composable function
 *
    TUITab(
      isUserScrollEnabledOnContent = true,
      isPagerEnabled = true,
      tabItems = listOf(TabItem("TabName", TarkaIcons.Tabs24Regular),
      selectedTabIndex = 1,
      onTabChanged = {}
    )
 */

@Composable fun TUITabBar(
  modifier: Modifier = Modifier,
  tabItems: ImmutableList<TabItem>,
  selectedTabIndex: Int,
  tags: TUITabBarTags = TUITabBarTags(),
  onTabChanged: (Int) -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = modifier
      .testTag(tags.parentId)
      .wrapContentWidth()
      .horizontalScroll(rememberScrollState())
      .background(color = TUITheme.colors.secondaryAlt, shape = RoundedCornerShape(32.dp))
  ) {
    tabItems.forEachIndexed { index, item ->
      TUITab(
        title = item.name,
        isSelected = selectedTabIndex == index,
        leadingIcon = item.leadingTabIcon,
        ) {
        onTabChanged.invoke(index)
      }
    }

  }
}

data class TabItem(
  val name: String,
  val leadingTabIcon: TarkaIcon? = null,
)

data class TUITabBarTags(
  val parentId: String = "TUITabBar",
)

@Composable
@Preview(showBackground = true)
fun PreviewTUITabRow() {


  val tabItems = listOf(
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
    TabItem("Tab"),
  )
  val tabItemsWithIcons = listOf(
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
    TabItem("Tab", leadingTabIcon = Regular.Circle12),
  )

  TUITheme {
    var currentTab by remember {
      mutableStateOf(0)
    }
    var selectedTab by remember {
      mutableStateOf(0)
    }
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Top,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {

      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItems.toImmutableList(),
        selectedTabIndex = currentTab,
        onTabChanged = {
          currentTab = it
        }
      )

      VerticalSpacer(space = 10)

      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItemsWithIcons.toImmutableList(),
        selectedTabIndex = selectedTab,
        onTabChanged = {
          selectedTab = it
        }
      )

      VerticalSpacer(space = 10)

    }
  }
}
