package com.tarkalabs.commonui

import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import com.tarkalabs.uicomponents.components.ButtonSize.L
import com.tarkalabs.uicomponents.components.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.ButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.ButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.components.TKButton
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ButtonScreenShotTest : ScreenshotTest {

  @get: Rule val composeRule = createComposeRule()

  @Test fun primaryButtonTest() {
    composeRule.setContent {
      TKButton(label = "Primary button", buttonStyle = PRIMARY, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }
  @Test fun secondaryButtonTest() {
    composeRule.setContent {
      TKButton(label = "Secondary button", buttonStyle = SECONDARY, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun ghostButtonTest() {
    composeRule.setContent {
      TKButton(label = "Ghost button", buttonStyle = GHOST, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }
  @Test fun errorButtonTest() {
    composeRule.setContent {
      TKButton(label = "Error button", buttonStyle = ERROR, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun outlineButtonTest() {
    composeRule.setContent {
      TKButton(label = "Outline button", buttonStyle = OUTLINE, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

}