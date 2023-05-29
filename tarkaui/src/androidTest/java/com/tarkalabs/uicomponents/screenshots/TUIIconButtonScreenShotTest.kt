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

@RunWith(JUnit4::class)
class TUIIconButtonScreenShotTest : ComposeScreenshotComparator() {

  @Test fun primaryIconButton() = compareScreenshotFor {
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.PRIMARY,
      )
  }

  @Test fun secondaryIconButton() = compareScreenshotFor {
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.SECONDARY,
      )
  }

  @Test fun ghostIconButton()  = compareScreenshotFor{
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.GHOST,
      )
  }

  @Test fun outlineIconButton() = compareScreenshotFor{
      TUIIconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.OUTLINE,
      )
  }
}