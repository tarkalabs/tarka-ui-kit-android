package com.tarkalabs.uicomponents.screenshots

import androidx.compose.ui.graphics.Color
import com.tarkalabs.tarkaicons.Circle12
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUITag
import com.tarkalabs.uicomponents.components.TagSize
import com.tarkalabs.uicomponents.components.TagType
import com.tarkalabs.uicomponents.components.TagType.CUSTOM
import com.tarkalabs.uicomponents.components.TagType.HIGH
import com.tarkalabs.uicomponents.components.TagType.LOW
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUITagScreenShotTest(
  private val tagType: TagType,
  private val tagSize: TagSize,
  private val testName: String,
  private val darkTheme: Boolean,
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val darkThemeValues = listOf(true, false)
      val tagTypes = listOf(
        LOW,
        HIGH,
        CUSTOM(
          bgContentColor = Color(0xFFFFB938),
          titleColor = Color(0xFF241D0F),
          iconTint = Color(0xFF241D0F)
        )
      )
      val tagSizes = TagSize.values()
      val testData = ArrayList<Array<Any?>>()
      for (tagType in tagTypes) {
        for (tagSize in tagSizes) {
          for (darkTheme in darkThemeValues) {
            val testName =
              "TagType_${if (tagType is HIGH) "high" else if (tagType is LOW) "low" else "custom"}_TagSize_${tagSize.name}_darkTheme_${darkTheme}"
            testData.add(
              arrayOf(
                tagType,
                tagSize,
                testName,
                darkTheme
              )
            )
          }
        }
      }
      return testData
    }
  }

  @Test fun test_tag_without_icon() {
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TagWithoutIcon_$testName") {
      TUITag(title = "Title", tagType = tagType, tagSize = tagSize) {}
    }
  }

  @Test fun test_tag_with_leading_icon() {
    val leadingIcon = TarkaIcons.Regular.Circle12
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TagWithLeadingIcon_$testName") {
      TUITag(title = "Title", tagType = tagType, tagSize = tagSize, leadingIcon = leadingIcon) {}
    }
  }

  @Test fun test_tag_with_trailing_icon() {
    val trailingIcon = TarkaIcons.Regular.Circle12
    compareScreenshotFor(darkTheme = darkTheme, imageName = "TagWithTrailingIcon_$testName") {
      TUITag(title = "Title", tagType = tagType, tagSize = tagSize, trailingIcon = trailingIcon) {}
    }
  }
}

