package com.tarkalabs.uicomponents.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.Checkmark12
import com.tarkalabs.tarkaicons.Delete24
import com.tarkalabs.tarkaicons.ReOrder24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoadSuccessful
import com.tarkalabs.uicomponents.components.TUIAttachmentUpload.AttachmentState.UpLoading
import com.tarkalabs.uicomponents.components.TUIThumbnailType.Document
import com.tarkalabs.uicomponents.components.base.IconButtonSize
import com.tarkalabs.uicomponents.components.base.IconButtonStyle.GHOST
import com.tarkalabs.uicomponents.components.base.TUIIconButton
import com.tarkalabs.uicomponents.components.base.TUIIconButtonTags
import com.tarkalabs.uicomponents.theme.TUITheme

object TUIAttachmentUpload {

  /**
   * A composable to display an attachment with different states, such as uploading progress and successful upload.
   *
   * @param modifier The modifier to customize the attachment container.
   * @param type The type of the thumbnail to display (e.g., image, video, etc.).
   * @param attachmentName The name of the attachment to display.
   * @param onAttachmentClick A callback function to handle attachment click events.
   * @param onTrailingIconClick A callback function to handle trailing icon click events.
   * @param state The state of the attachment (Uploading, Uploaded, etc.).
   * @param showLeadingIcon Whether to show a leading icon (e.g., reorder icon) before the thumbnail.
   * @param tags Tags for customizing test accessibility.
   * @param trailingIcon The drawable resource for the trailing icon
   *
   * How to use TUIAttachmentUpload()
   *
   *   TUIAttachmentUpload(
          type = Document,
          attachmentName = "document.jpg",
          onMenuClick = {},
          onAttachmentClick = {  },
          state = UpLoading(50),
          showLeadingIcon = true,
       )
   *
   */
  @Composable operator fun invoke(
    modifier: Modifier = Modifier,
    type: TUIThumbnailType,
    attachmentName: String,
    onAttachmentClick: () -> Unit,
    onTrailingIconClick: () -> Unit,
    trailingIcon: TarkaIcon,
    state: AttachmentState? = null,
    showLeadingIcon: Boolean,
    tags: TUIAttachmentUploadTags = TUIAttachmentUploadTags()
  ) {

    Row(
      modifier = modifier
        .testTag(tags.parentTag)
        .defaultMinSize(minHeight = 48.dp)
        .clickable {
          onAttachmentClick.invoke()
        },
      verticalAlignment = Alignment.CenterVertically
    ) {

      if (showLeadingIcon) {
        Box(
          contentAlignment = Alignment.Center,
          modifier = Modifier
            .size(40.dp)
            .testTag(tags.leadingIconTag)
        ) {
          Icon(
            modifier = Modifier
              .heightIn(max = 24.dp)
              .widthIn(max = 24.dp),
            painter = painterResource(id = TarkaIcons.Regular.ReOrder24.iconRes),
            contentDescription = TarkaIcons.Regular.ReOrder24.contentDescription,
            tint = TUITheme.colors.onSurface
          )

        }
      }

      TUIThumbnail(type = type, showTrailingIcon = false, tags = tags.thumbTag)

      val attachmentModifier = Modifier
        .weight(1f)
        .padding(horizontal = 8.dp)

      when (state) {
        UpLoadSuccessful -> {
          Row(modifier = attachmentModifier, verticalAlignment = Alignment.CenterVertically) {
            Icon(
              painter = painterResource(id = TarkaIcons.Regular.Checkmark12.iconRes),
              contentDescription = TarkaIcons.Regular.Checkmark12.contentDescription,
              tint = TUITheme.colors.success,
              modifier = Modifier.testTag(tags.successIconTag)
            )
            HorizontalSpacer(space = 8)
            AttachmentTitle(attachmentName = attachmentName, attachmentModifier)
          }
        }

        is UpLoading -> {
          val animatedProgress by animateFloatAsState(
            targetValue = state.progress / 100f, animationSpec = tween(durationMillis = 5000)
          )
          Column(modifier = attachmentModifier) {
            AttachmentTitle(attachmentName = attachmentName)
            VerticalSpacer(space = 8)
            LinearProgressIndicator(
              progress = animatedProgress,
              modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp))
                .testTag(tags.progressBarTag),
              trackColor = TUITheme.colors.surfaceVariant,
              color = TUITheme.colors.primaryAltHover
            )
          }
        }

        else -> {
          AttachmentTitle(attachmentName = attachmentName, attachmentModifier)
        }
      }

      TUIIconButton(
        icon = trailingIcon,
        iconButtonStyle = GHOST,
        buttonSize = IconButtonSize.XL,
        tags = tags.menuItemTag,
        onIconClick = onTrailingIconClick
      )

    }
  }

  /**
   * Represents the state of the attachment.
   */
  sealed class AttachmentState {
    /**
     * Represents the uploading state with the progress percentage.
     *
     * @param progress The progress percentage.
     */
    data class UpLoading(
      val progress: Int
    ) : AttachmentState()

    /**
     * Represents the successful upload state.
     */
    object UpLoadSuccessful : AttachmentState()
  }

  /**
   * Tags for customizing test accessibility.
   *
   * @param parentTag The tag for the parent container of the attachment.
   * @param menuItemTag Tags for customizing test accessibility for the menu (three-dot) icon.
   * @param leadingIconTag The tag for customizing test accessibility for the leading icon (if [showLeadingIcon] is `true`).
   * @param successIconTag The tag for customizing test accessibility for the success icon.
   * @param thumbTag Tags for customizing test accessibility for the thumbnail.
   */
  data class TUIAttachmentUploadTags(
    val parentTag: String = "TUIAttachmentUpload",
    val menuItemTag: TUIIconButtonTags = TUIIconButtonTags(parentTag = "TUIAttachmentUpload_menuItem"),
    val leadingIconTag: String = "TUIAttachmentUpload_leadingIcon",
    val successIconTag: String = "TUIAttachmentUpload_SuccessIcon",
    val progressBarTag: String = "TUIAttachmentUpload_ProgressBar",
    val thumbTag: TUIThumbnailTags = TUIThumbnailTags(),
  )

  /**
   * Internal composable function to display the attachment title.
   *
   * @param attachmentName The name of the attachment.
   * @param modifier The modifier to customize the title appearance.
   */
  @Composable internal fun AttachmentTitle(attachmentName: String, modifier: Modifier = Modifier) {
    Text(
      text = attachmentName,
      style = TUITheme.typography.body6,
      color = TUITheme.colors.onSurface,
      modifier = modifier,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )
  }
}

@Preview @Composable fun PreviewTUIAttachmentUpload() {
  TUITheme {
    Box(
      modifier = Modifier
        .background(color = TUITheme.colors.surface)
        .height(500.dp),
      contentAlignment = Alignment.Center
    ) {
      TUIAttachmentUpload(
        type = Document,
        attachmentName = "document.jpg",
        onTrailingIconClick = {

        },
        onAttachmentClick = { },
        state = UpLoading(50),
        showLeadingIcon = true,
        trailingIcon = TarkaIcons.Regular.Delete24
      )

    }
  }
}