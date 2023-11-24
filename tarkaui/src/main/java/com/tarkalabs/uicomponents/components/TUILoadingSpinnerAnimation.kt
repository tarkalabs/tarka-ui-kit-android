package com.tarkalabs.uicomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode.Restart
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.R
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * This Composable function used as a content when the UI is ready to show the ProgressBar layout
 * to show something is Loading in the background and intimates the user to wait
 *
 * This composable function simply contains
 * @param modifier to modify the properties of the parent component - Box
 * @param tags tags to used while testing to pick the particular component used inside this component.
 *
 * CustomProgressIndicator Composable function uses the canvas API in jetpack compose to the
 * The Custom Circular Progressbar with below steps.
 *
 * 1) one White Circle was drawn in the screen.
 * 2) one arc was drawn in the quarter size of above circle with proper angle
 * to overlap fine with circle.
 * 3) the Rotation Animation was performed.
 *
 * val circleRadius = radius - strokeWidth / 2
 *
 * here while drawing circle in canvas with stroke.
 * the stroke width is drawn partially inside of the outline of the circle & outside of the circle.
 * so in order to find the correct radius of the circle we are subtracting radius by the half of strokeWidth drawn in canvas.
 *
 *  val arcStartX = centerX - circleRadius
 *  val arcStartY = centerY - circleRadius
 *
 *  similarly the arc's offset also calculated by subtracting the center of circle by the (circleRadius)
 *  which is explained in above paragraph to position the arc in a right way above the circle
 *  otherwise the arc will be deviated from circle.
 * */
@Composable
fun TUILoadingSpinnerAnimation(
  modifier: Modifier = Modifier,
  tags: TUILoadingSpinnerAnimationTags = TUILoadingSpinnerAnimationTags(),
  progressImageDetail: ProgressImageDetail? = null,
  spinnerHeight: Dp,
) {
  Box(modifier = modifier.testTag(tags.parentTag), contentAlignment = Alignment.Center) {
    CustomProgressIndicator(
      modifier = Modifier
        .size(spinnerHeight)
        .testTag(tags.progressBarTag)
    )
    progressImageDetail?.let {
      Image(
        modifier = Modifier
          .testTag(tags.loaderImageTag)
          .width(progressImageDetail.progressImageWidth)
          .height(progressImageDetail.progressImageHeight),
        painter = painterResource(id = progressImageDetail.imageResId),
        contentDescription = progressImageDetail.contentDescription
      )
    }
  }
}

@Composable private fun CustomProgressIndicator(
  modifier: Modifier,
) {

  val angle by rememberInfiniteTransition(label = "InfiniteTransition").animateFloat(
    initialValue = 0f,
    targetValue = 360f,
    animationSpec = infiniteRepeatable(
      animation = tween(1300, easing = LinearEasing),
      repeatMode = Restart
    ),
    label = "FloatAnimation"
  )

  val outerCircleColor = TUITheme.colors.surfaceVariantHover
  val rotatingAngleColor = TUITheme.colors.primary

  Canvas(
    modifier = modifier
      .fillMaxSize()
      .rotate(angle)
  ) {
    val canvasSize = size.minDimension
    val centerX = size.width / 2
    val centerY = size.height / 2
    val radius = canvasSize / 2
    val strokeWidth = 4.dp.toPx()

    val circleRadius = radius - strokeWidth / 2
    drawCircle(
      color = outerCircleColor,
      center = Offset(centerX, centerY),
      radius = circleRadius,
      style = Stroke(width = strokeWidth)
    )

    val arcStartX = centerX - circleRadius
    val arcStartY = centerY - circleRadius
    drawArc(
      color = rotatingAngleColor,
      startAngle = -90f,
      sweepAngle = 90f,
      useCenter = false,
      topLeft = Offset(arcStartX, arcStartY),
      size = Size(circleRadius * 2, circleRadius * 2),
      style = Stroke(width = strokeWidth)
    )
  }
}

data class TUILoadingSpinnerAnimationTags(
  val parentTag: String = "TUILoadingSpinnerAnimationTag",
  val progressBarTag: String = "TUILoadingSpinnerAnimationTag_progressBarTag",
  val loaderImageTag: String = "TUILoadingSpinnerAnimationTag_EamImageTag",
)

data class ProgressImageDetail(
  @DrawableRes val imageResId: Int,
  val contentDescription: String,
  val progressImageHeight: Dp,
  val progressImageWidth: Dp
)

@Preview(showBackground = true)
@Composable
fun LoaderPreview() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black.copy(alpha = 0.4f)),
    contentAlignment = Alignment.Center
  ) {
    TUILoadingSpinnerAnimation(
      spinnerHeight = 240.dp,
      progressImageDetail = ProgressImageDetail(
        imageResId = R.drawable.keyboard_arrow_right,
        contentDescription = "",
        progressImageHeight = 116.dp,
        progressImageWidth = 116.dp
      )
    )
  }
}


