import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.TUIFloatingActionButton
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class FabTest {
  @get:Rule val composable = createComposeRule()

  private val FAB_TAG = "FAB_TAG"

  @Test fun isFabDisplayed() {
    composable.setContent {
      TUIFloatingActionButton(icon = TarkaIcons.Delete, testTag = FAB_TAG) {
      }
    }
    composable.onNodeWithTag(FAB_TAG).assertIsDisplayed()
  }

  @Test fun fabClickTest() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIFloatingActionButton(icon = TarkaIcons.Delete, testTag = FAB_TAG, onClick = onClick)
    }
    composable.onNodeWithTag(FAB_TAG).performClick()

    verify(onClick).invoke()
  }
}