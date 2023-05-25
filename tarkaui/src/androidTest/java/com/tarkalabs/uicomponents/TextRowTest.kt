package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.core.R.drawable
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TextRowTest {
  @get:Rule val composable = createComposeRule()

  @Test fun visibilityTest() {
    composable.setContent {
      TUITextRow(
        title = "Title",
        description = "Description",
        infoIcon = TarkaIcons.Delete,
        iconOne = TarkaIcons.Copy,
        iconTwo = TarkaIcons.CheckMark,
        buttonTitle = "Label",
        iconOneTestTag = "iconOneTestTag",
      )
    }
    composable.onNodeWithText("Title").assertIsDisplayed()
    composable.onNodeWithText("Description").assertIsDisplayed()
    composable.onNodeWithText("Label").assertIsDisplayed()

    // composable.onNodeWithText("iconOneTestTag").assertIsDisplayed()
  }

  @Test fun clickEventTest() {
    val onButtonClick: () -> Unit = mock()

    composable.setContent {
      TUITextRow(
        title = "Title",
        description = "Description",
        infoIcon = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        iconOne = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        iconTwo = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        buttonTitle = "Label",
        onButtonClick = onButtonClick
      )
    }
    composable.onNodeWithText("Label").performClick()

    verify(onButtonClick).invoke()
  }
}