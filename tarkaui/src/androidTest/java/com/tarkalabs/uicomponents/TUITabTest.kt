package com.tarkalabs.uicomponents

import androidx.compose.material3.Text
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import com.tarkalabs.uicomponents.components.TUITab
import com.tarkalabs.uicomponents.components.TUITabTags
import com.tarkalabs.uicomponents.components.TabItem
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITabTest {

  @get:Rule val composeTestRule = createComposeRule()

  private val testTags = TUITabTags(parentId = "testParent", tabId = "testTab", pagerId = "testPager")

  @Test fun is_passed_tabs_shown() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = false,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }

    composeTestRule.onNodeWithTag("Tab 1 ${testTags.tabId}").assertIsDisplayed()
    composeTestRule.onNodeWithTag("Tab 2 ${testTags.tabId}").assertIsDisplayed()
    composeTestRule.onNodeWithTag("Tab 2 ${testTags.tabId}").assertIsDisplayed()

  }

  @Test fun is_pass_tabs_shown_with_icon() {

    val leadingIcon = TarkaIcons.Tabs24Regular

    val tabItems = listOf(
      TabItem(name = "Tab 1", leadingTabIcon = leadingIcon, content = {}),
      TabItem(name = "Tab 2", leadingTabIcon = leadingIcon, content = {}),
      TabItem(name = "Tab 3", leadingTabIcon = leadingIcon, content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = false,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }

    composeTestRule.onAllNodesWithContentDescription(leadingIcon.contentDescription).assertCountEquals(3)
  }

  @Test fun is_passed_content_shown() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = { Text(text = "Content 1")}),
      TabItem(name = "Tab 2", content = { Text(text = "Content 2")}),
      TabItem(name = "Tab 3", content = { Text(text = "Content 3")}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //Initially the content of the first tab should be shown due to the selected index is 0.
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    //Other tab contents should not be exist
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()
  }

  @Test fun is_passed_content_not_shown_when_pager_disabled() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = { Text(text = "Content 1")}),
      TabItem(name = "Tab 2", content = { Text(text = "Content 2")}),
      TabItem(name = "Tab 3", content = { Text(text = "Content 3")}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = false,
        isUserScrollEnabledOnContent = true,
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

  @Test fun is_correct_tab_selected_based_on_selected_index_value() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = false,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 2,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //Third tab should be shown due to the selected index 2
    composeTestRule.onNodeWithTag("Tab 3 ${testTags.tabId}").assertIsSelected()
    //other tabs should not be shown
    composeTestRule.onNodeWithTag("Tab 1 ${testTags.tabId}").assertIsNotSelected()
    composeTestRule.onNodeWithTag("Tab 2 ${testTags.tabId}").assertIsNotSelected()
  }

  @Test fun is_pager_disabled_properly_based_on_param() {

    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = false,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }
    composeTestRule.onNodeWithTag(testTags.pagerId).assertDoesNotExist()

  }

  @Test fun is_pager_enabled_properly_based_on_param() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 1,
        tags = testTags,
        onTabChanged = {},
      )
    }
    composeTestRule.onNodeWithTag(testTags.pagerId).assertIsDisplayed()
  }

  @Test fun is_proper_content_shown_when_switching_tab_by_click_tabRow() {
    val tabItems = listOf(
      TabItem(name = "Tab 1", content = { Text(text = "Content 1")}),
      TabItem(name = "Tab 2", content = { Text(text = "Content 2")}),
      TabItem(name = "Tab 3", content = { Text(text = "Content 3")}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //Initially the content of the first tab should be shown due to the selected index is 0.
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    //Other tab contents should not be exist
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()

    //Clicking the second Tab & updating Index
    composeTestRule.onNodeWithTag("Tab 2 ${testTags.tabId}").performClick()

    //Now the content of the second tab should be shown due to the selected index is 1.
    composeTestRule.onNodeWithText("Content 2").assertIsDisplayed()
    //Other tab contents should not be shown
    composeTestRule.onNodeWithText("Content 1").assertIsNotDisplayed()
    composeTestRule.onNodeWithText("Content 3").assertIsNotDisplayed()
  }

  @Test fun is_onTabChange_invoked_and_proper_index_passed_while_clicking_tabRow() {

    val onTabChange: (Int) -> Unit = mock()

    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = onTabChange,
      )
    }

    var clickedTabIndex = 1
    composeTestRule.onNodeWithTag("Tab 2 ${testTags.tabId}").performClick()
    verify(onTabChange).invoke(clickedTabIndex)

    clickedTabIndex = 2
    composeTestRule.onNodeWithTag("Tab 3 ${testTags.tabId}").performClick()
    verify(onTabChange).invoke(clickedTabIndex)

  }

  @Test fun is_scrolling_disabled_in_pager_based_on_the_param() {

    val tabItems = listOf(
      TabItem(name = "Tab 1", content = { Text(text = "Content 1") }),
      TabItem(name = "Tab 2", content = { Text(text = "Content 2") }),
      TabItem(name = "Tab 3", content = { Text(text = "Content 3") }),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = false,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //state before scroll
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()

    //if the scrolling was disabled the page content couldn't change
    composeTestRule.onNodeWithTag(testTags.pagerId).performTouchInput { swipeLeft() }

    //state after scroll
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()

    //second scroll to right
    composeTestRule.onNodeWithTag(testTags.pagerId).performTouchInput { swipeRight() }

    //state after second scroll
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()

  }

  @Test fun is_proper_tab_shown_when_switching_tab_by_scrolling_pager() {

  }

  @Test fun is_onTabChange_invoked_while_scrolling_tabContent() {
    val onTabChange: (Int) -> Unit = mock()

    val tabItems = listOf(
      TabItem(name = "Tab 1", content = {}),
      TabItem(name = "Tab 2", content = {}),
      TabItem(name = "Tab 3", content = {}),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = onTabChange,
      )
    }

    composeTestRule.onNodeWithTag(testTags.pagerId).performTouchInput{ swipeLeft()  }
    composeTestRule.waitForIdle()
    verify(onTabChange.invoke(1))

  }

  @Test fun is_scrolling_enabled_in_pager_based_on_the_param() {

    val tabItems = listOf(
      TabItem(name = "Tab 1", content = { Text(text = "Content 1") }),
      TabItem(name = "Tab 2", content = { Text(text = "Content 2") }),
      TabItem(name = "Tab 3", content = { Text(text = "Content 3") }),
    )

    composeTestRule.setContent {
      TUITab(
        isPagerEnabled = true,
        isUserScrollEnabledOnContent = true,
        tabItems = tabItems,
        selectedTabIndex = 0,
        tags = testTags,
        onTabChanged = {},
      )
    }

    //state before scroll
    composeTestRule.onNodeWithText("Content 1").assertIsDisplayed()
    composeTestRule.onNodeWithText("Content 2").assertDoesNotExist()
    composeTestRule.onNodeWithText("Content 3").assertDoesNotExist()

    composeTestRule.onNodeWithTag(testTags.pagerId).performTouchInput { swipeLeft() }

    composeTestRule.waitForIdle()
    //if the scrolling was enabled the page content will change

    //state after scroll
    composeTestRule.onNodeWithText("Content 2").assertIsDisplayed()

  }

}