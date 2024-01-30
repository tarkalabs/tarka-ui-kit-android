package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Circle12
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.tarkaicons.Warning12
import com.tarkalabs.uicomponents.components.TagSize.L
import com.tarkalabs.uicomponents.components.TagSize.M
import com.tarkalabs.uicomponents.components.TagSize.S
import com.tarkalabs.uicomponents.components.TagType.CUSTOM
import com.tarkalabs.uicomponents.components.TagType.HIGH
import com.tarkalabs.uicomponents.components.TagType.LOW
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * A composable function that displays a text with leading or trailing icon at a time.
 *
 * @param modifier modifier used to modify properties of this composable function.
 * @param title what to be shown as text.
 * @param leadingIcon The icon to display before the title.
 * @param trailingIcon The icon to display after the title.
 * @param tags tags used to test this component.
 * @param tagSize specifies the size of the component
 * S- SMALL, M- MEDIUM, L- LARGE.
 * @param tagType specifies the style of the component
 * LOW, HIGH (without any custom colors)
 * CUSTOM (without custom colors for bgColor, titleText, IconTint)
 *
 * How to use TUITag() composable function
 *
 * TYPE 1 (SMALL):
 *  TUITag(
title = "Label",
tagType = HIGH,
tagSize = S,
trailingIcon = TarkaIcons.Circle16Regular,
)
 *
 * TYPE 2 (MEDIUM):
 *  TUITag(
title = "Label",
tagType = HIGH,
tagSize = M,
leadingIcon = TarkaIcons.Circle16Regular,
)
 *
 * TYPE 3 (LARGE):
 * TUITag(
title = "Warning",
tagType = CUSTOM(
bgContentColor = TUITheme.colors.warning,
titleColor = TUITheme.colors.onWarning,
iconTint = TUITheme.colors.onWarning
),
tagSize = L,
trailingIcon = TarkaIcons.Regular.Warning12,
)
 *
 *
 */
@Composable
fun TUITag(
  modifier: Modifier = Modifier,
  tagSize: TagSize = M,
  tagType: TagType = TagType.defaultStyle,
  leadingIcon: TarkaIcon? = null,
  title: String?,
  trailingIcon: TarkaIcon? = null,
  tags: TUITagTestTags = TUITagTestTags(),
  onClick: () -> Unit,
) {

  val iconModifier = when (tagSize) {
    S -> Modifier.size(16.dp)
    M, L -> Modifier.size(20.dp)
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
    L -> 8
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
       .clip(RoundedCornerShape(size = 4.dp))
       .testTag(tags.parentTag)
       .clickable { onClick.invoke() },
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

        title?.let {
          HorizontalSpacer(horizontalSpace)
          Text(
            modifier = Modifier.wrapContentSize(),
            text = it,
            color = titleColor,
            style = titleStyle,
            maxLines = 1,
          )
          HorizontalSpacer(horizontalSpace)
        }

        trailingIcon?.let {
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

data class TUITagTestTags(
  val parentTag: String = "Tag"
)

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
          tagSize = S,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L,
          trailingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          tagSize = S,
          trailingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          tagSize = M,
          trailingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          tagSize = L,
          trailingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
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
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M,
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L,
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S,
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M,
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L,
          leadingIcon = TarkaIcons.Regular.Circle12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = S,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          leadingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = M,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          leadingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagSize = L,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = TUITheme.colors.onWarning
          ),
          leadingIcon = TarkaIcons.Regular.Warning12,
          onClick = {},
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
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = M,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = HIGH,
          tagSize = L,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = S,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = M,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Label",
          tagType = LOW,
          tagSize = L,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = null
          ),
          tagSize = S,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = null
          ),
          tagSize = M,
          onClick = {},
        )

        VerticalSpacer(15)

        TUITag(
          title = "Warning",
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint = null
          ),
          tagSize = L,
          onClick = {},
        )
        VerticalSpacer(15)

        TUITag(
          title = null,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint =  TUITheme.colors.onWarning,
          ),
          tagSize = L,
          onClick = {},
          trailingIcon =  TarkaIcons.Regular.Warning12
        )
        VerticalSpacer(space = 10)
        TUITag(
          title = null,
          tagType = CUSTOM(
            bgContentColor = TUITheme.colors.warning,
            titleColor = TUITheme.colors.onWarning,
            iconTint =  TUITheme.colors.onWarning,
          ),
          tagSize = L,
          onClick = {},
          leadingIcon =  TarkaIcons.Regular.Warning12
        )

      }

      HorizontalSpacer(space = 20)

    }

  }
}