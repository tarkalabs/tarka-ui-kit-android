package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.base.IconButtonSize.XS
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Custom
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Outline
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Primary
import com.tarkalabs.tarkaui.components.base.IconButtonStyle.Secondary
import com.tarkalabs.tarkaui.components.base.TUIIconButton
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.Stop24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme
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
        iconButtonStyle = Primary,
      )
  }

  @Test fun secondaryIconButton() = compareScreenshotFor(darkTheme, "_secondaryIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = Secondary,
      )
  }

  @Test fun ghostIconButton()  = compareScreenshotFor(darkTheme, "_ghostIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = Ghost,
      )
  }

  @Test fun outlineIconButton() = compareScreenshotFor(darkTheme, "_outlineIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.ChevronRight20,
        buttonSize = XS,
        iconButtonStyle = Outline,
      )
  }

  @Test fun customIconButton() = compareScreenshotFor(darkTheme, "_customIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.Regular.Stop24,
        buttonSize = XS,
        iconButtonStyle = Custom(TUITheme.colors.success, TUITheme.colors.onSecondaryAlt),
      )
  }
}