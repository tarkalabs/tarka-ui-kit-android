package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronRight24
import com.tarkalabs.tarkaicons.Person24
import com.tarkalabs.tarkaicons.TarkaIcon
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.base.TUIBadge
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * This Composable function is used to Show the Cards in a list to pick the particular from User.
 *
 * @param modifier - used to modify the properties, behaviours of composes.
 * @param leadingIcon - Optional Leading Icon in the card.
 * @param label - title of the Card.
 * @param primaryDescription - description of the Card.
 * @param secondaryDescription - Optional additional description of the card.
 * @param primaryDetails - Optional details of the card.
 * @param secondaryDetails - Optional second details of the card.
 * @param badgeCount - Optional Count Details which is shown in Badge style.
 * @param showTrailingIcon - boolean indicated to shown the frontArrow at the end of the card.
 * @param isSelected - a boolean which indicates current clicked state of the card.
 * @param tags - data class consists of string values which are used to find the nodes inside this component while testing.
 * @param onCardClicked - lambda block which will be invoked while clicking this selection card.
 *
 * */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TUISelectionCard(
  modifier: Modifier = Modifier,
  leadingIcon: TarkaIcon? = null,
  label: String,
  primaryDescription: String,
  secondaryDescription: String? = null,
  primaryDetails: String? = null,
  secondaryDetails: String? = null,
  badgeCount: Int? = null,
  showTrailingIcon: Boolean = false,
  isSelected: Boolean = false,
  tags: TUISelectionCardTags = TUISelectionCardTags(),
  onCardClicked: () -> Unit,
) {

  Row(
    modifier = modifier
      .testTag(tags.parentTag)
      .semantics { testTagsAsResourceId = true }
      .clickable {
        onCardClicked.invoke()
      }
      .background(
        if (isSelected) TUITheme.colors.primaryAlt else TUITheme.colors.surface,
        shape = RoundedCornerShape(16.dp)
      )
      .padding(horizontal = 16.dp, vertical = 12.dp),
  ) {

    leadingIcon?.let {
      Icon(
        modifier = Modifier
          .size(24.dp)
          .testTag(tags.leadingIconTag),
        painter = painterResource(id = it.iconRes),
        contentDescription = it.contentDescription,
        tint = TUITheme.colors.secondary
      )
    }

    Column(
      modifier = Modifier
        .padding(start = if(leadingIcon != null) 16.dp else 0.dp)
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
        text = primaryDescription,
        color = TUITheme.colors.inputText,
        style = TUITheme.typography.heading6
      )

      secondaryDescription?.let {
        Text(
          modifier = Modifier.testTag(tags.description2Tag),
          text = it,
          color = TUITheme.colors.inputText,
          style = TUITheme.typography.heading6
        )
      }

      primaryDetails?.let {
        Text(
          modifier = Modifier.testTag(tags.detailsTag),
          text = it,
          color = TUITheme.colors.inputText,
          style = TUITheme.typography.heading6
        )
      }

      secondaryDetails?.let {
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
        modifier = Modifier.align(Alignment.CenterVertically)
          .padding(start = 16.dp)
          .testTag(tags.badgeTag),
        count = badgeCount,
        color = TUITheme.colors.tertiary
      )
    }

    if (showTrailingIcon) {
      Icon(
        modifier = Modifier.align(Alignment.CenterVertically)
          .size(24.dp)
          .testTag(tags.trailingFrontArrowIconTag),
        painter = painterResource(id = TarkaIcons.Regular.ChevronRight24.iconRes),
        contentDescription = TarkaIcons.Regular.ChevronRight24.contentDescription
      )
    }

  }
}

data class TUISelectionCardTags(
  val parentTag: String = "TUISelectionCard",
  val leadingIconTag: String = "TUISelectionCard_LeadingIconTag",
  val labelTag: String = "TUISelectionCard_LabelTag",
  val descriptionTag: String = "TUISelectionCard_PrimaryDescriptionTag",
  val description2Tag: String = "TUISelectionCard_SecondaryDescriptionTag",
  val detailsTag: String = "TUISelectionCard_PrimaryDetailsTag",
  val details2Tag: String = "TUISelectionCard_SecondaryDetailsTag",
  val badgeTag: String = "TUISelectionCard_BadgeTag",
  val trailingFrontArrowIconTag: String = "TUISelectionCard_TrailingFrontArrowIconTag",
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
      leadingIcon = TarkaIcons.Regular.Person24,
      label = "Label",
      primaryDescription = "Description",
      isSelected = true
    ) {}
    VerticalSpacer(space = 14)
    TUISelectionCard(
      label = "Label",
      primaryDescription = "Description",
      isSelected = true
    ) {}
    VerticalSpacer(space = 14)

    TUISelectionCard(
      leadingIcon = TarkaIcons.Regular.Person24,
      label = "Label",
      primaryDescription = "Description",
      secondaryDescription = "Description2",
      primaryDetails = "Details",
      secondaryDetails = "Details2",
      badgeCount = 4,
      showTrailingIcon = true
    ) {}
    VerticalSpacer(space = 14)
    TUISelectionCard(
      leadingIcon = TarkaIcons.Regular.Person24,
      label = "Label",
      primaryDescription = "Description",
      secondaryDescription = "Description2",
      primaryDetails = "Details",
      secondaryDetails = "Details2",
      badgeCount = 4,
      showTrailingIcon = true
    ) {}

    VerticalSpacer(space = 14)

    TUISelectionCard(
      leadingIcon = TarkaIcons.Regular.Person24,
      label = "Label",
      primaryDescription = "Description",
      secondaryDescription = "Description2",
      primaryDetails = "Details",
      secondaryDetails = "Details2",
      badgeCount = 4,
      showTrailingIcon = true,
      isSelected = true
    ) {}
    VerticalSpacer(space = 14)
    TUISelectionCard(
      leadingIcon = TarkaIcons.Regular.Person24,
      label = "Label",
      primaryDescription = "Description",
      secondaryDescription = "Description2",
      primaryDetails = "Details",
      secondaryDetails = "Details2",
      badgeCount = 4,
      showTrailingIcon = true,
      isSelected = true
    ) {}

  }
}