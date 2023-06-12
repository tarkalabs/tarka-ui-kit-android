package com.tarkalabs.uicomponents.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.tarkalabs.uicomponents.components.TUISnackBarType.Error
import com.tarkalabs.uicomponents.components.TUISnackBarType.Information
import com.tarkalabs.uicomponents.components.TUISnackBarType.Success
import com.tarkalabs.uicomponents.components.TUISnackBarType.Warning
import com.tarkalabs.uicomponents.models.TarkaIcon
import com.tarkalabs.uicomponents.theme.TUITheme

enum class TUISnackBarType {
  Success,
  Information,
  Warning,
  Error;
}

@Composable fun TUISnackBar(
  message: String,
  type: TUISnackBarType = TUISnackBarType.Information,
  leadingIcon: TarkaIcon? = null,
  actionLabel: String? = null,
  action: () -> Unit = {}
) {
  var containerColor = TUITheme.colors.onSecondary
  when(type){
    Success -> TODO()
    Information -> TODO()
    Warning -> TODO()
    Error -> TODO()
  }

  Snackbar(containerColor = TUITheme.colors.utilityOutline) {
    Row {
      if (leadingIcon != null) {
        Icon(
          painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription
        )
      }

      Text(message)
    }

  }
}