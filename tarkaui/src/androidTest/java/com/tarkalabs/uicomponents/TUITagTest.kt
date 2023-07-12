package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUITag
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITagTest {

  @get:Rule
  val composable = createComposeRule()

  @Test
  fun is_passed_title_is_shown() {
    val title = "test title"
    composable.setContent {
      TUITag(
        title = title,
        onClick = {})
    }
    composable.onNodeWithText(title).assertIsDisplayed()
  }

  @Test
  fun is_passed_leading_icon_is_shown() {
    val leadingIcon = TarkaIcons.Circle16Regular
    composable.setContent {
      TUITag(
        title = "Test",
        leadingIcon = leadingIcon,
        onClick = {})
    }
    composable.onNodeWithContentDescription(leadingIcon.contentDescription).assertIsDisplayed()
  }

  @Test
  fun is_passed_trailing_icon_is_shown() {
    val trailingIcon = TarkaIcons.Circle16Regular
    composable.setContent {
      TUITag(
        title = "Test",
        trailingIcon = trailingIcon,
        onClick = {})
    }
    composable.onNodeWithContentDescription(trailingIcon.contentDescription).assertIsDisplayed()
  }

  @Test
  fun is_click_event_invoked() {
    val clickLambda: () -> Unit = mock()
    composable.setContent {
      TUITag(
        title = "Test",
        onClick = clickLambda
      )
    }
    composable.onNodeWithTag(Tags.TAG_FOR_TUI_TAG).performClick()
    verify(clickLambda).invoke()
  }
}