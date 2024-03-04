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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tarkalabs.tarkaui.components.TUIAppTopBar
import com.tarkalabs.tarkaui.icons.ChevronLeft24
import com.tarkalabs.tarkaui.icons.Stack24
import com.tarkalabs.tarkaui.icons.TarkaIcons
import com.tarkalabs.tarkaui.icons.TarkaIcons.Regular
import com.tarkalabs.tarkaui.theme.TUITheme

private const val TITLE = "Kitchen Sink"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
class UIComponentListActivity : ComponentActivity() {

  @OptIn(ExperimentalMaterial3Api::class) override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


    setContent {
      var title by remember { mutableStateOf(TITLE) }
      var isInComponent by remember { mutableStateOf(false) }
      val navController = rememberNavController()
      TUITheme {
        Scaffold(topBar = {
          TUIAppTopBar(
            title = title,
            navigationIcon = if (isInComponent) TarkaIcons.Regular.ChevronLeft24 else Regular.Stack24,
            onNavigationIconClick = {
              if (isInComponent) {
                navController.popBackStack()
                isInComponent = false
                title = TITLE
              }
            }
          )
        }) { paddingValues ->

          NavHost(navController = navController, startDestination = "home", modifier = Modifier.padding(paddingValues)) {
            composable("home") {
              LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(componentList) {
                  UiItem(it) {
                    title = it
                    isInComponent = true
                    navController.navigate(it)
                  }
                }
              }
            }
            tuiComposable("TUIAvatar") {
              TUIAvatarComposable()
            }

            tuiComposable("TUIBadge") {
              TUIBadgeComposable()
            }

            tuiComposable("TUIButton") {
              TUIButtonComposable()
            }

            tuiComposable("TUIFloatingActionButton") {
              TUIFloatingActionButtonComposable()
            }

            tuiComposable("TUIIconButton") {
              TUIIconButtonComposable()
            }

            tuiComposable("TUIInputField") {
              TUIInputFieldComposable()
            }

            tuiComposable("TUIToggleRow") {
              TUIToggleRowComposable()
            }

            tuiComposable("TUIDraggableCard") {
              TUIDraggableCardComposable()
            }

            tuiComposable("TUISelectionCard") {
              TUISelectionCardComposable()
            }

            tuiComposable("TUICheckBox") {
              TUICheckBoxComposable()
            }

            tuiComposable("TUIRadioButton") {
              TUIRadioButtonComposable()
            }

            tuiComposable("TUIRadioButtonRow") {
              TUIRadioButtonRowComposable()
            }

            tuiComposable("TUIFloatingNavBar") {
              TUIFloatingNavBarComposable()
            }

            tuiComposable("TUIFloatingTab") {
              TUIFloatingTabComposable()
            }

            tuiComposable("TUITab") {
              TUITabComposable()
            }

            tuiComposable("TUITabBar") {
              TUITabBarComposable()
            }

            tuiComposable("TUIAttachmentUpload") {
              TUIAttachmentUploadComposable()
            }

            tuiComposable("TUINavigationRow") {
              TUINavigationRowComposable()
            }

            tuiComposable("TUISearchBar") {
              TUISearchBarComposable()
            }

            tuiComposable("TUISnackBar") {
              TUISnackBarComposable()
            }

            tuiComposable("TUIStatusIndicator") {
              TUIStatusIndicatorComposable()
            }

            tuiComposable("TUITextRow") {
              TUITextRowComposable()
            }

            tuiComposable("TUIAppTopBar") {
              TUIAppTopBarComposable()
            }

            tuiComposable("TUIChip") {
              TUIChipComposable()
            }

            tuiComposable("TUIMobileButtonBlock") {
              TUIMobileButtonBlockComposable()
            }

            tuiComposable("TUIMenuItem") {
              TUIMenuItemComposable()
            }

            tuiComposable("TUIMobileOverlayHeader") {
              TUIMobileOverlayHeaderComposable()
            }

            tuiComposable("TUIMobileOverlayFooter") {
              TUIMobileOverlayFooterComposable()
            }

            tuiComposable("TUISelectionCard") {
              TUISelectionCardComposable()
            }

            tuiComposable("TUITag") {
              TUITagComposable()
            }

            tuiComposable("TUIPlayPauseButton") {
              TUIPlayPauseButtonComposable()
            }

            tuiComposable("TUIMultiLevelSelectorHeader") {
              TUIMultiLevelSelectorHeaderComposable()
            }
          }
        }
      }
    }
  }

  private fun NavGraphBuilder.tuiComposable(
    name: String,
    content: @Composable () -> Unit,
  ) {
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
)

