package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.MenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.MenuItemStyle.Title
import com.tarkalabs.uicomponents.components.MenuItemStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.MenuItemTrailingContentType.Icon
import com.tarkalabs.uicomponents.components.TUIMenuItem
import com.tarkalabs.uicomponents.components.TUIMenuItemTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMenuItemTest {

  @get:Rule val composeTestRule = createComposeRule()
  val tags: TUIMenuItemTags = TUIMenuItemTags()

  @Test fun menuItem_Displayed() {
    composeTestRule.setContent {
      TUIMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = Icon(
          TarkaIcons.AddCircle24Regular.copy(tintColor = TUITheme.colors.success)
        ),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.leadingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun menuItem_WithDescription_Displayed() {
    composeTestRule.setContent {
      TUIMenuItem(
        title = "Label",
        style = TitleWithDescription("TitleWithDescription"),
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("TitleWithDescription",useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun button_Click_Triggered() {
    val onMenuItemClick: () -> Unit = mock()

    composeTestRule.setContent {
      TUIMenuItem(
        title = "Label",
        style = Title,
        onMenuItemClick = onMenuItemClick,
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = Icon(
          TarkaIcons.AddCircle24Regular.copy(tintColor = TUITheme.colors.success)
        ),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).performClick()

    verify(onMenuItemClick).invoke()
  }

}