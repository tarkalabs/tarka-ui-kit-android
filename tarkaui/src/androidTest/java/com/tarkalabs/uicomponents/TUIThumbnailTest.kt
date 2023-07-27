package com.tarkalabs.uicomponents

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIThumbnail
import com.tarkalabs.uicomponents.components.TUIThumbnailTags
import com.tarkalabs.uicomponents.components.TUIThumbnailType
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Image
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Video
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIThumbnailTest {
  @get:Rule val composeTestRule = createComposeRule()
  private val tags: TUIThumbnailTags = TUIThumbnailTags()


  @Test fun document_thumbnail_Displayed() {
    composeTestRule.setContent {
      TUIThumbnail(type = TUIThumbnailType.Document,
        showTrailingIcon = true,
        tags = tags)
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.centerIconTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun image_thumbnail_Displayed() {
    composeTestRule.setContent {
      val option = BitmapFactory.Options()
      option.inPreferredConfig = Bitmap.Config.ARGB_8888
      val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources, R.drawable.tarka, option
      ).asImageBitmap()

      TUIThumbnail(type = Image(bitmap),
        showTrailingIcon = true,
        tags = tags)
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }
  @Test fun video_thumbnail_Displayed() {
    composeTestRule.setContent {
      val option = BitmapFactory.Options()
      option.inPreferredConfig = Bitmap.Config.ARGB_8888
      val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources, R.drawable.tarka, option
      ).asImageBitmap()

      TUIThumbnail(type = Video(bitmap),
        showTrailingIcon = true,
        tags = tags)
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun thumbnail_Elements_Click_Triggered() {
    val onTrailingIconClick: () -> Unit = mock()
    val onThumbnailClick: () -> Unit = mock()

    composeTestRule.setContent {
      val option = BitmapFactory.Options()
      option.inPreferredConfig = Bitmap.Config.ARGB_8888
      val bitmap = BitmapFactory.decodeResource(
        LocalContext.current.resources, R.drawable.tarka, option
      ).asImageBitmap()

      TUIThumbnail(type = Video(bitmap),
        showTrailingIcon = true,
        tags = tags,
      onTrailingIconClick = onTrailingIconClick,
      onThumbnailClick = onThumbnailClick)
    }

    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).performClick()
    verify(onTrailingIconClick).invoke()


    composeTestRule.onNodeWithTag(tags.centerIconTag, useUnmergedTree = true).performClick()
    verify(onThumbnailClick).invoke()
  }


}