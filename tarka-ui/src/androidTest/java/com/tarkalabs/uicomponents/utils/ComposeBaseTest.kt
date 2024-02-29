package com.tarkalabs.uicomponents.utils

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule

open class ComposeBaseTest {

  @get:Rule val composeRule = createComposeRule()

  val context = InstrumentationRegistry.getInstrumentation().context
  val assetManager = context.assets
}
