package com.tarkalabs.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.Timer20
import com.tarkalabs.uicomponents.components.base.TUIInputField
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Icon
import com.tarkalabs.uicomponents.components.base.TUIInputFieldContentType.Text
import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus.Normal
import com.tarkalabs.uicomponents.components.base.TUIInputFieldTags
import com.tarkalabs.uicomponents.components.base.TUIInputFieldType.LookupInputField
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIInputFieldTest {
  @get:Rule val composeTestRule = createComposeRule()

  private val testTags: TUIInputFieldTags = TUIInputFieldTags()

  @Test fun tuiInputBodyField_Displayed() {
    composeTestRule.setContent {
      TUITheme {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ) {
          TUIInputField(
            leadingContent = Text("$"),
            trailingContent = Icon(TarkaIcons.Regular.Timer20),
            value = "",
            onValueChange = { },
            status = Normal,
            enabled = false,
            label = "Label",
            testTags = testTags,
            helperMessage = "Hello there"
          )
        }
      }
    }

    composeTestRule.onNodeWithTag(testTags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(testTags.trailingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(testTags.leadingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(testTags.labelTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(testTags.helperTextTag,useUnmergedTree = true).assertIsDisplayed()
  }

  @Test
  fun tuiInputBodyField_Click_Event_Triggered(){
    val textFieldClick: () -> Unit = mock()

    composeTestRule.setContent {
      TUITheme {
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
        ) {
          TUIInputField(
            leadingContent = Text("$"),
            trailingContent = Icon(TarkaIcons.Regular.Timer20),
            value = "",
            onValueChange = { },
            status = Normal,
            label = "Label",
            testTags = testTags,
            helperMessage = "Hello there",
            modifier = Modifier.clickable{
              textFieldClick.invoke()
            },
            inputFieldTye = LookupInputField
          )
        }
      }
    }

    composeTestRule.onNodeWithTag(testTags.parentTag,useUnmergedTree = true).performClick()
    verify(textFieldClick).invoke()

  }
}