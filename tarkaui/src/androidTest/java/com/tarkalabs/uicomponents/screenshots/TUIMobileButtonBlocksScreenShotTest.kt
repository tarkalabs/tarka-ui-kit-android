package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.ChevronUp24
import com.tarkalabs.tarkaicons.Eraser24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIMobileButtonBlock
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileButtonBlocksScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "_darkTheme_${darkTheme}"
          add(arrayOf(testName, darkTheme))
        }
      }
    }
  }

  @Test fun oneButtonOnlyWithoutIcon() = compareScreenshotFor(darkTheme, "_oneButtonOnlyWithoutIcon_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = null,
      outlineButtonOnClick = null,
    )
  }

  @Test fun oneButtonOnlyWithPrimaryLeadingIcon() = compareScreenshotFor(darkTheme, "_oneButtonOnlyWithPrimaryLeadingIcon_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = null,
      outlineButtonOnClick = null,
      primaryLeadingIcon = TarkaIcons.Regular.ChevronDown24,
      primaryTrailingIcon = null
    )
  }

  @Test fun oneButtonOnlyWithPrimaryTrailingIcon() = compareScreenshotFor(darkTheme, "_oneButtonOnlyWithPrimaryTrailingIcon_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = null,
      outlineButtonOnClick = null,
      primaryLeadingIcon = null,
      primaryTrailingIcon = TarkaIcons.Regular.ChevronUp24
    )
  }

  @Test fun twoButtonsWithOutlineTrailingIcon() = compareScreenshotFor(darkTheme, "_twoButtons_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
      outlineTrailingIcon = TarkaIcons.Regular.Eraser24
    )
  }

  @Test fun twoButtonsWithOutlineLeadingIcon() = compareScreenshotFor(darkTheme, "_twoButtons_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
      outlineLeadingIcon = TarkaIcons.Regular.Eraser24
    )
  }

  @Test fun twoButtons() = compareScreenshotFor(darkTheme, "_twoButtons_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
    )
  }

  @Test fun twoButtonsWithWeight() =
    compareScreenshotFor(darkTheme, "_twoButtonsWithWeight_$testName") {
      TUIMobileButtonBlock(
        primaryButtonLabel = "Label",
        primaryButtonOnClick = { /*TODO*/ },
        outlineButtonLabel = "Label",
        outlineButtonOnClick = { /*TODO*/ },
        primaryButtonWeight = 3f,
      )
    }
}