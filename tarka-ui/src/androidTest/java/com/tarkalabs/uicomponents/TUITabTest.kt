package com.tarkalabs.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.components.tab.TUITab
import com.tarkalabs.tarkaui.components.tab.TUITabTags
import com.tarkalabs.tarkaui.icons.Circle20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITabTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun is_passed_things_is_shown() {
    val tabTitle = "test"
    val leadIcon = TarkaIcons.Regular.Circle20
    composeTestRule.setContent {
      TUITab(
        title = tabTitle,
        leadingIcon = leadIcon
      ) {}
    }
    composeTestRule.onNodeWithText(tabTitle).assertExists()
    composeTestRule.onNodeWithContentDescription(leadIcon.contentDescription).assertExists()
  }

  @Test
  fun is_on_click_invokes() {
    val onClickLambda: () -> Unit = mock()
    val testTags = TUITabTags()
    composeTestRule.setContent {
      TUITab(title = "test", tags = testTags, onTabClicked = onClickLambda)
    }
    //Tab title is the parent tag for TUITab
    composeTestRule.onNodeWithTag("test").performClick()
    verify(onClickLambda).invoke()
  }
}