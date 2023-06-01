@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import android.graphics.BitmapFactory
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.uicomponents.R.drawable
import com.tarkalabs.uicomponents.components.AvatarSize
import com.tarkalabs.uicomponents.components.TUIAvatar
import com.tarkalabs.uicomponents.components.TopBar
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalMaterial3Api::class)
@RunWith(Parameterized::class)
class TUIAvatarScreenshotTest(
  private val testName: String,
  private val avatarSize: AvatarSize,
  private val showBadge: Boolean,
  private val darkTheme: Boolean
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any>> {
      val showBadgesValues = listOf(true, false)
      val avatarSizes = AvatarSize.values()
      val darkThemeValues = listOf(true, false)

      val testData = ArrayList<Array<Any>>()
      for (avatarSize in avatarSizes) {
        for (showBadge in showBadgesValues) {
          for (darkTheme in darkThemeValues) {
            val testName =
              "AvatarSize_${avatarSize.name}_showBadge_${showBadge}_darkTheme_${darkTheme}"
            testData.add(arrayOf(testName, avatarSize, showBadge, darkTheme))
          }
        }
      }
      return testData
    }
  }

  @Test fun test_avatar_with_image(){
    val bitmap = BitmapFactory.decodeStream(assetManager.open("avatarTest.webp"))

    compareScreenshotFor(darkTheme = darkTheme, imageName = "_testAvatarWithImage_$testName") {
      TUIAvatar(imageBitmap = bitmap.asImageBitmap(), avatarSize = avatarSize, showBadge = showBadge)
    }
  }

  @Test fun test_avatar_with_text(){
    val text = "AB"
    compareScreenshotFor(darkTheme = darkTheme, imageName = "_testAvatarWithText_$testName") {
      TUIAvatar(text = text, avatarSize = avatarSize, showBadge = showBadge)
    }
  }

  @Test fun test_avatar_with_icon(){
    val icon = TarkaIcons.DismissFilled
    compareScreenshotFor(darkTheme = darkTheme, imageName = "_testAvatarWithIcon_$testName") {
      TUIAvatar(icon = icon, avatarSize = avatarSize, showBadge = showBadge)
    }
  }
}