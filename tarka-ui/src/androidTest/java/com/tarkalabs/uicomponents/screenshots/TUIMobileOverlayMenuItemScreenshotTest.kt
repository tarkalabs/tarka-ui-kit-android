package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemLeadingContentType
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemLeadingContentType.Icon
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemLeadingContentType.StatusIndicator
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemStyle
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemStyle.Title
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemStyle.TitleWithDescription
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemTrailingContentType
import com.tarkalabs.tarkaui.components.MobileOverlayMenuItemTrailingContentType.SubMobileOverlayMenu
import com.tarkalabs.tarkaui.components.TUIMobileOverlayMenuItem
import com.tarkalabs.tarkaui.icons.AddCircle24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIMobileOverlayMenuItemScreenshotTest(
  private val style: MobileOverlayMenuItemStyle,
  private val leadingContentType: MobileOverlayMenuItemLeadingContentType?,
  private val trailingContentType: MobileOverlayMenuItemTrailingContentType?,
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
        MobileOverlayMenuItemTrailingContentType.Icon(TarkaIcons.Regular.AddCircle24),
        SubMobileOverlayMenu
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

    private fun getSimpleName(mobileOverlayMenuItemStyle: MobileOverlayMenuItemStyle): String {
      return when(mobileOverlayMenuItemStyle){
        Title -> "Title"
        is TitleWithDescription -> "TitleWithDescription"
      }
    }

    private fun getSimpleName(type: MobileOverlayMenuItemLeadingContentType?): String {
      return when(type){
        is Icon -> "Icon"
        StatusIndicator -> "StatusIndicator"
        else -> "null"
      }
    }

    private fun getSimpleName(type: MobileOverlayMenuItemTrailingContentType?): String {
      return when(type){
        is MobileOverlayMenuItemTrailingContentType.Icon -> "Icon"
        SubMobileOverlayMenu -> "SubMobileOverlayMenu"
        else -> "null"
      }
    }
  }

  @Test
  fun testTuiMobileOverlayMenuItem() {
    compareScreenshotFor(darkTheme, testName) {
      TUIMobileOverlayMenuItem(
        title = "Label",
        isSelected = isSelected,
        style = style,
        leadingContent = leadingContentType,
        trailingContent = trailingContentType,
        onMobileOverlayMenuItemClick = { /*TODO*/ },
      )
    }
  }
}