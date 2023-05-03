package com.tarkalabs.commonui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.commonui.components.ButtonHeight.Regular
import com.tarkalabs.commonui.theme.Eam360Theme

enum class ButtonHeight(val size: Dp) {
  Large(48.dp),
  Regular(40.dp),
  Small(32.dp),
  ExtraSmall(24.dp);

  fun iconSize(): Dp {
    return when (this) {
      Large -> 17.5.dp
      Regular -> 17.5.dp
      Small -> 11.dp
      ExtraSmall -> 11.dp
    }
  }

  fun paddingValues(isLeadingIconNull : Boolean, isTrailingIconNull:Boolean) = when (this) {
    Large, Regular -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 24.dp else 16.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 24.dp else 16.dp
    )

    Small -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 16.dp else 8.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 16.dp else 8.dp
    )

    ExtraSmall -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 8.dp else 4.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 8.dp else 4.dp
    )
  }

  @Composable
  fun textStyle() = when (this) {
    Large -> Eam360Theme.typography.button6
    Regular -> Eam360Theme.typography.button6
    Small -> Eam360Theme.typography.button7
    ExtraSmall -> Eam360Theme.typography.button8
  }
}

@Composable fun PrimaryButton(
  label: String,
  colors: ButtonColors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.primary,
    contentColor = MaterialTheme.colorScheme.onPrimary
  ),
  height: ButtonHeight = Regular,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  Button(
    onClick = onClick,
    colors = colors,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}

@Composable fun SecondaryButton(
  label: String,
  colors: ButtonColors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.secondary,
    contentColor = MaterialTheme.colorScheme.onSecondary
  ),
  height: ButtonHeight = Regular,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  Button(
    onClick = onClick,
    colors = colors,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}

@Composable fun OutlinedButton(
  label: String,
  colors: ButtonColors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.surface,
    contentColor = MaterialTheme.colorScheme.onSurface
  ),
  height: ButtonHeight = Regular,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  Button(
    onClick = onClick,
    colors = colors,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null),
    border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.onSurface)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}


@Composable fun GhostButton(
  label: String,
  colors: ButtonColors = ButtonDefaults.buttonColors(
    containerColor = Color.Transparent,
    contentColor = MaterialTheme.colorScheme.secondary
  ),
  height: ButtonHeight = Regular,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  Button(
    onClick = onClick,
    colors = colors,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}


@Composable fun ErrorButton(
  label: String,
  colors: ButtonColors = ButtonDefaults.buttonColors(
    containerColor = MaterialTheme.colorScheme.error,
    contentColor = MaterialTheme.colorScheme.onPrimary,
  ),
  height: ButtonHeight = Regular,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  Button(
    onClick = onClick,
    colors = colors,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon),
          contentDescription = "",
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}

@Composable @Preview(showBackground = true)
fun PreviewPrimaryButton() {

}