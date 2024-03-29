@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.screenshots

import android.graphics.BitmapFactory
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.graphics.asImageBitmap
import com.tarkalabs.tarkaui.components.base.AvatarSize
import com.tarkalabs.tarkaui.components.base.AvatarType.Icon
import com.tarkalabs.tarkaui.components.base.AvatarType.Image
import com.tarkalabs.tarkaui.components.base.AvatarType.Text
import com.tarkalabs.tarkaui.components.base.TUIAvatar
import com.tarkalabs.tarkaui.icons.Dismiss16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

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
      TUIAvatar(avatarType = Image(bitmap.asImageBitmap()), avatarSize = avatarSize, showBadge = showBadge)
    }
  }

  @Test fun test_avatar_with_text(){
    compareScreenshotFor(darkTheme = darkTheme, imageName = "_testAvatarWithText_$testName") {
      TUIAvatar(avatarType = Text("AB"), avatarSize = avatarSize, showBadge = showBadge)
    }
  }

  @Test fun test_avatar_with_icon(){
    compareScreenshotFor(darkTheme = darkTheme, imageName = "_testAvatarWithIcon_$testName") {
      TUIAvatar(avatarType = Icon(TarkaIcons.Filled.Dismiss16), avatarSize = avatarSize, showBadge = showBadge)
    }
  }
}