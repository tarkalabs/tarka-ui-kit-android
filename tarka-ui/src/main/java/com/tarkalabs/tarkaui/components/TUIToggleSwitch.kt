package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.extentions.clickableWithoutRipple
import com.tarkalabs.tarkaui.icons.Checkmark16
import com.tarkalabs.tarkaui.icons.Dismiss16
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * Below TUIToggleSwitch() defines a reusable composable function which can be used to create a Switch which takes several parameters such as
 * @param isChecked Checked status of the ToggleSwitch
 * @param enabled Enable status of the ToggleSwitch
 * @param tags Test Tags for the  TUIToggleSwitch
 * @param onCheckedChange() A callback function that is invoked when the toggle is clicked.
 *
 * How to use TUIToggleSwitch() composable function
 *
 *  TUIToggleSwitch(state = false ) {   }
 *
 */

@Composable fun TUIToggleSwitch(
  modifier: Modifier = Modifier,
  isChecked: Boolean,
  enabled: Boolean = true,
  tags: TUIToggleSwitchTags = TUIToggleSwitchTags(),
  onCheckedChange: () -> Unit
) {
  val iconTint = if (enabled) {
    if (isChecked) {
      TUITheme.colors.primary
    } else {
      TUITheme.colors.surfaceVariant
    }
  } else {
    TUITheme.colors.inputBackground.copy(alpha = 0.85f)
  }

  val iconBgTint = if (enabled) {
    if (isChecked) {
      TUITheme.colors.surface
    } else {
      TUITheme.colors.onSurface
    }
  } else {
    TUITheme.colors.utilityDisabledContent
  }

  val switchBgColor = if (enabled) {
    if (isChecked) {
      TUITheme.colors.primary
    } else {
      TUITheme.colors.surfaceVariant
    }
  } else {
    TUITheme.colors.utilityDisabledBackground
  }

  Box(
    modifier = modifier
      .clickableWithoutRipple {
        if (enabled) onCheckedChange()
      }
      .width(40.dp)
      .height(24.dp)
      .background(shape = RoundedCornerShape(20.dp), color = switchBgColor)
      .testTag(tags.parentTag)
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(2.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = if (isChecked) Arrangement.End else Arrangement.Start
    ) {
      Box(
        modifier = Modifier
          .width(20.dp)
          .height(20.dp)
          .clip(CircleShape)
          .background(iconBgTint),
        contentAlignment = Alignment.Center
      ) {
        Icon(
          modifier = Modifier,
          painter = painterResource(
            if (isChecked) TarkaIcons.Filled.Checkmark16.iconRes else TarkaIcons.Regular.Dismiss16.iconRes
          ),
          contentDescription = null,
          tint = iconTint
        )
      }
    }
  }
}

data class TUIToggleSwitchTags(val parentTag: String = "TUIToggleSwitchParentTag")

@Preview(showBackground = true)
@Composable
private fun TUIToggleSwitchPreview() {
  TUITheme {
    var isChecked by remember {
      mutableStateOf(true)
    }

    var isChecked2 by remember {
      mutableStateOf(true)
    }
    var isChecked3 by remember {
      mutableStateOf(false)
    }
    var isChecked4 by remember {
      mutableStateOf(false)
    }

    Box(
      modifier = Modifier.fillMaxSize()
        .background(color = TUITheme.colors.surface),
      contentAlignment = Alignment.Center
    ) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        TUIToggleSwitch(isChecked = isChecked, enabled = true) {
          isChecked = !isChecked
        }
        VerticalSpacer(space = 16)

        TUIToggleSwitch(isChecked = isChecked4, enabled = true) {
          isChecked4 = !isChecked4
        }
        VerticalSpacer(space = 16)
        TUIToggleSwitch(isChecked = isChecked3, enabled = false) {
          isChecked3 = !isChecked3
        }
        VerticalSpacer(space = 16)
        TUIToggleSwitch(isChecked = isChecked2, enabled = false) {
          isChecked2 = !isChecked2
        }
      }
    }
  }
}