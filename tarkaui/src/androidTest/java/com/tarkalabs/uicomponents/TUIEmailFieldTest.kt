package com.tarkalabs.uicomponents

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performTextInput
import com.tarkalabs.tarkaicons.AddCircle24
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.email.TUIEmailField
import com.tarkalabs.uicomponents.components.email.TUIEmailFieldTags
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIEmailFieldTest {
  @get:Rule val composable = createComposeRule()
  private val tags: TUIEmailFieldTags =
    TUIEmailFieldTags(iconButtonTag = TUIIconButtonTags(parentTag = "TRAILING_ICON"))
  private val emailList = listOf(
    "mike32@soft.com",
    "mike.smith@corp.co",
    "mike32@soft.com",
  )

  @Test fun email_field_is_displayed() {
    composable.setContent {
      val emailList = remember {
        mutableStateListOf(
          "mike32@soft.com",
          "mike.smith@corp.co",
          "mike33@soft.com",
        )
      }
      TUIEmailField(
        title = "To",
        emailAddressList = emailList,
        trailingIcon = Regular.AddCircle24,
        onItemRemoved = { position ->

        },
        trailingIconClick = {

        },
        onItemAdd = {

        },
        tags = tags,
        onInvalidEmail = {}
      )

    }

    composable.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.textFieldTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.flowRowTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText("To", useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.iconButtonTag.parentTag, useUnmergedTree = true)
      .assertIsDisplayed()
    emailList.forEach { email ->
      composable.onNodeWithText(email, useUnmergedTree = true).assertIsDisplayed()
    }
  }

  @Test fun click_event_is_Triggered() {
    val trailingIconClick: () -> Unit = mock()

    composable.setContent {
      val emailList = remember {
        mutableStateListOf(
          "mike32@soft.com",
          "mike.smith@corp.co",
          "mike33@soft.com",
        )
      }
      TUIEmailField(
        title = "To",
        emailAddressList = emailList,
        trailingIcon = Regular.AddCircle24,
        onItemRemoved = { position ->

        },
        trailingIconClick = trailingIconClick,
        onItemAdd = {
          emailList.add(it)
        },
        tags = tags, onInvalidEmail = {}
      )
    }

    composable.onNodeWithTag(tags.iconButtonTag.parentTag).performClick()
    verify(trailingIconClick).invoke()

    val inputText = "android@gmail.com"
    val textField = composable.onNodeWithTag(tags.textFieldTag, useUnmergedTree = true)
    textField.performTextInput(inputText)
    textField.performImeAction()

    composable.onNodeWithText(inputText, useUnmergedTree = true).assertIsDisplayed()
  }
}