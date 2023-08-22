package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.core.R.drawable
import com.tarkalabs.tarkaicons.Call16
import com.tarkalabs.tarkaicons.Checkmark16
import com.tarkalabs.tarkaicons.Copy24
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITextRow
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.components.TextRowStyle
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
        style = TextRowStyle.TitleWithDescription(description = "Description"),
        infoIcon = TarkaIcons.Regular.Delete24,
        iconOne = TarkaIcons.Regular.Copy24,
        iconTwo = TarkaIcons.Filled.Checkmark16,
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
        infoIcon = TarkaIcons.Regular.Call16,
        iconOne = TarkaIcons.Regular.Call16,
        iconTwo = TarkaIcons.Regular.Call16,
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