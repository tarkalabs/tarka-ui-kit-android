package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.Circle12
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.tab.TUITabBar
import com.tarkalabs.uicomponents.components.tab.TabItem
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITabBarScreenshotTest(
  val testName: String,
  val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val testData = ArrayList<Array<Any?>>()
      for (darkTheme in listOf(true, false)) {
        val testName = "darkTheme_$darkTheme"
        testData.add(arrayOf(testName, darkTheme))
      }
      return testData
    }

    val tabItems = listOf(
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
    )

    val tabItemsWithIcons = listOf(
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
    )

    val tabItemsWithContent = listOf(
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
      TabItem("Tab"),
    )

    val tabItemsWithIconAndContent = listOf(
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
      TabItem("Tab", leadingTabIcon = Regular.Circle12),
    )
  }

  @Test fun test_without_icon_and_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithoutIcon_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItems,
        selectedTabIndex = 0,
        onTabChanged = {}
      )
    }

  @Test fun test_with_icon() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithIcon_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItemsWithIcons,
        selectedTabIndex = 1,
        onTabChanged = {}
      )
    }

  @Test fun test_with_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithContent_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItemsWithContent,
        selectedTabIndex = 2,
        onTabChanged = {}
      )
    }

  @Test fun test_with_icon_and_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithIconAndContent_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        tabItems = tabItemsWithIconAndContent,
        selectedTabIndex = 2,
        onTabChanged = {}
      )
    }
}