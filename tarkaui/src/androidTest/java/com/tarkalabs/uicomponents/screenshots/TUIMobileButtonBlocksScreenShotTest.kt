package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.ChevronUp24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIMobileButtonBlock
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileButtonBlocksScreenShotTest(
  private val testName: String,
  private val darkTheme: Boolean,
  private val leadIcon: TarkaIcon?,
  private val trailIcon: TarkaIcon?,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (leadIcon in listOf(TarkaIcons.Regular.ChevronUp24, null)) {
            for (trailIcon in listOf(TarkaIcons.Regular.ChevronDown24, null)) {
              val testName = "leadIC_Exist_${leadIcon !=null}_trailIC_Exist_${trailIcon != null}_darkTheme_${darkTheme}"
              add(arrayOf(testName, darkTheme, leadIcon, trailIcon))
            }
          }
        }
      }
    }
  }

  @Test fun oneButtonOnly() = compareScreenshotFor(darkTheme, "_oneButtonOnly_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = null,
      outlineButtonOnClick = null,
      leadingIcon = leadIcon,
      trailingIcon = trailIcon
    )
  }

  @Test fun twoButtons() = compareScreenshotFor(darkTheme, "_twoButtons_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
      leadingIcon = leadIcon,
      trailingIcon = trailIcon
    )
  }

  @Test fun twoButtonsWithWeight() = compareScreenshotFor(darkTheme, "_twoButtonsWithWeight_$testName") {
    TUIMobileButtonBlock(
      primaryButtonLabel = "Label",
      primaryButtonOnClick = { /*TODO*/ },
      outlineButtonLabel = "Label",
      outlineButtonOnClick = { /*TODO*/ },
      primaryButtonWeight = 3f,
      leadingIcon = leadIcon,
      trailingIcon = trailIcon
    )
  }
}