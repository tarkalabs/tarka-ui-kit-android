package com.tarkalabs.uicomponents

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TUILoadingSpinnerAnimation
import org.junit.Rule
import org.junit.Test

class TUILoadingSpinnerAnimationTest {

  @get:Rule
  val composable = createComposeRule()

  @Test
  fun is_eam_logo_shown() {
    val eamLogoContentDescription = "EAM360Loader"
    composable.setContent {
      TUILoadingSpinnerAnimation(
        spinnerHeight = 100.dp
      )
    }
    composable.onNodeWithContentDescription(eamLogoContentDescription)
  }
}