package com.tarkalabs.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.base.BadgeSize
import com.tarkalabs.tarkaui.components.base.TUIBadge
import com.tarkalabs.tarkaui.theme.TUITheme

@Composable
fun TUIBadgeComposable() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "TUIBadge", style = TUITheme.typography.heading3)
        // Displaying a badge with count
        Row {
            TUIBadge(count = 2, badgeSize = BadgeSize.M)
            Spacer(modifier = Modifier.width(8.dp))
            TUIBadge(count = 8, badgeSize = BadgeSize.L, color = Color.Green)
            Spacer(modifier = Modifier.width(8.dp))
            TUIBadge(badgeSize = BadgeSize.S)
        }
    }
}