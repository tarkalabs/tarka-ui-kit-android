package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tarkalabs.commonui.components.EamGhostIconButton
import com.tarkalabs.commonui.components.EamTopBar
import com.tarkalabs.commonui.components.TextRowWithDescription
import com.tarkalabs.commonui.theme.Eam360uiandroidTheme
import com.tarkalabs.ui.R.drawable
import com.tarkalabs.ui.theme.ExampleTheme

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

  @Composable
  @Preview(showSystemUi = true)
  fun SettingScreen() {
    Scaffold(topBar = {
      EamTopBar(
        title = "Settings",
        navigationIcon = R.drawable.arrow_back
      )
    }) { paddingValues ->
      Column(modifier = Modifier.padding(paddingValues)) {
        Divider()
        SettingHeader()
        TextRowWithDescription(title = "Role", description = "Supervisor", infoIcon = drawable.keyboard_arrow_right)
        Divider()
        SettingItem {
          SettingItemContent(Icons.Default.Search, "Transaction errors", 3)
        }
        SettingItem {
          SettingItemContent(Icons.Default.Search, "Sync status")
        }
        SettingItem {
          SettingItemContent(Icons.Default.Search, "Tabs configuration")
        }
        SettingItem {
          SettingItemContent(Icons.Default.Search, "Export log")
        }
      }
    }
  }

  @Composable
  fun SettingItemContent(
    leadingIcon: ImageVector,
    title: String,
    badgeCount: Int? = null,
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(imageVector = leadingIcon, contentDescription = null)
      Text(text = title, Modifier.weight(1f))
      if (badgeCount != null)
        Badge { Text(text = badgeCount.toString()) }
      Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
  }

  @Composable
  fun SettingHeader() {
    // TODO: handle the center of the avatar
    Row {
      Column(
        modifier = Modifier.weight(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Image(
          painter = painterResource(id = drawable.avatar),
          contentDescription = null,
          modifier = Modifier
            .clip(CircleShape)
            .size(96.dp)
        )
        Text(text = "Ronald Richards")
        Text(text = "BEDFORD")
      }
      Column {
        EamGhostIconButton(icon = drawable.ic_refresh)
      }
    }
  }

  @Composable
  fun Lookup(onClick: () -> Unit = {}, label: String = "", body: String = "") {
    Row(modifier = Modifier.clickable {
      onClick()
    }, verticalAlignment = Alignment.CenterVertically) {
      Column(Modifier.weight(1f)) {
        Text(text = label)
        Text(text = body)
      }
      Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
  }

  @Composable
  fun SettingItem(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Surface(modifier.heightIn(min = 40.dp)) {
      content()
    }
  }

  @Composable
  fun TopBarNavigationIcon(imageVector: ImageVector, onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
      Icon(imageVector = imageVector, contentDescription = null)
    }
  }

  @Composable
  fun VerticalSpacer(space: Int) {
    Spacer(modifier = Modifier.height(space.dp))
  }

  @Composable
  fun HorizontalSpacer(space: Int) {
    Spacer(modifier = Modifier.width(space.dp))
  }
}