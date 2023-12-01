package com.tarkalabs.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.unit.dp
import com.tarkalabs.uicomponents.components.VerticalSpacer
import com.tarkalabs.uicomponents.components.tab.TUIFloatingNavBar
import com.tarkalabs.uicomponents.theme.TUITheme
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIFloatingNavBarTest {

  @get:Rule val composable = createComposeRule()
  @Test fun tuiFloatingNavBar_Displayed_And_Click_Event_Trigger() {
    val onTabSelected: (index: Int) -> Unit = mock()
    val tabItems = listOf(
      "Tab 1",
      "Tab 2",
      "Tab 3",
    )
    composable.setContent {
      TUITheme {
        val currentTabItem by remember {
          mutableStateOf(0)
        }
        Column(
          modifier = Modifier
            .background(color = TUITheme.colors.surface)
            .fillMaxWidth()
            .padding(10.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          VerticalSpacer(space = 40)
          TUIFloatingNavBar(
            tabItems = tabItems,
            onTabSelected = onTabSelected,
            currentTabItem = currentTabItem
          )
          VerticalSpacer(space = 40)
        }
      }

    }
    tabItems.forEachIndexed { index, tab ->
      composable.onNodeWithTag("${tab}_${index}").assertIsDisplayed()
      composable.onNodeWithTag("${tab}_${index}").performClick()
      verify(onTabSelected).invoke(index)
    }
  }
}