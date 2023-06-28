package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * Below TUIToggleSwitch() defines a reusable composable function which can be used to create a Switch which takes several parameters such as
 * @param state Checked status of the ToggleSwitch
 * @param enabled Enable status of the ToggleSwitch
 * @param tags Test Tags for the  TUIToggleSwitch
 * @param onToggleChange() A callback function that is invoked when the toggle is clicked.
 *
 * How to use TUIToggleSwitch() composable function
 *
 *  TUIToggleSwitch(state = false ) {   }
 *
 */

@Composable fun TUIToggleSwitch(
  state: Boolean, enabled: Boolean = true,
  tags: TUIToggleSwitchTags = TUIToggleSwitchTags(),
  onToggleChange: () -> Unit
) {
  var switchCheckedState by remember { mutableStateOf(state) }
  TUITheme {
    Switch(
      modifier = Modifier.testTag(tags.parentTag),
      checked = switchCheckedState, enabled = enabled, onCheckedChange = {
        switchCheckedState = it
        onToggleChange()
      }, thumbContent = {
        Icon(
          modifier = Modifier
            .size(width = 40.dp, height = 24.dp)
            .testTag(tags.iconTag),
          painter = painterResource(if (switchCheckedState) TarkaIcons.CheckMark16Filled.iconRes else TarkaIcons.Dismiss24Regular.iconRes),
          contentDescription = null,
        )
      }, colors = getSwitchDefaultColors()
    )
  }
}

@Composable private fun getSwitchDefaultColors() = SwitchDefaults.colors(
  checkedThumbColor = TUITheme.colors.constantLight,
  checkedTrackColor = TUITheme.colors.primary,
  checkedIconColor = TUITheme.colors.primary,
  checkedBorderColor = TUITheme.colors.primary,
  uncheckedThumbColor = TUITheme.colors.onSurface,
  uncheckedTrackColor = TUITheme.colors.surfaceVariant,
  uncheckedIconColor = TUITheme.colors.constantLight,
  uncheckedBorderColor = Color.Transparent,
  disabledCheckedThumbColor = TUITheme.colors.utilityDisabledContent.copy(alpha = 0.38f),
  disabledCheckedTrackColor = TUITheme.colors.utilityDisabledBackground.copy(alpha = 0.06f),
  disabledCheckedIconColor = TUITheme.colors.inputBackground.copy(alpha = 0.85f),
  disabledCheckedBorderColor = Color.Transparent,
  disabledUncheckedThumbColor = TUITheme.colors.utilityDisabledContent.copy(alpha = 0.38f),
  disabledUncheckedTrackColor = TUITheme.colors.utilityDisabledBackground.copy(alpha = 0.06f),
  disabledUncheckedBorderColor = Color.Transparent,
  disabledUncheckedIconColor = TUITheme.colors.inputBackground.copy(alpha = 0.85f)
)

data class TUIToggleSwitchTags(
  val parentTag: String = Tags.TAG_TOGGLE_SWITCH,
  val iconTag: String = Tags.TAG_TOGGLE_SWITCH_ICON,
)

@Preview(showBackground = true) @Composable fun TUIToggleSwitchPreview() {
  TUITheme {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
      ) {
        TUIToggleSwitch(state = true) {}
        VerticalSpacer(space = 10)
        TUIToggleSwitch(state = false) {}
        VerticalSpacer(space = 10)
        TUIToggleSwitch(state = false, enabled = false) {}
        VerticalSpacer(space = 10)
        TUIToggleSwitch(state = true, enabled = false) {}
      }
    }

  }
}