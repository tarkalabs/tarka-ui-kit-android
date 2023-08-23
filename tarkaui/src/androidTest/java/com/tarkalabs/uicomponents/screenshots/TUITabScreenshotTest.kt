package com.tarkalabs.uicomponents.screenshots

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Circle12
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITabBar
import com.tarkalabs.uicomponents.components.TabItem
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITabScreenshotTest(
  val testName: String,
  val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      return mutableListOf(arrayOf(Any())).apply {
        for (darkTheme in listOf(true, false)) {
          val testName = "darkTheme_$darkTheme"
          add(arrayOf(testName, darkTheme))
        }
      }
    }

    val tabItems = listOf(
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
      TabItem("Tab") {},
    )

    val tabItemsWithIcons = listOf(
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {},
    )

    val tabItemsWithContent = listOf(
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 1",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 2",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 3",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 4",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 5",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 6",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 7",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab") {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 8",
          textAlign = TextAlign.Center
        )
      },
    )

    val tabItemsWithIconAndContent = listOf(
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 1",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 2",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 3",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 4",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 5",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 6",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 7",
          textAlign = TextAlign.Center
        )
      },
      TabItem("Tab", leadingTabIcon = TarkaIcons.Regular.Circle12) {
        Text(
          modifier = Modifier.fillMaxSize(),
          text = "Content 8",
          textAlign = TextAlign.Center
        )
      },
    )
  }

  @Test fun test_without_icon_and_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithoutIcon_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        isUserScrollEnabledOnContent = false,
        isPagerEnabled = false,
        tabItems = tabItems,
        selectedTabIndex = 0,
        onTabChanged = {}
      )
    }

  @Test fun test_with_icon() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithIcon_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        isUserScrollEnabledOnContent = false,
        isPagerEnabled = false,
        tabItems = tabItemsWithIcons,
        selectedTabIndex = 1,
        onTabChanged = {}
      )
    }

  @Test fun test_with_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithContent_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        isUserScrollEnabledOnContent = true,
        isPagerEnabled = true,
        tabItems = tabItemsWithContent,
        selectedTabIndex = 2,
        onTabChanged = {}
      )
    }

  @Test fun test_with_icon_and_content() =
    compareScreenshotFor(darkTheme = darkTheme, imageName = "WithIconAndContent_$testName") {
      TUITabBar(
        modifier = Modifier.padding(10.dp),
        isUserScrollEnabledOnContent = true,
        isPagerEnabled = true,
        tabItems = tabItemsWithIconAndContent,
        selectedTabIndex = 2,
        onTabChanged = {}
      )
    }
}