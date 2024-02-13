package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.icons.Circle12
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITag
import com.tarkalabs.uicomponents.components.TUITagTestTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITagTest {

  @get:Rule
  val composable = createComposeRule()

  @Test
  fun is_passed_things_is_shown() {
    val title = "test title"
    val leadingIcon = TarkaIcons.Regular.Circle12
    val trailingIcon = TarkaIcons.Regular.Circle12
    composable.setContent {
      TUITag(
        title = title,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        onClick = {})
    }
    composable.onNodeWithText(title).assertIsDisplayed()
    composable.onNodeWithContentDescription(leadingIcon.contentDescription).assertIsDisplayed()
    composable.onNodeWithContentDescription(trailingIcon.contentDescription).assertIsDisplayed()
  }

  @Test
  fun is_click_event_invoked() {
    val clickLambda: () -> Unit = mock()
    val testTag = TUITagTestTags(parentTag = "Test Tag")
    composable.setContent {
      TUITag(
        title = "Test",
        onClick = clickLambda,
        tags = testTag
      )
    }
    composable.onNodeWithTag(testTag.parentTag).performClick()
    verify(clickLambda).invoke()
  }
}