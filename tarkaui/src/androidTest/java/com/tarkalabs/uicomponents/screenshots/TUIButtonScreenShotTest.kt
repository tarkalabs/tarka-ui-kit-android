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
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIButtonScreenShotTest(
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

  @Test fun primaryButtonTest() = compareScreenshotFor(darkTheme, "_primaryButtonTest_$testName") {
    TUIButton(label = "Primary button", buttonStyle = PRIMARY, height = L, onClick = {})
  }

  @Test fun secondaryButtonTest() = compareScreenshotFor(darkTheme, "_secondaryButtonTest_$testName") {
    TUIButton(label = "Secondary button", buttonStyle = SECONDARY, height = L, onClick = {})
  }

  @Test fun ghostButtonTest() = compareScreenshotFor(darkTheme, "_ghostButtonTest_$testName") {
    TUIButton(label = "Ghost button", buttonStyle = GHOST, height = L, onClick = {})
  }

  @Test fun errorButtonTest() = compareScreenshotFor(darkTheme, "_errorButtonTest_$testName"){
    TUIButton(label = "Error button", buttonStyle = ERROR, height = L, onClick = {})
  }

  @Test fun outlineButtonTest() = compareScreenshotFor(darkTheme, "_outlineButtonTest_$testName"){
    TUIButton(label = "Outline button", buttonStyle = OUTLINE, height = L, onClick = {})
  }
}