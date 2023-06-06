package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tarkalabs.uicomponents.Tags
import com.tarkalabs.uicomponents.components.AvatarSize.L
import com.tarkalabs.uicomponents.components.AvatarSize.M
import com.tarkalabs.uicomponents.components.AvatarSize.S
import com.tarkalabs.uicomponents.components.AvatarSize.XL
import com.tarkalabs.uicomponents.components.AvatarSize.XS
import com.tarkalabs.uicomponents.components.AvatarSize.XXL
import com.tarkalabs.uicomponents.components.AvatarType.Icon
import com.tarkalabs.uicomponents.components.AvatarType.Image
import com.tarkalabs.uicomponents.components.AvatarType.Text
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

enum class AvatarSize(val size: Dp) {
  XS(24.dp),
  S(32.dp),
  M(48.dp),
  L(64.dp),
  XL(80.dp),
  XXL(96.dp)
}

sealed class AvatarType{
  data class Icon(val icon : TarkaIcon) : AvatarType()
  data class Text(val text : String) : AvatarType()
  data class Image(val image : ImageBitmap) : AvatarType()
}

/**
* A composable function that displays an avatar image.
 * @param modifier The modifier to be applied to the avatar.
 * @param avatarType The type of avatar to be displayed. It can be an Icon, Image, or Text.
 * @param avatarSize The size of the avatar. It can be AvatarSize.S, AvatarSize.M, or AvatarSize.L. The default value is AvatarSize.L.
 * @param showBadge Determines whether to show a badge on the avatar. The default value is false.
 * @param avatarTag The test tag for the Avatar.
 * @param badgeTag  The test tag for the Avatar Badge.
 */
@Composable
fun TUIAvatar(
  modifier: Modifier = Modifier,
  avatarType: AvatarType,
  avatarSize: AvatarSize = L,
  showBadge: Boolean = false,
  avatarTag : String = Tags.TAG_AVATAR,
  badgeTag : String = Tags.TAG_AVATAR_BADGE,
) {
  Box(
    modifier = modifier.size(avatarSize.size),
    contentAlignment = Alignment.Center
  ) {
    Box(
      modifier = modifier
        .size(avatarSize.size)
        .clip(CircleShape)
        .background(TUITheme.colors.tertiary)
        .testTag(avatarTag),
      contentAlignment = Alignment.Center
    ) {
      when(avatarType){
        is Icon -> {
          val iconSize = iconSizeFor(avatarSize)
          Icon(
            modifier = Modifier.size(iconSize),
            painter = painterResource(id = avatarType.icon.iconRes),
            contentDescription = avatarType.icon.contentDescription,
            tint = TUITheme.colors.onTertiary
          )
        }
        is Image -> {
          Image(bitmap = avatarType.image, contentDescription = "Avatar Image")
        }
        is Text -> {
          val typography = typographyFor(avatarSize)
          Text(text = avatarType.text.take(3), color = TUITheme.colors.onTertiary, style = typography)
        }
      }
    }
    if (showBadge) {
      val badgeSize = badgeSizeFor(avatarSize)
      TUIBadge(
        modifier = Modifier.align(Alignment.BottomEnd).testTag(badgeTag),
        badgeSize = badgeSize,
        color = TUITheme.colors.success
      )
    }
  }
}

@Composable
private fun badgeSizeFor(avatarSize: AvatarSize) =
  when (avatarSize) {
    XS, M, S -> BadgeSize.S
    L -> BadgeSize.M
    XXL, XL -> BadgeSize.L
  }

@Composable
private fun iconSizeFor(size: AvatarSize) = when (size) {
  XS, S -> 16.dp
  L, M -> 24.dp
  XXL, XL -> 32.dp
}

@Composable
private fun typographyFor(size: AvatarSize) = when (size) {
  XS -> TUITheme.typography.heading7.copy(fontSize = 12.sp)
  S -> TUITheme.typography.heading7
  M -> TUITheme.typography.heading6
  L -> TUITheme.typography.heading5
  XL -> TUITheme.typography.heading4
  XXL -> TUITheme.typography.heading3
}

@Composable
@Preview(showBackground = true)
fun AvatarIconPreview(){
  TUIAvatar(
    avatarType = Icon(TarkaIcons.Search),
    avatarSize = L
  )
}

@Composable
@Preview(showBackground = true)
fun AvatarTextPreview(){
  TUIAvatar(
    avatarType = Text(text = "TUK"),
    avatarSize = L,
  )
}