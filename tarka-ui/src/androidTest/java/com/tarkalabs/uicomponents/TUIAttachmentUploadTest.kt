package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.tarkaui.icons.Delete24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload.AttachmentState.UpLoadSuccessful
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.tarkaui.components.TUIAttachmentUpload.TUIAttachmentUploadTags
import com.tarkalabs.tarkaui.components.TUIMediaThumbnailType.Document
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIAttachmentUploadTest {
  @get:Rule val composable = createComposeRule()
  private val tags: TUIAttachmentUploadTags = TUIAttachmentUploadTags()

private val attachmentName = "document.jpg"

  @Test fun simple_Attachment__Displayed() {
    composable.setContent {
      TUIAttachmentUpload(
        type = Document,
        attachmentName = attachmentName,
        onTrailingIconClick = {
        },
        onAttachmentClick = { },
        tags = tags,
        showLeadingIcon = true,
        trailingIcon = TarkaIcons.Regular.Delete24
      )
    }
    composable.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText(attachmentName,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.menuItemTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.thumbTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun upload_Attachment__Displayed() {
    composable.setContent {
      TUIAttachmentUpload(
        type = Document,
        attachmentName = attachmentName,
        onTrailingIconClick = {
        },
        onAttachmentClick = { },
        tags = tags,
        state = UpLoading(progress = 50),
        showLeadingIcon = true,
        trailingIcon = TarkaIcons.Regular.Delete24
      )
    }
    composable.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText(attachmentName,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.menuItemTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.thumbTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.progressBarTag,useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun upload_Success_Attachment__Displayed() {
    composable.setContent {
      TUIAttachmentUpload(
        type = Document,
        attachmentName = attachmentName,
        onTrailingIconClick = {
        },
        onAttachmentClick = { },
        tags = tags,
        state = UpLoadSuccessful,
        showLeadingIcon = true,
        trailingIcon = TarkaIcons.Regular.Delete24
      )
    }
    composable.onNodeWithTag(tags.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithText(attachmentName,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.menuItemTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.thumbTag.parentTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.successIconTag,useUnmergedTree = true).assertIsDisplayed()
    composable.onNodeWithTag(tags.leadingIconTag,useUnmergedTree = true).assertIsDisplayed()
  }

  @Test fun attachment_Click_Triggered() {
    val onMenuClick: () -> Unit = mock()
    val onAttachmentClick: () -> Unit = mock()


    composable.setContent {
      TUIAttachmentUpload(
        type = Document,
        attachmentName = attachmentName,
        onTrailingIconClick = onMenuClick,
        onAttachmentClick = onAttachmentClick,
        tags = tags,
        showLeadingIcon = true,
        trailingIcon = TarkaIcons.Regular.Delete24
      )
    }

    composable.onNodeWithTag(tags.menuItemTag.parentTag,useUnmergedTree = true).performClick()
    verify(onMenuClick).invoke()

    composable.onNodeWithTag(tags.parentTag,useUnmergedTree = true).performClick()
    verify(onAttachmentClick).invoke()

  }

}