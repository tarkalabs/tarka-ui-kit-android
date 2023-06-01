@file:OptIn(ExperimentalMaterial3Api::class)

package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUIColors
import com.tarkalabs.uicomponents.theme.TUITheme

// TODO: 5/2/2023 use dimensions instead of hard coded things

/**
 *
 * The TUINavigationRow composable function creates a row that represents a navigation item in a UI.
 * It handles click events and provides a callback for customization. The row can display a title,
 * an optional leading icon, a badge count, and a right arrow icon. The appearance can be modified
 * using the provided modifiers. When the row is clicked, the specified [onClick] function is invoked.
 *
 * @param title: The title text to be displayed in the navigation row.
 * @param leadingIcon: The optional leading icon displayed before the title.
 * @param badgeCount: The optional count to display as a badge.
 * @param showRightArrow: Whether to show a right arrow icon.
 * @param modifier: The modifier to apply to the row.
 * @param badgeTestTag: The test tag for the badge.
 * @param rowTestTag: The test tag for the row.
 * @param onClick: The callback function when the row is clicked.
 *
 * Example usage:
 *
 * TUINavigationRow(
 *   title = "Profile",
 *   leadingIcon = TarkaIcons.Profile,
 *   badgeCount = 2,
 *   showRightArrow = true,
 *   modifier = Modifier.fillMaxWidth(),
 *   badgeTestTag = "profile_badge",
 *   rowTestTag = "profile_row",
 *   onClick = { /* Handle click event */ }
 * )
 *
 */
@OptIn(ExperimentalMaterial3Api::class) @Composable fun TUINavigationRow(
  title: String,
  leadingIcon: TarkaIcon? = null,
  badgeCount: Int? = null,
  showRightArrow: Boolean = false,
  modifier: Modifier = Modifier,
  badgeTestTag: String = Tags.TAG_NAVIGATION_ROW_BADGE,
  rowTestTag: String = Tags.TAG_NAVIGATION_ROW,
  onClick: () -> Unit,
) {
  Row(modifier = modifier
    .clickable { onClick() }
    .padding(8.dp)
    .defaultMinSize(minHeight = 40.dp)
    .testTag(rowTestTag),
    verticalAlignment = Alignment.CenterVertically) {
    if (leadingIcon != null) Icon(
      modifier = Modifier.size(24.dp),
      painter = painterResource(id = leadingIcon.iconRes),
      contentDescription = leadingIcon.contentDescription,
      tint = TUITheme.colors.secondary
    )
    Text(
      text = title,
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 20.dp),
      style = TUITheme.typography.heading7,
      color = TUITheme.colors.onSurface
    )
    if (badgeCount != null) Badge(
      containerColor = TUITheme.colors.error,
      modifier = Modifier
        .size(18.dp)
        .align(Alignment.CenterVertically)
        .testTag(badgeTestTag),
    ) {
      Text(
        text = badgeCount.toString(),
        style = TUITheme.typography.button8,
        color = TUITheme.colors.onTertiary,
      )
    }

    if (showRightArrow) {
      Icon(
        painter = painterResource(id = TarkaIcons.ChevronRight.iconRes),
        contentDescription = TarkaIcons.ChevronRight.contentDescription,
        tint = TUITheme.colors.utilityOutline
      )
    }
  }
}

@Preview(showBackground = true) @Composable fun TUINavigationRowPreview() {
  TUINavigationRow(
    title = "Label",
    leadingIcon = TarkaIcon(androidx.core.R.drawable.ic_call_decline, "Call Decline"),
    badgeCount = 5,
    showRightArrow = true
  ) {

  }
}