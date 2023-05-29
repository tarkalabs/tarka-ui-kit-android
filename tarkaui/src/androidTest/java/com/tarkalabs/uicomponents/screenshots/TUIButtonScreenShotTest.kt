package com.tarkalabs.uicomponents.screenshots

import ButtonSize.L
import ButtonStyle.ERROR
import ButtonStyle.GHOST
import ButtonStyle.OUTLINE
import ButtonStyle.PRIMARY
import ButtonStyle.SECONDARY
import TUIButton
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TUIButtonScreenShotTest : ComposeScreenshotComparator() {

  @Test fun primaryButtonTest() = compareScreenshotFor {
    TUIButton(label = "Primary button", buttonStyle = PRIMARY, height = L, onClick = {})
  }

  @Test fun secondaryButtonTest() = compareScreenshotFor {
    TUIButton(label = "Secondary button", buttonStyle = SECONDARY, height = L, onClick = {})
  }

  @Test fun ghostButtonTest() = compareScreenshotFor {
    TUIButton(label = "Ghost button", buttonStyle = GHOST, height = L, onClick = {})
  }

  @Test fun errorButtonTest() = compareScreenshotFor {
    TUIButton(label = "Error button", buttonStyle = ERROR, height = L, onClick = {})
  }

  @Test fun outlineButtonTest() = compareScreenshotFor {
    TUIButton(label = "Outline button", buttonStyle = OUTLINE, height = L, onClick = {})
  }
}