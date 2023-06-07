package com.tarkalabs.uicomponents.screenshots

import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tarkalabs.uicomponents.components.TUIInputField
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Focused
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Inactive
import com.tarkalabs.uicomponents.components.TUIInputFieldStatus.Success
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIInputFieldScreenshotTest : ComposeScreenshotComparator() {

  @Test
  fun testScreenshot() {
    compareScreenshotFor {

      TUITheme {
        var textValue by remember {
          mutableStateOf("hello world")
        }
        TUIInputField(value = textValue, onValueChange = {}, status = Success)
      }
    }
  }
}