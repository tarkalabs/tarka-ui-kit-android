package com.tarkalabs.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tarkalabs.tarkaicons.ChevronLeft24
import com.tarkalabs.tarkaicons.Stack24
import com.tarkalabs.tarkaicons.TarkaIcons.Regular
import com.tarkalabs.uicomponents.components.TUIAppTopBar
import com.tarkalabs.uicomponents.theme.TUITheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      var title by remember { mutableStateOf("Kitchen Sink") }
      var isInComponent by remember { mutableStateOf(false) }
      val navController = rememberNavController()
      TUITheme {
        Scaffold(topBar = {
          TUIAppTopBar(
            title = title,
            navigationIcon = if (isInComponent) Regular.ChevronLeft24 else Regular.Stack24,
            onNavigationIconClick = {
              if (isInComponent) {
                navController.popBackStack()
                isInComponent = false
              }
            }
          )
        }) { paddingValues ->

          NavHost(navController = navController, startDestination = "home") {
            composable("home") {
              LazyVerticalGrid(columns = GridCells.Fixed(2), Modifier.padding(paddingValues)) {
                items(componentList) {
                  UiItem(it) {
                    title = it
                    isInComponent = true
                    navController.navigate(it)
                  }
                }
              }
            }
            TuiComposable("TUIAvatar"){

            }

            TuiComposable("TUIBadge"){

            }

            TuiComposable("TUIButton"){

            }

            TuiComposable("TUIFloatingActionButton"){

            }

            TuiComposable("TUIIconButton"){

            }

            TuiComposable("TUIInputField"){

            }

            TuiComposable("TUIToggleRow"){

            }

            TuiComposable("TUIDraggableCard"){

            }

            TuiComposable("TUISelectionCard"){

            }

            TuiComposable("TUICheckBox"){

            }

            TuiComposable("TUIRadioButton"){

            }

            TuiComposable("TUIRadioButtonRow"){

            }

            TuiComposable("TUIFloatingNavBar"){

            }

            TuiComposable("TUIFloatingTab"){

            }

            TuiComposable("TUITab"){

            }

            TuiComposable("TUITabBar"){

            }

            TuiComposable("TUIAttachmentUpload"){

            }

            TuiComposable("TUINavigationRow"){

            }

            TuiComposable("TUISearchBar"){

            }

            TuiComposable("TUISnackBar"){

            }

            TuiComposable("TUIStatusIndicator"){

            }

            TuiComposable("TUITextRow"){

            }

            TuiComposable("TUIAppTopBar"){

            }

            TuiComposable("TUIChip"){

            }

            TuiComposable("TUIMobileButtonBlock"){

            }

            TuiComposable("TUIMenuItem"){

            }

            TuiComposable("TUIMobileOverlayHeader"){

            }

            TuiComposable("TUIMobileOverlayFooter"){

            }

            TuiComposable("TUISelectionCard"){

            }

            TuiComposable("TUITag"){

            }

            TuiComposable("TUIPlayPauseButton"){

            }

            TuiComposable("TUIMultiLevelSelectorHeader"){

            }
          }
        }
      }
    }
  }

  private fun NavGraphBuilder.TuiComposable(name: String,  content : @Composable () -> Unit) {
    composable(name) {
      content()

    }
  }

  @Composable
  fun UiItem(
    itemName: String,
    onItemClick: () -> Unit,
  ) {
    Card(
      modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .clickable { onItemClick() },
      shape = RoundedCornerShape(8.dp),
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp)
      ) {
        Text(
          text = itemName,
          maxLines = 1,
          style = MaterialTheme.typography.bodyMedium
        )
      }
    }
  }

  @OptIn(ExperimentalMaterial3Api::class)
  @Composable
  fun GenericComposable(name: String, navController: NavController) {
    Column {
      TUIAppTopBar(
        title = name,
        navigationIcon = Regular.ChevronLeft24,
        onNavigationIconClick = { navController.popBackStack() }
      )
    }
  }
}

val componentList = listOf(
  "TUIAvatar",
  "TUIBadge",
  "TUIButton",
  "TUIFloatingActionButton",
  "TUIIconButton",
  "TUIInputField",
  "TUIToggleRow",
  "TUIDraggableCard",
  "TUISelectionCard",
  "TUICheckBox",
  "TUIRadioButton",
  "TUIRadioButtonRow",
  "TUIFloatingNavBar",
  "TUIFloatingTab",
  "TUITab",
  "TUITabBar",
  "TUIAttachmentUpload",
  "TUINavigationRow",
  "TUISearchBar",
  "TUISnackBar",
  "TUIStatusIndicator",
  "TUITextRow",
  "TUIAppTopBar",
  "TUIChip",
  "TUIMobileButtonBlock",
  "TUIMenuItem",
  "TUIMobileOverlayHeader",
  "TUIMobileOverlayFooter",
  "TUISelectionCard",
  "TUITag",
  "TUIPlayPauseButton",
  "TUIMultiLevelSelectorHeader"
)

