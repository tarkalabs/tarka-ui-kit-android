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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.base.TUIBadge
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.models.TarkaIcons
import com.tarkalabs.uicomponents.theme.TUITheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TUISelectionCard(
  modifier: Modifier = Modifier,
  leadingIcon: TarkaIcon? = null,
  label: String,
  description: String,
  description2: String? = null,
  details: String? = null,
  details2: String? = null,
  badgeCount: Int? = null,
  isTrailingBackArrowEnabled: Boolean = false,
  isSelected: Boolean = false,
  tags: TUISelectionCardTags = TUISelectionCardTags(),
  onCardClicked: () -> Unit,
) {

  val isCardTapped = remember {
    mutableStateOf(isSelected)
  }

  Row(
    modifier = modifier.testTag(tags.parentTag)
      //used to consider testTags as resourceId to improve testability and accessibility
      .semantics {  testTagsAsResourceId = true }
      .clickable {
        onCardClicked.invoke()
        isCardTapped.value = !isCardTapped.value
      }
      .background(
        if (isCardTapped.value) TUITheme.colors.primaryAlt else TUITheme.colors.surface,
        shape = RoundedCornerShape(16.dp)
      )
      .padding(horizontal = 16.dp, vertical = 12.dp),
  ) {

    leadingIcon?.let {
      Box(modifier = modifier, contentAlignment = Alignment.TopStart) {
        Icon(
          modifier = Modifier.size(24.dp).testTag(tags.leadingIconTag),
          painter = painterResource(id = it.iconRes),
          contentDescription = it.contentDescription,
          tint = TUITheme.colors.secondary
        )
      }
    }

    Row(
      horizontalArrangement = Arrangement.Start,
      verticalAlignment = Alignment.CenterVertically
    ) {

      Column(
        modifier = Modifier
          .padding(start = 16.dp)
          .weight(1f)
      ) {

        Text(
          modifier = Modifier.testTag(tags.labelTag),
          text = label,
          color = TUITheme.colors.inputTextDim.copy(alpha = 0.7f),
          style = TUITheme.typography.body7
        )

        Text(
          modifier = Modifier.testTag(tags.descriptionTag),
          text = description,
          color = TUITheme.colors.inputText,
          style = TUITheme.typography.heading6
        )

        description2?.let {
          Text(
            modifier = Modifier.testTag(tags.description2Tag),
            text = it,
            color = TUITheme.colors.inputText,
            style = TUITheme.typography.heading6
          )
        }

        details?.let {
          Text(
            modifier = Modifier.testTag(tags.detailsTag),
            text = it,
            color = TUITheme.colors.inputText,
            style = TUITheme.typography.heading6
          )
        }

        details2?.let {
          Text(
            modifier = Modifier.testTag(tags.details2Tag),
            text = it,
            color = TUITheme.colors.inputText,
            style = TUITheme.typography.heading6
          )
        }

      }

      badgeCount?.let {
        TUIBadge(
          modifier = Modifier.padding(start = 16.dp).testTag(tags.badgeTag),
          count = badgeCount,
          color = TUITheme.colors.tertiary
        )
      }

      if (isTrailingBackArrowEnabled) {
        Icon(
          modifier = Modifier.size(24.dp).testTag(tags.trailingFrontArrowIconTag),
          painter = painterResource(id = TarkaIcons.ChevronRight24Regular.iconRes),
          contentDescription = TarkaIcons.ChevronRight24Regular.contentDescription
        )
      }
    }

  }
}

data class TUISelectionCardTags(
  val parentTag: String ="ParentTag",
  val leadingIconTag: String ="LeadingIconTag",
  val labelTag: String ="LabelTag",
  val descriptionTag: String ="DescriptionTag",
  val description2Tag: String ="Description2Tag",
  val detailsTag: String ="DetailsTag",
  val details2Tag: String ="Details2Tag",
  val badgeTag: String ="BadgeTag",
  val trailingFrontArrowIconTag: String ="TrailingFrontArrowIconTag",
)

@Preview
@Composable
fun TUISelectionCardPreview() {

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(15.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    TUISelectionCard(
      leadingIcon = TarkaIcons.Person24Regular,
      label = "Label",
      description = "Description",
      description2 = "Description2",
      details = "Details",
      details2 = "Details2",
      badgeCount = 4,
      isTrailingBackArrowEnabled = true
    ) {}
    VerticalSpacer(space = 14)
    TUISelectionCard(
      leadingIcon = TarkaIcons.Person24Regular,
      label = "Label",
      description = "Description",
      description2 = "Description2",
      details = "Details",
      details2 = "Details2",
      badgeCount = 4,
      isTrailingBackArrowEnabled = true
    ) {}

    VerticalSpacer(space = 14)

    TUISelectionCard(
      leadingIcon = TarkaIcons.Person24Regular,
      label = "Label",
      description = "Description",
      description2 = "Description2",
      details = "Details",
      details2 = "Details2",
      badgeCount = 4,
      isTrailingBackArrowEnabled = true,
      isSelected = true
    ) {}
    VerticalSpacer(space = 14)
    TUISelectionCard(
      leadingIcon = TarkaIcons.Person24Regular,
      label = "Label",
      description = "Description",
      description2 = "Description2",
      details = "Details",
      details2 = "Details2",
      badgeCount = 4,
      isTrailingBackArrowEnabled = true,
      isSelected = true
    ) {}

  }
}