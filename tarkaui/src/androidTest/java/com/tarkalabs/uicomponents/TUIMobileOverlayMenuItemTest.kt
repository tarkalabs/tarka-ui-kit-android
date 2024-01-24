package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.AddCircle24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemStyle.Title
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemTrailingContentType.Icon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItem
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItemTags
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMobileOverlayMenuItemTest {

  @get:Rule val composeTestRule = createComposeRule()
  val tags: TUIMobileOverlayMenuItemTags = TUIMobileOverlayMenuItemTags()

  @Test fun mobileOverlayMenuItem_Displayed() {
    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMobileOverlayMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        ),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.leadingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun mobileOverlayMenuItem_WithDescription_Displayed() {
    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = TitleWithDescription("TitleWithDescription"),
        onMobileOverlayMenuItemClick = {},
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
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMobileOverlayMenuItemClick = onMenuItemClick,
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingContent = StatusIndicator,
        trailingContent = Icon(
          TarkaIcons.Regular.AddCircle24.copy(tintColor = TUITheme.colors.success)
        ),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).performClick()

    verify(onMenuItemClick).invoke()
  }

}