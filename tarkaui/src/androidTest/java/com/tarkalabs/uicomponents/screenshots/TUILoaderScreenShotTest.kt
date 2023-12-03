package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.material.R.drawable
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
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (withImage in listOf(true, false)) {
            val testName =
              "darkTheme_${darkTheme}_withImage_${withImage}"
            add(arrayOf(testName, darkTheme, withImage))
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
          spinnerImage = if (spinnerImage) TUILoaderSpinnerImage(
            resourceId = drawable.material_ic_keyboard_arrow_right_black_24dp,
            contentDescription = "loader_content",
            height = 100.dp,
            width = 100.dp
          ) else null
        )
      }
    }
  }
}