package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Secondary
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.components.base.TUIButtonTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIButtonTest {

  @get:Rule val composable = createComposeRule()

  private val tags = TUIButtonTags(parentTag = "button_tag")

  @Test fun button_Displayed() {
    composable.setContent {
      TUIButton(label = "Button", tags = tags, onClick = { }, buttonStyle = Secondary)
    }
    composable.onNodeWithText("Button").assertIsDisplayed()
  }

  @Test fun button_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIButton(
        label = "Button",
        onClick = onClick,
        buttonStyle = Secondary
      )
    }
    composable.onNodeWithText("Button").performClick()

    verify(onClick).invoke()
  }
}