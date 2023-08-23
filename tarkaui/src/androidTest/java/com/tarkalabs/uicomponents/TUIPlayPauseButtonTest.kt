package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.Pause12
import com.tarkalabs.tarkaicons.Play12
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.PlayPauseButtonState.Pause
import com.tarkalabs.uicomponents.components.PlayPauseButtonState.Play
import com.tarkalabs.uicomponents.components.TUIPlayPauseButton
import com.tarkalabs.uicomponents.components.TUIPlayPauseButtonsTestTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIPlayPauseButtonTest {

  @get:Rule
  val composable = createComposeRule()

  @Test
  fun is_onclick_invoked() {
    val clickLambda: () -> Unit = mock()
    val testTag = TUIPlayPauseButtonsTestTags(parentId = "Test Tag")
    composable.setContent {
      TUIPlayPauseButton(
        onClick = clickLambda,
        tags = testTag
      )
    }
    composable.onNodeWithTag(testTag.parentId).performClick()
    verify(clickLambda).invoke()
  }

  @Test
  fun based_on_state_play_icon_shown_or_not() {
    //This icon is used for play state inside the component
    val playIcon = TarkaIcons.Filled.Play12

    composable.setContent {
      TUIPlayPauseButton(
        state = Play
      ) {}
    }
    composable.onNodeWithContentDescription(playIcon.contentDescription).assertIsDisplayed()
  }

  @Test
  fun based_on_state_pause_icon_shown_or_not() {
    //This icon is used for pause state inside the component
    val pauseIcon = TarkaIcons.Filled.Pause12

    composable.setContent {
      TUIPlayPauseButton(
        state = Pause
      ) {}
    }
    composable.onNodeWithContentDescription(pauseIcon.contentDescription).assertIsDisplayed()
  }
}