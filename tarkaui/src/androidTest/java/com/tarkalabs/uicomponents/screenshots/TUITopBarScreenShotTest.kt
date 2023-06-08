@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.uicomponents.R.drawable
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.models.TarkaIcon
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalMaterial3Api::class)
@RunWith(JUnit4::class)
class TUITopBarScreenShotTest : ComposeScreenshotComparator() {

  @Test fun renderTopAppBarTextOnly() = compareScreenshotFor {
    TUITopBar(title = "Screenshot")
  }

  @Test fun renderTopAppBarTextWithIcon() = compareScreenshotFor {
    TUITopBar(
      title = "Screenshot",
      navigationIcon = TarkaIcon(drawable.keyboard_arrow_right, "Arrow Right")
    )
  }
}