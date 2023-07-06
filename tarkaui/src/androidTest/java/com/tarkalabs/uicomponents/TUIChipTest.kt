package com.tarkalabs.uicomponents

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import com.tarkalabs.uicomponents.components.ChipLeadingContent
import com.tarkalabs.uicomponents.components.ChipType
import com.tarkalabs.uicomponents.components.TUIChip
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIChipTest {

  @get:Rule
  val composable = createComposeRule()

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
        onClick = onClick
      )
    }


    composable.onNodeWithText("Assist chip").assertIsDisplayed()
    composable.onNodeWithTag(Tags.TAG_AVATAR, useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText("Assist chip").performClick()
    verify(onClick).invoke()
  }
}