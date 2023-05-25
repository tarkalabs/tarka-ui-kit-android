package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.ColorInputBackground
import com.tarkalabs.uicomponents.theme.ColorLight
import com.tarkalabs.uicomponents.theme.ColorUtilityDisabledBackground
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * Below TUIToggleSwitch() defines a reusable composable function which can be used to create an Button with various styles and sizes which takes several parameters such as
 * @param state Checked status of the ToggleSwitch
 * @param enabled Enable status of the ToggleSwitch
 * @param onToggleChange() A callback function that is invoked when the toggle is clicked.
 *
 * How to use TUIToggleSwitch() composable function
 *
 *  TUIToggleSwitch(state = false ) {   }
 *
 */

@Composable fun TUIToggleSwitch(
  state: Boolean, enabled: Boolean = true, onToggleChange: () -> Unit
) {
  var switchCheckedState by remember { mutableStateOf(state) }
  TUITheme {
    Switch(checked = switchCheckedState, enabled = enabled, onCheckedChange = {
      switchCheckedState = it
      onToggleChange()
    }, thumbContent = {
      Icon(
        painter = painterResource(if (switchCheckedState) TarkaIcons.CheckMark.iconRes else TarkaIcons.Dismiss.iconRes),
        contentDescription = null,
        modifier = Modifier.size(width = 40.dp, height = 24.dp)
      )
    }, colors = SwitchDefaults.colors(
      checkedThumbColor = ColorLight,
      checkedTrackColor = MaterialTheme.colorScheme.primary,
      checkedIconColor = MaterialTheme.colorScheme.primary,
      checkedBorderColor = ColorLight,
      uncheckedThumbColor = MaterialTheme.colorScheme.onSurface,
      uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
      uncheckedIconColor = ColorLight,
      uncheckedBorderColor = Color.Transparent,

      disabledCheckedThumbColor = ColorUtilityDisabledBackground.copy(alpha = 0.38f),
      disabledCheckedTrackColor = ColorUtilityDisabledBackground.copy(alpha = 0.06f),
      disabledCheckedIconColor = ColorInputBackground.copy(alpha = 0.85f),
      disabledCheckedBorderColor = Color.Transparent,
      disabledUncheckedThumbColor = ColorUtilityDisabledBackground.copy(alpha = 0.38f),
      disabledUncheckedTrackColor = ColorUtilityDisabledBackground.copy(alpha = 0.06f),
      disabledUncheckedBorderColor = Color.Transparent,
      disabledUncheckedIconColor = ColorInputBackground.copy(alpha = 0.85f)
    )
    )
  }
}

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