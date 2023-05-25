package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUINavigationRow
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class NavigationRowTest {
  @get:Rule val composable = createComposeRule()

  private val BADGE_TAG = "BADGE_TAG"
  private val ROW_TAG = "ROW_TAG"

  @Test fun navigationRowVisibilityTest() {

    composable.setContent {
      TUINavigationRow(
        title = "Label",
        leadingIcon = TarkaIcons.Copy,
        badgeCount = 5,
        onClick = {},
        badgeTestTag = BADGE_TAG,
      )
    }

    composable.onNodeWithText("Label").assertIsDisplayed()
    // composable.onNodeWithTag(BADGE_TAG).assertIsDisplayed()
  }

  @Test fun checkClickEvent(){
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUINavigationRow(
        title = "Label",
        leadingIcon = TarkaIcons.Copy,
        badgeCount = 5,
        onClick = onClick,
        badgeTestTag = BADGE_TAG,
        rowTestTag = ROW_TAG
      )
    }

    composable.onNodeWithTag(ROW_TAG).performClick()

    verify(onClick).invoke()

  }
}