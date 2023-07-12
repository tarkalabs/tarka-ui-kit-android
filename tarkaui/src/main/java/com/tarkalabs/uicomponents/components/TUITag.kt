package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.TagSize.L
import com.tarkalabs.uicomponents.components.TagSize.M
import com.tarkalabs.uicomponents.components.TagSize.S
import com.tarkalabs.uicomponents.components.TagType.CUSTOM
import com.tarkalabs.uicomponents.components.TagType.HIGH
import com.tarkalabs.uicomponents.components.TagType.LOW
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TagSize(val size: Dp) {
  S(24.dp),
  M(32.dp),
  L(40.dp),
}

sealed class TagType {
  object HIGH : TagType()
  object LOW : TagType()
  data class CUSTOM(
    val bgContentColor: Color,
    val titleColor: Color,
    val iconTint: Color?,
  ) : TagType()

  companion object {
    val defaultStyle: TagType = HIGH
  }
}

@Composable
fun TUITag(
  modifier: Modifier = Modifier,
  tagSize: TagSize = M,
  tagType: TagType = TagType.defaultStyle,
  leadingIcon: TarkaIcon? = null,
  title: String,
  trailingIcon: TarkaIcon? = null,
) {

  val iconModifier = when (tagSize) {
    S -> Modifier.size(12.dp)
    M, L -> Modifier.size(16.dp)
  }

  val titleStyle = when (tagSize) {
    S -> TUITheme.typography.button8
    M -> TUITheme.typography.button7
    L -> TUITheme.typography.button6
  }

  val contentPadding = when (tagSize) {
    S -> 6.dp
    M -> 8.dp
    L -> 10.dp
  }

  val horizontalSpace = when (tagSize) {
    S -> 4
    M -> 6
    L -> 10
  }

  val backgroundColor = when (tagType) {
    LOW -> TUITheme.colors.secondaryAlt
    HIGH -> TUITheme.colors.secondary
    is CUSTOM -> tagType.bgContentColor
  }

  val titleColor = when (tagType) {
    LOW -> TUITheme.colors.onSecondaryAlt
    HIGH -> TUITheme.colors.onSecondary
    is CUSTOM -> tagType.titleColor
  }

  val iconTint = when (tagType) {
    LOW -> TUITheme.colors.onSecondaryAlt
    HIGH -> TUITheme.colors.onSecondary
    is CUSTOM -> tagType.iconTint
  }

  Surface(
    modifier = modifier
      .clip(RoundedCornerShape(size = 4.dp)),
    color = backgroundColor
  ) {
    Box(modifier = Modifier.padding(contentPadding)) {
      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {

        leadingIcon?.let {
          Icon(
            modifier = iconModifier,
            painter = painterResource(id = leadingIcon.iconRes),
            contentDescription = leadingIcon.contentDescription,
            tint = iconTint ?: Color.Transparent
          )
        }

        HorizontalSpacer(horizontalSpace)

        Text(
          modifier = Modifier.wrapContentSize(),
          text = title,
          color = titleColor,
          style = titleStyle,
        )

        trailingIcon?.let {

          HorizontalSpacer(horizontalSpace)

          Icon(
            modifier = iconModifier,
            painter = painterResource(id = trailingIcon.iconRes),
            contentDescription = trailingIcon.contentDescription,
            tint = iconTint ?: Color.Transparent
          )
        }

      }
    }
  }
}

@Composable
@Preview(showBackground = true)
fun TUITagPreview() {

  TUITheme {

    Row(
      horizontalArrangement = Arrangement.Center,
      verticalAlignment = Alignment.Top,
      modifier = Modifier.padding(top = 10.dp)
    ) {

      HorizontalSpacer(space = 10)

      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = S
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = null
          ),
          tagSize = S
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = null
          ),
          tagSize = M
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = null
          ),
          tagSize = L
        )

      }

      HorizontalSpacer(space = 35)

      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = S,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L,
          leadingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = S,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          leadingIcon = TarkaIcons.Warning12Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = M,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          leadingIcon = TarkaIcons.Warning12Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = L,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          leadingIcon = TarkaIcons.Warning12Regular,
        )

      }

      HorizontalSpacer(space = 35)

      Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
      ) {

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = S,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L,
          trailingIcon = TarkaIcons.Circle16Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          tagSize = S,
          trailingIcon = TarkaIcons.Warning12Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          tagSize = M,
          trailingIcon = TarkaIcons.Warning12Regular,
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.inputText,
            iconTint = TUITheme.colors.constantDark
          ),
          tagSize = L,
          trailingIcon = TarkaIcons.Warning12Regular,
        )

      }

      HorizontalSpacer(space = 20)

    }

  }
}