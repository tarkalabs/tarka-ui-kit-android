package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.components.TUISearchBar
import com.tarkalabs.tarkaui.components.TUISearchBarTags
import com.tarkalabs.tarkaui.components.base.TUIIconButtonTags
import com.tarkalabs.tarkaui.icons.Dismiss24
import com.tarkalabs.tarkaui.icons.Search24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUISearchBarTest {
  @get:Rule val composable = createComposeRule()

  private val leadingIconTags: TUIIconButtonTags = TUIIconButtonTags(parentTag = "LEADING_ICON_TAG")
  private val trailingIconTags: TUIIconButtonTags =
    TUIIconButtonTags(parentTag = "TRAILING_ICON_TAG")
  private val searchBarTags: TUISearchBarTags = TUISearchBarTags(parentTag = "SEARCH_BAR_TAG",
    leadingIconTags = leadingIconTags,
    trailingIconTags = trailingIconTags
  )

  @Test fun search_bar_is_displayed() {
    composable.setContent {
      TUISearchBar(
        query = "",
        placeholder = "Search",
        onQueryTextChange = {},
        onLeadingIconClick = {},
        searchBarTags = searchBarTags,
        trailingIcon = TarkaIcons.Regular.Dismiss24,
        leadingIcon = TarkaIcons.Regular.Search24,
      )
    }
    composable.onNodeWithTag(searchBarTags.parentTag).assertIsDisplayed()
    composable.onNodeWithTag(leadingIconTags.parentTag, useUnmergedTree = true).assertIsDisplayed()

  }

  @Test fun trailing_icon_is_displayed() {
    composable.setContent {
      TUISearchBar(
        query = "Wo",
        placeholder = "Search",
        onQueryTextChange = {},
        onLeadingIconClick = {},
        searchBarTags = searchBarTags,
        trailingIcon = TarkaIcons.Regular.Dismiss24,
      )
    }
    composable.onNodeWithTag(trailingIconTags.parentTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun search_bar_leading_icon_click_triggered() {
    val leadingIconClick: () -> Unit = mock()

    composable.setContent {
      TUISearchBar(
        query = "",
        placeholder = "Search",
        onQueryTextChange = { },
        onLeadingIconClick = leadingIconClick,
        searchBarTags = searchBarTags,
        trailingIcon = TarkaIcons.Regular.Dismiss24,
        leadingIcon = TarkaIcons.Regular.Search24,
      )
    }
    composable.onNodeWithTag(leadingIconTags.parentTag, useUnmergedTree = true)
      .assertHasClickAction().performClick()
    verify(leadingIconClick).invoke()
  }

  @Test fun search_bar_trailing_icon_click_triggered() {
    composable.setContent {
      TUISearchBar(
        query = "Hello",
        placeholder = "Search",
        onQueryTextChange = { },
        onLeadingIconClick = {},
        searchBarTags = searchBarTags,
        trailingIcon = TarkaIcons.Regular.Dismiss24,
      )
    }
    composable.onNodeWithTag(trailingIconTags.parentTag, useUnmergedTree = true)
      .assertHasClickAction()
      .performClick()
  }
}