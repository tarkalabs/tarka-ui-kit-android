package com.tarkalabs.uicomponents.screenshots

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.uicomponents.components.TUIThumbnail
import com.tarkalabs.uicomponents.components.TUIThumbnailSize
import com.tarkalabs.uicomponents.components.TUIThumbnailTags
import com.tarkalabs.uicomponents.components.TUIThumbnailType
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Audio
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Image
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Video
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIThumbnailScreenShotTest(
  private val showTrailingIcon: Boolean,
  private val thumbnailSize: TUIThumbnailSize,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  private lateinit var  bitmap : ImageBitmap

  @Before
  fun setUp() {
    bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp")).asImageBitmap()
  }

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(true, false)
      val showTrailingIconValues = listOf(true, false)
      val thumbnailSizeValues = TUIThumbnailSize.values()


      val testData = ArrayList<Array<Any?>>()
        for (tuiThumbnailSize in thumbnailSizeValues) {
          for (showTrailingIcon in showTrailingIconValues) {
            for (darkTheme in darkThemeValues) {
              val testName =
                "Size_${tuiThumbnailSize.name}_showTrailingIcon_${showTrailingIcon}_darkTheme_${darkTheme}"
              testData.add(
                arrayOf(
                  showTrailingIcon,
                  tuiThumbnailSize,
                  testName,
                  darkTheme
                )
              )
            }
          }
      }
      return testData
    }
  }

  @Test fun test_thumbnails_case_audio() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Audio_$testName") {
      TUIThumbnail(
        type = Audio,
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
        )
    }
  }

  @Test fun test_thumbnails_case_document() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Document_$testName") {
      TUIThumbnail(
        type = Document,
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }

  @Test fun test_thumbnails_case_image() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Image_$testName") {
      TUIThumbnail(
        type = Image(bitmap),
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }

  @Test fun test_thumbnails_case_video() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Video_$testName") {
      TUIThumbnail(
        type = Video(bitmap),
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }
}