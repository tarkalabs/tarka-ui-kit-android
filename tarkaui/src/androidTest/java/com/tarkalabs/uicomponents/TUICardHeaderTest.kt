package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.MoreHorizontal24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUICardHeader
import com.tarkalabs.uicomponents.components.TUICardHeaderTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUICardHeaderTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun is_passed_things_shown() {

    val onTrailIconClick: () -> Unit = mock()
    val title = "Test Title"
    val tagTitle = "Test Tag Title"
    val trailingIcon = TarkaIcons.Regular.MoreHorizontal24

    val testTags = TUICardHeaderTags()
    composeTestRule.setContent {
      TUICardHeader(
        title = title,
        tagTitle = tagTitle,
        trailingIcon = trailingIcon,
        onTrailingIconClick = onTrailIconClick,
        tags = testTags
      )
    }

    composeTestRule.onNodeWithTag(testTags.titleTag).assertTextEquals(title)
    composeTestRule.onNodeWithTag(testTags.tagTitleTag).assertTextEquals(tagTitle)

    composeTestRule.onNodeWithContentDescription(trailingIcon.contentDescription).assertExists()

    composeTestRule.onNodeWithTag(testTags.trailingIconTag).performClick()
    verify(onTrailIconClick).invoke()
  }
}