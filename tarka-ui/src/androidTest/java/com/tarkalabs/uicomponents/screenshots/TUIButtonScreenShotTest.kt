package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.base.ButtonSize.L
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Custom
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Error
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Ghost
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Outline
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Primary
import com.tarkalabs.tarkaui.components.base.ButtonStyle.Secondary
import com.tarkalabs.tarkaui.components.base.TUIButton
import com.tarkalabs.tarkaui.theme.TUITheme
import org.junit.Test
import org.junit.runner.RunWith
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
    TUIButton(label = "Primary button", buttonStyle = Primary, height = L, onClick = {})
  }

  @Test fun secondaryButtonTest() = compareScreenshotFor(darkTheme, "_secondaryButtonTest_$testName") {
    TUIButton(label = "Secondary button", buttonStyle = Secondary, height = L, onClick = {})
  }

  @Test fun ghostButtonTest() = compareScreenshotFor(darkTheme, "_ghostButtonTest_$testName") {
    TUIButton(label = "Ghost button", buttonStyle = Ghost, height = L, onClick = {})
  }

  @Test fun errorButtonTest() = compareScreenshotFor(darkTheme, "_errorButtonTest_$testName"){
    TUIButton(label = "Error button", buttonStyle = Error, height = L, onClick = {})
  }

  @Test fun outlineButtonTest() = compareScreenshotFor(darkTheme, "_outlineButtonTest_$testName"){
    TUIButton(label = "Outline button", buttonStyle = Outline, height = L, onClick = {})
  }

  @Test fun customButtonTest() = compareScreenshotFor(darkTheme, "_customButtonTest_$testName"){
    TUIButton(
      label = "Custom button", buttonStyle = Custom(
      containerColor = TUITheme.colors.secondaryAlt, contentColor = TUITheme.colors.onSecondaryAlt
    ), height = L, onClick = {})
  }
}