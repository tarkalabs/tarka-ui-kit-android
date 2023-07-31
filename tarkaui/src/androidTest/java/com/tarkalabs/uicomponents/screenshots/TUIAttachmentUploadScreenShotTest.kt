package com.tarkalabs.uicomponents.screenshots

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Image
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIAttachmentUploadScreenShotTest(
  private val darkTheme: Boolean,
  private val showLeadingIcon: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {
  companion object {

    @JvmStatic @Parameterized.Parameters fun data(): Collection<Array<Any?>> {
      val testData = ArrayList<Array<Any?>>()
      val darkThemeValues = listOf(true, false)
      val leadingIconsValues = listOf(true, false)

      for (showLeadingIcon in leadingIconsValues) {
        for (darkThemeValue in darkThemeValues) {
          val testName = "Style_showLeadingIcon${showLeadingIcon}_darkTheme_${darkThemeValue}"
          testData.add(arrayOf(darkThemeValue, showLeadingIcon, testName))
        }
      }
      return testData
    }
  }

  @Test fun test_normal_image_attachment() {
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
    compareScreenshotFor(
      darkTheme = darkTheme,
      imageName = "_testNormalImageAttachment_$testName"
    ) {
      TUIAttachmentUpload(type = Image(bitmap.asImageBitmap()),
        attachmentName = "document.jpg",
        onMenuClick = {},
        onAttachmentClick = { },
        showLeadingIcon = showLeadingIcon
      )
    }
  }

  @Test fun test_upload_image_attachment() {
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
    compareScreenshotFor(
      darkTheme = darkTheme,
      imageName = "_testUploadImageAttachment_$testName"
    ) {
      TUIAttachmentUpload(type = Image(bitmap.asImageBitmap()),
        attachmentName = "document.jpg",
        onMenuClick = {},
        onAttachmentClick = { },
        showLeadingIcon = showLeadingIcon,
        state = AttachmentState.UpLoading(51)
      )
    }
  }

  @Test fun test_upload_success_image_attachment() {
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
    compareScreenshotFor(
      darkTheme = darkTheme,
      imageName = "_testUploadSuccessImageAttachment_$testName"
    ) {
      TUIAttachmentUpload(type = Image(bitmap.asImageBitmap()),
        attachmentName = "document.jpg",
        onMenuClick = {},
        onAttachmentClick = { },
        showLeadingIcon = showLeadingIcon,
        state = AttachmentState.UpLoadSuccessful
      )
    }
  }

  @Test fun test_normal_document_attachment() {
    compareScreenshotFor(
      darkTheme = darkTheme,
      imageName = "_testNormalDocumentAttachment_$testName"
    ) {
      TUIAttachmentUpload(type = Document,
        attachmentName = "document.jpg",
        onMenuClick = {},
        onAttachmentClick = { },
        showLeadingIcon = showLeadingIcon
      )
    }
  }
}