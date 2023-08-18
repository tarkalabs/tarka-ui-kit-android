package com.tarkalabs.uicomponents

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemBgColor.GREEN
import com.tarkalabs.uicomponents.components.MobileOverlayMenuLeadingContent.ADD
import com.tarkalabs.uicomponents.components.MobileOverlayMenuTrailingContent
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItem
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItemTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMobileOverlayMenuItemTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun is_passed_things_shown() {

    val title = "titleTest"
    val desc = "descriptionTest"

    //icon used while MobileOverlayMenuLeadingContent.CHECKMARK passed
    val leadingIconConRes = TarkaIcons.Add24Filled.contentDescription

    //icon used while MobileOverlayMenuLeadingContent.CHECKMARK passed
    val trailingIconConRes = TarkaIcons.CheckMark24Filled.contentDescription

    // used color while passing backgroundColor = GREEN
    val greenBgColor = Color(0xFF148F47).copy(alpha = 0.10f)

    val tags = TUIMobileOverlayMenuItemTags()

    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(
        title = title,
        trailingContent = MobileOverlayMenuTrailingContent.CHECKMARK,
        leadingContent = ADD,
        description = desc,
        backgroundColor = GREEN
      ) {}
    }

    fun SemanticsNodeInteraction.assertBackgroundColor(expectedBackground: Color) {
      val capturedName = captureToImage().colorSpace.name
      assertEquals(expectedBackground.colorSpace.name, capturedName)
    }

    composeTestRule.onNodeWithTag(tags.titleTag, useUnmergedTree = true).assertTextEquals(title)
    composeTestRule.onNodeWithTag(tags.descriptionTag, useUnmergedTree = true)
      .assertTextEquals(desc)
    composeTestRule.onNodeWithTag(tags.leadingIconTag, useUnmergedTree = true)
      .assertContentDescriptionEquals(leadingIconConRes)
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true)
      .assertContentDescriptionEquals(trailingIconConRes)
    composeTestRule.onNodeWithTag(tags.parentTag).assertBackgroundColor(greenBgColor)
  }

  @Test
  fun on_item_click_invoked() {
    val onClickLambda: () -> Unit = mock()
    val testTags = TUIMobileOverlayMenuItemTags()
    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(title = "", onItemClicked = onClickLambda, tags = testTags)
    }
    composeTestRule.onNodeWithTag(testTags.parentTag).performClick()
    verify(onClickLambda).invoke()
  }
}