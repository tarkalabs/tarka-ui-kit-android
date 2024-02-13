@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.components.base.IconButtonSize.XS
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.SECONDARY
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIIconButtonScreenShotTest(
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
  @Test fun primaryIconButton() = compareScreenshotFor(darkTheme, "_primaryIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = PRIMARY,
      )
  }

  @Test fun secondaryIconButton() = compareScreenshotFor(darkTheme, "_secondaryIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = SECONDARY,
      )
  }

  @Test fun ghostIconButton()  = compareScreenshotFor(darkTheme, "_ghostIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = GHOST,
      )
  }

  @Test fun outlineIconButton() = compareScreenshotFor(darkTheme, "_outlineIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = OUTLINE,
      )
  }
}