import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tarkalabs.uicomponents.components.base.TUIFloatingActionButton
import com.tarkalabs.uicomponents.components.base.TUIFloatingActionButtonTags
import com.tarkalabs.uicomponents.models.TarkaIcons
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TUIFabTest {
  @get:Rule val composable = createComposeRule()

  private val tags = TUIFloatingActionButtonTags(parentTag = "testTag")

  @Test fun fab_Displayed() {
    composable.setContent {
      TUIFloatingActionButton(icon = TarkaIcons.Delete24Regular, tags = tags) {
      }
    }
    composable.onNodeWithTag(tags.parentTag).assertIsDisplayed()
  }

  @Test fun fab_Click_Triggered() {
    val onClick: () -> Unit = mock()

    composable.setContent {
      TUIFloatingActionButton(icon = TarkaIcons.Delete24Regular, tags = tags, onClick = onClick)
    }
    composable.onNodeWithTag(tags.parentTag).performClick()
    verify(onClick).invoke()
  }
}