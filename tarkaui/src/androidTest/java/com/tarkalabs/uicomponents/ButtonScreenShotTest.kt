package com.tarkalabs.uicomponents

import TUIButton
import ButtonSize.L
import ButtonStyle.ERROR
import ButtonStyle.GHOST
import ButtonStyle.OUTLINE
import ButtonStyle.PRIMARY
import ButtonStyle.SECONDARY
import androidx.compose.ui.test.junit4.createComposeRule
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ButtonScreenShotTest : ScreenshotTest {

  @get: Rule val composeRule = createComposeRule()

  @Test fun primaryButtonTest() {
    composeRule.setContent {
      TUIButton(label = "Primary button", buttonStyle = PRIMARY, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun secondaryButtonTest() {
    composeRule.setContent {
      TUIButton(label = "Secondary button", buttonStyle = SECONDARY, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun ghostButtonTest() {
    composeRule.setContent {
      TUIButton(label = "Ghost button", buttonStyle = GHOST, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun errorButtonTest() {
    composeRule.setContent {
      TUIButton(label = "Error button", buttonStyle = ERROR, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }

  @Test fun outlineButtonTest() {
    composeRule.setContent {
      TUIButton(label = "Outline button", buttonStyle = OUTLINE, height = L, onClick = {})
    }
    compareScreenshot(composeRule)
  }
}