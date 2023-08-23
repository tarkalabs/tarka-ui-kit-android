package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaicons.AddCircle24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.MenuItemLeadingContentType
import com.tarkalabs.uicomponents.components.MenuItemLeadingContentType.Icon
import com.tarkalabs.uicomponents.components.MenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.uicomponents.components.MenuItemStyle
import com.tarkalabs.uicomponents.components.MenuItemStyle.Title
import com.tarkalabs.uicomponents.components.MenuItemStyle.TitleWithDescription
import com.tarkalabs.uicomponents.components.MenuItemTrailingContentType
import com.tarkalabs.uicomponents.components.MenuItemTrailingContentType.SubMenu
import com.tarkalabs.uicomponents.components.TUIMenuItem
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMenuItemScreenshotTest(
  private val style: MenuItemStyle,
  private val leadingContentType: MenuItemLeadingContentType?,
  private val trailingContentType: MenuItemTrailingContentType?,
  private val isSelected: Boolean,
  private val darkTheme: Boolean,
  private val testName: String
) : ComposeScreenshotComparator() {

  companion object {

    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val styles = listOf(Title, TitleWithDescription("Label"))
      val testData = ArrayList<Array<Any?>>()
      val leadingContentTypes = listOf(
        null,
        Icon(TarkaIcons.Regular.AddCircle24),
        StatusIndicator
      )
      val trailingContentTypes = listOf(
        null,
        MenuItemTrailingContentType.Icon(TarkaIcons.Regular.AddCircle24),
        SubMenu
      )
      val isSelectedValues = listOf(true, false)
      val darkThemeValues = listOf(true, false)
      for (menuItemStyle in styles) {
        for (leadingContentType in leadingContentTypes) {
          for (trailingContentType in trailingContentTypes) {
            for (selectedValue in isSelectedValues) {
              for (darkThemeValue in darkThemeValues) {
                val testName =
                  "Style_${getSimpleName(menuItemStyle)}_LeadingContentType_${getSimpleName(leadingContentType)}_TrailingIconType_${getSimpleName(trailingContentType)}_isSelected_${selectedValue}_darkTheme_${darkThemeValue}"
                testData.add(
                  arrayOf(
                    menuItemStyle,
                    leadingContentType,
                    trailingContentType,
                    selectedValue,
                    darkThemeValue,
                    testName
                  )
                )
              }
            }
          }
        }
      }
      return testData
    }

    private fun getSimpleName(menuItemStyle: MenuItemStyle): String {
      return when(menuItemStyle){
        Title -> "Title"
        is TitleWithDescription -> "TitleWithDescription"
      }
    }

    private fun getSimpleName(type: MenuItemLeadingContentType?): String {
      return when(type){
        is Icon -> "Icon"
        StatusIndicator -> "StatusIndicator"
        else -> "null"
      }
    }

    private fun getSimpleName(type: MenuItemTrailingContentType?): String {
      return when(type){
        is MenuItemTrailingContentType.Icon -> "Icon"
        SubMenu -> "SubMenu"
        else -> "null"
      }
    }
  }

  @Test
  fun testTuiMenuItem() {
    compareScreenshotFor(darkTheme, testName) {
      TUIMenuItem(
        title = "Label",
        isSelected = isSelected,
        style = style,
        leadingContent = leadingContentType,
        trailingContent = trailingContentType,
        onMenuItemClick = { /*TODO*/ },
      )
    }
  }
}