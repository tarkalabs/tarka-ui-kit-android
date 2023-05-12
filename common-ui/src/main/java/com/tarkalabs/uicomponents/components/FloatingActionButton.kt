package com.tarkalabs.uicomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.L
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.R
import com.tarkalabs.uicomponents.components.FloatingActionButtonSize.S

enum class FloatingActionButtonSize(val size: Dp) {
  S(40.dp),
  R(56.dp),
  L(96.dp)
}

@Composable fun FloatingActionButton(
  fabSize: FloatingActionButtonSize = S,
  @DrawableRes icon: Int,
  contentDescription: String,
  onClick: () -> Unit
) {
  val iconSize = when (fabSize) {
    S, R -> 18.dp
    L -> 22.dp
  }
  FloatingActionButton(
    onClick = onClick,
    containerColor = MaterialTheme.colorScheme.primary,
    shape = CircleShape,
    modifier = Modifier.defaultMinSize(minHeight = fabSize.size, minWidth = fabSize.size)
  ) {
    Icon(
      modifier = Modifier.defaultMinSize(iconSize, iconSize),
      painter = painterResource(id = icon),
      contentDescription = contentDescription
    )
  }
}

@Preview(showBackground = true)
@Composable fun FloatingActionButtonPreview() {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly

  ) {
    FloatingActionButton(
      L, com.tarkalabs.uicomponents.R.drawable.keyboard_arrow_right, "Large FAB"
    ) {

    }
    Spacer(modifier = Modifier.padding(5.dp))
    FloatingActionButton(
      R, com.tarkalabs.uicomponents.R.drawable.keyboard_arrow_right, "Regular FAB"
    ) {

    }
    Spacer(modifier = Modifier.padding(5.dp))
    FloatingActionButton(
      S, com.tarkalabs.uicomponents.R.drawable.keyboard_arrow_right, "Small FAB"
    ) {

    }
  }
}




