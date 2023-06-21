package com.tarkalabs.uicomponents.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.microsoft.fluent.mobile.icons.R
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_counterclockwise_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_export_ltr_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_sync_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_arrow_sync_circle_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_barcode_scanner_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_calendar_ltr_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_16_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_circle_16_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_checkmark_starburst_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_down_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_up_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_copy_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_delete_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_16_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_dismiss_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_error_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_header_arrow_down_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_document_text_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_info_20_filled
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_local_language_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_map_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_question_circle_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_re_order_dots_vertical_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_search_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_shield_task_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_tabs_24_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_timer_20_regular
import com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_warning_12_regular

data class TarkaIcon(
  @DrawableRes val iconRes: Int,
  val contentDescription: String,
  val tintColor : Color? = null,
) {
  fun withColor(color: Color): TarkaIcon {
    return this.copy(tintColor = color)
  }
}

object TarkaIcons {

  val Warning12Regular = TarkaIcon(ic_fluent_warning_12_regular, "Warning")
  val CheckMarkCircle16Regular = TarkaIcon(ic_fluent_checkmark_circle_16_regular, "Check Mark Success")
  val ChevronUp = TarkaIcon(ic_fluent_chevron_up_20_regular, "Chevron Up")
  val ChevronRight = TarkaIcon(R.drawable.ic_fluent_chevron_right_20_regular, "Chevron Right")
  val ChevronLeft = TarkaIcon(ic_fluent_chevron_left_20_regular, "Chevron Left")
  val ChevronDown = TarkaIcon(ic_fluent_chevron_down_20_regular, "Chevron Down")
  val CheckmarkStarburst =
    TarkaIcon(ic_fluent_checkmark_starburst_24_regular, "Checkmark Starburst")
  val Tabs = TarkaIcon(ic_fluent_tabs_24_regular, "Tabs")
  val ArrowExport = TarkaIcon(ic_fluent_arrow_export_ltr_24_regular, "Arrow Export")
  val Timer20Regular = TarkaIcon(ic_fluent_timer_20_regular, "Arrow Export")
  val Calendar24Regular = TarkaIcon(ic_fluent_calendar_ltr_24_regular, "Arrow Export")
  val ArrowSync20Regular = TarkaIcon(ic_fluent_arrow_sync_20_regular, "Arrow Export")
  val ArrowCounterClockWise =
    TarkaIcon(ic_fluent_arrow_counterclockwise_24_regular, "Arrow Counter clockwise")
  val Search = TarkaIcon(ic_fluent_search_24_regular, "Search")
  val Copy = TarkaIcon(ic_fluent_copy_24_regular, "Copy")
  val Delete = TarkaIcon(ic_fluent_delete_24_regular, "Delete")
  val Dismiss = TarkaIcon(ic_fluent_dismiss_24_regular, "Dismiss")
  val DismissFilled = TarkaIcon(ic_fluent_dismiss_16_filled, "Dismiss")
  val ArrowSyncCircle = TarkaIcon(ic_fluent_arrow_sync_circle_24_regular, "Arrow Sync Circle")
  val DocumentHeaderArrowDown =
    TarkaIcon(ic_fluent_document_header_arrow_down_24_regular, "Document Header Arrow Down")
  val DocumentError = TarkaIcon(ic_fluent_document_error_24_regular, "Document Error")
  val Map = TarkaIcon(ic_fluent_map_24_regular, "Map")
  val ReOrderDots = TarkaIcon(ic_fluent_re_order_dots_vertical_24_regular, "Re order dots")
  val CheckMark = TarkaIcon(ic_fluent_checkmark_16_filled, "Check Mark")
  val QuestionCircle = TarkaIcon(ic_fluent_question_circle_24_regular, "Question Circle")
  val DocumentText = TarkaIcon(ic_fluent_document_text_24_regular, "Document Text")
  val ShieldTask = TarkaIcon(ic_fluent_shield_task_24_regular, "Document Text")
  val LocalLanguage = TarkaIcon(ic_fluent_local_language_24_regular, "Language")
  val BarCodeScanner = TarkaIcon(ic_fluent_barcode_scanner_24_regular, "BarCode Scanner")
  val Info20Filled = TarkaIcon(ic_fluent_info_20_filled, "Information")
}