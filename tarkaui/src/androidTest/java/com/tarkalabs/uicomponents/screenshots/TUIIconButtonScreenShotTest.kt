@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.TUIIconButton
import com.tarkalabs.uicomponents.components.IconButtonSize
import com.tarkalabs.uicomponents.components.IconButtonStyle
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
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
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.PRIMARY,
      )
  }

  @Test fun secondaryIconButton() = compareScreenshotFor(darkTheme, "_secondaryIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.SECONDARY,
      )
  }

  @Test fun ghostIconButton()  = compareScreenshotFor(darkTheme, "_ghostIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.GHOST,
      )
  }

  @Test fun outlineIconButton() = compareScreenshotFor(darkTheme, "_outlineIconButton_$testName"){
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.OUTLINE,
      )
  }
}