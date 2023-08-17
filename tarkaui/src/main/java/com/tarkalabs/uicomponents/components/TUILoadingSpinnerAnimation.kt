package com.tarkalabs.uicomponents.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.R
import com.tarkalabs.uicomponents.theme.TUITheme

@Composable
fun TUILoadingSpinnerAnimation(
  modifier: Modifier = Modifier,
) {
  Box(modifier = modifier, contentAlignment = Alignment.Center) {
    CustomProgressIndicator(modifier = Modifier.size(76.dp))
    Image(
      modifier = Modifier
        .width(60.dp)
        .height(11.dp),
      painter = painterResource(id = R.drawable.loader_spin_image),
      contentDescription = "EAM360Loader"
    )
  }
}

@Composable fun CustomProgressIndicator(
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
    val strokeWidth = 4f

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

@Preview
@Composable
fun LoaderPreview() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black.copy(alpha = 0.4f)),
    contentAlignment = Alignment.Center
  ) {
    TUILoadingSpinnerAnimation()
  }
}


