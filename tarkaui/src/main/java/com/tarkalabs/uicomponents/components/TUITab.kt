package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

/**
 * A composable function that displays a horizontal tabRow with Tabs with or without icons.
 *
 * @param modifier - used to modify the properties of composable function
 * @param isPagerEnabled - used to hide/show the horizontal pager below the tabRow.
 * @param isUserScrollEnabledOnContent - Specifies whether the user can able to scroll the content in horizontal pager or not.
 * @param tabItems - list of items used to set the tab title & tab content in pager.
 * recommended to pass tabs that exceeds more than the device's width to use scroll feature effectively.
 * @param selectedTabIndex - int which decides the initial selected tab in tabRow. first tab index is 0 not 1.
 * @param tags - tags used to test the components.
 * @param onTabChanged - callback Invoked when the tab is changed by clicking tabRow or while scrolling content in pager.
 *
 * How to use TUITab() composable function
 *
 *      TUITab(
 *      isUserScrollEnabledOnContent = true,
isPagerEnabled = true,
tabItems = listOf(TabItem("TabName", TarkaIcons.Tabs24Regular),
selectedTabIndex = 1,
onTabChanged = {}
)
 */

@OptIn(ExperimentalFoundationApi::class) @Composable fun TUITab(
  modifier: Modifier = Modifier,
  isPagerEnabled: Boolean,
  isUserScrollEnabledOnContent: Boolean,
  tabItems: List<TabItem>,
  selectedTabIndex: Int,
  tags: TUITabTags = TUITabTags(),
  onTabChanged: (Int) -> Unit,
) {

  //state used when pager is disabled
  val currentTab = remember { mutableStateOf(selectedTabIndex) }

  //state used when pager is enabled
  //because pager in compose accepts only pagerState as a state
  val pagerState = rememberPagerState(selectedTabIndex)

  Column(
    modifier = modifier.wrapContentSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
  ) {

    val scope = rememberCoroutineScope()

    val currentTabIndex = if (isPagerEnabled) {
      pagerState.currentPage
    } else {
      currentTab.value
    }

    Row(
      horizontalArrangement = Arrangement.SpaceAround,
      modifier = Modifier
        .wrapContentWidth()
        .horizontalScroll(rememberScrollState())
        .clip(RoundedCornerShape(30.dp))
        .background(TUITheme.colors.secondaryAlt)
    )
    {

      tabItems.forEachIndexed { index, item ->

        Tab(modifier = Modifier
          .testTag("${item.name} ${tags.tabId}")
          .padding(4.dp)
          .clip(RoundedCornerShape(30.dp))
          .background(if (currentTabIndex == index) TUITheme.colors.secondary else Color.Transparent),
          selected = currentTabIndex == index,
          selectedContentColor = TUITheme.colors.secondary,
          unselectedContentColor = TUITheme.colors.onSurface,
          onClick = {
            onTabChanged.invoke(index)
            scope.launch {
              if (isPagerEnabled) {
                pagerState.animateScrollToPage(index)
              } else {
                currentTab.value = index
              }
            }
          }) {
          Row(
            modifier = Modifier.padding(start = 6.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
          ) {

            item.leadingTabIcon?.let {
              Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = it.iconRes),
                contentDescription = it.contentDescription,
                tint = if (currentTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
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
              color = if (currentTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
            )
          }

        }
      }

    }

    VerticalSpacer(space = 5)

    if (isPagerEnabled) {
      HorizontalPager(
        modifier = Modifier
          .fillMaxHeight(),
        pageCount = tabItems.count(),
        state = pagerState,
        userScrollEnabled = isUserScrollEnabledOnContent,
      ) { tabIndex ->
        Column(
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally,
          modifier = Modifier
            .testTag("${tags.contentId}$tabIndex")
        ) {
          tabItems[tabIndex].content.invoke()
        }
      }
    }

  }

  if (isPagerEnabled) {
    LaunchedEffect(pagerState) {
      snapshotFlow { pagerState.currentPage }.distinctUntilChanged().collect(onTabChanged)
    }
  }
}

data class TabItem(
  val name: String,
  val leadingTabIcon: TarkaIcon? = null,
  val content: @Composable () -> Unit,
)

data class TUITabTags(
  val parentId: String = "ScrollableTab",
  val tabId: String = "Tab",
  val contentId: String = "PagerContent",
)

@Composable @Preview(showBackground = true) fun PreviewTUITabRow() {

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
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
    TabItem("Tab", leadingTabIcon = TarkaIcons.Circle12Regular) {},
  )
  val tabItemsWithContent = listOf(
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 1",
        textAlign = TextAlign.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 2",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 3",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 4",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 5",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 6",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 7",
        textAlign = Companion.Center
      )
    },
    TabItem("Tab") {
      Text(
        modifier = Modifier.fillMaxSize(),
        text = "Content 8",
        textAlign = Companion.Center
      )
    },
  )

  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {

    TUITab(
      modifier = Modifier.padding(10.dp),
      isUserScrollEnabledOnContent = false,
      isPagerEnabled = false,
      tabItems = tabItems,
      selectedTabIndex = 1,
      onTabChanged = {}
    )

    VerticalSpacer(space = 10)

    TUITab(
      modifier = Modifier.padding(10.dp),
      isUserScrollEnabledOnContent = false,
      isPagerEnabled = false,
      tabItems = tabItemsWithIcons,
      selectedTabIndex = 1,
      onTabChanged = {}
    )

    VerticalSpacer(space = 10)

    TUITab(
      modifier = Modifier.padding(10.dp),
      isUserScrollEnabledOnContent = true,
      isPagerEnabled = true,
      tabItems = tabItemsWithContent,
      selectedTabIndex = 1,
      onTabChanged = {}
    )

  }
}
