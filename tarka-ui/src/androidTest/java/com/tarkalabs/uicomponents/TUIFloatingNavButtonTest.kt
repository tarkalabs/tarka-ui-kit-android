package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.CalendarRtl24
import com.tarkalabs.tarkaicons.Directions24
import com.tarkalabs.tarkaicons.Diversity24
import com.tarkalabs.tarkaicons.Map24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButton
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Burger
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.List
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Navigation
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.BURGER
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.LIST
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.VIEW_TOGGLE
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIFloatingNavButtonTest {

  @get:Rule val composable = createComposeRule()
  private val tags = TUIFloatingNavButtonTags()


  @Test fun floating_nav_btn_is_displayed() {
    val onClick: () -> Unit = mock()
    composable.run {
      setContent {
        TUIFloatingNavButton(
          contentType = Navigation(TarkaIcons.Filled.Diversity24, text = "Test"),
          onClicked = onClick, tags = tags
        )
      }
      onNodeWithTag(tags.parentTag).run {
        assertIsDisplayed()
        performClick()
        verify(onClick)()
      }

      onNodeWithTag(tags.leadingIconTag, true).assertIsDisplayed()
      onNodeWithTag(tags.trailingIconTag, true).assertIsDisplayed()
    }
  }

  @Test fun floating_nav_btn_trailing_icon_is_not_displayed() {
    val onClick: () -> Unit = mock()
    composable.run {
      setContent {
        TUIFloatingNavButton(
          contentType = Navigation(TarkaIcons.Filled.Diversity24, text = "Test"),
          onClicked = onClick, tags = tags, style = VIEW_TOGGLE
        )
      }
      onNodeWithTag(tags.parentTag).run {
        assertIsDisplayed()
        performClick()
        verify(onClick)()
      }

      onNodeWithTag(tags.leadingIconTag, true).assertIsDisplayed()
      onNodeWithTag(tags.trailingIconTag, true).assertDoesNotExist()
    }
  }

  @Test fun floating_nav_list_type_all_icons_are_displayed() {
    val onIconOneClick: () -> Unit = mock()
    val onIconTwoClick: () -> Unit = mock()
    val onIconThreeClick: () -> Unit = mock()

    composable.run {
      setContent {
        TUIFloatingNavButton(
          contentType = List(
            iconOne = TarkaIcons.Filled.CalendarRtl24,
            onIconOneClick = onIconOneClick,
            iconTwo = TarkaIcons.Filled.Map24,
            onIconTwoClick = onIconTwoClick,
            iconThree = TarkaIcons.Filled.Directions24,
            onIconThreeClick = onIconThreeClick
          ),
          style = LIST
        )
      }
      onNodeWithTag(tags.iconOneTag).run {
        assertIsDisplayed()
        performClick()
        verify(onIconOneClick)()
      }
      onNodeWithTag(tags.iconTwoTag).run {
        assertIsDisplayed()
        performClick()
        verify(onIconTwoClick)()
      }
      onNodeWithTag(tags.iconThreeTag).run {
        assertIsDisplayed()
        performClick()
        verify(onIconThreeClick)()
      }
    }
  }

  @Test fun floating_nav_list_type_few_icons_are_displayed() {
    val onIconOneClick: () -> Unit = mock()
    val onIconTwoClick: () -> Unit = mock()

    composable.run {
      setContent {
        TUIFloatingNavButton(
          contentType = List(
            iconOne = TarkaIcons.Filled.CalendarRtl24,
            onIconOneClick = onIconOneClick,
            iconTwo = TarkaIcons.Filled.Map24,
            onIconTwoClick = onIconTwoClick,
          ),
          style = LIST
        )
      }
      onNodeWithTag(tags.iconOneTag).run {
        assertIsDisplayed()
        performClick()
        verify(onIconOneClick)()
      }
      onNodeWithTag(tags.iconTwoTag).run {
        assertIsDisplayed()
        performClick()
        verify(onIconTwoClick)()
      }
      onNodeWithTag(tags.iconThreeTag).run {
        assertDoesNotExist()
      }
    }
  }

  @Test fun floating_nav_burger_button_is_displayed() {
    val onClick: () -> Unit = mock()
    composable.run {
      setContent {
        TUIFloatingNavButton(
          contentType = Burger,
          style = BURGER,
          onClicked = onClick
        )
      }
      onNodeWithTag(tags.burgerIconTag, true).run {
        assertIsDisplayed()
        performClick()
        verify(onClick)()
      }
    }
  }
}