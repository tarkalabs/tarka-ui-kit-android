@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.uicomponents.R.drawable
import com.tarkalabs.uicomponents.components.TUIMobileButtonBlock
import com.tarkalabs.uicomponents.components.TUITopBar
import com.tarkalabs.uicomponents.models.TarkaIcon
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.runners.Parameterized


@RunWith(Parameterized::class)
class TUIMobileButtonBlocksScreenShotTest(
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

  @Test fun oneButtonOnly() = compareScreenshotFor(darkTheme, "_oneButtonOnly_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = null,
      outlineButtonOnClick = null
    )
  }

  @Test fun twoButtons() = compareScreenshotFor(darkTheme, "_twoButtons_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ }
    )
  }

  @Test fun twoButtonsWithWeight() = compareScreenshotFor(darkTheme, "_twoButtonsWithWeight_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
      primaryButtonWeight = 3f
    )
  }
}