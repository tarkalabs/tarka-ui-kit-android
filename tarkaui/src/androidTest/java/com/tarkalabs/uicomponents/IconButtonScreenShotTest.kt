@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.commonui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.IconButton
import com.tarkalabs.uicomponents.components.IconButtonSize
import com.tarkalabs.uicomponents.components.IconButtonStyle
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class IconButtonScreenShotTest : ScreenshotTest {

  @get:Rule
  val composeRule = createComposeRule()

  @Test
  fun primaryIconButton() {
    composeRule.setContent {
      IconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.PRIMARY,
      )
    }

    compareScreenshot(composeRule)
  }

  @Test
  fun secondaryIconButton() {
    composeRule.setContent {
      IconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.SECONDARY,
      )

    }

    compareScreenshot(composeRule)
  }

  @Test
  fun ghostIconButton() {
    composeRule.setContent {
      IconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.GHOST,
      )

    }

    compareScreenshot(composeRule)
  }

  @Test
  fun outlineIconButton() {
    composeRule.setContent {
      IconButton(
        icon = TarkaIcons.ChevronRight,
        buttonSize = IconButtonSize.XS,
        iconButtonStyle = IconButtonStyle.OUTLINE,
      )

    }

    compareScreenshot(composeRule)
  }
}