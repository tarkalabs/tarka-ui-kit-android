package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.TUISearchBar
import com.tarkalabs.tarkaui.icons.Person24
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUISearchBarScreenshotTest(
  private val darkTheme: Boolean,
  private val leadingIcon: TarkaIcon?,
  private val query: String,
  private val placeHolder: String,
  private val testName: String,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {

      val darkThemeValues = listOf(true, false)
      val leadingIconValues = listOf(TarkaIcons.Regular.Person24, null)
      val queryValues = listOf("", "Query")
      val placeHoldersValues = listOf("null", "Hint")

      val testData = arrayListOf<Array<Any?>>()

      for (darkTheme in darkThemeValues)
        for (leadingIconValue in leadingIconValues)
          for (queryValue in queryValues)
            for (placeHoldersValue in placeHoldersValues)
              testData.add(
                arrayOf(
                  darkTheme, leadingIconValue, queryValue, placeHoldersValue,
                  "darkTheme_${darkTheme}_leadingIconValue_${if (leadingIconValue == null) "null" else "normal"}_query_${queryValue}_placeHolder_${placeHoldersValue}"
                )
              )

      return testData
    }
  }

  @Test
  fun testTUISearchBar() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = testName) {
      TUISearchBar(
        query = query,
        placeholder = placeHolder,
        leadingIcon = leadingIcon,
        onQueryTextChange = {},
        onLeadingIconClick = {},
      )
    }
  }
}