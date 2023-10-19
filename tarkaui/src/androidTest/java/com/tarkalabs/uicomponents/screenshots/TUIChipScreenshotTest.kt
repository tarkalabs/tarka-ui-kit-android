package com.tarkalabs.uicomponents.screenshots

import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.asImageBitmap
import androidx.test.platform.app.InstrumentationRegistry
import com.tarkalabs.tarkaicons.CalendarLtr24
import com.tarkalabs.tarkaicons.Checkmark16
import com.tarkalabs.tarkaicons.Dismiss20
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.ChipLeadingContent
import com.tarkalabs.uicomponents.components.ChipSize
import com.tarkalabs.uicomponents.components.ChipType
import com.tarkalabs.uicomponents.components.TUIChip
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIChipScreenshotTest(
  private val size: ChipSize,
  private val type: ChipType,
  private val darkTheme: Boolean,
  private val testName: String
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val context = InstrumentationRegistry.getInstrumentation().context
      val assetManager = context.assets
      val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))
      val leadingContent = listOf(
        null,
        ChipLeadingContent.Image(bitmap.asImageBitmap()),
        ChipLeadingContent.Icon(TarkaIcons.Filled.Checkmark16)
      )

      val types =
        leadingContent.map { ChipType.Assist(it) } + filterChipTypes() + leadingContent.map {
          ChipType.Input(
            it, TarkaIcons.Filled.Dismiss20
          )
        } + leadingContent.map { ChipType.Input(it, TarkaIcons.Filled.Dismiss20) } + listOf(
          ChipType.Suggestion(null),
          ChipType.Suggestion(TarkaIcons.Regular.CalendarLtr24),
        )

      val chipSizes = ChipSize.values()
      val darkThemeValues = listOf(true, false)
      val testData = ArrayList<Array<Any?>>()
      for (type in types) {
        for (chipSize in chipSizes) {
          for (darkTheme in darkThemeValues) {
            val testName = when (type) {
              is ChipType.Assist -> "ChipSize_${chipSize}_chipType_${type.javaClass.simpleName}_chipTypeContent_${type.content?.javaClass?.simpleName.toString()}_darkTheme_${darkTheme}"
              is ChipType.Filter -> "ChipSize_${chipSize}_chipType_${type.javaClass.simpleName}_chipTypeShowLeadingCheck_${type.showLeadingCheck}_chipTypeShowTrailingCaret_${type.showTrailingCaret}_chipTypeShowTrailingDismiss_${type.showTrailingDismiss}_chipTypeSelected_${type.selected}_darkTheme_${darkTheme}"
              is ChipType.Input -> "ChipSize_${chipSize}_chipType_${type.javaClass.simpleName}_chipTypeShowTrailingDismiss_${type.trailingIcon}_chipTypeContent_${type.content?.javaClass?.simpleName}_darkTheme_${darkTheme}"
              is ChipType.Suggestion -> "ChipSize_${chipSize}_chipType_${type.javaClass.simpleName}_chipTypeImage_${type.image.toString()}_darkTheme_${darkTheme}"
            }
            testData.add(
              arrayOf(
                chipSize, type, darkTheme, testName,
              )
            )
          }
        }
      }
      return testData
    }
  }

  @Test
  fun test_tui_chip() {
    compareScreenshotFor(darkTheme, testName) {
      TUIChip(
        type = type,
        label = type.javaClass.simpleName,
        chipSize = size,
        onClick = { },
      )
    }
  }
}

private fun filterChipTypes(): List<ChipType> {
  val filterVariations = mutableListOf<ChipType>()
  val booleans = listOf(true, false)
  booleans.forEach { selected ->
    booleans.forEach { showLeadingCheck ->
      booleans.forEach { showTrailingDismiss ->
        booleans.forEach { showTrailingCaret ->
          filterVariations.add(
            ChipType.Filter(
              selected = selected,
              showLeadingCheck = showLeadingCheck,
              showTrailingDismiss = showTrailingDismiss,
              showTrailingCaret = showTrailingCaret,
              badgeCount = null
            )
          )
        }
      }
    }
  }
  return filterVariations
}