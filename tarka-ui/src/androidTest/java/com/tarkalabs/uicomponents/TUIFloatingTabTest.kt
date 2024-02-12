package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.tab.TUIFloatingTab
import com.tarkalabs.uicomponents.components.tab.TUIFloatingTabTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIFloatingTabTest {
  @get:Rule val composable = createComposeRule()

  private val tags = TUIFloatingTabTags()

  @Test fun tuiFloatingTab_Displayed_And_Click_Event_Trigger() {
    val onTabSelected: () -> Unit = mock()

    composable.setContent {
      TUIFloatingTab(title = "Tab", selected = true, tags = tags, onSelected = onTabSelected)
    }
    composable.onNodeWithTag(tags.parentTag).assertIsDisplayed()
    composable.onNodeWithText("Tab").assertIsDisplayed()
    composable.onNodeWithTag(tags.parentTag).performClick()
    verify(onTabSelected).invoke()
  }
}