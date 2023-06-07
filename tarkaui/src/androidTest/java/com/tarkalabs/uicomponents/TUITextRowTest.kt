package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.core.R.drawable
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUITextRowTest {
  @get:Rule val composable = createComposeRule()

  private val tags = TUITextRowTags(parentTag = "testTag")

  @Test fun textRow_Elements_Displayed() {
    composable.setContent {
      TUITextRow(
        title = "Title",
        description = "Description",
        infoIcon = TarkaIcons.Delete,
        iconOne = TarkaIcons.Copy,
        iconTwo = TarkaIcons.CheckMark,
        buttonTitle = "Label",
        tags = tags
      )
    }

    composable.onNodeWithText("Title").assertIsDisplayed()
    composable.onNodeWithText("Description").assertIsDisplayed()
    composable.onNodeWithTag(tags.buttonTag).assertIsDisplayed()
    composable.onNodeWithTag(tags.infoIconTag)
      .assertIsDisplayed()
    composable.onNodeWithTag(tags.iconOneTags.parentTag).assertIsDisplayed()
    composable.onNodeWithTag(tags.iconTwoTags.parentTag).assertIsDisplayed()
  }

  @Test fun textRow_Elements_Click_Triggered() {
    val onButtonClick: () -> Unit = mock()

    composable.setContent {
      TUITextRow(
        title = "Title",
        description = "Description",
        infoIcon = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        iconOne = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        iconTwo = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
        buttonTitle = "Label",
        onButtonClick = onButtonClick,
        tags = tags,
        onTextRowClick = {
        }
      )
    }
    composable.onNodeWithText("Label").performClick()
    verify(onButtonClick).invoke()

    composable.onNodeWithTag(tags.parentTag)
      .assertHasClickAction()
      .performClick()
  }
}