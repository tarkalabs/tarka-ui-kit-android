package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaicons.ChevronDown24
import com.tarkalabs.tarkaicons.TarkaIcons
import com.tarkalabs.uicomponents.components.InspectionStatus.COMPLETED
import com.tarkalabs.uicomponents.components.InspectionStatus.IN_PROGRESS
import com.tarkalabs.uicomponents.components.InspectionStatus.PENDING
import com.tarkalabs.uicomponents.components.base.ButtonStyle.OUTLINE
import com.tarkalabs.uicomponents.components.base.ButtonStyle.SECONDARY
import com.tarkalabs.uicomponents.components.base.TUIButton
import com.tarkalabs.uicomponents.theme.TUITheme

/**
 * This Component used to denote the basic details of the Inspection with required Action
 * @param modifier The modifier to apply to the button.
 * @param inspectionStatus  - Status of the Inspection which is bounded in InspectionStatus enum.
 * @param formName - The Form Name Of the Inspection Like => (#FormNo) formName
 * @param onInfoIconClick - The callback function to be executed when the DropDown Icon is clicked in right to Form Details.
 * @param onActionButtonClick - The callback function to be executed when the Action Button is clicked which is based on Inspection Status.
 * How to use TUIInspectionModule() composable function
 *
TUIInspectionModule(
inspectionStatus = IN_PROGRESS,
formName = "(#1014) Vehicle Inspection Report",
onInfoIconClick = { },
onActionButtonClick = {}
)
 *
 */
@Composable
fun TUIInspectionModule(
  modifier: Modifier = Modifier,
  inspectionStatus: InspectionStatus,
  formName: String,
  onInfoIconClick: () -> Unit,
  onActionButtonClick: (InspectionStatus) -> Unit,
  tags: TUIInspectionModuleTags = TUIInspectionModuleTags(),
) {

  val buttonTitle = when (inspectionStatus) {
    PENDING -> "Start Inspection"
    IN_PROGRESS -> "Continue Inspection"
    COMPLETED -> "View Report"
  }

  val buttonStyle = when (inspectionStatus) {
    PENDING, IN_PROGRESS -> SECONDARY
    COMPLETED -> OUTLINE
  }

  val tagType = when (inspectionStatus) {
    PENDING -> {
      TagType.CUSTOM(
        bgContentColor = TUITheme.colors.accentBaseK,
        titleColor = TUITheme.colors.onAccentK,
        iconTint = null
      )
    }

    IN_PROGRESS -> {
      TagType.CUSTOM(
        bgContentColor = TUITheme.colors.accentBaseP,
        titleColor = TUITheme.colors.onAccentP,
        iconTint = null
      )
    }

    COMPLETED -> {
      TagType.CUSTOM(
        bgContentColor = TUITheme.colors.accentBaseF,
        titleColor = TUITheme.colors.onAccentF,
        iconTint = null
      )
    }
  }

  Column(
    modifier = modifier
      .testTag(tags.parentTag)
      .background(
        color = TUITheme.colors.surface,
        shape = RoundedCornerShape(16.dp)
      )
      .padding(horizontal = 16.dp)
  ) {

    VerticalSpacer(space = 16)

    TUICardHeader(
      primaryTag = TUICardTag(
        title = inspectionStatus.value,
        tagType = tagType,
        onClick = {}),
      title = "Inspection",
    )

    VerticalSpacer(space = 16)

    TUITextRow(
      title = "Form",
      style = TextRowStyle.TitleWithDescription(formName),
      infoIcon = TarkaIcons.Regular.ChevronDown24,
      onInfoIconClick = onInfoIconClick
    )

    VerticalSpacer(space = 16)

    TUIButton(
      label = buttonTitle, buttonStyle = buttonStyle
    ) {
      onActionButtonClick.invoke(inspectionStatus)
    }

    VerticalSpacer(space = 16)

  }
}

enum class InspectionStatus(val value: String) {
  PENDING("Pending"),
  IN_PROGRESS("In Progress"),
  COMPLETED("Completed")
}

data class TUIInspectionModuleTags(
  val parentTag: String = "TUIInspectionModule",
)

@Preview
@Composable
fun TUIInspectionModulePreview() {
  TUITheme {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .verticalScroll(rememberScrollState())
    ) {
      TUIInspectionModule(
        inspectionStatus = PENDING,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )

      VerticalSpacer(space = 8)

      TUIInspectionModule(
        inspectionStatus = IN_PROGRESS,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )

      VerticalSpacer(space = 8)

      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }
}