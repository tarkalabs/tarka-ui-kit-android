@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable
import com.tarkalabs.common_ui.R
import com.tarkalabs.commonui.theme.Eam360Theme

// TODO: 5/2/2023  add content description
// TODO: 5/2/2023 use dimensions instead of hard coded things
@OptIn(ExperimentalMaterial3Api::class) @Composable fun NavigationRow(
  title: String,
  @DrawableRes leadingIcon: Int? = null,
  badgeCount: Int? = null,
  showRightArrow: Boolean = false,
  modifier: Modifier = Modifier,
  onClick: () -> Unit
) {
  Row(modifier = modifier
    .clickable { onClick() }
    .padding(8.dp)
    .defaultMinSize(minHeight = 40.dp),
    verticalAlignment = Alignment.CenterVertically) {
    if (leadingIcon != null) Icon(
      modifier = Modifier.size(24.dp),
      painter = painterResource(id = leadingIcon),
      contentDescription = null,
      tint = MaterialTheme.colorScheme.secondary
    )
    Text(
      text = title,
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 20.dp),
      style = Eam360Theme.typography.heading7,
      color = MaterialTheme.colorScheme.onSurface
    )
    if (badgeCount != null) Badge(
      containerColor = MaterialTheme.colorScheme.error,
      modifier = Modifier
        .size(18.dp)
        .align(Alignment.CenterVertically),
    ) {
      Text(
        text = badgeCount.toString(),
        style = Eam360Theme.typography.button8,
        color = MaterialTheme.colorScheme.onTertiary,
      )
    }
    if (showRightArrow) {
      Icon(
        painter = painterResource(id = R.drawable.keyboard_arrow_right), contentDescription = null
      )
    }
  }
}

@Preview(showBackground = true) @Composable fun NavigationRowPreview() {
  NavigationRow(
    title = "Label", leadingIcon = drawable.ic_call_decline, badgeCount = 5, showRightArrow = true
  ) {

  }
}