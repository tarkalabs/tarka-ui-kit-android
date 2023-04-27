package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.R.drawable
import com.tarkalabs.common_ui.R

@Composable
fun TextRowWithDescription(
  title : String,
  description : String,
  modifier: Modifier = Modifier.fillMaxWidth(),
  @DrawableRes iconOne : Int? = null,
  @DrawableRes iconTwo : Int? = null,
  buttonTitle : String? = null,
  @DrawableRes infoIcon : Int? = null,
  onIconOneClick : () -> Unit = {},
  onIconTwoClick : () -> Unit = {},
  onButtonClick : () -> Unit = {},
  onInfoIconClick : () -> Unit = {},
  onTextRowClick : () -> Unit = {},
) {
  Row(modifier.clickable { onTextRowClick() }, verticalAlignment = Alignment.CenterVertically) {
    Column(Modifier.weight(1f)) {
      Text(text = title)
      Text(text = description)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
      if (iconOne != null)
        EamGhostIconButton(icon = iconOne, onIconClick = onIconOneClick)
      if (iconTwo != null)
        EamGhostIconButton(icon = iconTwo, onIconClick = onIconTwoClick)
      if (buttonTitle != null) {
        OutlinedButton(onClick = onButtonClick) {
          Text(text = buttonTitle)
        }
      }
      if (infoIcon != null){
        IconButton(onClick = onInfoIconClick) {
          Icon(painter = painterResource(id = infoIcon), contentDescription = null)
        }
      }
    }
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextRowWithDescriptionPreview() {
  TextRowWithDescription(title = "Title", description = "Description", infoIcon = drawable.ic_call_answer,
    iconOne = drawable.ic_call_answer,
    iconTwo = drawable.ic_call_answer,
    buttonTitle = "Label"
  )
}