package com.tarkalabs.uicomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tarkalabs.uicomponents.components.ChipType.Assist
import com.tarkalabs.uicomponents.components.ChipType.Filter
import com.tarkalabs.uicomponents.components.ChipType.Input
import com.tarkalabs.uicomponents.components.ChipType.Suggestion
import com.tarkalabs.uicomponents.models.TarkaIcon

sealed class ChipType {
  object Assist : ChipType()
  data class Input(val selected: Boolean = false) : ChipType()
  class Suggestion() : ChipType()
  data class Filter(val selected: Boolean = false) : ChipType()
}

enum class ChipSize(val size: Int) {
  SMALL(32),
  WIDE(40)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TUIChip(
  modifier: Modifier = Modifier,
  type: ChipType,
  selected: Boolean,
  size: ChipSize,
  leadingIcon: TarkaIcon? = null,
  //leadingAvatar: @DrawableRes Int? = null,
  trailingIcon: TarkaIcon? = null,

  onClick: (() -> Unit)
) {
  when (type) {
    is Assist -> AssistChip(onClick = onClick, label = {})
    is Input -> InputChip(selected = type.selected, onClick = onClick, label = { Text(text = "") })
    is Suggestion -> SuggestionChip(onClick = onClick, label = { Text(text = "") })
    is Filter -> FilterChip(
      selected = type.selected,
      onClick = onClick,
      label = { Text(text = "") })
  }
}

// TODO: should we allow content or specific images and icons