package com.tarkalabs.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUILoaderSpinnerImage
import com.tarkalabs.uicomponents.components.TUILoader
import org.junit.Rule
import org.junit.Test

class TUILoaderTest {

  @get:Rule
  val composable = createComposeRule()

  @Test
  fun is_eam_logo_shown_without_image() {
    val eamLogoContentDescription = "EAM360Loader"
    composable.setContent {
      TUILoader(
        size = 100.dp
      )
    }
    composable.onNodeWithContentDescription(eamLogoContentDescription)
  }

  @Test
  fun is_eam_logo_shown_with_image() {
    val eamLogoContentDescription = "EAM360Loader"
    composable.setContent {
      TUILoader(
        size = 100.dp,
        TUILoadingSpinnerImage = TUILoaderSpinnerImage(
          resourceId = com.google.android.material.R.drawable.material_ic_keyboard_arrow_right_black_24dp,
          contentDescription = "",
          progressImageWidth = 130.dp,
          height = 50.dp
        )
      )
    }
    composable.onNodeWithContentDescription(eamLogoContentDescription)
  }
}