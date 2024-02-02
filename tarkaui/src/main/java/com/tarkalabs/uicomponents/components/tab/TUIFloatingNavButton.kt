package com.tarkalabs.uicomponents.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.CalendarRtl24
import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.Directions24
import com.tarkalabs.tarkaicons.Diversity24
import com.tarkalabs.tarkaicons.Map24
import com.tarkalabs.tarkaicons.Navigation24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Burger
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.List
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonContentType.Navigation
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.BURGER
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.LIST
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.NAVIGATION
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavButtonStyle.VIEW_TOGGLE
import com.tarkalabs.uicomponents.extentions.clickableWithoutRipple
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUIFloatingNavButtonStyle {
  NAVIGATION,
  VIEW_TOGGLE,
  LIST,
  BURGER;

  companion object {
    val defaultStyle: TUIFloatingNavButtonStyle = NAVIGATION
  }
}

sealed class TUIFloatingNavButtonContentType {
  data class List(
    val iconOne: TarkaIcon? = null,
    val onIconOneClick: (() -> Unit)? = null,
    val iconTwo: TarkaIcon? = null,
    val onIconTwoClick: (() -> Unit)? = null,
    val iconThree: TarkaIcon? = null,
    val onIconThreeClick: (() -> Unit)? = null
  ) : TUIFloatingNavButtonContentType()

  data class Navigation(
    val leadingIcon: TarkaIcon? = null,
    val text: String,
  ) : TUIFloatingNavButtonContentType()

  object Burger : TUIFloatingNavButtonContentType()
}

@Composable fun TUIFloatingNavButton(
  modifier: Modifier = Modifier,
  style: TUIFloatingNavButtonStyle = TUIFloatingNavButtonStyle.defaultStyle,
  contentType: TUIFloatingNavButtonContentType,
  onClicked: (() -> Unit)? = null,
  tags: TUIFloatingNavButtonTags = TUIFloatingNavButtonTags()
) {
  Row(modifier = modifier
    .wrapContentSize()
    .clickableWithoutRipple {
      if (style != LIST && onClicked != null) {
        onClicked()
      }
    }
    .background(
      shape = RoundedCornerShape(32.dp), color = TUITheme.colors.primaryAltHover.copy(0.3f)
    )
    .border(
      width = 1.dp, color = TUITheme.colors.primaryAltHover, shape = RoundedCornerShape(32.dp)
    )
    .testTag(tags.parentTag)) {

    when (contentType) {
      is Burger -> TUIFloatingNavBurgerButton()

      is Navigation -> TUIFloatingNavTypeButton(contentType, style)

      is List -> TUIFloatingNavListButton(contentType)
    }
  }
}

@Composable
private fun TUIFloatingNavTypeButton(
  contentType: Navigation,
  style: TUIFloatingNavButtonStyle,
  tags: TUIFloatingNavButtonTags = TUIFloatingNavButtonTags(),
) {
  Row(
    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {

    if (contentType.leadingIcon != null) Icon(
      modifier = Modifier.testTag(tags.leadingIconTag),
      painter = painterResource(id = contentType.leadingIcon.iconRes),
      contentDescription = contentType.leadingIcon.contentDescription,
      tint = TUITheme.colors.primary,
    )

    Text(
      modifier = Modifier.padding(horizontal = 8.dp),
      text = contentType.text,
      style = TUITheme.typography.heading6,
      color = TUITheme.colors.primary
    )

    if (style == NAVIGATION) {
      Icon(
        modifier = Modifier.testTag(tags.trailingIconTag),
        painter = painterResource(id = TarkaIcons.Filled.ChevronDown24.iconRes),
        contentDescription = TarkaIcons.Filled.ChevronDown24.contentDescription,
        tint = TUITheme.colors.primary,
      )
    }
  }
}

@Composable fun TUIFloatingNavListButton(
  contentType: List,
  tags: TUIFloatingNavButtonTags = TUIFloatingNavButtonTags(),
) {
  Row(
    modifier = Modifier
      .padding(horizontal = 4.dp, vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    if (contentType.iconOne != null) {
      Icon(
        modifier = Modifier
          .padding(12.dp)
          .clickableWithoutRipple {
            if (contentType.onIconOneClick != null) {
              contentType.onIconOneClick.invoke()
            }
          }
          .testTag(tags.iconOneTag),
        painter = painterResource(id = contentType.iconOne.iconRes),
        contentDescription = contentType.iconOne.contentDescription,
        tint = TUITheme.colors.primary
      )
    }
    if (contentType.iconTwo != null) {
      Icon(
        modifier = Modifier
          .padding(12.dp)
          .clickableWithoutRipple {
            if (contentType.onIconTwoClick != null) {
              contentType.onIconTwoClick.invoke()
            }
          }
          .testTag(tags.iconTwoTag),
        painter = painterResource(id = contentType.iconTwo.iconRes),
        contentDescription = contentType.iconTwo.contentDescription,
        tint = TUITheme.colors.primary,
      )
    }
    if (contentType.iconThree != null) {
      Icon(
        modifier = Modifier
          .padding(12.dp)
          .clickableWithoutRipple {
            if (contentType.onIconThreeClick != null) {
              contentType.onIconThreeClick.invoke()
            }
          }
          .testTag(tags.iconThreeTag),
        painter = painterResource(id = contentType.iconThree.iconRes),
        contentDescription = contentType.iconThree.contentDescription,
        tint = TUITheme.colors.primary
      )
    }
  }
}

@Composable
fun TUIFloatingNavBurgerButton(tags: TUIFloatingNavButtonTags = TUIFloatingNavButtonTags()) {
  Box(
    modifier = Modifier
      .padding(horizontal = 8.dp, vertical = 8.dp),
  ) {
    Icon(
      modifier = Modifier
        .padding(8.dp)
        .testTag(tags.burgerIconTag),
      painter = painterResource(id = TarkaIcons.Filled.Navigation24.iconRes),
      contentDescription = TarkaIcons.Filled.Navigation24.contentDescription,
      tint = TUITheme.colors.primary
    )
  }
}


data class TUIFloatingNavButtonTags(
  val parentTag: String = "TUIFloatingNavButton",
  val leadingIconTag: String = "TUIFloatingNavButton_LeadingIcon",
  val trailingIconTag: String = "TUIFloatingNavButton_TrailingIcon",
  val iconOneTag: String = "TUIFloatingNavButton_Icon_One",
  val iconTwoTag: String = "TUIFloatingNavButton_Icon_Two",
  val iconThreeTag: String = "TUIFloatingNavButton_Icon_Three",
  val burgerIconTag: String = "TUIFloatingNavButton_Burger_Icon"
)

@Preview @Composable fun TUIFloatingNavButtonPreview() {
  TUITheme {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(TUITheme.colors.surface),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      VerticalSpacer(space = 40)
      TUIFloatingNavButton(
        contentType = Navigation(leadingIcon = TarkaIcons.Filled.Diversity24, "Overview"),
      )
      VerticalSpacer(space = 40)
      TUIFloatingNavButton(
        contentType = List(
          iconOne = TarkaIcons.Regular.CalendarRtl24, iconTwo = TarkaIcons.Regular.Map24,
          iconThree = TarkaIcons.Regular.Directions24
        ), style = LIST
      )
      VerticalSpacer(space = 40)
      TUIFloatingNavButton(
        contentType = Navigation(leadingIcon = TarkaIcons.Filled.Diversity24, "Overview"),
        style = VIEW_TOGGLE
      )
      VerticalSpacer(space = 40)
      TUIFloatingNavButton(contentType = Burger, style = BURGER)
    }

  }
}