package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tarkalabs.tarkaui.components.base.BadgeSize.L
import com.tarkalabs.tarkaui.components.base.BadgeStyle
import com.tarkalabs.tarkaui.components.base.TUIBadge
import com.tarkalabs.tarkaui.components.base.TUIBadgeTags
import com.tarkalabs.tarkaui.icons.Symbols16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Rule
import org.junit.Test

class TUIBadgeTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val tags = TUIBadgeTags(parentTag = "testTag")

    @Test
    fun text_badge_Displayed() {
        composeTestRule.setContent {
            TUIBadge(
                badgeSize = L,
                tags = tags,
                style = BadgeStyle.Count(299)
            )
        }
        composeTestRule.onNodeWithText("299").assertIsDisplayed()
        composeTestRule.onNodeWithTag(tags.iconTag).assertDoesNotExist()
    }

    @Test
    fun icon_badge_Displayed() {
        composeTestRule.setContent {
            TUIBadge(
                badgeSize = L,
                tags = tags,
                style = BadgeStyle.Icon(TarkaIcons.Regular.Symbols16)
            )
        }
        composeTestRule.onNodeWithTag(tags.iconTag).assertIsDisplayed()
    }

    @Test
    fun empty_badge_Displayed() {
        composeTestRule.setContent {
            TUIBadge(
                badgeSize = L,
                tags = tags
            )
        }
        composeTestRule.onNodeWithTag(tags.iconTag).assertDoesNotExist()
        composeTestRule.onNodeWithTag(tags.parentTag).assertExists()
    }
}