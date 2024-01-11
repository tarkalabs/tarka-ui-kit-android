package com.tarkalabs.uicomponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.ArrowCounterclockwise24
import com.tarkalabs.tarkaicons.ArrowExportLtr24
import com.tarkalabs.tarkaicons.Checkmark16
import com.tarkalabs.tarkaicons.ChevronRight20
import com.tarkalabs.tarkaicons.Copy24
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.Search24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import com.tarkalabs.uicomponents.components.TUITopAppBar
import com.tarkalabs.uicomponents.components.TUITopBarTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITopBarTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val navigationIconTags = TUIIconButtonTags(parentTag = "NavigationIcon")
  private val searchIconTags = TUIIconButtonTags(parentTag = "SearchIcon")
  private val menuIconOneTags = TUIIconButtonTags(parentTag = "MenuIconOne")
  private val menuIconTwoTags = TUIIconButtonTags(parentTag = "MenuIconTwo")
  private val menuIconThreeTags = TUIIconButtonTags(parentTag = "MenuIconThree")

  private val tags = TUITopBarTags(
    navigationIconTags = navigationIconTags,
    searchIconTags = searchIconTags,
    menuIconOneTags = menuIconOneTags,
    menuIconTwoTags = menuIconTwoTags,
    menuIconThreeTags = menuIconThreeTags
  )

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBar_Item_Displayed() {
    composeTestRule.setContent {
      TUITopAppBar(
        title = "title",
        navigationIcon = TarkaIcons.Regular.ChevronRight20,
        menuItemIconOne = TarkaIcons.Filled.Checkmark16,
        menuItemIconTwo = TarkaIcons.Regular.Delete24,
        menuItemIconThree = TarkaIcons.Regular.ArrowCounterclockwise24,
        tags = tags
      )
    }

    composeTestRule.onNodeWithText("title").assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.navigationIconTags.parentTag).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.menuIconOneTags.parentTag).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.menuIconTwoTags.parentTag).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.menuIconThreeTags.parentTag).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBar_SearchIcon_Displayed() {
    composeTestRule.setContent {
      TUITopAppBar(
        title = "title",
        navigationIcon = TarkaIcons.Regular.ChevronRight20,
        searchIcon = TarkaIcons.Regular.Search24,
        tags = TUITopBarTags(searchIconTags = searchIconTags)
      )
    }

    composeTestRule.onNodeWithTag(searchIconTags.parentTag).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBar_All_Icons_Click_Events_Trigged() {
    val onNavigationIconClick: () -> Unit = mock()
    val onFirstMenuItemClicked: () -> Unit = mock()
    val onSecondMenuItemClicked: () -> Unit = mock()
    val onThirdMenuItemClicked: () -> Unit = mock()

    composeTestRule.setContent {
      TUITopAppBar(
        title = "title",
        navigationIcon = TarkaIcons.Regular.ChevronRight20,
        searchIcon = TarkaIcons.Regular.Search24,
        menuItemIconOne = TarkaIcons.Regular.Copy24,
        menuItemIconTwo = TarkaIcons.Regular.Delete24,
        menuItemIconThree = TarkaIcons.Regular.ArrowExportLtr24,
        onNavigationIconClick = onNavigationIconClick,
        onFirstMenuItemClicked = onFirstMenuItemClicked,
        onSecondMenuItemClicked = onSecondMenuItemClicked,
        onThirdMenuItemClicked = onThirdMenuItemClicked,
        tags = tags
      )
    }

    composeTestRule.onNodeWithTag(tags.navigationIconTags.parentTag).performClick()
    composeTestRule.onNodeWithTag(tags.menuIconOneTags.parentTag).performClick()
    composeTestRule.onNodeWithTag(tags.menuIconTwoTags.parentTag).performClick()
    composeTestRule.onNodeWithTag(tags.menuIconThreeTags.parentTag).performClick()

    verify(onNavigationIconClick).invoke()
    verify(onFirstMenuItemClicked).invoke()
    verify(onSecondMenuItemClicked).invoke()
    verify(onThirdMenuItemClicked).invoke()
  }
}