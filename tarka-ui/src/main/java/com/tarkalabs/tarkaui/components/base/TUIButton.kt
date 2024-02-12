package com.tarkalabs.tarkaui.components.base

import com.tarkalabs.uicomponents.components.base.ButtonSize.L
import com.tarkalabs.uicomponents.components.base.ButtonSize.M
import com.tarkalabs.uicomponents.components.base.ButtonSize.S
import com.tarkalabs.uicomponents.components.base.ButtonSize.XS
import com.tarkalabs.uicomponents.components.base.ButtonStyle.ERROR
import com.tarkalabs.uicomponents.components.base.ButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.ButtonStyle.PRIMARY
import com.tarkalabs.uicomponents.components.base.ButtonStyle.SECONDARY
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarkalabs.tarkaicons.Add24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.HorizontalSpacer
import com.tarkalabs.uicomponents.theme.TUITheme

enum class ButtonStyle {
  PRIMARY,
  SECONDARY,
  GHOST,
  ERROR,
  OUTLINE;
}

enum class ButtonSize(val size: Dp) {
  XL(56.dp),
  L(48.dp),
  M(40.dp),
  S(32.dp),
  XS(24.dp);

  fun iconSize(): Dp {
    return when (this) {
      XL, L, M -> 24.dp
      S, XS -> 16.dp
    }
  }

  fun iconSpace(): Int {
    return when (this) {
      XL, L, M -> 8
      S, XS -> 4
    }
  }

  fun paddingValues(isLeadingIconNull: Boolean, isTrailingIconNull: Boolean) = when (this) {
    XL, L, M -> PaddingValues(
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
    XL, L, M -> TUITheme.typography.button6
    S -> TUITheme.typography.button7
    XS -> TUITheme.typography.button8
  }
}

/**
 * Below TUIButton() defines a reusable composable function which can be used to create an Button with various styles and sizes which takes several parameters such as
 * @param label The text to be displayed on the button.
 * @param modifier The modifier to apply to the button.
 * @param height The height size of the button. Default is [ButtonSize.M].
 * @param buttonStyle The style of the button. Default is [ButtonStyle.PRIMARY].
 * @param leadingIcon The drawable resource for the leading icon, if any. Default is null.
 * @param trailingIcon The drawable resource for the trailing icon, if any. Default is null.
 * @param onClick The callback function to be executed when the button is clicked.
 * How to use TKButton() composable function
 *
TUIButton(
label = "Primary Button",
height = M,
buttonStyle = PRIMARY,
onClick = {}
)
 *
 */
@Composable fun TUIButton(
  label: String,
  modifier: Modifier = Modifier,
  height: ButtonSize = M,
  buttonStyle: ButtonStyle = PRIMARY,
  leadingIcon: TarkaIcon? = null,
  trailingIcon: TarkaIcon? = null,
  tags: TUIButtonTags = TUIButtonTags(),
  onClick: () -> Unit,
) {
  val buttonColor = when (buttonStyle) {
    PRIMARY -> {
      ButtonDefaults.buttonColors(
        containerColor = TUITheme.colors.primary,
        contentColor = TUITheme.colors.onPrimary
      )
    }

    SECONDARY -> {
      ButtonDefaults.buttonColors(
        containerColor = TUITheme.colors.secondary,
        contentColor = TUITheme.colors.onSecondary
      )
    }

    GHOST -> {
      ButtonDefaults.buttonColors(
        containerColor = Color.Transparent, contentColor = TUITheme.colors.secondary
      )
    }

    ERROR -> {
      ButtonDefaults.buttonColors(
        containerColor = TUITheme.colors.error,
        contentColor = TUITheme.colors.onPrimary,
      )
    }

    OUTLINE -> {
      ButtonDefaults.buttonColors(
        containerColor = TUITheme.colors.surface,
        contentColor = TUITheme.colors.onSurface
      )
    }
  }

  Button(
    onClick = onClick,
    colors = buttonColor,
    modifier = modifier
      .height(height.size)
      .testTag(tags.parentTag),
    contentPadding = height.paddingValues(
      isLeadingIconNull = leadingIcon == null,
      isTrailingIconNull = trailingIcon == null
    ),
    border = if (buttonStyle == OUTLINE) BorderStroke(
      width = 1.dp, color = TUITheme.colors.onSurface
    ) else null
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          modifier = Modifier
            .size(height.iconSize())
            .testTag(tags.leadingIconTag)
        )
        HorizontalSpacer(space = height.iconSpace())
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        HorizontalSpacer(space = height.iconSpace())
        Icon(
          painter = painterResource(id = trailingIcon.iconRes),
          contentDescription = trailingIcon.contentDescription,
          modifier = Modifier
            .size(height.iconSize())
            .testTag(tags.trailingIconTag)
        )
      }
    }
  }
}

data class TUIButtonTags(
  val parentTag: String = "TUIButton",
  val leadingIconTag: String = "TUIButton_LeadingIcon",
  val trailingIconTag: String = "TUIButton_TrailingIcon",
)

@Composable @Preview(showBackground = true, showSystemUi = true) fun PreviewPrimaryButton() {
  TUITheme {
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
          TUIButton(label = "Primary ", height = M, buttonStyle = PRIMARY, onClick = {}, trailingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Primary ", height = L, buttonStyle = PRIMARY, onClick = {}, trailingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Primary ", height = S, buttonStyle = PRIMARY, onClick = {}, trailingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Primary ", height = XS, buttonStyle = PRIMARY, onClick = {}, trailingIcon = Regular.Add24)
        }
        Column {
          Text("Secondary Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TUIButton(label = "Secondary ", height = M, buttonStyle = SECONDARY, onClick = {}, leadingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Secondary ", height = L, buttonStyle = SECONDARY, onClick = {}, leadingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Secondary ", height = S, buttonStyle = SECONDARY, onClick = {}, leadingIcon = Regular.Add24)
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Secondary ", height = XS, buttonStyle = SECONDARY, onClick = {}, leadingIcon = Regular.Add24)
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
          TUIButton(label = "Ghost Button", height = M, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Ghost Button", height = L, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Ghost Button", height = S, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Ghost Button", height = XS, buttonStyle = GHOST, onClick = {})
        }

        Column {
          Text("Error Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TUIButton(label = "Error Button", height = M, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Error Button", height = L, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Error Button", height = S, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TUIButton(label = "Error Button", height = XS, buttonStyle = ERROR, onClick = {})

        }
      }
      Text("Outline Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.height(20.dp))
      TUIButton(label = "Outline Button", height = M, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TUIButton(label = "Outline Button", height = L, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TUIButton(label = "Outline Button", height = S, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TUIButton(label = "Outline Button", height = XS, buttonStyle = OUTLINE, onClick = {})
    }
  }
}