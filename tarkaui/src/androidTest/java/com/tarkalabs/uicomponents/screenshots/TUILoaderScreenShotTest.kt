package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.android.material.R.drawable
import com.tarkalabs.uicomponents.components.LoaderImageSize
import com.tarkalabs.uicomponents.components.LoaderSize
import com.tarkalabs.uicomponents.components.LoaderSize.L
import com.tarkalabs.uicomponents.components.LoaderSize.M
import com.tarkalabs.uicomponents.components.LoaderSize.S
import com.tarkalabs.uicomponents.components.TUILoaderSpinnerImage
import com.tarkalabs.uicomponents.components.TUILoader
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUILoaderScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean,
  private val spinnerImage: Boolean,
  private val loaderSize: LoaderSize,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (withImage in listOf(true, false)) {
            for (loaderSize in listOf(L, M, S)) {
              val testName =
                "darkTheme_${darkTheme}_withImage_${withImage}_loaderSize_${loaderSize}"
              add(arrayOf(testName, darkTheme, withImage, loaderSize))
            }
          }
        }
      }
    }
  }

  @Test
  fun loaderScreenShotTest() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(TUITheme.colors.surface),
        contentAlignment = Alignment.Center
      ) {
        TUILoader(
          loaderHeight = loaderSize,
          spinnerImage = if (spinnerImage) TUILoaderSpinnerImage(
            resourceId = drawable.material_ic_keyboard_arrow_right_black_24dp,
            contentDescription = "loader_content",
            imageSize = if (loaderSize == L) LoaderImageSize.L else if (loaderSize == M) LoaderImageSize.M else LoaderImageSize.S
          ) else null
        )
      }
    }
  }
}