package com.tarkalabs.uicomponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TopBar
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TopBarTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val NAVIGATION_ICON_TAG = "NAVIGATION_ICON_TAG"
  private val SEARCH_ICON_TAG = "SEARCH_ICON_TAG"
  private val MENU_ONE_ICON_TAG = "MENU_ONE_ICON_TAG"
  private val MENU_TWO_ICON_TAG = "MENU_TWO_ICON_TAG"
  private val MENU_THREE_ICON_TAG = "MENU_THREE_ICON_TAG"

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBarTitleDisplayed() {
    composeTestRule.setContent {
      TopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,
        menuItemIconOne = TarkaIcons.ChevronRight,
        menuItemIconTwo = TarkaIcons.ChevronRight,
        menuItemIconThree = TarkaIcons.ChevronRight,
        navigationIconTestTag = NAVIGATION_ICON_TAG,
        searchIconTestTag = SEARCH_ICON_TAG,
        menuItemOneTestTag = MENU_ONE_ICON_TAG,
        menuItemTwoTestTag = MENU_TWO_ICON_TAG,
        menuItemThreeTestTag = MENU_THREE_ICON_TAG,
      )
    }

    composeTestRule.onNodeWithText("title").assertIsDisplayed()
    composeTestRule.onNodeWithTag(NAVIGATION_ICON_TAG).assertIsDisplayed()
    composeTestRule.onNodeWithTag(SEARCH_ICON_TAG).assertIsDisplayed()
    composeTestRule.onNodeWithTag(MENU_ONE_ICON_TAG).assertIsDisplayed()
    composeTestRule.onNodeWithTag(MENU_TWO_ICON_TAG).assertIsDisplayed()
    composeTestRule.onNodeWithTag(MENU_THREE_ICON_TAG).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBarSearchIconDisplayed() {
    composeTestRule.setContent {
      TopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,
        navigationIconTestTag = NAVIGATION_ICON_TAG,
        searchIconTestTag = SEARCH_ICON_TAG,

        )
    }

    composeTestRule.onNodeWithTag(SEARCH_ICON_TAG).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBarClickEventTest() {
    val onNavigationIconClick: () -> Unit = mock()
    val onFirstMenuItemClicked: () -> Unit = mock()
    val onSecondMenuItemClicked: () -> Unit = mock()
    val onThirdMenuItemClicked: () -> Unit = mock()

    composeTestRule.setContent {
      TopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,

        menuItemIconOne = TarkaIcons.ChevronRight,
        menuItemIconTwo = TarkaIcons.ChevronRight,
        menuItemIconThree = TarkaIcons.ChevronRight,

        navigationIconTestTag = NAVIGATION_ICON_TAG,
        searchIconTestTag = SEARCH_ICON_TAG,

        menuItemOneTestTag = MENU_ONE_ICON_TAG,
        menuItemTwoTestTag = MENU_TWO_ICON_TAG,
        menuItemThreeTestTag = MENU_THREE_ICON_TAG,
        onNavigationIconClick = onNavigationIconClick,
        onFirstMenuItemClicked = onFirstMenuItemClicked,
        onSecondMenuItemClicked = onSecondMenuItemClicked,
        onThirdMenuItemClicked = onThirdMenuItemClicked,
      )
    }

    composeTestRule.onNodeWithTag(NAVIGATION_ICON_TAG).performClick()
    composeTestRule.onNodeWithTag(MENU_ONE_ICON_TAG).performClick()
    composeTestRule.onNodeWithTag(MENU_TWO_ICON_TAG).performClick()
    composeTestRule.onNodeWithTag(MENU_THREE_ICON_TAG).performClick()

    verify(onNavigationIconClick).invoke()
    verify(onFirstMenuItemClicked).invoke()
    verify(onSecondMenuItemClicked).invoke()
    verify(onThirdMenuItemClicked).invoke()
  }
}