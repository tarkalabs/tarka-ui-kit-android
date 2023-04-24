package com.tarkalabs.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.tarkalabs.ui.theme.ExampleTheme

class SettingActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ExampleTheme {
        SettingScreen()
      }
    }
  }

  @Composable
  fun SettingScreen() {
    EAMTopBar(
      leadingIcon = { TopBarNavigationIcon(Icons.Default.ArrowBack)  },
      titleContent = { Text(text = "Settings") }
    )
  }

  @Composable
  fun TopBarNavigationIcon(imageVector: ImageVector, onClick: () -> Unit = {}) {
    IconButton(onClick = onClick) {
      Icon(imageVector = imageVector, contentDescription = null)
    }
  }
  @Composable fun EAMTopBar(
    leadingIcon: @Composable () -> Unit,
    titleContent: @Composable () -> Unit
  ) {
    TopAppBar(
      navigationIcon =  leadingIcon,
      title = titleContent,
    )
  }
}