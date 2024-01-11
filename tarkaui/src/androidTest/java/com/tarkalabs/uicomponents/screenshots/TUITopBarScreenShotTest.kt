@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.tarkaicons.ArrowRight16
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITopAppBar
import org.junit.Test
import org.junit.runner.RunWith
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
    TUITopAppBar(title = "Screenshot")
  }

  @Test fun renderTopAppBarTextWithIcon() = compareScreenshotFor(darkTheme, "_renderTopAppBarTextWithIcon_$testName") {
    TUITopAppBar(
      title = "Screenshot",
      navigationIcon = TarkaIcons.Filled.ArrowRight16
    )
  }
}