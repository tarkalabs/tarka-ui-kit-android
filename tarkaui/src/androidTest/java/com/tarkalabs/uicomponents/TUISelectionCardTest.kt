package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUISelectionCard
import com.tarkalabs.uicomponents.components.TUISelectionCardTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUISelectionCardTest {

  @get:Rule val composeRule = createComposeRule()

  @Test
  fun isPassedThingsInShownInUI() {

    val label = "LabelTest"
    val desc = "DescTest"
    val desc2 = "Desc2Test"
    val detail = "Detail1Test"
    val detail2 = "Detail2Test"
    val badgeCount = 5

    val leadingIcon = TarkaIcons.Person24Regular

    //This is default icon when
    // isTrailingBackArrowEnabled = true
    val trailingIcon = TarkaIcons.ChevronRight24Regular

    val tags = TUISelectionCardTags()

    composeRule.setContent {
      TUISelectionCard(
        label = label,
        description = desc,
        description2 = desc2,
        details = detail,
        details2 = detail2,
        badgeCount = badgeCount,
        leadingIcon = leadingIcon,
        showTrailingIcon = true,
        tags = tags,
      ) {

      }
    }

    //if we used multiple similar types of composable or Nodes inside a  compose function. jetpack will merge all those into one for performance improvements.
    // but we need to find the exact unmerged node (composable) to test. so that's why passed useUnmergedTree = true while finding a node.

    // All are Text Composable
    composeRule.onNodeWithTag(tags.labelTag, useUnmergedTree = true).assertTextEquals(label)
    composeRule.onNodeWithTag(tags.descriptionTag, useUnmergedTree = true).assertTextEquals(desc)
    composeRule.onNodeWithTag(tags.description2Tag, useUnmergedTree = true).assertTextEquals(desc2)
    composeRule.onNodeWithTag(tags.detailsTag, useUnmergedTree = true).assertTextEquals(detail)
    composeRule.onNodeWithTag(tags.details2Tag, useUnmergedTree = true).assertTextEquals(detail2)

    //All are Icon Composable
    composeRule.onNodeWithTag(tags.leadingIconTag, useUnmergedTree = true)
      .assertContentDescriptionContains(leadingIcon.contentDescription)
    composeRule.onNodeWithTag(tags.trailingFrontArrowIconTag, useUnmergedTree = true)
      .assertContentDescriptionContains(trailingIcon.contentDescription)
  }

  @Test
  fun isOnclickInvoked() {

    val onCLickLambda: () -> Unit = mock()

    val parentTestTag = "TestParentTag"

    composeRule.setContent {
      TUISelectionCard(
        label = "",
        description = "",
        onCardClicked = onCLickLambda,
        tags = TUISelectionCardTags().copy(parentTag = parentTestTag)
      )
    }

    composeRule.onNodeWithTag(parentTestTag).performClick()

    verify(onCLickLambda).invoke()
  }
}