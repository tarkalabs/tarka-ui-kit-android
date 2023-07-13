package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
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
 * @param content: A dynamic Composable to display in row
 * @param modifier: The modifier to apply to the row.
 * @param tags: The test tag for the row.
 * @param onClick: The callback function when the row is clicked.
 * @param content: The child content of the navigation row(Eg: TUIBadge, Connection Status etc).
 *
 * Example usage:
 *
 * TUINavigationRow(
 *   title = "Profile",
 *   leadingIcon = TarkaIcons.Profile,
 *   modifier = Modifier.fillMaxWidth(),
 *   badgeTestTag = "profile_badge",
 *   rowTestTag = "profile_row",
 *   onClick = { /* Handle click event */ }
 * )
 *
 */
@Composable fun TUINavigationRow(
  modifier: Modifier = Modifier,
  title: String,
  leadingIcon: TarkaIcon? = null,
  showRightArrow: Boolean = false,
  tags: TUINavigationRowTags = TUINavigationRowTags(),
  onClick: () -> Unit,
  content: (@Composable RowScope.() -> Unit)? = null,
) {
  Row(modifier = modifier
    .clickable { onClick() }
    .padding(8.dp)
    .defaultMinSize(minHeight = 40.dp)
    .testTag(tags.parentTag), verticalAlignment = Alignment.CenterVertically) {
    if (leadingIcon != null) Icon(
      modifier = Modifier
        .size(24.dp)
        .testTag(tags.leadingIconTag),
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
    content?.invoke(this)
    if (showRightArrow) {
      Icon(
        modifier = Modifier.testTag(tags.rightArrowTag),
        painter = painterResource(id = TarkaIcons.ChevronRight20Regular.iconRes),
        contentDescription = TarkaIcons.ChevronRight20Regular.contentDescription,
        tint = TUITheme.colors.utilityOutline
      )
    }
  }
}

data class TUINavigationRowTags(
  val parentTag: String = "TUINavigationRow",
  val leadingIconTag: String = "TUINavigationRow_LeadingIcon",
  val rightArrowTag: String = "TUINavigationRow_TrailingIcon"
)

@Preview(showBackground = true) @Composable fun TUINavigationRowPreview() {
  TUINavigationRow(
    title = "Label",
    leadingIcon = TarkaIcon(androidx.core.R.drawable.ic_call_decline, "Call Decline"),
    onClick = {

    },
  ) {
    Text(text = "NILESH")
  }
}