package com.tarkalabs.uicomponents.screenshots

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.uicomponents.components.TUIMediaThumbnail
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailSize
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Audio
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Document
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Image
import com.tarkalabs.uicomponents.components.TUIMediaThumbnailType.Video
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIThumbnailScreenShotTest(
  private val showTrailingIcon: Boolean,
  private val thumbnailSize: TUIMediaThumbnailSize,
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
      val thumbnailSizeValues = TUIMediaThumbnailSize.values()


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
      TUIMediaThumbnail(
        type = Audio,
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
        )
    }
  }

  @Test fun test_thumbnails_case_document() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Document_$testName") {
      TUIMediaThumbnail(
        type = Document,
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }

  @Test fun test_thumbnails_case_image() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Image_$testName") {
      TUIMediaThumbnail(
        type = Image(bitmap),
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }

  @Test fun test_thumbnails_case_video() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TUIThumbnail_Type_Video_$testName") {
      TUIMediaThumbnail(
        type = Video(bitmap),
        showTrailingIcon = showTrailingIcon,
        size = thumbnailSize,
      )
    }
  }
}