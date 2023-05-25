package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.R.drawable
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.theme.Eam360Theme

@Composable fun TUITextRow(
  title: String,
  description: String,
  modifier: Modifier = Modifier.fillMaxWidth(),
  iconOne: TarkaIcon? = null,
  iconTwo: TarkaIcon? = null,
  buttonTitle: String? = null,
  infoIcon: TarkaIcon? = null,
  onIconOneClick: () -> Unit = {},
  onIconTwoClick: () -> Unit = {},
  onButtonClick: () -> Unit = {},
  onInfoIconClick: () -> Unit = {},
  onTextRowClick: () -> Unit = {},
  paddingValues: PaddingValues = PaddingValues()
) {
  Row(
    modifier
      .clickable { onTextRowClick() }
      .defaultMinSize(minHeight = 40.dp)
      .padding(paddingValues),
    verticalAlignment = Alignment.CenterVertically) {
    Column(Modifier.weight(1f)) {
      Text(
        text = title,
        style = Eam360Theme.typography.body8,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
      )
      Text(
        text = description,
        style = Eam360Theme.typography.body7,
        color = MaterialTheme.colorScheme.onSurface
      )
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      if (iconOne != null) IconButton(
        icon = iconOne,
        onIconClick = onIconOneClick,
        iconButtonStyle = IconButtonStyle.GHOST,
      )
      if (iconTwo != null) IconButton(
        icon = iconTwo,
        onIconClick = onIconTwoClick,
        iconButtonStyle = IconButtonStyle.GHOST

      )
      if (buttonTitle != null) {
        OutlinedButton(
          modifier = Modifier
            .height(40.dp)
            .width(90.dp), onClick = onButtonClick
        ) {
          Text(text = buttonTitle)
        }
      }
      if (infoIcon != null) {
        IconButton(modifier = Modifier.size(24.dp), onClick = onInfoIconClick) {
          Icon(painter = painterResource(id = infoIcon.iconRes), contentDescription = null)
        }
      }
    }
  }
}

@Preview(showBackground = true) @Composable fun TextRowWithDescriptionPreview() {
  TUITextRow(
    title = "Title",
    description = "Description",
    infoIcon = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    iconOne = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    iconTwo = TarkaIcon(drawable.ic_call_answer, "Call Answer"),
    buttonTitle = "Label"
  )
}