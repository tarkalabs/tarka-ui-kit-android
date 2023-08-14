package com.tarkalabs.uicomponents.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.microsoft.fluent.mobile.icons.R
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_add_circle_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_counterclockwise_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_export_ltr_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_sync_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_sync_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_sync_circle_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_barcode_scanner_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_calendar_ltr_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_caret_down_20_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chat_bubbles_question_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_12_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_16_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_20_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_circle_16_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_starburst_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_down_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_up_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_circle_12_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_copy_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_delete_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_device_eq_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_16_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_20_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_error_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_header_arrow_down_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_text_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_error_circle_16_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_eye_12_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_info_20_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_local_language_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_map_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_pause_12_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_pause_24_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_play_12_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_more_horizontal_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_play_16_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_play_24_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_question_circle_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_re_order_dots_vertical_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_search_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_shield_task_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_tabs_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_timer_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_timer_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_warning_12_regular

data class TarkaIcon(
  @DrawableRes val iconRes: Int,
  val contentDescription: String,
  val tintColor: Color? = null,
) {
  fun withColor(color: Color): TarkaIcon {
    return this.copy(tintColor = color)
  }
}

object TarkaIcons {

  val Warning12Regular = TarkaIcon(ic_fluent_warning_12_regular, "Warning")
  val CheckMarkCircle16Regular =
    TarkaIcon(ic_fluent_checkmark_circle_16_regular, "Check Mark Success")
  val ChevronUp20Regular = TarkaIcon(ic_fluent_chevron_up_20_regular, "Chevron Up")
  val ChevronRight20Regular =
    TarkaIcon(R.drawable.ic_fluent_chevron_right_20_regular, "Chevron Right")
  val ChevronRight20Filled =
    TarkaIcon(R.drawable.ic_fluent_chevron_right_20_filled, "Chevron Right")
  val ChevronLeft20Regular = TarkaIcon(ic_fluent_chevron_left_20_regular, "Chevron Left")
  val ChevronLeft24Regular = TarkaIcon(ic_fluent_chevron_left_24_regular, "Chevron Left")
  val ChevronDown20Regular = TarkaIcon(ic_fluent_chevron_down_20_regular, "Chevron Down")
  val CheckmarkStarburst24Regular =
    TarkaIcon(ic_fluent_checkmark_starburst_24_regular, "Checkmark Starburst")
  val Tabs24Regular = TarkaIcon(ic_fluent_tabs_24_regular, "Tabs")
  val ArrowExportLtr24Regular = TarkaIcon(ic_fluent_arrow_export_ltr_24_regular, "Arrow Export")
  val Timer20Regular = TarkaIcon(ic_fluent_timer_20_regular, "Arrow Export")
  val Timer24Regular = TarkaIcon(ic_fluent_timer_24_regular, "Timer")
  val Calendar24Regular = TarkaIcon(ic_fluent_calendar_ltr_24_regular, "Calendar")
  val ArrowSync20Regular = TarkaIcon(ic_fluent_arrow_sync_20_regular, "Arrow Export")
  val ArrowSync24Regular = TarkaIcon(ic_fluent_arrow_sync_24_regular, "Arrow Sync")
  val ArrowCounterClockWise24Regular =
    TarkaIcon(ic_fluent_arrow_counterclockwise_24_regular, "Arrow Counter clockwise")
  val Search24Regular = TarkaIcon(ic_fluent_search_24_regular, "Search")
  val Copy24Regular = TarkaIcon(ic_fluent_copy_24_regular, "Copy")
  val Delete24Regular = TarkaIcon(ic_fluent_delete_24_regular, "Delete")
  val Dismiss20Regular = TarkaIcon(ic_fluent_dismiss_20_regular, "Dismiss")
  val Dismiss24Regular = TarkaIcon(ic_fluent_dismiss_24_regular, "Dismiss")
  val Dismiss16Filled = TarkaIcon(ic_fluent_dismiss_16_filled, "Dismiss")
  val Dismiss20Filled = TarkaIcon(ic_fluent_dismiss_20_filled, "Dismiss")
  val ArrowSyncCircle24Regular =
    TarkaIcon(ic_fluent_arrow_sync_circle_24_regular, "Arrow Sync Circle")
  val DocumentHeaderArrowDown24Regular =
    TarkaIcon(ic_fluent_document_header_arrow_down_24_regular, "Document Header Arrow Down")
  val DocumentError24Regular = TarkaIcon(ic_fluent_document_error_24_regular, "Document Error")
  val Map24Regular = TarkaIcon(ic_fluent_map_24_regular, "Map")
  val ReOrderDotsVertical24Regular =
    TarkaIcon(ic_fluent_re_order_dots_vertical_24_regular, "Re order dots")
  val CheckMark16Filled = TarkaIcon(ic_fluent_checkmark_16_filled, "Check Mark")
  val CheckMark20Filled = TarkaIcon(ic_fluent_checkmark_20_filled, "Check Mark")
  val QuestionCircle24Regular = TarkaIcon(ic_fluent_question_circle_24_regular, "Question Circle")
  val DocumentText24Regular = TarkaIcon(ic_fluent_document_text_24_regular, "Document Text")
  val ShieldTask24Regular = TarkaIcon(ic_fluent_shield_task_24_regular, "Document Text")
  val LocalLanguage24Regular = TarkaIcon(ic_fluent_local_language_24_regular, "Language")
  val BarCodeScanner24Regular = TarkaIcon(ic_fluent_barcode_scanner_24_regular, "BarCode Scanner")
  val Info20Filled = TarkaIcon(ic_fluent_info_20_filled, "Information")
  val ChatBubblesQuestion24Regular = TarkaIcon(ic_fluent_chat_bubbles_question_24_regular, "FAQ")
  val CaretDown20Filled = TarkaIcon(ic_fluent_caret_down_20_filled, "Caret Down")
  val Circle12Regular = TarkaIcon(ic_fluent_circle_12_regular, "Circle")
  val AddCircle24Regular =
    TarkaIcon(ic_fluent_add_circle_24_regular, "Add")
  val ErrorCircle16Regular =
    TarkaIcon(ic_fluent_error_circle_16_regular, "Add")
  val Eye12Regular = TarkaIcon(ic_fluent_eye_12_regular, "Eye")
  val Play16Filled = TarkaIcon(ic_fluent_play_16_filled, "Play")
  val Document24Regular = TarkaIcon(ic_fluent_document_24_regular, "Document")
  val Wave24Regular = TarkaIcon(ic_fluent_device_eq_24_regular, "Audio")
  val Play12Filled = TarkaIcon(ic_fluent_play_12_filled, "Play")
  val Play24Filled = TarkaIcon(ic_fluent_play_24_filled, "Play")
  val Pause12Filled = TarkaIcon(ic_fluent_pause_12_filled, "Pause")
  val Pause24Filled = TarkaIcon(ic_fluent_pause_24_filled, "Pause")
  val ReOrder24Regular = TarkaIcon(ic_fluent_re_order_dots_vertical_24_regular, "ReOrder")
  val MoreHorizontal24Regular = TarkaIcon(ic_fluent_more_horizontal_24_regular, "More")
  val checkmark12Regular = TarkaIcon(ic_fluent_checkmark_12_regular, "Check")
}