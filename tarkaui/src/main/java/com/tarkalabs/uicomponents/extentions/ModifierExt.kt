package com.tarkalabs.uicomponents.extentions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role

/**
 * Removes the ripple effect from the modifier.
 *
 * @param onClick The callback function to be invoked when the modifier is clicked.
 *
 * @return A Modifier instance without the ripple effect.
 */
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier = composed {
  clickable(indication = null, interactionSource = remember { MutableInteractionSource() }) {
    onClick()
  }
}

/**
 * Removes the ripple effect from the Toggleable composable.
 *
 * @param value The current value of the Toggleable.
 * @param onValueChange The callback function to be invoked when the value of the Toggleable changes.
 * @param role The accessibility role for the Toggleable (optional).
 *
 * @return A Modifier instance without the ripple effect.
 */
fun Modifier.toggleableWithoutRipple(
  value: Boolean,
  onValueChange: (Boolean) -> Unit,
  role: Role? = null,
): Modifier = composed {
  toggleable(
    value = value,
    indication = null,
    interactionSource = remember { MutableInteractionSource() },
    onValueChange = onValueChange,
    role = role
  )
}