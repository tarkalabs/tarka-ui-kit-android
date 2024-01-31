package com.tarkalabs.uicomponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaicons.AddCircle24
<<<<<<<< HEAD:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMobileOverlayMenuItemTest.kt
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemStyle.Title
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.MobileOverlayMenuItemTrailingContentType.Icon
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItem
import com.tarkalabs.uicomponents.components.TUIMobileOverlayMenuItemTags
import com.tarkalabs.uicomponents.theme.TUITheme
========
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUIMenuItem
import com.tarkalabs.uicomponents.components.TUIMenuItemTags
>>>>>>>> develop:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMenuItemTest.kt
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIMobileOverlayMenuItemTest {

  @get:Rule val composeTestRule = createComposeRule()
<<<<<<<< HEAD:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMobileOverlayMenuItemTest.kt
  val tags: TUIMobileOverlayMenuItemTags = TUIMobileOverlayMenuItemTags()

  @Test fun mobileOverlayMenuItem_Displayed() {
    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMobileOverlayMenuItemClick = {},
========
  val tags = TUIMenuItemTags()

  @Test fun menu_Item_Displayed() {
    composeTestRule.setContent {
      TUIMenuItem(
        label = "Label",
        onMenuItemClick = {},
>>>>>>>> develop:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMenuItemTest.kt
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = Regular.AddCircle24,
        trailingIcon = Regular.AddCircle24,
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.leadingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingContentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
  }

<<<<<<<< HEAD:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMobileOverlayMenuItemTest.kt
  @Test fun mobileOverlayMenuItem_WithDescription_Displayed() {
    composeTestRule.setContent {
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = TitleWithDescription("TitleWithDescription"),
        onMobileOverlayMenuItemClick = {},
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("Label",useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithText("TitleWithDescription",useUnmergedTree = true).assertIsDisplayed()
  }

========
>>>>>>>> develop:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMenuItemTest.kt
  @Test fun button_Click_Triggered() {
    val onMenuItemClick: () -> Unit = mock()

    composeTestRule.setContent {
<<<<<<<< HEAD:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMobileOverlayMenuItemTest.kt
      TUIMobileOverlayMenuItem(
        title = "Label",
        style = Title,
        onMobileOverlayMenuItemClick = onMenuItemClick,
========
      TUIMenuItem(
        label = "Label",
        onMenuItemClick = onMenuItemClick,
>>>>>>>> develop:tarkaui/src/androidTest/java/com/tarkalabs/uicomponents/TUIMenuItemTest.kt
        isSelected = true,
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = Regular.AddCircle24,
        trailingIcon = Regular.AddCircle24,
        tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag,useUnmergedTree = true).performClick()

    verify(onMenuItemClick).invoke()
  }

}