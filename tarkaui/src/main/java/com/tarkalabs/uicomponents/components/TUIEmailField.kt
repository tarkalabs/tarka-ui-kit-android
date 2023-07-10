package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.ChipType.Input
import com.tarkalabs.uicomponents.components.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@OptIn(ExperimentalLayoutApi::class) @Composable fun TUIEmailField(
  title: String,
  emailList: List<String>,
  trailingIcon: TarkaIcon,
  trailingIconClick: () -> Unit,
  onItemRemoved: (Int) -> Unit
) {
  val emailAddressList = remember { mutableStateListOf(*emailList.toTypedArray()) }

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
      emailAddressList.forEachIndexed { index, email ->
        TUIChip(
          modifier = Modifier.padding(2.dp),
          type = Input(showTrailingDismiss = true),
          label = email,
          onClick = {
            onItemRemoved.invoke(index)
          },

          )
      }
    }

    TUIIconButton(
      icon = trailingIcon, onIconClick = trailingIconClick, iconButtonStyle = GHOST
    )
  }
}

@Preview @Composable fun PreviewTUIEmailField() {
  TUITheme {
    val emailList = remember {
     mutableListOf("mike32@soft.com",
       "mike.smith@corp.co",
       "mike32@soft.com",)
    }
    TUIEmailField(title = "To",
      emailList = emailList,
      trailingIcon = TarkaIcons.AddCircle24Regular,
      onItemRemoved = { position ->
        emailList.removeAt(position)
      },
      trailingIconClick = {

      })
  }
}