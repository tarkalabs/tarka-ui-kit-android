package com.tarkalabs.uicomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.sp
import com.tarkalabs.uicomponents.components.ButtonSize.L
import com.tarkalabs.uicomponents.components.ButtonSize.M
import com.tarkalabs.uicomponents.components.ButtonSize.S
import com.tarkalabs.uicomponents.components.ButtonSize.XS
import com.tarkalabs.uicomponents.components.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.ButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.ButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.theme.Eam360Theme
import com.tarkalabs.uicomponents.theme.EamTheme

enum class ButtonStyle {
  PRIMARY,
  SECONDARY,
  GHOST,
  ERROR,
  OUTLINE;
}

enum class ButtonSize(val size: Dp) {
  L(48.dp),
  M(40.dp),
  S(32.dp),
  XS(24.dp);

  fun iconSize(): Dp {
    return when (this) {
      L -> 17.5.dp
      M -> 17.5.dp
      S, XS -> 11.dp
    }
  }

  fun paddingValues(isLeadingIconNull: Boolean, isTrailingIconNull: Boolean) = when (this) {
    L, M -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 24.dp else 16.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 24.dp else 16.dp
    )

    S -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 16.dp else 8.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 16.dp else 8.dp
    )

    XS -> PaddingValues(
      top = 0.dp,
      start = if (isLeadingIconNull) 8.dp else 4.dp,
      bottom = 0.dp,
      end = if (isTrailingIconNull) 8.dp else 4.dp
    )
  }

  @Composable fun textStyle() = when (this) {
    L -> Eam360Theme.typography.button6
    M -> Eam360Theme.typography.button6
    S -> Eam360Theme.typography.button7
    XS -> Eam360Theme.typography.button8
  }
}

/**
 * Below TKButton() defines a reusable composable function which can be used to create an Button with various styles and sizes which takes several parameters such as
 * @param label The text to be displayed on the button.
 * @param height The height size of the button. Default is [ButtonSize.M].
 * @param buttonStyle The style of the button. Default is [ButtonStyle.PRIMARY].
 * @param leadingIcon The drawable resource for the leading icon, if any. Default is null.
 * @param trailingIcon The drawable resource for the trailing icon, if any. Default is null.
 * @param onClick The callback function to be executed when the button is clicked.
 *
 * How to use TKButton() composable function
 *
TKButton(
label = "Primary Button",
height = M,
buttonStyle = PRIMARY,
onClick = {}
)
 *
 */
@Composable fun TKButton(
  label: String,
  height: ButtonSize = M,
  buttonStyle: ButtonStyle = PRIMARY,
  @DrawableRes leadingIcon: Int? = null,
  @DrawableRes trailingIcon: Int? = null,
  onClick: () -> Unit,
) {

  val buttonColor = when (buttonStyle) {
    PRIMARY -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
      )
    }

    SECONDARY -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
      )
    }

    GHOST -> {
      ButtonDefaults.buttonColors(
        containerColor = Color.Transparent, contentColor = MaterialTheme.colorScheme.secondary
      )
    }

    ERROR -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onPrimary,
      )
    }

    OUTLINE -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
      )
    }
  }
  Button(
    onClick = onClick,
    colors = buttonColor,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null),
    border = if (buttonStyle == OUTLINE) BorderStroke(
      width = 1.dp, color = MaterialTheme.colorScheme.onSurface
    ) else null
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

@Composable @Preview(showBackground = true, showSystemUi = true) fun PreviewPrimaryButton() {
  EamTheme {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
      Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
          Text("Primary Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Primary ", height = M, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = L, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = S, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = XS, buttonStyle = PRIMARY, onClick = {})

        }
        Column {
          Text("Secondary Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Secondary ", height = M, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = L, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = S, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = XS, buttonStyle = SECONDARY, onClick = {})
        }
      }

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 10.dp)
      ) {
        Column(horizontalAlignment = Alignment.Start) {
          Text("Ghost Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Ghost Button", height = M, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = L, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = S, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = XS, buttonStyle = GHOST, onClick = {})
        }

        Column {
          Text("Error Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Error Button", height = M, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = L, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = S, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = XS, buttonStyle = ERROR, onClick = {})

        }
      }
      Text("Outline Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.height(20.dp))
      TKButton(label = "Outline Button", height = M, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = L, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = S, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = XS, buttonStyle = OUTLINE, onClick = {})
    }
  }
}