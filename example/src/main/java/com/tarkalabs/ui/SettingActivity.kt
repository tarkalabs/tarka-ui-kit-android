package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.commonui.components.EamGhostIconButton
import com.tarkalabs.commonui.components.EamTopBar
import com.tarkalabs.commonui.components.NavigationRow
import com.tarkalabs.commonui.components.TextRowWithDescription
import com.tarkalabs.commonui.components.VerticalSpacer
import com.tarkalabs.commonui.theme.ColorUtilityOutline
import com.tarkalabs.commonui.theme.Eam360Theme
import com.tarkalabs.commonui.theme.Eam360uiandroidTheme
import com.tarkalabs.ui.R.drawable

@OptIn(ExperimentalMaterial3Api::class)
class SettingActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      Eam360uiandroidTheme {
        SettingScreen()
      }
    }
  }

  @Composable @Preview(showSystemUi = true) fun SettingScreen() {
    Scaffold(topBar = {
      EamTopBar(
        title = "Settings", navigationIcon = drawable.arrow_back
      )
    },
    containerColor = MaterialTheme.colorScheme.surface) { paddingValues ->
      Column(modifier = Modifier.padding(paddingValues)) {
        Divider()
        VerticalSpacer(space = 24)
        SettingHeader()
        VerticalSpacer(space = 16)
        TextRowWithDescription(
          title = "Role",
          description = "Supervisor",
          infoIcon = drawable.keyboard_arrow_right,
          modifier = Modifier.fillMaxWidth(),
          paddingValues = PaddingValues(horizontal = 24.dp)

        )
        VerticalSpacer(space = 16)
        Divider()
        VerticalSpacer(space = 16)
        Column(Modifier.padding(horizontal = 16.dp)) {
          NavigationRow(
            title = "Transaction errors",
            badgeCount = 3,
            showRightArrow = true,
            leadingIcon = drawable.ic_transaction
          )
          NavigationRow(
            title = "Sync status", showRightArrow = true, leadingIcon = drawable.checkmark_starburst
          )
          NavigationRow(
            title = "Tabs configuration", showRightArrow = true, leadingIcon = drawable.tabs
          )
          NavigationRow(
            title = "Export log", showRightArrow = true, leadingIcon = drawable.arrow_export
          )
        }
        VerticalSpacer(space = 16)
      }
    }
  }

  @Composable fun SettingHeader() {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp)
    ) {
      Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Image(
          painter = painterResource(id = drawable.avatar),
          contentDescription = null,
          modifier = Modifier
            .clip(CircleShape)
            .size(96.dp)
        )
        VerticalSpacer(space = 16)
        Text(
          text = "Ronald Richards",
          style = Eam360Theme.typography.heading6,
          color = MaterialTheme.colorScheme.onSurface
        )
        Text(text = "BEDFORD",
        style = Eam360Theme.typography.body7,
        color = ColorUtilityOutline)
      }
      Box(modifier = Modifier.align(Alignment.TopEnd)) {
        EamGhostIconButton(icon = drawable.ic_refresh)
      }
    }
  }
}