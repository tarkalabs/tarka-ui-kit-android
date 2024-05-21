package com.tarkalabs.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.components.TUIToggleSwitch
import com.tarkalabs.tarkaui.components.TUIToggleSwitchTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoInteractions

class TUIToggleSwitchTest {
  @get:Rule val composeTestRule = createComposeRule()
  private val tags: TUIToggleSwitchTags = TUIToggleSwitchTags()

  @Test fun should_invoke_on_checked_change_upon_click() {
    val onCheckedChange: () -> Unit = mock()

    composeTestRule.setContent {
      TUIToggleSwitch(isChecked = false, onCheckedChange = onCheckedChange)
    }
    composeTestRule.onNodeWithTag(tags.parentTag).performClick()

    verify(onCheckedChange).invoke()
  }

  @Test fun should_not_invoke_on_checked_change_upon_click_if_disabled() {
    val onCheckedChange: () -> Unit = mock()

    composeTestRule.setContent {
      TUIToggleSwitch(isChecked = false, enabled = false, onCheckedChange = onCheckedChange)
    }
    composeTestRule.onNodeWithTag(tags.parentTag).performClick()

    verifyNoInteractions(onCheckedChange)
  }
}
