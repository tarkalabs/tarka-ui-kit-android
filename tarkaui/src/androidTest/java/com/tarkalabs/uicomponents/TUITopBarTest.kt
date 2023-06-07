package com.tarkalabs.uicomponents

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIIconButtonTags
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.components.TUITopBarTags
import com.tarkalabs.uicomponents.models.TarkaIcons
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
      TUITopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        menuItemIconOne = TarkaIcons.CheckMark,
        menuItemIconTwo = TarkaIcons.Delete,
        menuItemIconThree = TarkaIcons.ArrowCounterClockWise,
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
      TUITopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,
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
      TUITopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,
        menuItemIconOne = TarkaIcons.Copy,
        menuItemIconTwo = TarkaIcons.Delete,
        menuItemIconThree = TarkaIcons.ArrowExport,
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