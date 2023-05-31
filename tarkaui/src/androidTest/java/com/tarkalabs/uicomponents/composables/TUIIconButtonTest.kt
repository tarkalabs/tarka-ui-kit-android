package com.tarkalabs.uicomponents.composables

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIIconButton
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIIconButtonTest {
  @get:Rule val composable = createComposeRule()

  private val ICON_BUTTON = "ICON_BUTTON"

  @Test fun icon_Button_Displayed() {
    composable.setContent {
      TUIIconButton(icon = TarkaIcons.Delete, testTag = ICON_BUTTON) {
      }
    }
    composable.onNodeWithTag(ICON_BUTTON).assertIsDisplayed()
    composable.onNodeWithContentDescription(TarkaIcons.Delete.contentDescription).assertIsDisplayed()
  }

  @Test fun icon_Button_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIIconButton(icon = TarkaIcons.Delete, testTag = ICON_BUTTON, onIconClick = onClick)
    }

    composable.onNodeWithTag(ICON_BUTTON).performClick()
    verify(onClick).invoke()
  }
}