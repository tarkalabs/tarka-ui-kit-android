package com.tarkalabs.uicomponents.components

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.PlayPauseButtonSize.L
import com.tarkalabs.uicomponents.components.PlayPauseButtonSize.M
import com.tarkalabs.uicomponents.components.PlayPauseButtonState.Pause
import com.tarkalabs.uicomponents.components.PlayPauseButtonState.Play
import com.tarkalabs.uicomponents.components.PlayPauseButtonType.HOVER
import com.tarkalabs.uicomponents.components.PlayPauseButtonType.NON_HOVER
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * A composable function that displays a button with Play & Pause.
 *
 * @param modifier modifier used to modify properties of this composable function.
 * @param buttonType Specifies a Type - whether it is Hover or Non-Hover.
 * @param buttonSize Specifies a Size - whether it is Large or Medium.
 * @param state Specifies a State -whether it is Play or Pause.
 * @param tags tags used to test this component.
 * @param onClick a callback invoked when user clicks.
 *
 * How to use TUIPlayPauseButtons() composable function
 *
 * TYPE 1 (LARGE):
 *   TUIPlayPauseButtons(
modifier = Modifier.padding(top = 16.dp),
buttonType = NON_HOVER, buttonSize = L, state = Play
) {}
 *
 * TYPE 2 (MEDIUM):
 *   TUIPlayPauseButtons(
modifier = Modifier.padding(top = 16.dp),
buttonType = HOVER, buttonSize = M, state = Pause
) {}
 *
 */
@Composable fun TUIPlayPauseButtons(
  modifier: Modifier = Modifier,
  buttonType: PlayPauseButtonType = NON_HOVER,
  buttonSize: PlayPauseButtonSize = M,
  state: PlayPauseButtonState = Play,
  tags: TUIPlayPauseButtonsTestTags = TUIPlayPauseButtonsTestTags(),
  onClick: () -> Unit,
) {

  val color = when (buttonType) {
    HOVER -> TUITheme.colors.constantDark.copy(alpha = 0.6f)
    NON_HOVER -> TUITheme.colors.constantDark.copy(alpha = 0.75f)
  }

  val iconModifier = when (buttonSize) {
    L -> Modifier
      .size(56.dp)
      .padding(16.dp)

    M -> Modifier
      .size(24.dp)
      .padding(4.dp)
  }

  when (buttonSize) {
    L -> modifier.size(L.size)
    M -> modifier.size(M.size)
  }


  Box(
    modifier = modifier
      .testTag(tags.parentId)
      .background(color = color, shape = RoundedCornerShape(size = 44.dp))
      .clickable { onClick.invoke() }, contentAlignment = Alignment.Center
  ) {

    val icon = when (state) {
      Play -> TarkaIcons.PlayIcon12Filled
      Pause -> TarkaIcons.PauseIcon12Filled
    }

    Icon(
      modifier = iconModifier,
      painter = painterResource(id = icon.iconRes),
      contentDescription = icon.contentDescription,
      tint = TUITheme.colors.constantLight
    )

  }
}

enum class PlayPauseButtonType {
  HOVER,
  NON_HOVER
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
  val parentId: String = "playPauseButtonTag",
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

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = HOVER, buttonSize = L, state = Play
      ) {}


      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = HOVER, buttonSize = M, state = Play
      ) {}

    }

    Column(
      modifier = Modifier.padding(start = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = NON_HOVER, buttonSize = L, state = Play
      ) {}

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = NON_HOVER, buttonSize = M, state = Play
      ) {}

    }

    Column(
      modifier = Modifier.padding(start = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = HOVER, buttonSize = L, state = Pause
      ) {}


      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = HOVER, buttonSize = M, state = Pause
      ) {}

    }

    Column(
      modifier = Modifier.padding(start = 16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.Start
    ) {

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = NON_HOVER, buttonSize = L, state = Pause
      ) {}

      TUIPlayPauseButtons(
        modifier = Modifier.padding(top = 16.dp),
        buttonType = NON_HOVER, buttonSize = M, state = Pause
      ) {}

    }

  }
}