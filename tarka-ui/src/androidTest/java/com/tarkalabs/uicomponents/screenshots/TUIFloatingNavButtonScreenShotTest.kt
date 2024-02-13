package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.icons.CalendarRtl24
import com.tarkalabs.tarkaui.icons.Directions24
import com.tarkalabs.tarkaui.icons.Diversity24
import com.tarkalabs.tarkaui.icons.Map24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButton
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Burger
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Navigation
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.BURGER
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.LIST
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.NAVIGATION
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.VIEW_TOGGLE
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIFloatingNavButtonScreenShotTest(
  private val darkTheme: Boolean,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      return mutableListOf<Array<Any?>>().apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_${darkTheme}"
          add(arrayOf(darkTheme, testName))
        }
      }
    }
  }

  @Test fun floatingNavButton() = compareScreenshotFor(darkTheme, "_floatingNavButton_$testName") {
    TUIFloatingNavButton(
      contentType = Navigation(leadingIcon = TarkaIcons.Filled.Diversity24, text = "Overview"),
      style = NAVIGATION
    )
  }

  @Test fun floatingNavViewToggleButton() =
    compareScreenshotFor(darkTheme, "_floatingNavViewToggleButton_$testName") {
      TUIFloatingNavButton(
        contentType = Navigation(leadingIcon = TarkaIcons.Filled.Diversity24, text = "Overview"),
        style = VIEW_TOGGLE
      )
    }

  @Test fun floatingNavBurgerButton() =
    compareScreenshotFor(darkTheme, "_floatingNavBurgerButton_$testName") {
      TUIFloatingNavButton(contentType = Burger, style = BURGER)
    }

  @Test fun floatingNavListButton() =
    compareScreenshotFor(darkTheme, "_floatingNavListButton_$testName") {
      TUIFloatingNavButton(
        contentType = List(
          iconOne = TarkaIcons.Filled.CalendarRtl24, iconTwo = TarkaIcons.Filled.Map24,
          iconThree = TarkaIcons.Filled.Directions24
        ), style = LIST
      )
    }
}