package com.tarkalabs.uicomponents.screenshots

import com.tarkalabs.uicomponents.components.InspectionStatus.COMPLETED
import com.tarkalabs.uicomponents.components.InspectionStatus.IN_PROGRESS
import com.tarkalabs.uicomponents.components.InspectionStatus.PENDING
import com.tarkalabs.uicomponents.components.TUIInspectionModule
import org.junit.Test

class TUIInspectionModuleScreenShotTest : ComposeScreenshotComparator() {

  @Test
  fun test_Inspection_module_pending_type_lightTheme() {
    compareScreenshotFor(false, "Inspection_Module_darkTheme_false_Pending_Type") {
      TUIInspectionModule(
        inspectionStatus = PENDING,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }

  @Test
  fun test_Inspection_module_pending_type_darkTheme() {
    compareScreenshotFor(true, "Inspection_Module_darkTheme_true_Pending_Type") {
      TUIInspectionModule(
        inspectionStatus = PENDING,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }

  @Test
  fun test_Inspection_module_in_progress_type_lightTheme() {
    compareScreenshotFor(false, "Inspection_Module_darkTheme_false_InProgress_Type") {
      TUIInspectionModule(
        inspectionStatus = IN_PROGRESS,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }

  @Test
  fun test_Inspection_module_in_progress_type_darkTheme() {
    compareScreenshotFor(true, "Inspection_Module_darkTheme_true_InProgress_Type") {
      TUIInspectionModule(
        inspectionStatus = IN_PROGRESS,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }

  @Test
  fun test_Inspection_module_completed_type_lightTheme() {
    compareScreenshotFor(false, "Inspection_Module_darkTheme_false_Completed_Type") {
      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }

  @Test
  fun test_Inspection_module_completed_type_darkTheme() {
    compareScreenshotFor(true, "Inspection_Module_darkTheme_true_Completed_Type") {
      TUIInspectionModule(
        inspectionStatus = COMPLETED,
        formName = "(#1014) Vehicle Inspection Report",
        onInfoIconClick = { },
        onActionButtonClick = {}
      )
    }
  }
}