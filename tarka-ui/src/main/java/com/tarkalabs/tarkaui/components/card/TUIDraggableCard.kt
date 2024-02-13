package com.tarkalabs.tarkaui.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.tarkalabs.tarkaui.icons.ReOrderDotsVertical24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIToggleSwitch
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 *This Component is used to show the list of Cards those can be dragged vertically & re-arranged by the users.
 *
 * @param modifier - used to modify the parent (Row) attributes
 * @param dragIconModifier - a modifier with dragListener & used in trailingIcon which is used to consume drag events.
 * @param title - title text of the card which usually contains tab Name in TabConfigure Screen in Technician Settings.
 * @param switchCheckedState - initial checked status of the switch
 * @param onSwitchCheckedChange - callback which invokes when switch state changes
 * @param tags - tags used to pick the compose items while testing
 */
@Composable
fun TUIDraggableCard(
  modifier: Modifier = Modifier,
  dragIconModifier: Modifier,
  title: String,
  switchCheckedState: Boolean,
  onSwitchCheckedChange: () -> Unit,
  isDragging: Boolean = false,
  tags: TUIDraggableCardTags = TUIDraggableCardTags(),
) {
  Row(
    modifier = modifier
      .testTag(tags.parentTag)
      .fillMaxWidth()
      .background(color = TUITheme.colors.surface, shape = RoundedCornerShape(16.dp))
      .padding(top = 8.dp, bottom = 8.dp, start = 8.dp, end = 16.dp)
      .zIndex(if (isDragging) 1f else 0f)
      .graphicsLayer {
        shadowElevation = if (isDragging) 8f else 0f
      },
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround
  ) {

    Icon(
      modifier = dragIconModifier
        .testTag(tags.leadReOrderIconTag)
        .size(48.dp)
        .padding(12.dp),
      painter = painterResource(id = TarkaIcons.Regular.ReOrderDotsVertical24.iconRes),
      contentDescription = TarkaIcons.Regular.ReOrderDotsVertical24.contentDescription,
      tint = TUITheme.colors.onSurface
    )

    Text(
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 16.dp),
      text = title,
      color = TUITheme.colors.inputText,
      style = TUITheme.typography.heading6,
    )

    TUIToggleSwitch(isChecked = switchCheckedState, onCheckedChange = onSwitchCheckedChange)
  }
}

data class TUIDraggableCardTags(
  val parentTag: String = "TUIDraggableCard",
  val leadReOrderIconTag: String = "TUIDraggableCard_DragIcon",
)

@Preview
@Composable
fun TUIDraggableCardPreview() {
  TUITheme(darkTheme = true) {

    Column(modifier = Modifier.background(color = TUITheme.colors.onSurface)) {

      VerticalSpacer(space = 5)

      TUIDraggableCard(
        title = "Description 1",
        switchCheckedState = true,
        onSwitchCheckedChange = {},
        dragIconModifier = Modifier
      )

      VerticalSpacer(space = 5)

      TUIDraggableCard(
        title = "Description 2",
        switchCheckedState = false,
        onSwitchCheckedChange = {},
        dragIconModifier = Modifier
      )

      VerticalSpacer(space = 5)

    }
  }
}