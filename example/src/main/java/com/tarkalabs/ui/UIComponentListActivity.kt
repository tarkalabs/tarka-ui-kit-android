package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tarkalabs.uicomponents.components.BadgeSize
import com.tarkalabs.uicomponents.components.TUIBadge
import com.tarkalabs.uicomponents.theme.TUITheme

class UIComponentListActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      TUITheme {
        TUIBadge(count = 2, badgeSize = BadgeSize.M)
      }
    }
  }
}