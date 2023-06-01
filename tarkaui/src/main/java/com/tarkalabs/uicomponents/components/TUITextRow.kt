package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * A composable function that represents a text row in a UI.
 * It displays a title, a description, and optional icons, button, and info icon.
 *
 * @param title: The title text to be displayed in the text row.
 * @param description: The description text to be displayed in the text row.
 * @param modifier: The modifier to apply to the row.
 * @param iconOne: The optional first icon to display.
 * @param iconTwo: The optional second icon to display.
 * @param buttonTitle: The optional title for the button.
 * @param infoIcon: The optional info icon to display.
 * @param onIconOneClick: The callback function when the first icon is clicked.
 * @param onIconTwoClick: The callback function when the second icon is clicked.
 * @param onButtonClick: The callback function when the button is clicked.
 * @param onInfoIconClick: The callback function when the info icon is clicked.
 * @param onTextRowClick: The callback function when the text row is clicked.
 * @param paddingValues: The padding values to apply to the row.
 * @param testTag: The test tag for the first icon.
 *
 * The TUITextRow composable function creates a row that represents a text item in a UI.
 * It handles click events and provides callback functions for customization. The row displays
 * a title and a description. It can also include optional icons, a button, and an info icon.
 * The appearance and behavior of the row can be modified using the provided modifiers and callbacks.
 *
 * Example usage:
 *
 * TUITextRow(
 *   title = "Account",
 *   description = "Manage your account settings",
 *   iconOne = TarkaIcons.Settings,
 *   onIconOneClick = { /* Handle icon one click event */ },
 *   buttonTitle = "Edit",
 *   onButtonClick = { /* Handle button click event */ },
 *   onTextRowClick = { /* Handle text row click event */ }
 * )
 *
 */
@Composable fun TUITextRow(
  title: String,
  description: String,
  modifier: Modifier = Modifier.fillMaxWidth(),
  iconOne: TarkaIcon? = null,
  iconTwo: TarkaIcon? = null,
  buttonTitle: String? = null,
  infoIcon: TarkaIcon? = null,
  onIconOneClick: () -> Unit = {},
  onIconTwoClick: () -> Unit = {},
  onButtonClick: () -> Unit = {},
  onInfoIconClick: () -> Unit = {},
  onTextRowClick: () -> Unit = {},
  paddingValues: PaddingValues = PaddingValues(),
  testTag: String = Tags.TAG_TEXT_ROW
) {
  Row(modifier
    .clickable { onTextRowClick() }
    .defaultMinSize(minHeight = 40.dp)
    .padding(paddingValues)
    .testTag(testTag),
    verticalAlignment = Alignment.CenterVertically) {
    Column(Modifier.weight(1f)) {
      Text(
        text = title,
        style = TUITheme.typography.body8,
        color = TUITheme.colors.onSurface.copy(alpha = 0.7f)
      )
      Text(
        text = description,
        style = TUITheme.typography.body7,
        color = TUITheme.colors.onSurface
      )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      if (iconOne != null) TUIIconButton(
        icon = iconOne,
        onIconClick = onIconOneClick,
        iconButtonStyle = IconButtonStyle.GHOST,
        testTag = iconOne.contentDescription
      )
      if (iconTwo != null) TUIIconButton(
        icon = iconTwo,
        onIconClick = onIconTwoClick,
        iconButtonStyle = IconButtonStyle.GHOST,
        testTag = iconTwo.contentDescription

      )
      if (buttonTitle != null) {
        OutlinedButton(
          modifier = Modifier
            .height(40.dp)
            .width(90.dp), onClick = onButtonClick
        ) {
          Text(text = buttonTitle)
        }
      }
      if (infoIcon != null) {
        Icon(
          painter = painterResource(id = infoIcon.iconRes),
          contentDescription = infoIcon.contentDescription,
          tint = TUITheme.colors.utilityOutline,
          modifier = Modifier.clickable(onClick = onInfoIconClick)
        )
      }
    }
  }
}

@Preview(showBackground = true) @Composable fun TUITextRowPreview() {
  TUITextRow(
    title = "Title",
    description = "Description",
    infoIcon = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    iconOne = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    iconTwo = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    buttonTitle = "Label"
  )
}