package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Circle12
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

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
  tabItems: List<TabItem>,
  selectedTabIndex: Int,
  tags: TUITabBarTags = TUITabBarTags(),
  onTabChanged: (Int) -> Unit,
) {
  Row(
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = modifier
      .wrapContentWidth()
      .horizontalScroll(rememberScrollState())
      .background(color = TUITheme.colors.secondaryAlt, shape = RoundedCornerShape(32.dp))
  ) {
    tabItems.forEachIndexed { index, item ->
      Tab(modifier = Modifier
        .testTag("${item.name} ${tags.tabId}")
        .padding(4.dp)
        .clip(RoundedCornerShape(32.dp))
        .background(if (selectedTabIndex == index) TUITheme.colors.secondary else Color.Transparent),
        selected = selectedTabIndex == index,
        selectedContentColor = TUITheme.colors.secondary,
        unselectedContentColor = TUITheme.colors.onSurface,
        onClick = {
          onTabChanged.invoke(index)
        }) {
        Row(
          modifier = Modifier.padding(start = if (item.leadingTabIcon != null) 6.dp else 0.dp),
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically
        ) {

          item.leadingTabIcon?.let {
            Icon(
              modifier = Modifier.size(20.dp),
              painter = painterResource(id = it.iconRes),
              contentDescription = it.contentDescription,
              tint = if (selectedTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
            )
          }

          Text(
            modifier = Modifier.padding(
              start = if (item.leadingTabIcon == null) 16.dp else 4.dp,
              end = 16.dp,
              top = 6.dp,
              bottom = 6.dp
            ),
            text = item.name,
            style = TUITheme.typography.button6,
            color = if (selectedTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
          )
        }

      }
    }

  }
}

data class TabItem(
  val name: String,
  val leadingTabIcon: TarkaIcon? = null,
  val content: @Composable () -> Unit,
)

data class TUITabBarTags(
  val parentId: String = "TUITabBar",
  val tabId: String = "TUITabBar_TabTag",
  val contentId: String = "TUITabBar_PagerContentTag",
)

@Composable
@Preview(showBackground = true)
fun PreviewTUITabRow() {


  val tabItems = listOf(
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
    TabItem("Tab") {},
  )
  val tabItemsWithIcons = listOf(
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
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
        tabItems = tabItems,
        selectedTabIndex = currentTab,
        onTabChanged = {
          currentTab = it
        }
      )

      VerticalSpacer(space = 10)

      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItemsWithIcons,
        selectedTabIndex = selectedTab,
        onTabChanged = {
          selectedTab = it
        }
      )

      VerticalSpacer(space = 10)

    }
  }
}
