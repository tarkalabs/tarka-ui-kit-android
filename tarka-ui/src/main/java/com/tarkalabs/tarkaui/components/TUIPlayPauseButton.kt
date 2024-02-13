package com.tarkalabs.tarkaui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.icons.Pause12
import com.tarkalabs.tarkaui.icons.Pause24
import com.tarkalabs.tarkaui.icons.Play12
import com.tarkalabs.tarkaui.icons.Play24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.components.PlayPauseButtonSize.L
import com.tarkalabs.tarkaui.components.PlayPauseButtonSize.M
import com.tarkalabs.tarkaui.components.PlayPauseButtonState.Pause
import com.tarkalabs.tarkaui.components.PlayPauseButtonState.Play
import com.tarkalabs.tarkaui.extentions.maxHeight
import com.tarkalabs.tarkaui.extentions.maxWidth
import com.tarkalabs.tarkaui.theme.TUITheme

/**
 * A composable function that displays a button with Play & Pause.
 *
 * @param modifier modifier used to modify properties of this composable function.
 * @param buttonSize Specifies a Size - whether it is Large or Medium.
 * @param state Specifies a State -whether it is Play or Pause.
 * @param tags tags used to test this component.
 * @param onClick a callback invoked when user clicks.
 *
 * How to use TUIPlayPauseButtons() composable function
 *
 * TYPE 1 (LARGE):
     TUIPlayPauseButtons(
      modifier = Modifier.padding(top = 16.dp),
      buttonType = NON_HOVER, buttonSize = L, state = Play
    )
 *
 * TYPE 2 (MEDIUM):
     TUIPlayPauseButtons(
      modifier = Modifier.padding(top = 16.dp),
      buttonType = HOVER, buttonSize = M, state = Pause
    )
 *
 */
@Composable fun TUIPlayPauseButton(
  modifier: Modifier = Modifier,
  buttonSize: PlayPauseButtonSize = M,
  state: PlayPauseButtonState = Play,
  tags: TUIPlayPauseButtonsTestTags = TUIPlayPauseButtonsTestTags(),
  onClick: () -> Unit,
) {

  val iconModifier = when (buttonSize) {
    L -> Modifier
      .maxWidth(24)
      .maxHeight(24)
    M -> Modifier
      .maxWidth(16)
      .maxHeight(16)
  }

  when (buttonSize) {
    L -> modifier.size(L.size)
    M -> modifier.size(M.size)
  }

  val contentModifier = when (buttonSize) {
    L -> Modifier.padding(16.dp)
    M -> Modifier.padding(4.dp)
  }

  val icon = when (state) {
    Play -> if (buttonSize == M) TarkaIcons.Filled.Play12 else TarkaIcons.Filled.Play24
    Pause -> if (buttonSize == M) TarkaIcons.Filled.Pause12 else TarkaIcons.Filled.Pause24
  }

  Box(
    modifier = modifier
      .testTag(tags.parentId)
      .clip(RoundedCornerShape(size = 44.dp))
      .background(color = TUITheme.colors.constantDark.copy(alpha = 0.75f))
      .clickable { onClick.invoke() }, contentAlignment = Alignment.Center
  ) {
    Box(
      modifier = contentModifier,
    ) {
      Icon(
        modifier = iconModifier,
        painter = painterResource(id = icon.iconRes),
        contentDescription = icon.contentDescription,
        tint = TUITheme.colors.constantLight
      )
    }
  }
}

enum class PlayPauseButtonSize(val size: Dp) {
  L(56.dp),
  M(24.dp)
}

enum class PlayPauseButtonState {
  Play,
  Pause
}

data class TUIPlayPauseButtonsTestTags(
  val parentId: String = "TUIPlayPauseButtons",
)

@Preview @Composable fun TUIPlayPauseButtonPreview() {
  Row(
    modifier = Modifier
      .padding(15.dp)
      .fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center
  ) {
    Column(
      modifier = Modifier.padding(start = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {
      TUIPlayPauseButton(
        modifier = Modifier.padding(top = 16.dp), buttonSize = L, state = Play
      ) {}
      TUIPlayPauseButton(
        modifier = Modifier.padding(top = 16.dp), buttonSize = M, state = Play
      ) {}
    }

    Column(
      modifier = Modifier.padding(start = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {
      TUIPlayPauseButton(
        modifier = Modifier.padding(top = 16.dp), buttonSize = L, state = Pause
      ) {}
      TUIPlayPauseButton(
        modifier = Modifier.padding(top = 16.dp), buttonSize = M, state = Pause
      ) {}
    }
  }
}