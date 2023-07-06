package com.tarkalabs.uicomponents

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.tarkalabs.uicomponents.components.ChipLeadingContent
import com.tarkalabs.uicomponents.components.ChipType
import com.tarkalabs.uicomponents.components.TUIChip
import com.tarkalabs.uicomponents.components.TUIChipTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIChipTest {

  @get:Rule
  val composable = createComposeRule()
  val chipTags = TUIChipTags()

  val context = InstrumentationRegistry.getInstrumentation().context
  val assetManager = context.assets

  @Test
  fun display_assist_chip_avatar() {
    val onClick: () -> Unit = mock()
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
    composable.setContent {
      TUIChip(
        type = ChipType.Assist,
        label = "Assist chip",
        leadingContent = ChipLeadingContent.Image(bitmap.asImageBitmap()),
        onClick = onClick,
        tags = chipTags.copy(parentTag = "Assist")
      )
    }

    composable.onNodeWithTag("Assist").assertIsDisplayed()
    composable.onNodeWithText("Assist chip").assertIsDisplayed()
    composable.onNodeWithTag(Tags.TAG_AVATAR, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText("Assist chip").performClick()
    verify(onClick).invoke()
  }

  @Test
  fun display_assist_chip_icon() {
    composable.setContent {
      TUIChip(type = ChipType.Assist,
        label = "Assist chip",
        leadingContent = ChipLeadingContent.Icon(TarkaIcons.Calendar24Regular),
        onClick = {})
    }

    composable.onNodeWithContentDescription(
      TarkaIcons.Calendar24Regular.contentDescription, useUnmergedTree = true
    ).assertIsDisplayed()
  }

  @Test
  fun display_input_chip() {
    val onClick: () -> Unit = mock()
    composable.setContent {
      TUIChip(
        type = ChipType.Input(true),
        label = "Input chip",
        onClick = onClick,
        tags = chipTags.copy(parentTag = "Input"),
      )
    }

    composable.onNodeWithTag("Input").assertIsDisplayed()
    composable.onNodeWithText("Input chip").assertIsDisplayed()
    composable.onNodeWithText("Input chip").performClick()
    verify(onClick).invoke()
  }

  @Test
  fun display_input_avatar() {
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
    composable.setContent {
      TUIChip(
        type = ChipType.Input(),
        label = "Input chip",
        onClick = { },
        leadingContent = ChipLeadingContent.Image(bitmap.asImageBitmap()),
        )
    }

    composable.onNodeWithTag(Tags.TAG_AVATAR, useUnmergedTree = true).assertIsDisplayed()
  }
}