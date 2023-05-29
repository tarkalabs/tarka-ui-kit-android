package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.L
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.R
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.S
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons

enum class FloatingActionButtonSize(val size: Dp) {
  S(40.dp),
  R(56.dp),
  L(96.dp)
}

/**
 * Below TUIFloatingActionButton() defines a reusable composable function which can be used to create an FAB with various styles and sizes which takes several parameters such as
 * @param fabSize The size of the FAB. Default is [FloatingActionButtonSize.M].
 * @param icon The icon of the button. It should be TarkIcon
 * @param onClick The callback function to be executed when the button is clicked.
 * @param testTag The test tag for the TUIFloatingActionButton.

 * How to use TUIFloatingActionButton() composable function
 *
 * TUIFloatingActionButton(fabSize = S, icon = TarkaIcons.ChevronRight, onClick = {})
 *
 */
@Composable fun TUIFloatingActionButton(
  fabSize: FloatingActionButtonSize = S,
  icon: TarkaIcon,
  testTag : String = "",
  onClick: () -> Unit,
) {
  val iconSize = when (fabSize) {
    S, R -> 18.dp
    L -> 22.dp
  }
  FloatingActionButton(
    onClick = onClick,
    containerColor = MaterialTheme.colorScheme.primary,
    shape = CircleShape,
    modifier = Modifier.defaultMinSize(minHeight = fabSize.size, minWidth = fabSize.size)
      .testTag(testTag)
  ) {
    Icon(
      modifier = Modifier.defaultMinSize(iconSize, iconSize),
      painter = painterResource(id = icon.iconRes),
      contentDescription = icon.contentDescription
    )
  }
}

@Preview(showBackground = true) @Composable fun FloatingActionButtonPreview() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
  ) {
    TUIFloatingActionButton(
      L, TarkaIcons.ChevronRight
    ) {

    }
    Spacer(modifier = Modifier.padding(5.dp))
    TUIFloatingActionButton(
      R, TarkaIcons.ChevronRight
    ) {

    }
    Spacer(modifier = Modifier.padding(5.dp))
    TUIFloatingActionButton(
      S, TarkaIcons.ChevronRight
    ) {

    }
  }
}




