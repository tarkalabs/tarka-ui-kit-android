package com.tarkalabs.uicomponents

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIMediaThumbnail
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailTags
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Image
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Video
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIThumbnailTest {
  @get:Rule val composeTestRule = createComposeRule()
  private val tags: TUIMediaThumbnailTags = TUIMediaThumbnailTags()

  @Test fun document_thumbnail_Displayed() {
    composeTestRule.setContent {
      TUIMediaThumbnail(
        type = TUIMediaThumbnailType.Document, showTrailingIcon = true, tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.centerIconTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Composable fun getBitmap(): ImageBitmap {
    val option = BitmapFactory.Options()
    option.inPreferredConfig = Bitmap.Config.ARGB_8888
    return BitmapFactory.decodeResource(
      LocalContext.current.resources, R.drawable.tarka, option
    ).asImageBitmap()
  }

  @Test fun image_thumbnail_Displayed() {
    composeTestRule.setContent {
      TUIMediaThumbnail(
        type = Image(getBitmap()), showTrailingIcon = true, tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun video_thumbnail_Displayed() {
    composeTestRule.setContent {
      TUIMediaThumbnail(
        type = Video(getBitmap()), showTrailingIcon = true, tags = tags
      )
    }
    composeTestRule.onNodeWithTag(tags.parentTag, useUnmergedTree = true).assertIsDisplayed()
    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun thumbnail_Elements_Click_Triggered() {
    val onTrailingIconClick: () -> Unit = mock()
    val onThumbnailClick: () -> Unit = mock()

    composeTestRule.setContent {
      TUIMediaThumbnail(
        type = Video(getBitmap()),
        showTrailingIcon = true,
        tags = tags,
        onTrailingIconClick = onTrailingIconClick,
        onThumbnailClick = onThumbnailClick
      )
    }

    composeTestRule.onNodeWithTag(tags.trailingIconTag, useUnmergedTree = true).performClick()
    verify(onTrailingIconClick).invoke()


    composeTestRule.onNodeWithTag(tags.centerIconTag, useUnmergedTree = true).performClick()
    verify(onThumbnailClick).invoke()
  }
}