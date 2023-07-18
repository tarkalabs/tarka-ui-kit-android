package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.base.TUIInputFieldStatus
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class TUIInputFieldScreenshotTest(
  private val leadingIcon: TarkaIcon?,
  private val trailingIcon: TarkaIcon?,
  private val label: String?,
  private val inputText: String,
  private val status: TUIInputFieldStatus,
  private val darkTheme: Boolean,
  private val helperMessage: String?,
  private val testName: String
) : ComposeScreenshotComparator() {

  companion object {
    @JvmStatic
    @Parameterized.Parameters
    fun data(): Collection<Array<Any?>> {
      val leadingIconValues = listOf(null, TarkaIcons.CheckMark16Filled)
      val trailingIconValues = listOf(null, TarkaIcons.Dismiss16Filled)
      val labelValues = listOf(null, "Label")
      val inputTextValues = listOf("", "Input Text")
      val helperMessageValues = listOf(null, "Helper / hint message goes here.")
      val statusValues = TUIInputFieldStatus.values()
      val darkThemeValues = listOf(true, false)

      val testData = ArrayList<Array<Any?>>()
      for (helperMessageValue in helperMessageValues) {
        for (leadingIconValue in leadingIconValues) {
          for (trailingIconValue in trailingIconValues) {
            for (label in labelValues) {
              for (inputTextValue in inputTextValues) {
                for (statusValue in statusValues) {
                  for (darkTheme in darkThemeValues) {
                    val testName =
                      "InputStatus_${statusValue}_inputTextValue_${inputTextValue}_label_${label}_trailingIcon_${if (trailingIconValue != null) "true" else "false"}_leadingIcon_${if (leadingIconValue != null) "true" else "false"}_helperMessage_${if (helperMessageValue != null) "true" else "false"}_darkTheme_${darkTheme}"
                    testData.add(
                      arrayOf(
                        leadingIconValue,
                        trailingIconValue,
                        label,
                        inputTextValue,
                        statusValue,
                        darkTheme,
                        helperMessageValue,
                        testName
                      )
                    )
                  }
                }
              }
            }
          }
        }
      }
      return testData
    }
  }

  // @Test
  // @Ignore
  // fun test_input_field() {
  //   compareScreenshotFor(darkTheme, testName, {
  //     it.onNodeWithTag("TUIInputField_mainInputField").performClick()
  //   }) {
  //     TUITheme {
  //       TUIInputField(
  //         modifier = Modifier.focusable(),
  //         value = inputText,
  //         onValueChange = {},
  //         status = status,
  //         label = label,
  //         leadingIcon = leadingIcon,
  //         trailingIcon = trailingIcon,
  //         helperMessage = helperMessage
  //       )
  //     }
  //   }
  // }
}