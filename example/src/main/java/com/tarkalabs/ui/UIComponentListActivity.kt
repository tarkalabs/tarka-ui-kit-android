package com.tarkalabs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tarkalabs.tarkaui.components.ChipType.Filter
import com.tarkalabs.tarkaui.components.HorizontalSpacer
import com.tarkalabs.tarkaui.components.TUIAppTopBar
import com.tarkalabs.tarkaui.components.TUIChip
import com.tarkalabs.tarkaui.components.VerticalSpacer
import com.tarkalabs.tarkaui.icons.ArrowSort20
import com.tarkalabs.tarkaui.icons.ChevronRight20
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      TUITheme {
        var query by remember {
          mutableStateOf("")
        }

        var showSearchbar by remember {
          mutableStateOf(false)
        }

        Scaffold(topBar = {
          TUIAppTopBar(
            title = "Lorem Ipsum",
            navigationIcon = Regular.ChevronRight20,
            menuItemIconOne = Regular.ChevronRight20,
            menuItemIconTwo = Regular.ChevronRight20,
            menuItemIconThree = Regular.ChevronRight20,
          )
        }) { paddingValues ->
          Column(
            modifier = Modifier
              .padding(paddingValues)
              .fillMaxWidth()
              .fillMaxHeight()
              .padding(horizontal = 8.dp)
          ) {
            VerticalSpacer(space = 30)
            Row {
              HorizontalSpacer(space = 20)
              TUIChip(
                type = Filter(
                  trailingIcon = Regular.ArrowSort20,
                  showTrailingDismiss = showSearchbar,
                  showTrailingCaret = true,
                  selected = showSearchbar
                ),
                label = "Something",
                onClick = {
                  showSearchbar = true
                  Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED")
                },
                onDismissClick = {
                  showSearchbar = !showSearchbar
                  Log.e("TAG_CHIP", "TUIChipPreview: 123")
                },
              )
              HorizontalSpacer(space = 20)
              TUIChip(
                type = Filter(
                  trailingIcon = Regular.ArrowSort20,
                  showTrailingDismiss = true,
                  showTrailingCaret = true,
                  selected = true
                ),
                label = "Something",
                onClick = {
                  showSearchbar = true
                  Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED")
                },
                onDismissClick = {
                  showSearchbar = !showSearchbar
                  Log.e("TAG_CHIP", "TUIChipPreview: 123")
                },
              )
              HorizontalSpacer(space = 20)
            }
            VerticalSpacer(space = 30)
            Row {
              HorizontalSpacer(space = 20)
              TUIChip(
                type = Filter(
                  trailingIcon = Regular.ArrowSort20,
                  showTrailingDismiss = showSearchbar,
                  showTrailingCaret = true,
                  showLeadingCheck = true,
                  selected = showSearchbar
                ),
                label = "Something",
                onClick = {
                  showSearchbar = true
                  Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED")
                },
                onDismissClick = {
                  showSearchbar = !showSearchbar
                  Log.e("TAG_CHIP", "TUIChipPreview: 123")
                },
              )
              HorizontalSpacer(space = 20)
              TUIChip(
                type = Filter(
                  trailingIcon = Regular.ArrowSort20,
                  showTrailingDismiss = true,
                  showTrailingCaret = true,
                  selected = true,
                  showLeadingCheck = true,
                ),
                label = "Something",
                onClick = {
                  showSearchbar = true
                  Log.e("TAG_CHIP", "TUIChipPreview: TAG_CLICKED")
                },
                onDismissClick = {
                  showSearchbar = !showSearchbar
                  Log.e("TAG_CHIP", "TUIChipPreview: 123")
                },
              )
              HorizontalSpacer(space = 20)
            }
          }

        }
      }
    }
  }
}
