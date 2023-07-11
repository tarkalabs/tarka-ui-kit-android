package com.tarkalabs.uicomponents

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.uicomponents.components.TUIEmailField
import com.tarkalabs.uicomponents.components.TUIEmailFieldTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test

class TUIEmailFieldTest {
  @get:Rule val composable = createComposeRule()
  private val tags: TUIEmailFieldTags = TUIEmailFieldTags()
  private val emailList = listOf(  "mike32@soft.com",
    "mike.smith@corp.co",
    "mike32@soft.com",)

  @Test fun email_field_is_displayed() {
    composable.setContent {
      val emailList = remember {
        mutableStateListOf(
          "mike32@soft.com",
          "mike.smith@corp.co",
          "mike32@soft.com",
        )
      }
      TUIEmailField(
        title = "To",
        emailAddressList = emailList,
        trailingIcon = TarkaIcons.AddCircle24Regular,
        onItemRemoved = { position ->

        },
        trailingIconClick = {

        },
        onItemAdd = {

        },
        tags = tags
      )

    }

    composable.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.textFieldTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.flowRowTag, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText("To", useUnmergedTree = true).assertIsDisplayed()
    // emailList.forEach { email ->
    //   composable.onNodeWithText(email, useUnmergedTree = true).assertIsDisplayed()
    // }
    composable.onNodeWithTag(tags.iconButtonTag.parentTag, useUnmergedTree = true).assertIsDisplayed()
  }
}