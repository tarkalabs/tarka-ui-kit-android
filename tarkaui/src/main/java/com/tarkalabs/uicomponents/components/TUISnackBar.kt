package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUISnackBarType.Error
import com.tarkalabs.uicomponents.components.TUISnackBarType.Information
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.components.TUISnackBarType.Warning
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun rememberTUISnackBarState(
  key: String? = null,
  hostState: SnackbarHostState = SnackbarHostState(),
  type: TUISnackBarType = Information,
  leadingIcon: TarkaIcon? = null,
): TUISnackBarState {
  return rememberSaveable(key = key, saver = TUISnackBarState.Saver) {
    TUISnackBarState(hostState, type, leadingIcon)
  }
}

/**
 * Represents the state of a TUI Snackbar.
 *
 * @param hostState The SnackbarHostState associated with the Snackbar.
 * @param type The type of the Snackbar.
 * @param leadingIcon The leading icon of the Snackbar.
 */
class TUISnackBarState(
  hostState: SnackbarHostState = SnackbarHostState(),
  type: TUISnackBarType = Information,
  leadingIcon: TarkaIcon? = null,
) {

  companion object {
    val Saver = listSaver(save = {
      listOf(it.type, it.leadingIcon)
    }, restore = {
      TUISnackBarState(it[0] as SnackbarHostState, it[1] as TUISnackBarType, it[2] as TarkaIcon?)
    })
  }

  internal val hostState: SnackbarHostState by mutableStateOf(hostState)
  var type: TUISnackBarType by mutableStateOf(type)
  var leadingIcon: TarkaIcon? by mutableStateOf(leadingIcon)

  /**
   * Shows a Snackbar with the provided visuals.
   *
   * @param visuals The SnackbarVisuals to be displayed.
   * @return The SnackbarResult representing the result of the Snackbar action.
   */
  suspend fun showSnackBar(visuals: SnackbarVisuals): SnackbarResult {
    hostState.currentSnackbarData?.dismiss()
    return hostState.showSnackbar(visuals)
  }

  /**
   * Shows a Snackbar with the provided message, action label, and duration.
   *
   * @param message The message to be displayed in the Snackbar.
   * @param actionLabel The label of the action button. (optional)
   * @param withDismissAction Whether to include a dismiss action. (optional)
   * @param duration The duration of the Snackbar.
   * @return The SnackbarResult representing the result of the Snackbar action.
   */
  suspend fun showSnackBar(
    message: String,
    actionLabel: String? = null,
    withDismissAction: Boolean = false,
    duration: SnackbarDuration = if (actionLabel == null) SnackbarDuration.Short else SnackbarDuration.Indefinite
  ): SnackbarResult {
    hostState.currentSnackbarData?.dismiss()
    return hostState.showSnackbar(message, actionLabel, withDismissAction, duration)
  }
}

/**
 * A composable function that displays a TUI SnackbarHost.
 *
 * @param state The TUISnackBarState representing the state of the Snackbar.
 * @param modifier The modifier for the SnackbarHost. (optional)
 * @param tags The TUISnackBarTags to be applied to the TUISnackBar. (optional)
 */
@Composable
fun TUISnackBarHost(
  state: TUISnackBarState,
  modifier: Modifier = Modifier,
  tags: TUISnackBarTags = TUISnackBarTags(),
) {
  SnackbarHost(
    modifier = modifier,
    hostState = state.hostState,
  ) { snackbarData: SnackbarData ->
    TUISnackBar(
      modifier = Modifier.padding(5.dp),
      message = snackbarData.visuals.message,
      actionLabel = snackbarData.visuals.actionLabel,
      leadingIcon = state.leadingIcon,
      type = state.type,
      tags = tags
    ) {
      snackbarData.performAction()
    }
  }
}

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
@Composable
internal fun TUISnackBar(
  modifier: Modifier = Modifier,
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

  Box(
    modifier = modifier
      .defaultMinSize(minHeight = 56.dp)
      .background(containerColor, shape = RoundedCornerShape(32.dp))
      .padding(16.dp)
  ) {
    Row(
      modifier = Modifier
        .testTag(tags.parentTag),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center,
    ) {
      if (leadingIcon != null) {
        Icon(
          modifier = Modifier.testTag(tags.leadingIconTag),
          painter = painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          tint = textColor
        )
      }
      Text(
        modifier = Modifier
          .weight(1f, fill = false)
          .padding(start = 8.dp),
        text = message,
        color = textColor,
        style = TUITheme.typography.body6,
        textAlign = if (leadingIcon == null) TextAlign.Center else TextAlign.Start
      )
      if (actionLabel != null) {
        Button(
          modifier = Modifier
            .testTag(tags.dismissActionTag)
            .height(32.dp)
            .padding(start = 24.dp),
          onClick = action,
          colors = ButtonDefaults.buttonColors(
            contentColor = containerColor, containerColor = textColor
          ),
          contentPadding = PaddingValues(1.dp)
        ) {
          Text(
            modifier = Modifier.padding(horizontal = 17.dp),
            text = actionLabel, style = TUITheme.typography.body7)
        }
      }
    }

  }
}

data class TUISnackBarTags(
  val parentTag: String = "TUISnackBar",
  val leadingIconTag: String = "TUISnackBar_LeadingIcon",
  val dismissActionTag: String = "TUISnackBar_DismissAction",
)

enum class TUISnackBarType {
  Success,
  Information,
  Warning,
  Error;
}

@Preview
@Composable
fun TUIInformationSnackBarPreview() {
  TUISnackBar(
    message = "Hello there",
    actionLabel = "dgsd",
    leadingIcon = TarkaIcons.Regular.Delete24,
    type = Information
  )
}

@Preview
@Composable
fun TUISuccessSnackBarPreview() {
  TUISnackBar(
    message = "Hello there", actionLabel = "dgsd", leadingIcon = TarkaIcons.Regular.Delete24, type = Success
  )
}

@Preview
@Composable
fun TUIWarningSnackBarPreview() {
  TUISnackBar(
    message = "Hello there", actionLabel = "dgsd", leadingIcon = TarkaIcons.Regular.Delete24, type = Warning
  )
}

@Preview
@Composable
fun TUIErrorSnackBarPreview() {
  TUISnackBar(
    message = "Hello there", type = Error
  )
}