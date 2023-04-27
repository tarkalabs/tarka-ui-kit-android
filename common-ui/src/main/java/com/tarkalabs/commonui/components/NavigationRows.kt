@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable
import com.tarkalabs.common_ui.R

@Composable
fun NavigationRow(
  title: String,
  @DrawableRes leadingIcon: Int? = null,
  badgeCount: Int? = null,
  showRightArrow: Boolean = false,
  modifier: Modifier = Modifier,
  onClick: () -> Unit = {}
) {
  Row(
    modifier = modifier
      .clickable { onClick() }
      .padding(8.dp)
      .height(40.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    if (leadingIcon != null)
      Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(id = leadingIcon),
        contentDescription = null
      )
    Text(text = title, modifier = Modifier
      .weight(1f)
      .padding(horizontal = 20.dp))
    if (badgeCount != null)
      Badge { Text(text = badgeCount.toString()) }
    if (showRightArrow) {
      Icon(
        painter = painterResource(id = R.drawable.keyboard_arrow_right),
        contentDescription = null
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun NavigationRowPreview() {
  NavigationRow(
    title = "Label",
    leadingIcon = drawable.ic_call_decline,
    badgeCount = 5,
    showRightArrow = true
  )
}