package com.tarkalabs.uicomponents.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.Diversity24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.BURGER
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.NAVIGATION
import com.tarkalabs.uicomponents.extentions.clickableWithoutRipple
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIFloatingNavButtonStyle {
  NAVIGATION,
  LIST,
  BURGER;

  companion object {
    val defaultStyle: TUIFloatingNavButtonStyle = NAVIGATION
  }
}

sealed class TUIFloatingNavButtonContentType {
  data class List(
    val iconOne: TarkaIcon,
    val onIconOneClick: (() -> Unit)? = null,
    val iconTwo: TarkaIcon,
    val onIconTwoClick: (() -> Unit)? = null,
    val iconThree: TarkaIcon,
    val onIconFourClick: (() -> Unit)? = null
  ) : TUIFloatingNavButtonContentType()

  data class Navigation(val text: String) : TUIFloatingNavButtonContentType()
  object Burger : TUIFloatingNavButtonContentType()
}

@Composable fun TUIFloatingNavButton(
  modifier: Modifier = Modifier,
  style: TUIFloatingNavButtonStyle = TUIFloatingNavButtonStyle.defaultStyle,
  leadingIcon: TarkaIcon? = null,
  title: String,
  onClicked: () -> Unit
) {

  Row(modifier  a w2 = modifier
    .wrapContentSize()
    .clickableWithoutRipple {
      if (style == NAVIGATION || style == BURGER) onClicked()
    }
    .background(shape = RoundedCornerShape(32.dp), color = TUITheme.colors.primaryAltHover)
    .testTag("")) {

    Row(
      modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {

      if (leadingIcon != null) Icon(
        painter = painterResource(id = leadingIcon.iconRes),
        contentDescription = leadingIcon.contentDescription,
        tint = TUITheme.colors.primary,
      )

      Text(
        modifier = Modifier.padding(horizontal = 8.dp),
        text = title,
        style = TUITheme.typography.heading6,
        color = TUITheme.colors.primary
      )
      Icon(
        painter = painterResource(id = TarkaIcons.Filled.ChevronDown24.iconRes),
        contentDescription = TarkaIcons.Filled.ChevronDown24.contentDescription,
        tint = TUITheme.colors.primary,
      )

    }

  }
}

@Preview @Composable fun TUIFloatingNavButtonPreview() {
  TUITheme {

    var currentTabItem by remember {
      mutableStateOf(0)
    }

    Column(modifier = Modifier.wrapContentSize(Alignment.Center)) {
      VerticalSpacer(space = 40)
      TUIFloatingNavButton(leadingIcon = TarkaIcons.Filled.Diversity24, title = "Overview") {

      }
      VerticalSpacer(space = 40)
    }
  }
}