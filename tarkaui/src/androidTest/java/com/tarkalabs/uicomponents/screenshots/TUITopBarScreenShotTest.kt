@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.uicomponents.R.drawable
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.models.TarkaIcon
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.runners.Parameterized

@OptIn(ExperimentalMaterial3Api::class)
@RunWith(Parameterized::class)
class TUITopBarScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_${darkTheme}"
          add(arrayOf(testName, darkTheme))
        }
      }
    }
  }

  @Test fun renderTopAppBarTextOnly() = compareScreenshotFor(darkTheme, "_renderTopAppBarTextOnly_$testName") {
    TUITopBar(title = "Screenshot")
  }

  @Test fun renderTopAppBarTextWithIcon() = compareScreenshotFor(darkTheme, "_renderTopAppBarTextWithIcon_$testName") {
    TUITopBar(
      title = "Screenshot",
      navigationIcon = TarkaIcon(drawable.keyboard_arrow_right, "Arrow Right")
    )
  }
}