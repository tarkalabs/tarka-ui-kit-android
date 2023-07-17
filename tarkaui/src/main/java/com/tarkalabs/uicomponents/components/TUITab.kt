package com.tarkalabs.uicomponents.components

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.models.TarkaIcon
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
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top,
  ) {

    val scope = rememberCoroutineScope()

    val currentTabIndex = if (isPagerEnabled) {
      pagerState.currentPage
    } else {
      currentTab.value
    }

    /*ScrollableTabRow(
      modifier = Modifier
        .testTag(tags.parentId)
        .wrapContentWidth()
        .fillMaxWidth()
        .padding(15.dp)
        .clip(RoundedCornerShape(30.dp)),
      selectedTabIndex = currentTabIndex,
      containerColor = TUITheme.colors.secondaryAlt,
      indicator = {
        TabRowDefaults.Indicator(
          modifier = Modifier
            .background(Color.Transparent)
            .height(0.dp),
          color = Color.Transparent,
          height = 0.dp,
        )
      },
      divider = {},
      edgePadding = 0.dp,
    )*/ 
    Row(
      horizontalArrangement = Arrangement.SpaceAround,
      modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .horizontalScroll(rememberScrollState())
        .clip(RoundedCornerShape(30.dp))
        .background(TUITheme.colors.secondaryAlt)
      )
    {

      tabItems.forEachIndexed { index, item ->

        Tab(modifier = Modifier
          .testTag("${item.name} ${tags.tabId}")
          .padding(5.dp)
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
            modifier = Modifier.padding(start = 5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
          ) {

            item.leadingTabIcon?.let {
              Icon(
                painter = painterResource(id = it.iconRes),
                contentDescription = it.contentDescription,
                tint = if (currentTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
              )
            }

            HorizontalSpacer(space = 4)

            Text(
              modifier = Modifier.padding(10.dp),
              text = item.name,
              style = TUITheme.typography.button6,
              color = if (currentTabIndex == index) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
            )
          }

        }
      }

    }

    if (isPagerEnabled) {
      HorizontalPager(
        modifier = Modifier
          .testTag(tags.pagerId)
          .fillMaxHeight(),
        pageCount = tabItems.count(),
        state = pagerState,
        userScrollEnabled = isUserScrollEnabledOnContent,
      ) { tabIndex ->
        Column(
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
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
  val pagerId: String = "HorizontalPager",
)

@Composable @Preview(showBackground = true) fun PreviewTUITabRow() {

  val contentModifier = Modifier.fillMaxHeight()
  val tabItems = listOf(TabItem("Tab 1") { Text(modifier = contentModifier, text = "Content 1") },
    TabItem("Tab 2") { Text(modifier = contentModifier, text = "Content 2") },
  )

  val context = LocalContext.current

  val scope = rememberCoroutineScope()

  TUITab(isUserScrollEnabledOnContent = true,
    isPagerEnabled = true,
    tabItems = tabItems,
    selectedTabIndex = 1,
    onTabChanged = {
      scope.launch {
        Toast.makeText(context, "Tab : ${it + 1} Changed", Toast.LENGTH_SHORT).show()
      }
    })
}
