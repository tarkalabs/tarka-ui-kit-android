package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIMultiLevelSelectorHeader
import com.tarkalabs.uicomponents.components.TUIMultiLevelSelectorHeader.TUIMultiLevelSelectorHeaderTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMultiLevelSelectorHeaderTest {

  @get:Rule val composable = createComposeRule()

  private val tags = TUIMultiLevelSelectorHeaderTags()

  @Test fun multiLevelSelectorHeader_Displayed() {
    composable.setContent {
      TUIMultiLevelSelectorHeader(
        modifier = Modifier.fillMaxWidth(),
        isSelected = true,
        title = "Hello There",
        tags = tags
      ) {}

    }
    composable.onNodeWithText("Hello There").assertIsDisplayed()
    composable.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithContentDescription("leadingIcon", useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithContentDescription("trailingIcon", useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun multiLevelSelectorHeader_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIMultiLevelSelectorHeader(
        modifier = Modifier.fillMaxWidth(),
        isSelected = true,
        title = "Hello There",
        tags = tags,
        onClick = onClick
      )

    }
    composable.onNodeWithTag(tags.parentTag, useUnmergedTree = true).performClick()
    verify(onClick).invoke()
  }
}