package com.tarkalabs.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.tarkaicons.Circle20
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITab
import com.tarkalabs.uicomponents.components.TUITabTags
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
    // composeTestRule.onNodeWithTag(testTags.parentTag).performClick()
    verify(onClickLambda).invoke()
  }
}