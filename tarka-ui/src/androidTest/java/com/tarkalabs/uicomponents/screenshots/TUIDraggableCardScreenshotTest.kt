package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.Modifier
import com.tarkalabs.tarkaui.components.card.TUIDraggableCard
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIDraggableCardScreenshotTest(
  private val testName: String,
  private val switchState: Boolean,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf<Array<Any>>().apply {
        for (darkTheme in listOf(true, false)) {
          for (switchState in listOf(true, false)) {
            val testName = "switchState_${switchState}darkTheme_${darkTheme}"
            add(arrayOf(testName, switchState, darkTheme))
          }
        }
      }
    }
  }

  @Test fun renderTUIDraggableCard() =
    compareScreenshotFor(darkTheme, "DraggableCard_$testName") {
      TUIDraggableCard(
        dragIconModifier = Modifier,
        switchCheckedState = switchState,
        title = "Description 1",
        onSwitchCheckedChange = {})
    }
}