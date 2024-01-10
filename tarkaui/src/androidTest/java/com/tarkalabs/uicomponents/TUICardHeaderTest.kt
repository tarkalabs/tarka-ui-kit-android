package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tarkalabs.tarkaicons.MoreHorizontal24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUICardHeader
import com.tarkalabs.uicomponents.components.TUICardHeaderTags
import org.junit.Rule
import org.junit.Test

class TUICardHeaderTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun tuiCardHeader_component_displayed() {

    val title = "Header Title"
    val tagOneTitle = "tagOne"
    val tagTwoTitle = "tagTwo"
    val tagThreeTitle = "tagThree"
    val trailingIcon = TarkaIcons.Regular.MoreHorizontal24

    val testTags = TUICardHeaderTags()
    composeTestRule.setContent {
      TUICardHeader(
        title = title,
        tagOneTitle = tagOneTitle,
        tagTwoTitle = tagTwoTitle,
        trailingIcon = trailingIcon,
        tagThreeTitle = tagThreeTitle,
        tags = testTags
      )
    }

    composeTestRule.onNodeWithTag(tagOneTitle).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tagTwoTitle).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tagThreeTitle).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tagThreeTitle).assertIsDisplayed()
    composeTestRule.onNodeWithTag(testTags.trailingIconTag).assertIsDisplayed()
  }
}