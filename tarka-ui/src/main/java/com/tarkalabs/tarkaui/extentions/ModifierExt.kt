package com.tarkalabs.tarkaui.extentions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

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

/**
 * set maximum height to given composable.
 * @param height The current value of the Toggleable.
 * @return A Modifier instance after setting max height.
 */
fun Modifier.maxHeight(
  height: Int,
): Modifier = composed {
  heightIn(max = height.dp)
}

/**
 * set maximum width to given composable.
 * @param width The current value of the Toggleable.
 * @return A Modifier instance after setting maximum width.
 */
fun Modifier.maxWidth(
  width: Int,
): Modifier = composed {
  widthIn(max = width.dp)
}