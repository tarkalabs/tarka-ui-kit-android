package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUINavigationRow
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUINavigationRowTest {
  @get:Rule val composable = createComposeRule()

  private val BADGE_TAG = "BADGE_TAG"
  private val ROW_TAG = "ROW_TAG"

  @Test fun navigationRow_Elements_Displayed() {

    composable.setContent {
      TUINavigationRow(
        title = "Label",
        leadingIcon = TarkaIcons.CheckMark,
        badgeCount = 5,
        showRightArrow = true,
        onClick = {},
        badgeTestTag = BADGE_TAG,
        rowTestTag = "rowTestTag"
      )

    }

    composable.onNodeWithText("Label").assertIsDisplayed()
    composable.onNodeWithTag("rowTestTag").assertIsDisplayed()
    composable.onAllNodesWithTag(BADGE_TAG, useUnmergedTree = true).onFirst().assertIsDisplayed()
    composable.onNodeWithContentDescription(TarkaIcons.ChevronRight.contentDescription).assertIsDisplayed()
    composable.onNodeWithContentDescription(TarkaIcons.CheckMark.contentDescription, useUnmergedTree = true).assertIsDisplayed()

  }

  @Test fun navigationRow_Elements_Click_Triggered() {
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

    composable.onNodeWithTag(ROW_TAG)
      .assertHasClickAction()
      .performClick()

  }
}