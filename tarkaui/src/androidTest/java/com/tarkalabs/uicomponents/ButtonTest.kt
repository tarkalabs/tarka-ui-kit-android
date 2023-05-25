package com.tarkalabs.uicomponents

import ButtonStyle.SECONDARY
import TUIButton
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ButtonTest {
  @get:Rule val composable = createComposeRule()

  private val BUTTON_TAG = "BUTTON_TAG"

  @Test fun isButtonDisplayed() {
    composable.setContent {
      TUIButton(label = "Button", onClick = { }, buttonStyle = SECONDARY, testTag = BUTTON_TAG)
    }
    composable.onNodeWithTag(BUTTON_TAG).assertIsDisplayed()
  }

  @Test fun buttonClickTest() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIButton(
        label = "Button", onClick = onClick, buttonStyle = SECONDARY, testTag = BUTTON_TAG
      )
    }
    composable.onNodeWithTag(BUTTON_TAG).performClick()

    verify(onClick).invoke()
  }
}