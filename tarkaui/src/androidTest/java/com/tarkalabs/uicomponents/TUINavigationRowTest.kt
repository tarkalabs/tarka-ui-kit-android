package com.tarkalabs.uicomponents

import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUINavigationRow
import com.tarkalabs.uicomponents.components.TUINavigationRowTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUINavigationRowTest {
  @get:Rule val composable = createComposeRule()

  private val TAGS = TUINavigationRowTags(parentTag = "rowTestTag")

  @Test fun navigationRow_Elements_Displayed() {

    composable.setContent {
      TUINavigationRow(title = "Label",
        leadingIcon = TarkaIcons.CheckMark,
        onClick = {},
        tags = TAGS,
        content = {
          Text(text = "BEDFORD", modifier = Modifier.testTag("BEDFORD"))
        })

    }

    composable.onNodeWithText("Label").assertIsDisplayed()
    composable.onNodeWithText("BEDFORD").assertIsDisplayed()
  }

  @Test fun navigationRow_Elements_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUINavigationRow(
        title = "Label",
        leadingIcon = TarkaIcons.Copy,
        onClick = onClick,
        tags = TAGS,
      ) {

      }
    }
    composable.onNodeWithTag(TAGS.parentTag).performClick()
    verify(onClick).invoke()

    composable.onNodeWithTag(TAGS.parentTag).assertHasClickAction().performClick()
  }
}