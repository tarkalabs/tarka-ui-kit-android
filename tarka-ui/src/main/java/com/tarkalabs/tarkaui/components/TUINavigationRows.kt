package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.Call20
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

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
 * @param showRightArrow: The trailing arrow con displayed at the end.
 * @param content: A dynamic Composable to display in row
 * @param modifier: The modifier to apply to the row.
 * @param isSelected: The selected state of the row
 * @param tags: The test tag for the row.
 * @param onClick: The callback function when the row is clicked.
 * @param content: The child content of the navigation row(Eg: TUIBadge, Connection Status etc).
 *
 * Example usage:
 *
 * TUINavigationRow(
 *   title = "Profile",
 *   leadingIcon = TarkaIcon.Profile,
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
  isSelected: Boolean = false,
  tags: TUINavigationRowTags = TUINavigationRowTags(),
  onClick: () -> Unit,
  content: (@Composable RowScope.() -> Unit)? = null
) {
  Surface(
    color = if (isSelected) TUITheme.colors.primaryAlt else TUITheme.colors.surface,
    modifier = Modifier.fillMaxWidth(),
    shape = if (isSelected) RoundedCornerShape(8.dp) else RectangleShape
  ) {
    Row(
      modifier = modifier
        .clickable { onClick() }
        .defaultMinSize(minHeight = 40.dp)
        .padding(8.dp)
        .testTag(tags.parentTag),
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (leadingIcon != null) {
        Icon(
          modifier = Modifier
            .size(24.dp)
            .testTag(tags.leadingIconTag),
          painter = painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          tint = if (isSelected) TUITheme.colors.onSecondaryAlt else TUITheme.colors.secondary
        )
      }
      Text(
        text = title,
        modifier = Modifier
          .weight(1f)
          .padding(horizontal = 20.dp),
        style = TUITheme.typography.heading7,
        color = if (isSelected) TUITheme.colors.onSecondaryAlt else TUITheme.colors.onSurface
      )
      content?.invoke(this)
      if (showRightArrow) {
        Icon(
          modifier = Modifier.testTag(tags.rightArrowTag),
          painter = painterResource(id = Regular.ChevronRight20.iconRes),
          contentDescription = Regular.ChevronRight20.contentDescription,
          tint = TUITheme.colors.utilityOutline
        )
      }
    }
  }
}

data class TUINavigationRowTags(
  val parentTag: String = "TUINavigationRow",
  val leadingIconTag: String = "TUINavigationRow_LeadingIcon",
  val rightArrowTag: String = "TUINavigationRow_TrailingIcon"
)

@Preview(showBackground = true)
@Composable
private fun TUINavigationRowPreview() {
  Column {
    TUINavigationRow(
      title = "Label",
      leadingIcon = Regular.Call20,
      onClick = {
      }
    ) {
      Text(text = "NILESH")
    }

    TUINavigationRow(
      title = "Label",
      isSelected = true,
      leadingIcon = Regular.Call20,
      onClick = {
      }
    ) {
      Text(text = "NILESH")
    }
  }
}