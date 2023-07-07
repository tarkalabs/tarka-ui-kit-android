package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@OptIn(ExperimentalLayoutApi::class)
@Composable fun TUIEmailField(
  title: String,
  emailList: List<String>,
  trailingIcon: TarkaIcon,
  trailingIconClick: () -> Unit,
) {
  Row(
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = title,
      style = TUITheme.typography.body7,
      color = TUITheme.colors.utilityOutline,
      modifier = Modifier.padding(15.dp)
    )
    FlowRow(
      modifier = Modifier.weight(1f),
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically,
      maxItemsInEachRow = 3
    ) {
      emailList.forEach { email ->
        Text(text = email,
          modifier = Modifier.padding(horizontal = 5.dp))
      }
    }

    TUIIconButton(
      icon = trailingIcon,
      onIconClick = trailingIconClick,
      iconButtonStyle = GHOST
    )
  }
}

@Preview @Composable fun PreviewTUIEmailField() {
  TUITheme {
    TUIEmailField(
      title = "To",
      emailList = listOf("abcdsds@gmail.com", "abd@gmail.com", "bcasdsdsd@gmail.com"),
      trailingIcon = TarkaIcons.AddCircle24Regular
    ) {

    }
  }
}