package com.tarkalabs.tarkaui.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.HorizontalSpacer
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.icons.Circle20
import com.tarkalabs.tarkaui.icons.TarkaIcon
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * This composable function gives the Tab used in TabRow.
 *
 * @param modifier - Usual thing used in compose to modify the composable properties & behaviour.
 * @param title - Title Text of the tab
 * @param isSelected - Boolean which denotes the selected state of the Tab,
 * @param leadingIcon - LeadingIcon of the tab.
 * @param tags - data class consist of tags used in testing
 * @param onTabClicked -  lambda invokes when we click the Tab
 *
 * Sample:
 *  TUITab(
 *    modifier = Modifier.width(105.dp),
 *    title = "Tab",
 *    leadingIcon = TarkaIcons.Regular.Circle20,
 *    isSelected = true
 *  ) {}
 *
 * */
@Composable
fun TUITab(
  modifier: Modifier = Modifier,
  title: String,
  isSelected: Boolean = false,
  leadingIcon: TarkaIcon? = null,
  tags: TUITabTags = TUITabTags(),
  onTabClicked: () -> Unit,
) {
  Tab(modifier = modifier
    .testTag(title)
    .padding(4.dp)
    .clip(RoundedCornerShape(32.dp))
    .background(if (isSelected) TUITheme.colors.secondary else Color.Transparent),
    selected = isSelected,
    selectedContentColor = TUITheme.colors.secondary,
    unselectedContentColor = TUITheme.colors.onSurface,
    onClick = {
      onTabClicked.invoke()
    }) {
    Row(
      modifier = Modifier.padding(start = if (leadingIcon != null) 6.dp else 0.dp),
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.CenterVertically
    ) {

      leadingIcon?.let {
        Icon(
          modifier = Modifier
            .testTag(tags.leadIconTag)
            .size(20.dp),
          painter = painterResource(id = it.iconRes),
          contentDescription = it.contentDescription,
          tint = if (isSelected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
        )
      }

      Text(
        modifier = Modifier.padding(
          start = if (leadingIcon == null) 16.dp else 4.dp,
          end = 16.dp,
          top = 6.dp,
          bottom = 6.dp
        ),
        text = title,
        style = TUITheme.typography.button6,
        color = if (isSelected) TUITheme.colors.onSecondary else TUITheme.colors.onSurface,
      )
    }

  }
}

data class TUITabTags(
  val leadIconTag: String = "TUITab_leadIcon_Tag",
)

@Preview(showBackground = true)
@Composable
fun TUITabPreview() {
  Column {

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
      TUITab(modifier = Modifier.width(105.dp), title = "Tab") {}
      HorizontalSpacer(space = 5)
      TUITab(modifier = Modifier.width(105.dp), title = "Tab", isSelected = true) {}
    }

    VerticalSpacer(space = 15)

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
      TUITab(
        modifier = Modifier.width(105.dp),
        title = "Tab",
        leadingIcon = Regular.Circle20
      ) {}
      HorizontalSpacer(space = 5)
      TUITab(
        modifier = Modifier.width(105.dp),
        title = "Tab",
        leadingIcon = Regular.Circle20,
        isSelected = true
      ) {}
    }

  }
}
