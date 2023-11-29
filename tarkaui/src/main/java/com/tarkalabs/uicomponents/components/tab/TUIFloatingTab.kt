package com.tarkalabs.uicomponents.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.extentions.clickableWithoutRipple
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * The TUIFloatingTab is a composable function designed to create a customizable floating tab in a user interface.
 * @param modifier A modifier for the tab's layout and behavior.
 * @param title The title or label of the tab.
 * @param selected  A boolean indicating whether the tab is currently selected or not.
 * @param tags Tags for identifying and testing the tab.
 * @param onSelected A callback that will be invoked when the tab is selected.
 *
 * How To use TUIFloatingTab()
 *
 * TUIFloatingTab(title = "Tab 1", selected = true) { }
 *
 */
@Composable fun TUIFloatingTab(
  modifier: Modifier = Modifier,
  title: String,
  selected: Boolean,
  tags: TUIFloatingTabTags = TUIFloatingTabTags(),
  onSelected: () -> Unit,
) {

  val tabBgColor = if (selected) {
    TUITheme.colors.primary
  } else {
    Color.Transparent
  }

  Box(modifier = modifier
    .clickableWithoutRipple {
      onSelected()
    }
    .defaultMinSize(minWidth = 61.dp)
    .background(shape = RoundedCornerShape(32.dp), color = tabBgColor)
    .testTag(tags.parentTag),
    contentAlignment = Alignment.Center) {
    Text(
      modifier = Modifier.padding(16.dp),
      text = title,
      style = TUITheme.typography.body6,
      color = if (selected) TUITheme.colors.onPrimary else TUITheme.colors.primary
    )
  }
}

data class TUIFloatingTabTags(
  val parentTag: String = "TUIFloatingTabTagParentTag"
)

@Preview @Composable fun TUIFloatingTabPreview() {
  TUITheme {
    var tab1 by remember {
      mutableStateOf(true)
    }
    var tab2 by remember {
      mutableStateOf(false)
    }
    var tab3 by remember {
      mutableStateOf(true)
    }
    var tab4 by remember {
      mutableStateOf(false)
    }
    Column(
      modifier = Modifier
        .background(color = TUITheme.colors.surface)
        .fillMaxWidth(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      VerticalSpacer(space = 16)
      TUIFloatingTab(title = "Tab 1", selected = tab1) {
        tab1 = !tab1
      }
      VerticalSpacer(space = 16)
      TUIFloatingTab(title = "Tab 2", selected = tab2) {
        tab2 = !tab2
      }
      VerticalSpacer(space = 16)
      TUIFloatingTab(title = "Tab Log Name", selected = tab3) {
        tab3 = !tab3
      }
      VerticalSpacer(space = 16)
      TUIFloatingTab(title = "Tab Log Name", selected = tab4) {
        tab4 = !tab4
      }
    }
  }
}