package com.tarkalabs.uicomponents.composables

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

  @OptIn(ExperimentalMaterial3Api::class) @Test fun visibilityTest() {
    composeTestRule.setContent {
      TopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,
        menuItemIconOne = TarkaIcons.CheckMark,
        menuItemIconTwo = TarkaIcons.Delete,
        menuItemIconThree = TarkaIcons.ArrowCounterClockWise,
      )
    }

    composeTestRule.onNodeWithText("title").assertIsDisplayed()
    composeTestRule.onNodeWithTag(TarkaIcons.ChevronRight.contentDescription).assertIsDisplayed()
    composeTestRule.onNodeWithTag(TarkaIcons.CheckMark.contentDescription).assertIsDisplayed()
    composeTestRule.onNodeWithTag(TarkaIcons.Delete.contentDescription).assertIsDisplayed()
    composeTestRule.onNodeWithTag(TarkaIcons.ArrowCounterClockWise.contentDescription).assertIsDisplayed()
    composeTestRule.onNodeWithTag(TarkaIcons.Search.contentDescription).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun topBarSearchIconDisplayed() {
    composeTestRule.setContent {
      TopBar(
        title = "title",
        navigationIcon = TarkaIcons.ChevronRight,
        searchIcon = TarkaIcons.Search,)
    }

    composeTestRule.onNodeWithTag(TarkaIcons.ChevronRight.contentDescription).assertIsDisplayed()
  }

  @OptIn(ExperimentalMaterial3Api::class) @Test fun clickEventTest() {
    val onNavigationIconClick: () -> Unit = mock()
    val onFirstMenuItemClicked: () -> Unit = mock()
    val onSecondMenuItemClicked: () -> Unit = mock()
    val onThirdMenuItemClicked: () -> Unit = mock()

    composeTestRule.setContent {
      TopBar(
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
      )
    }

    composeTestRule.onNodeWithTag(TarkaIcons.ChevronRight.contentDescription).performClick()
    composeTestRule.onNodeWithTag( TarkaIcons.Copy.contentDescription).performClick()
    composeTestRule.onNodeWithTag( TarkaIcons.Delete.contentDescription).performClick()
    composeTestRule.onNodeWithTag(TarkaIcons.ArrowExport.contentDescription).performClick()

    verify(onNavigationIconClick).invoke()
    verify(onFirstMenuItemClicked).invoke()
    verify(onSecondMenuItemClicked).invoke()
    verify(onThirdMenuItemClicked).invoke()
  }
}