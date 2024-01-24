package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.AddCircle24
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUIMenuItem
import com.tarkalabs.uicomponents.components.TUIMenuItemTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMenuItemTest {

  @get:Rule val composeTestRule = createComposeRule()
  val tags = TUIMenuItemTags()

  @Test fun menu_Item_Displayed() {
    composeTestRule.setContent {
      TUIMenuItem(
        label = "Label",
        onMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = Regular.AddCircle24,
        trailingIcon = Regular.AddCircle24,
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.leadingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun button_Click_Triggered() {
    val onMenuItemClick: () -> Unit = mock()

    composeTestRule.setContent {
      TUIMenuItem(
        label = "Label",
        onMenuItemClick = onMenuItemClick,
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = Regular.AddCircle24,
        trailingIcon = Regular.AddCircle24,
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).performClick()

    verify(onMenuItemClick).invoke()
  }

}