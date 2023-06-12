package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.TUISnackBarType.Error
import com.tarkalabs.uicomponents.components.TUISnackBarType.Information
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.components.TUISnackBarType.Warning
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme


/**
 * Displays a snack bar with a message and optional action button.
 *
 * @param message The text message to display in the snack bar.
 * @param type The type of the snack bar (default: Information).
 * @param leadingIcon An optional icon to display before the message.
 * @param actionLabel The label for the optional action button.
 * @param tags Tags for testing and identification purposes.
 * @param action The action to be performed when the action button is clicked.
 *
 *  How to use TUISnackBar() composable function
 *
 *   TUISnackBar(
        message = "Task completed successfully!",
        type = Success,
        leadingIcon = TarkaIcon.Success,
        actionLabel = "Dismiss",
        tags = TUISnackBarTags(parentTag = "example_snackbar"),
        action = { /* Perform action on dismiss */ }
    )
 */
@Composable fun TUISnackBar(
  message: String,
  type: TUISnackBarType = Information,
  leadingIcon: TarkaIcon? = null,
  actionLabel: String? = null,
  tags: TUISnackBarTags = TUISnackBarTags(),
  action: () -> Unit = {},
) {
  var containerColor = TUITheme.colors.secondary
  var textColor = TUITheme.colors.onSecondary

  when (type) {
    Success -> {
      textColor = TUITheme.colors.onSuccess
      containerColor = TUITheme.colors.success
    }

    Information -> {
      textColor = TUITheme.colors.onSecondary
      containerColor = TUITheme.colors.secondary
    }

    Warning -> {
      textColor = TUITheme.colors.onWarning
      containerColor = TUITheme.colors.warning
    }

    Error -> {
      textColor = TUITheme.colors.onError
      containerColor = TUITheme.colors.error
    }
  }

  Snackbar(
    containerColor = containerColor,
    modifier = Modifier
      .fillMaxWidth()
      .defaultMinSize(minHeight = 56.dp)
      .clip(RoundedCornerShape(32.dp)),
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .testTag(tags.parentTag),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
    ) {
      if (leadingIcon != null) {
        Icon(
          painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          modifier = Modifier.testTag(tags.leadingIconTag)
        )
        HorizontalSpacer(space = 10)
      }
      Text(
        message,
        color = textColor,
        style = TUITheme.typography.body6,
        modifier = Modifier.weight(1f)
      )
      if (actionLabel != null) {
        HorizontalSpacer(space = 24)

        Button(
          onClick = action, colors = ButtonDefaults.buttonColors(
            contentColor = containerColor, containerColor = textColor
          ), modifier = Modifier.testTag(tags.dismissActionTag)
        ) {
          Text(text = actionLabel, style = TUITheme.typography.body7)
        }
      }
      HorizontalSpacer(space = 16)
    }

  }
}

data class TUISnackBarTags(
  val parentTag: String = Tags.TAG_SNACK_BAR,
  val leadingIconTag: String = Tags.TAG_SNACK_BAR_LEADING_ICON,
  val dismissActionTag: String = Tags.TAG_SNACK_BAR_DISMISS_ACTION,
)

enum class TUISnackBarType {
  Success,
  Information,
  Warning,
  Error;
}

@Preview @Composable fun TUISnackBarPreview() {
  TUISnackBar(
    message = "Hello there", actionLabel = "dgsd", leadingIcon = TarkaIcons.Delete, type = Success
  )
}