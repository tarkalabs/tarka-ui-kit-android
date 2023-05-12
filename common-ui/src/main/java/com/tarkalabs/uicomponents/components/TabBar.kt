package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

@Composable fun TabBar(
  items: List<String>,
  modifier: Modifier = Modifier,
  selectedTabIndex: Int,
  onSelectedTab: (Int) -> Unit
) {
  var selectedIndex by remember { mutableStateOf(selectedTabIndex) }

  TabRow(selectedTabIndex = selectedTabIndex,
    modifier = modifier,
    containerColor = Color.Transparent,
    contentColor = MaterialTheme.colorScheme.onSurface,
    indicator = {

    }) {
    items.forEachIndexed { index, text ->
      val selected = selectedTabIndex == index
      Tab(modifier = if (selected) Modifier
        .clip(RoundedCornerShape(50))
        .background(
          Color.White
        )
      else Modifier
        .clip(RoundedCornerShape(50))
        .background(
          Color(
            0xff1E76DA
          )
        ), selected = selected, onClick = {
        selectedIndex = index
      }, text = { Text(text = text, color = Color(0xff6FAAEE)) })
    }
  }
}