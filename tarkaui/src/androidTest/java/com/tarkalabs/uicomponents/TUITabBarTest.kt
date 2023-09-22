package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.Tabs24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITabBar
import com.tarkalabs.uicomponents.components.TUITabBarTags
import com.tarkalabs.uicomponents.components.TUITabTags
import com.tarkalabs.uicomponents.components.TabItem
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITabBarTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  private val testTags = TUITabBarTags()

  @Test
  fun is_passed_tabs_shown() {
    val tabItems = listOf(
      TabItem(name = "Tab 1"),
      TabItem(name = "Tab 2"),
      TabItem(name = "Tab 3"),
    )

    composeTestRule.setContent {
      TUITabBar(
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }

    composeTestRule.onNodeWithTag(tabItems[0].name).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tabItems[1].name).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tabItems[2].name).assertIsDisplayed()
  }

  @Test
  fun is_pass_tabs_shown_with_icon() {

    val leadingIcon = TarkaIcons.Regular.Tabs24

    val tabItems = listOf(
      TabItem(name = "Tab 1", leadingTabIcon = leadingIcon),
      TabItem(name = "Tab 2", leadingTabIcon = leadingIcon),
      TabItem(name = "Tab 3", leadingTabIcon = leadingIcon),
    )

    composeTestRule.setContent {
      TUITabBar(
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }

    composeTestRule.onAllNodesWithContentDescription(leadingIcon.contentDescription)
      .assertCountEquals(3)
  }

  @Test
  fun is_passed_content_not_shown_when_pager_disabled() {
    val tabItems = listOf(
      TabItem(name = "Tab 1"),
      TabItem(name = "Tab 2"),
      TabItem(name = "Tab 3"),
    )

    composeTestRule.setContent {
      TUITabBar(
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //tab contents should not be shown because the pager is disabled in the parameter
    composeTestRule.onNodeWithText("Content 1").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()
  }

  @Test
  fun is_correct_tab_selected_based_on_selected_index_value() {
    val tabItems = listOf(
      TabItem(name = "Tab 1"),
      TabItem(name = "Tab 2"),
      TabItem(name = "Tab 3"),
    )

    composeTestRule.setContent {
      TUITabBar(
        tabItems = tabItems,
        selectedTabIndex = 2,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //Third tab should be shown due to the selected index 2
    composeTestRule.onNodeWithTag(tabItems[2].name, useUnmergedTree = true).assertIsSelected()
    //other tabs should not be shown
    composeTestRule.onNodeWithTag(tabItems[0].name, useUnmergedTree = true).assertIsNotSelected()
    composeTestRule.onNodeWithTag(tabItems[1].name, useUnmergedTree = true).assertIsNotSelected()
  }

  @Test
  fun is_onTabChange_invoked_and_proper_index_passed_while_clicking_tabRow() {

    val onTabChange: (Int) -> Unit = mock()

    val tabItems = listOf(
      TabItem(name = "Tab 1"),
      TabItem(name = "Tab 2"),
      TabItem(name = "Tab 3"),
    )

    composeTestRule.setContent {
      TUITabBar(
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = onTabChange,
      )
    }

    var clickedTabIndex = 1
    composeTestRule.onNodeWithTag(tabItems[1].name).performClick()
    verify(onTabChange).invoke(clickedTabIndex)

    clickedTabIndex = 2
    composeTestRule.onNodeWithTag(tabItems[2].name).performClick()
    verify(onTabChange).invoke(clickedTabIndex)
  }

}