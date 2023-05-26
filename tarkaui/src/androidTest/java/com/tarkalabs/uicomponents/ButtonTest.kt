package com.tarkalabs.uicomponents

import ButtonStyle.SECONDARY
import TUIButton
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class ButtonTest {
  @get:Rule val composable = createComposeRule()


  @Test fun button_Displayed() {
    composable.setContent {
      TUIButton(label = "Button", onClick = { }, buttonStyle = SECONDARY)
    }
    composable.onNodeWithText("Button").assertIsDisplayed()
  }

  @Test fun button_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIButton(
        label = "Button",
        onClick = onClick,
        buttonStyle = SECONDARY
      )
    }
    composable.onNodeWithText("Button").performClick()

    verify(onClick).invoke()
  }
}