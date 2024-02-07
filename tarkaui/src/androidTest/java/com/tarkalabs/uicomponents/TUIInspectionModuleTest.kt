package com.tarkalabs.uicomponents

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.InspectionStatus
import com.tarkalabs.uicomponents.components.InspectionStatus.COMPLETED
import com.tarkalabs.uicomponents.components.InspectionStatus.IN_PROGRESS
import com.tarkalabs.uicomponents.components.InspectionStatus.PENDING
import com.tarkalabs.uicomponents.components.TUIInspectionModule
import com.tarkalabs.uicomponents.components.TUITextRowTags
import com.tarkalabs.uicomponents.components.base.TUIButtonTags
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIInspectionModuleTest {

  @get:Rule val composable = createComposeRule()

  @Test fun is_passed_pending_status_shown() {
    val formNo = "(#formNo) formName"
    composable.setContent {
      TUIInspectionModule(
        inspectionStatus = PENDING,
        formName = formNo,
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
    composable.onNodeWithText(PENDING.value).assertIsDisplayed()
    composable.onNodeWithText(formNo).assertIsDisplayed()
  }

  @Test fun is_passed_in_progress_status_shown() {
    composable.setContent {
      TUIInspectionModule(
        inspectionStatus = IN_PROGRESS,
        formName = "(#formNo) formName",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
    composable.onNodeWithText(IN_PROGRESS.value).assertIsDisplayed()
  }

  @Test fun is_passed_completed_status_shown() {
    composable.setContent {
      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#formNo) formName",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
    composable.onNodeWithText(COMPLETED.value).assertIsDisplayed()
  }

  @Test fun is_form_icon_click_invokes() {
    val onFormIconClick: () -> Unit = mock()
    composable.setContent {
      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#formNo) formName",
        onInfoIconClick = onFormIconClick,
        onActionButtonClick = {}
      )
    }
    composable.onNodeWithTag(TUITextRowTags().infoIconTag).performClick()
    verify(onFormIconClick).invoke()
  }

  @Test fun is_button_click_invokes() {
    val onButtonClick: (InspectionStatus) -> Unit = mock()
    composable.setContent {
      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#formNo) formName",
        onInfoIconClick = { },
        onActionButtonClick = onButtonClick
      )
    }
    composable.onNodeWithTag(TUIButtonTags().parentTag).performClick()
    verify(onButtonClick).invoke(COMPLETED)
  }
}